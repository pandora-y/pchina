package com.pchina.cms.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH";
	
	public static final String FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
	
	public static SimpleDateFormat sdf1 = new SimpleDateFormat(FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
	
	public static final String FORMAT_DATE = "yyyyMMdd";
	
	public static SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT_DATE);
	
	public static Date parseDateTime(String str) {
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String formatDateTime(Date date) {
		return sdf.format(date);
	}
	public static String formatDate(Date date) {
		return sdf2.format(date);
	}
	public static String formatDateTimeAll(Date date) {
		return sdf1.format(date);
	}
	
	public static boolean compareCurrentDate(Date on, Date off) {
		SimpleDateFormat sdfint = new SimpleDateFormat("yyyyMMddHH");
		int current = Integer.parseInt(sdfint.format(new Date()));
		int online = Integer.parseInt(sdfint.format(on));
		int offline = Integer.parseInt(sdfint.format(off));
		if (current >= online && current <= offline) {
			return true;
		}
		return false;
	}
	
	public static int getHour(Date date) {
		SimpleDateFormat sdfhour = new SimpleDateFormat("HH");
		return Integer.parseInt(sdfhour.format(date));
	}
	
	public static void main(String[] args) {
		System.out.println(getHour(new Date()));
	}
}
