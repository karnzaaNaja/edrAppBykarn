package com.example.msi_gl62.edr.util;

public class AppUtil {

    public static boolean isEmpty(Object s) {
        return s == null || s instanceof String && ((((String) s).length() == 0) || ((String) s).equalsIgnoreCase("null"));
    }


}
