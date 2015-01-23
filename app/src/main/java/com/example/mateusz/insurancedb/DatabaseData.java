package com.example.mateusz.insurancedb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mateusz on 14.12.14.
 */
public class DatabaseData {
    List<String> data1 = new ArrayList<String>();
    List<String> data2 = new ArrayList<String>();

    public DatabaseData() {
        this.data1.add("xxx");
        this.data2.add("xxx");
    }

    public List<String> getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2.add(data2);
    }

    public List<String> getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1.add(data1);
    }
}
