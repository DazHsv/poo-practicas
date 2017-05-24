package utils;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

import java.util.Calendar;

public final class DateHelper {
	private Calendar c;
	
	public DateHelper() { this.c = Calendar.getInstance(); }
	
	public int getDay() { return c.get(Calendar.DAY_OF_MONTH); }
	public int getMonth() { return c.get(Calendar.MONTH) + 1; }
	public int getYear() { return c.get(Calendar.YEAR); }
	public int getHour() { return c.get(Calendar.HOUR); }
	public int getMinute() { return c.get(Calendar.MINUTE); }
	public int getSecond() { return c.get(Calendar.SECOND); }
	
	public String getFullDate() { return getDate() + " " + getTime(); }
	
	public String getDate() {
		return String.format("%d/%d/%d",
				getDay(),
				getMonth(),
				getYear());
	}
	
	public String getTime() {
		return String.format("%d:%d:%d",
				getHour(),
				getMinute(),
				getSecond());
	}
}
