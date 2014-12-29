package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.model.Oc;
import com.domain.repository.OcRepository;

/**
 * Created by mateusz on 28.12.14.
 */
public class AddOcUseCaseImpl implements AddOcUseCase {

    private final OcRepository ocRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private AddOcUseCase.Callback callback;
    private Oc oc;

    public AddOcUseCaseImpl(OcRepository ocRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        if(ocRepository == null || threadExecutor == null || postExecutionThread == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null.");
        }
        this.ocRepository = ocRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }


    @Override
    public void execute(Oc oc, Callback callback) {
        if(oc == null || callback == null) {
            throw new IllegalArgumentException("Null parameters.");
        }
        this.oc = oc;
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.ocRepository.addOc(this.oc, this.repositoryCallback);
    }

    private OcRepository.OcAddCallback repositoryCallback = new OcRepository.OcAddCallback() {
        @Override
        public void onOcAdded() {
            notifyAddOcSuccessful();
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyAddOcSuccessful() {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
              callback.onOcAdded();
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
