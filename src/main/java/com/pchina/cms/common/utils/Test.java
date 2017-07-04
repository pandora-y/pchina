package com.pchina.cms.common.utils;

import java.util.HashMap;
import java.util.Map;

//import java.util.HashMap;
//import java.util.Map;


public class Test {
	
	public static void main(String[] args) {
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("keyword", "shiliang");
			HttpRequester request = new HttpRequester();
			HttpRespons hr = request.sendPost("http://localhost:8080/user/list", params);
			System.out.println(hr.getUrlString());     
			System.out.println(hr.getProtocol());     
			System.out.println(hr.getHost());     
			System.out.println(hr.getPort());     
			System.out.println(hr.getContentEncoding());     
			System.out.println(hr.getMethod()); 
			System.out.println(hr.getContent());
      
        } catch (Exception e) {     
            e.printStackTrace();     
        }   
	}
	
}
