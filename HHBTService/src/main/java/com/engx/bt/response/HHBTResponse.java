/**
 *
 */
package com.engx.bt.response;

import java.util.HashMap;
import java.util.Map;

public abstract class HHBTResponse {
    Map<String, Object> responseMap = new HashMap<String, Object>();

    public Map<String, Object> getResponseMap() {
        return responseMap;
    }

    public abstract void prepareResponse(Object object, String message);
}