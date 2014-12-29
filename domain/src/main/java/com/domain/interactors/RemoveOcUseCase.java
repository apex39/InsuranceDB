package com.domain.interactors;

import com.domain.exception.ErrorBundle;

/**
 * Created by mateusz on 28.12.14.
 */
public interface RemoveOcUseCase extends Interactor {
    interface Callback {
    void onOcRemoved();
    void onError(ErrorBundle errorBundle);
}
    void execute(int ocId, Callback callback);
}