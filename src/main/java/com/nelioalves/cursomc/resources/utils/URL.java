package com.nelioalves.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static List<Integer> decodeIntList(String param){
		String[] params = param.split(",");
		List<Integer> list = new ArrayList<Integer>();
		
		for(String p : params) {
			list.add(Integer.valueOf(p));
		}
		
		return list;
	}

}
