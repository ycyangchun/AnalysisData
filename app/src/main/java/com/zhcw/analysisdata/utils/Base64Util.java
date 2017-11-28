package com.zhcw.analysisdata.utils;

import android.util.Base64;

/**
 * Created by YangChun .
 * on 2017/3/11.
 */

public class Base64Util {
    public static byte[] encode(byte[] s) {
        if (s == null)
            return null;
        return Base64.encode(s, Base64.DEFAULT);
    }

    public static byte[] decode(String s) {
        if (s == null)
            return null;
        try {
            return Base64.decode(s, Base64.DEFAULT);
        } catch (Exception e) {
            return null;
        }
    }
}
