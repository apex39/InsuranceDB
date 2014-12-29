package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.model.Oc;

/**
 * Created by mateusz on 28.12.14.
 */
public interface ModifyOcUseCase extends Interactor {
    interface Callback {
        void onOcModified();
        void onError(ErrorBundle errorBundle);
    }
    void execute(Oc oc, Callback callback);
}