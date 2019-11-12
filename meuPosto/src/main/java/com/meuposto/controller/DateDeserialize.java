package com.meuposto.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;;

public class DateDeserialize {

	public static Timestamp deserialize(String data) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			System.out.println(data);
			Timestamp datatime = new Timestamp(format.parse(data).getTime());
			System.out.println(datatime.toString());
			return datatime;
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
