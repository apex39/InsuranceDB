package com.domain.repository;

import com.domain.exception.ErrorBundle;
import com.domain.model.Customer;
import com.domain.model.Oc;

import java.util.Collection;

/**
 * Created by mateusz on 28.12.14.
 */
public interface OcRepository {
    void getOcRecentList(final int userId, OcListCallback ocListCallback);
    void getOcById(final int ocId, OcCallback ocCallback);
    void getOcByRegistrationNumber(int ocRegistrationNumber, OcCallback ocCallback);
    void getOcByCustomer(Customer customer, OcListCallback ocListCallback);
    void addOc(Oc oc, OcAddCallback ocAddCallback);
    void removeOc(final int ocId, OcRemoveCallback ocRemoveCallback);
    void modifyOc(Oc oc, OcModifyCallback ocModifyCallback);


    interface ErrorHandle{
        void onError(ErrorBundle errorBundle);
    }

    interface OcListCallback extends ErrorHandle{
        void onOcListReceived(Collection<Oc> ocCollection);
    }

    interface OcCallback extends ErrorHandle{
        void onOcReceived(Oc oc);
    }

    interface OcAddCallback extends ErrorHandle{
        void onOcAdded();
    }

    interface OcRemoveCallback extends ErrorHandle{
        void onOcRemoved();
    }

    interface OcModifyCallback extends ErrorHandle{
        void onOcModified();
    }
}
