package com.engx.bt.common;

import com.google.gson.Gson;

/**
 * Java File. Title : HhbtCommonUtil.java.
 * Description :  This Configuration class is used to perform all
 * common methods.
 * 
 * Copyright : ENGX-TechBullets (c) 2016 Company : EPAM Solutions.
 *
 * @author : rvaddi
 * @version : 0.1
 */

public class HhbtCommonUtil {
		
    /**
     * This method will convert any object into String.
     *
     * @param object
     *            This is the request Object.
     * @return String
     */
    public final static String convertIntoJson(final Object object) {
        return new Gson().toJson(object);
    }
}