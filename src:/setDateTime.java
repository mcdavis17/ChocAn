package project4;

import java.util.*;
import java.time.*;

public class setDateTime  {

	int second;
	int minute;
	int hour;
	int dayOfYear; 
	int dayOfMonth;
	int dayOfWeek;
	int month; 
	int year;
	int LocalDateTime LDT;

	public setDateTime ()  {
		LDT = LocalDateTime.now();
		second = -1;
		minute = -1;
		hour = -1;
		dayOfYear = -1;
		dayOfMonth = -1;
		dayOfWeek = -1;
		month = -1;
		year = -1;
	}
	
	public void setCurrentTimeDate() {
		LDT = LocalDateTime.now();
		setDayOfYear(LDT.getDayOfYear());
		setDayOfMonth(LDT.getDayOfMonth());
		setDayOfWeek(LDT.getDayOfWeek());
		setMonth(LDT.getMonth());
		setYear(LDT.getYear());
		setMinute(LDT.getMinute());
		setSecond(LDT.getSecond());
	}
	
	public void setSecond(int e) { 
		if (e >= 60) {
			throw new NumberFormatException("Second value may not be greater than or equal to 60.")
		}
		if (e < 0) {
			throw new NumberFormatException("Second value must be positive.");
		}
		second = e;
	}
	
	public void setMinute (int m) {
		if (m >= 60) {
			throw new NumberFormatException("Minute value may not be greater than or equal to 60.")
		}
		if (m < 0) {
			throw new NumberFormatException("Second value must be positive.");
		}
		minute = m;	
	}
	
	public void setHour (int h) {
		if (h >= 24) {
			throw new NumberFormatException("Hour value must be less than or equals to 24.");
		}
		if (h < 0) {
			throw new NumberFormatException("Hour value must be greater than or equals to 0.");
		}
		hour = h;
	}
	
	public void setDayOfYear(int d) {
		if (a < 0) {
			throw new NumberFormatException("Day of year value must be positive.");	
		}
		if (a > 366) {
			throw new NumberFomratException("Day of  year value must be less than 366.");
	}
		day = d;
	}
	
	public void setDayOfMonth(int dom) {
		if ((getMonth() == 2) && (a > 0) && (a <= 28)) {
			dayOfMonth = dom;
		}
		else if ((a <- 31) && (a > 0)) {
			dayOfMonth = dom;
		}
		else if ((getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11 && (a > 0) && (a <= 30))) {
			dayOfMonth = dom;
		}
		else {
			throw new NumberFormatException("Day of month value must be positive and less than 28, 30, or 31.");
		}
	}
	public void setDayOfWeek(int dow) {
		if (dow < 0 || dow > 7) {
			throw new NumberFormatException("Day of week must be greater than 0 and less than 7.");
		}
		dayOfWeek = dow;
	}
	public void setMonth(int mon) {
		if (mon > 12 || mon <= 0) {
			throw new NumberFormatException("Month must be greater than 0 and less than 12.");
		}
		month = mon;
	}	
	public void setYear(int actualYear) {
		Calendar calendar = new GregorianCalendar();
		int curYear = calendar.get(Calendar.YEAR);
		year = actualYear;
	}
	public int getSecond() {
		return second;
	}
	public int getMinute() {
		return minute;
	}
	public int getHour() {
		return hour;
	}
	public int getYear() {
		return year;
	}
	public int getDayOfYear() {
		return day;
	}
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public int getMonth() {
		return month;
	}
	
	public void setPrintDate() {
		if (month < 10) {
			System.out.print("0");
		}
		System.out.print(getMonth() + "-");
		if (dayOfMonth < 10) {
			System.out.print("0");
		}
		System.out.print(getDayOfMonth() + "-");
		System.out.print(getYear());
	}
	public void setPrintTime() {
		if (hour < 10) {
			System.out.print("0");
		}
		System.out.print(getHour() + ":");
		if (minute < 10) {
			System.out.print("0");
		}
		System.out.print(getMinute() + ":");
		if (second < 10) {
			System.out.print("0");
		}
		System.out.print(getSecond());
	}
	public void setPrintDateTime() {
		setPrintDate();
		System.out.print("0");
		setPrintTime();
	}
}

