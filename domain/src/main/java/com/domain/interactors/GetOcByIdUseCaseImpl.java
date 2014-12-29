package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.model.Oc;
import com.domain.repository.OcRepository;

/**
 * Created by mateusz on 29.12.14.
 */
public class GetOcByIdUseCaseImpl implements GetOcByIdUseCase {

    private final OcRepository ocRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private int ocId = -1;
    private GetOcByIdUseCase.Callback callback;
    
    public GetOcByIdUseCaseImpl(OcRepository ocRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        if(ocRepository == null || threadExecutor == null || postExecutionThread == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null.");
        }
        this.ocRepository = ocRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(final int ocId, Callback callback) {
       if(ocId < 0 || callback == null) {
           throw new IllegalArgumentException("Null parameter.");
       }
       this.ocId = ocId;
       this.callback = callback;
       this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.ocRepository.getOcById(this.ocId, this.repositoryCallback);
    }
    private OcRepository.OcCallback repositoryCallback = new OcRepository.OcCallback() {
        @Override
        public void onOcReceived(Oc oc) {
            notifyOcReceivedSuccessful(oc);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyOcReceivedSuccessful(final Oc oc) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onOcReceived(oc);
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(errorBundle);
            }
        });
    }
}