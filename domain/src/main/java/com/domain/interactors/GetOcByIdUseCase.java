package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.model.Oc;

/**
 * Created by mateusz on 28.12.14.
 */
public interface GetOcByIdUseCase extends Interactor {
    interface Callback {
        void onOcReceived(Oc oc);
        void onError(ErrorBundle errorBundle);
    }
    void execute(int ocId, Callback callback);
}
