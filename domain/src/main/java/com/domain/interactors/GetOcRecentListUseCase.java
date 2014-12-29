package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.model.Oc;

import java.util.Collection;

/**
 * Created by mateusz on 28.12.14.
 */
public interface GetOcRecentListUseCase extends Interactor {
    interface Callback {
        void onOcListReceived(Collection<Oc> ocCollection);
        void onError(ErrorBundle errorBundle);
    }

    void execute(int userId, Callback callback);
}
