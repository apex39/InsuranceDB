package com.data.test;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import com.data.OcRequestQueue;



public class OcRequestQueueTest extends InstrumentationTestCase {

    Context context;

    @Override
    public void setUp() throws Exception {
        context = getInstrumentation().getContext();
    }

    public void testGetInstance() throws Exception {
        assertEquals(new OcRequestQueue(), OcRequestQueue.getInstance(context));
    }
}