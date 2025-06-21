package com.employee.timetracker.utility;

import java.time.LocalTime;

public class TimeDateUtility 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		int h=lt.getHour();
		int m=lt.getMinute();
		int s=lt.getSecond();
		StringBuffer time=new StringBuffer();
		time.append(h<10?"0"+h:h);
		time.append(":");
		time.append(m<10?"0"+m:m);
		time.append(":");
		time.append(s<10?"0"+s:s);
		return time.toString();
	}
	public static String getTotalTime(String outtime,String intime)
	{
		int intimes=getTimeInSeconds(intime);
		int outtimes=getTimeInSeconds(outtime);
		int totals=intimes-outtimes;
		int h=totals/3600;
		int s=totals%3600;
		int m=s/60;
		s=s%60;
		return getTime(h,m,s);
	}
	private static int getTimeInSeconds(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*3600+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
	private static String getTime(int h,int m,int s)
	{
		String total=h+" hours, "+m+" minutes and "+s+" seconds";
		
	    if(h==0 && m==0)
			total=s+" seconds exactly";
		else if(h==0 && s==0)
			total=m+" minutes exactly";
		else if(m==0 && s==0)
			total=h+" hours exactly";
		else if(h==0 && m==0)
			total=s+" seconds exactly";
		else if(h==0)
			total=m+" minutes and "+s+" seconds";
		else if(m==0)
			total=h+" hours and "+s+" seconds";
		else if(s==0)
			total=h+" hours and "+m+" minutes";
		return total;
	}
	public static String changeDateFormat(String date)
	{
		String[] x=date.split("-");
		return x[2]+"-"+x[1]+"-"+x[0];
	}
}
