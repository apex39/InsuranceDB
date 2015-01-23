package com.data;
import android.content.Context;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;


/**
 * Created by mateusz on 03.01.15.
 */
public class OcRequestQueue {
    static RequestQueue requestQueue;
    static Context mContext;
    static Cache cache;
    static Network network;

    private static OcRequestQueue ourInstance = new OcRequestQueue();

    public static OcRequestQueue getInstance(Context context) {
        if (ourInstance == null) {
            mContext = context;
            requestQueue = setRequestQueue(mContext);
        }
        return ourInstance;
    }

    private static RequestQueue setRequestQueue(Context context) {
        cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024);
        network = new BasicNetwork(new HurlStack());
        return new RequestQueue(cache,network);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public OcRequestQueue() {

    }
}
