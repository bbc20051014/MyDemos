package com.lzg.test.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lzg.test.ws.pojo.DoService;
import com.lzg.test.ws.pojo.DoServiceResponse;
import com.lzg.test.ws.service.LzgRepository;

/**
 * 
 * @author lzg
 * @date 2018年5月27日 上午10:31:31
 *
 */
@Endpoint
public class LzgEndpoint {
	
	
	//跟wsdl.xml文件中得保持一致
	private static final String NAMESPACE_URI = "http://www.lzg.test.com";
	@Autowired
	private LzgRepository lzzgRepository; 
	
	    //配置对外接口
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "doService")
	    @ResponsePayload
	    public DoServiceResponse service(@RequestPayload DoService request) {
	    	DoServiceResponse response = new DoServiceResponse();
	        response.setReturn(lzzgRepository.findService(request.getServiceCode(),request.getReqXml()));
	        
	        return response;
	    }

}
