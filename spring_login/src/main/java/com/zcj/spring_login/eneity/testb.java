package com.zcj.spring_login.eneity;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class testb {
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        l.add("fdsf");
        int i = 0;
        digvui(l, i);
    }


    public static void digvui(List l, int i) {
        System.out.println(l.get(i));
        if (i < l.size() - 1) {
            digvui(l, i + 1);
        }
    }
}
