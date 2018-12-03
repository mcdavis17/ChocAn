
//prints current the date and then time
package project4;

import java.util.*;
import java.time.*;

/**
 * @author Richard Anthony
 *
 */
public class SetDateTime  {

	int second;
	int minute;
	int hour;
	int day; 
	int dayOfMonth;
	int dayOfWeek;
	int month; 
	int year;
	private LocalDateTime LDT;

	/**
	 * sets the time and date
	 */
	public SetDateTime ()  {
		LDT = LocalDateTime.now();
		second = -1;
		minute = -1;
		hour = -1;
		day = -1;
		dayOfMonth = -1;
		dayOfWeek = -1;
		month = -1;
		year = -1;
	}
	
	/**
	 * Sets current time and date
	 */
	public void setCurrentTimeDate() {
		LDT = LocalDateTime.now();
		setDayOfYear(LDT.getDayOfYear());
		setDayOfMonth(LDT.getDayOfMonth());
		setDayOfWeek(LDT.getDayOfWeek().getValue());
		setMonth(LDT.getMonth().getValue());
		setYear(LDT.getYear());
		setMinute(LDT.getMinute());
		setSecond(LDT.getSecond());
	}
	
	/**
	 * Sets second value
	 * 
	 * @param e seconds
	 */
	public void setSecond(int e) { 
		if (e >= 60) {
			throw new NumberFormatException("Second value may not be greater than or equal to 60.");
		}
		if (e < 0) {
			throw new NumberFormatException("Second value must be positive.");
		}
		second = e;
	}
	
	/**
	 * Sets minute value
	 * 
	 * @param m minute
	 */
	public void setMinute (int m) {
		if (m >= 60) {
			throw new NumberFormatException("Minute value may not be greater than or equal to 60.");
		}
		if (m < 0) {
			throw new NumberFormatException("Second value must be positive.");
		}
		minute = m;	
	}
	
	/**
	 * sets hour value
	 * 
	 * @param h hour
	 */
	public void setHour (int h) {
		if (h >= 24) {
			throw new NumberFormatException("Hour value must be less than or equals to 24.");
		}
		if (h < 0) {
			throw new NumberFormatException("Hour value must be greater than or equals to 0.");
		}
		hour = h;
	}
	
	/**
	 * sets day of year
	 * 
	 * @param d day
	 */
	public void setDayOfYear(int d) {
		if (d < 0) {
			throw new NumberFormatException("Day of year value must be positive.");	
		}
		if (d > 366) {
			throw new NumberFormatException("Day of  year value must be less than 366.");
	}
		day = d;
	}
	
	/**
	 * sets day of month
	 * 
	 * @param dom day of month
	 */
	public void setDayOfMonth(int dom) {
		if ((getMonth() == 2) && (dom > 0) && (dom <= 28)) {
			dayOfMonth = dom;
		}
		else if ((dom <= 31) && (dom > 0)) {
			dayOfMonth = dom;
		}
		else if ((getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11 && (dom > 0) && (dom <= 30))) {
			dayOfMonth = dom;
		}
		else {
			throw new NumberFormatException("Day of month value must be positive and less than 28, 30, or 31.");
		}
	}
	
	/**
	 * sets day of week
	 * 
	 * @param dow day of week
	 */
	public void setDayOfWeek(int dow) {
		if (dow < 0 || dow > 7) {
			throw new NumberFormatException("Day of week must be greater than 0 and less than 7.");
		}
		dayOfWeek = dow;
	}
	/**
	 * sets month
	 * 
	 * @param mon month
	 */
	public void setMonth(int mon) {
		if (mon > 12 || mon <= 0) {
			throw new NumberFormatException("Month must be greater than 0 and less than 12.");
		}
		month = mon;
	}	
	/**
	 * sets year
	 * 
	 * @param actualYear year
	 */
	public void setYear(int actualYear) {
		Calendar calendar = new GregorianCalendar();
		int curYear = calendar.get(Calendar.YEAR);
		year = actualYear;
	}
	/**
	 * gets seconds value
	 * 
	 * @return seconds
	 */
	public int getSecond() {
		return second;
	}
	/**
	 * gets minutes value
	 * 
	 * @return minutes 
	 */
	public int getMinute() {
		return minute;
	}
	/**
	 * gets hour value
	 * 
	 * @return hour
	 */
	public int getHour() {
		return hour;
	}
	/**
	 * gets year
	 * 
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * gets day of the year
	 * 
	 * @return day of year
	 */
	public int getDayOfYear() {
		return day;
	}
	/**
	 * gets the day of the month
	 * 
	 * @return day of month
	 */
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	/**
	 * Gets day of week 
	 * 
	 * @return day of week
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	/**
	 * gets the month
	 * 
	 * @return month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Sets how to print the date
	 */
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
	/**
	 * Sets how to print the time
	 */
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
	/**
	 * Sets how to print the date and time
	 */
	public void setPrintDateTime() {
		setPrintDate();
		System.out.print("0");
		setPrintTime();
	}
}
