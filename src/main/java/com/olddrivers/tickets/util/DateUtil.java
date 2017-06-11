package com.olddrivers.tickets.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateUtil {
	public static List<String> getTodayAndTomorrow() {
		List<String> dates = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		dates.add(new Date(cal.getTimeInMillis()).toString());
        cal.add(Calendar.DATE,1);
        dates.add(new Date(cal.getTimeInMillis()).toString());
		return dates;
	}
}
