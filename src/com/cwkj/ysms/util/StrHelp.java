package com.cwkj.ysms.util;

import java.io.UnsupportedEncodingException;

public class StrHelp {

	public static String getChinese(String s) {
		try {
			return new String(s.getBytes("gb2312"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}
}