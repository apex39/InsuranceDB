package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.model.Oc;
import com.domain.repository.OcRepository;

import java.util.Collection;

/**
 * Created by mateusz on 29.12.14.
 */
public class GetOcRecentListUseCaseImpl implements GetOcRecentListUseCase {
    private final OcRepository ocRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private GetOcRecentListUseCase.Callback callback;
    private int userId;

    public GetOcRecentListUseCaseImpl(OcRepository ocRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        if(ocRepository == null || threadExecutor == null || postExecutionThread == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null.");
        }
        this.ocRepository = ocRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }


    @Override
    public void execute(int userId, GetOcRecentListUseCase.Callback callback) {
        if(callback == null) {
            throw new IllegalArgumentException("Null parameters.");
        }
        this.userId = userId;
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.ocRepository.getOcRecentList(this.userId ,this.repositoryCallback);
    }

    private OcRepository.OcListCallback repositoryCallback = new OcRepository.OcListCallback() {

        @Override
        public void onOcListReceived(Collection<Oc> ocCollection) {
            notifyOcListReceivedSuccessful(ocCollection);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }

    };

    private void notifyOcListReceivedSuccessful(final Collection<Oc> ocCollection) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {callback.onOcListReceived(ocCollection);
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
