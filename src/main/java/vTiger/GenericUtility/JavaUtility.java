package vTiger.GenericUtility;

import java.util.Random;

//import sun.util.calendar.LocalGregorianCalendar.Date;
import java.util.Date;
public class JavaUtility {

	public int getRandomNumber()
	{
		Random r=new Random();
		int value=r.nextInt(1000);
		return value;
	}
	public String getSystemDate()
	{
		Date d=new Date();
		String value=d.toString();
		return value;
	}
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] dArr=d.toString().split(" ");
		String date=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String day=dArr[0];

		String time=dArr[3];
		String dateformat=date+"_"+day+"_"+month+"_"+year+"_"+time;
		return dateformat;
	}
}
