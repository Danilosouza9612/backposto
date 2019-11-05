package com.meuposto.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateDeserialize {

	public static Date deserialize(String data) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return new Date(format.parse(data).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Date deserializeWithoutTime(String data) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return new Date(format.parse(data).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
