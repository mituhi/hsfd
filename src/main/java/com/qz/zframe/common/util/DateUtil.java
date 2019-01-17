package com.qz.zframe.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/*
	 * //把时间戳变为时间存入 public static String getDateStringByTimeSTamp(String time)
	 * throws ParseException { Long timeStamp = Long.parseLong(time); String result
	 * = null; SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 * Date date = new Date(timeStamp*1000); result = sd.format(date); return
	 * result; } //只取时间的年月日 public static Date Format(Date date) throws
	 * ParseException { SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * String dateNow = sdf.format(date); Date dates = sdf.parse(dateNow); return
	 * dates; } //时间戳转date只取年月日 public static Date getDateToDate(long l) throws
	 * ParseException { SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * String dateNow = sdf.format(l); Date dates = sdf.parse(dateNow); return
	 * dates; }
	 */

	// date 只要年份
	public static String getDateToYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		String time = String.valueOf(year);
		return time;

	}

	// date 只要月份
		public static String getDateToMonth(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			String time = String.valueOf(month+1);
			return time;
		}
		//date 只要日
		public static String getDateToDay(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			String time = String.valueOf(day);
			return time;
		}
		//date 只要时
			public static String getDateToHours(Date date) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int hours = cal.get(cal.HOUR_OF_DAY);
					String time = String.valueOf(hours);
					return time;
				}
			//date 只要分
			public static String getDateToFen(Date date) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int minute = cal.get(cal.MINUTE);
					String time = String.valueOf(minute);
					return time;
				}
	// Date 判断两个时间是不是在同一周内
	public static Boolean getDateForWeeek(Date date, Date time) {
		Boolean bool = false;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		cal2.setTime(time);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		// subYear==0,说明是同一年
		if (subYear == 0) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				bool = true;
		}
		// 不是同一年
		else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				bool = true;
		}
		return bool;

	}

	// 当前时间是本月第几周
	public static int getWeek(Date date) {
		/*
		 * SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd"); Date date
		 * =sdf.parse(str);
		 */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 第几周
		int week = calendar.get(Calendar.WEEK_OF_MONTH);
		return week;
	}
	   //当前季度的最后一天
	   public static Date getCurrentQuarterEndTime() {
	        Calendar c = Calendar.getInstance();
	        int currentMonth = c.get(Calendar.MONTH) + 1;
	        Date now = null;
	        try {
	            if (currentMonth >= 1 && currentMonth <= 3) {
	                c.set(Calendar.MONTH, 2);
	                c.set(Calendar.DATE, 31);
	            } else if (currentMonth >= 4 && currentMonth <= 6) {
	                c.set(Calendar.MONTH, 5);
	                c.set(Calendar.DATE, 30);
	            } else if (currentMonth >= 7 && currentMonth <= 9) {
	                c.set(Calendar.MONTH, 8);
	                c.set(Calendar.DATE, 30);
	            } else if (currentMonth >= 10 && currentMonth <= 12) {
	                c.set(Calendar.MONTH, 11);
	                c.set(Calendar.DATE, 31);
	            }
	            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:55:00");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return now;
	    }
	//获取当前时间的年份
	public static String getNowDate() {
		final SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar c = Calendar.getInstance();
		 String now=DateUtil.getDateToYear(c.getTime());
		 return now;
		
	}
	
	//当前季度的最后时间
	public static String getSeason() {
		String test=null;
		Date date=DateUtil.getCurrentQuarterEndTime();
		String s=DateUtil.getDateToMonth(date);
		Double  a=Double.parseDouble(s)/(double) 3;
		if(a<=1) {
			test="第一季度";
		}
		if(a>1 && a<=2) {
			test="第二季度";
		}
		if(a>2 && a<=3) {
			test="第三季度";
		}
		if(a>3 && a<=4) {
			test="第四季度";
		}
		return test;
		
	}
	
	 /**
     * 时间相减
     * @param strDateBegin
     * @param strDateEnd
     * @param iType
     * @return  相差的天数
     */
    public static int getDiffDate(Date DateBegin , Date DateEnd){
    	
		long dateBeginTime = DateBegin.getTime();
		long dateEndTime = DateEnd.getTime();
		return  (int)((dateEndTime-dateBeginTime) / 86400000L);
		
    }
	
	
    /**
     * 日期增加天数
     * @param date
     * @param iCount
     * @return
     */
    public static Date getAddDate(Date date, int iCount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, iCount);
        return cal.getTime();
    }
    
    
    /**
     * @Description:获取当月最后一天日期
     * @param: @param date
     * @param: @return   
     * @return: Date
     */
    public static Date getMonthEnd(Date date) {
    	
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return c.getTime();
    }
    
    
	public static Date getYearFinish() throws ParseException {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        Date  time=null;
        c.set(Calendar.DAY_OF_YEAR, 1);
        //System.out.println(c.getTime()); // 第一天
        c.add(Calendar.YEAR, 1);
        c.set(Calendar.DAY_OF_YEAR, -1);
        System.out.println(c.getTime()); // 最后一天
        time= longSdf.parse(shortSdf.format(c.getTime()+"23:55:00"));
		return time;
		
	}
	public static  Date  getStringToDate(String time) throws ParseException {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = shortSdf.parse(time);
		return date;
		
	}
	public static java.sql.Date getDateToDatetime(String date) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date udate = sdf.parse(date);
		java.sql.Date sdate = new java.sql.Date(udate.getTime());
		return sdate;
		
	}
	
	public static void main(String[] args) throws ParseException  {
	/*	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = formatter.format(DateUtil.getCurrentQuarterEndTime());
		System.out.println("当前季度结束："+string.toString());*/
       // Date  d=DateUtil.getCurrentQuarterEndTime();
		/*String t=DateUtil.getSeason();
		System.out.println(t);*/
		//System.out.println(DateUtil.getDateToMonth(d));
		
	   Date  date=new Date();
	  String s=DateUtil.getDateToYear(date);
	 
	  
	   String s1=DateUtil.getDateToMonth(date);
	   String s2=DateUtil.getDateToDay(date);
		
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		
	}
}
