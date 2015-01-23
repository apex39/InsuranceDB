package com.data;
import android.content.Context;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.domain.exception.ErrorBundle;
import com.domain.model.Customer;
import com.domain.model.Oc;
import com.domain.repository.OcRepository;
import com.android.volley.*;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


public class OcRepositoryImpl implements OcRepository {

    /*Presentation layer needs to pass context, which is needed by volley*/
    Context mContext;
    Class<Oc> ocModel;
    public OcRepositoryImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void getOcRecentList(int userId, final OcListCallback ocListCallback) {
        final List<Oc> ocList = new ArrayList<>();
        /*TODO: Get links from server while logging in*/
        /*TODO: Don't download all OC, only by user's ID and basic info*/
        String url = "http://validate.jsontest.com/?json={'key':'value'}";
        Response.Listener<Oc> successListener = new Response.Listener<Oc>() {
            @Override
            public void onResponse(Oc ocModel) {
                ocList.add(ocModel);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //todo
            }
        };

        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET, url, ocModel, successListener, errorListener);
        OcRequestQueue.getInstance(mContext).addToRequestQueue(gsonRequest);
    }

    @Override
    public void getOcById(int ocId, final OcCallback ocCallback) {
        String url = "http://validate.jsontest.com/?json={'key':'value'}";


        Response.Listener<Oc> successListener = new Response.Listener<Oc>() {
            @Override
            public void onResponse(Oc ocModel) {
                ocCallback.onOcReceived(ocModel);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ocCallback.onError(new DataErrorBundle(volleyError));
            }
        };

        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET, url, ocModel, successListener, errorListener);
        OcRequestQueue.getInstance(mContext).addToRequestQueue(gsonRequest);
    }

    @Override
    public void getOcByRegistrationNumber(int ocRegistrationNumber, OcCallback ocCallback) {

    }

    @Override
    public void getOcByCustomer(Customer customer, OcListCallback ocListCallback) {

    }

    @Override
    public void addOc(Oc oc, OcAddCallback ocAddCallback) {

    }

    @Override
    public void removeOc(int ocId, OcRemoveCallback ocRemoveCallback) {

    }

    @Override
    public void modifyOc(Oc oc, OcModifyCallback ocModifyCallback) {

    }
}
