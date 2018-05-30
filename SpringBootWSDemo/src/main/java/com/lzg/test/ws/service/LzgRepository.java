package com.lzg.test.ws.service;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 
 * @author lzg
 * @date 2018年5月27日 上午10:27:41
 *
 */
@Component
public class LzgRepository {

    public String findService(String serviceCode, String reqXml) {
    	System.out.println("serviceCode = " + serviceCode);
    	System.out.println("reqXml = " + reqXml);
        Assert.notNull(serviceCode, "The serviceCode must not be null");
        return serviceCode + "--->" + System.currentTimeMillis();
    }
}