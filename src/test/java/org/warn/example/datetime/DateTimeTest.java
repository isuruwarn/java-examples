package org.warn.example.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTimeTest {
	
	@Test
	public void testCalendarSDF() {
		Calendar now = Calendar.getInstance();
		System.out.println(now.toString());
		System.out.println(now.get(Calendar.MONTH)+1 + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		System.out.println(sdf.format(now.getTime()));
	}
	
	@Test
	public void testLocalDateTime() {
		// java 8 LocalDateTime
		String dateText = "2007-12-03T10:15:30";
		LocalDateTime ldt = LocalDateTime.parse( dateText );
		System.out.println( ldt.format( DateTimeFormatter.ofPattern("yyyy/MM/dd") ));
	}
	
	@Test
	public void testSimulatedTS() {
		long ts1 = getSimulatedTS(); // FOR DEMO ONLY!
		long ts2 = ts1 - 86400;
		log.info("Timestamp1 - " + ts2);
		log.info("Timestamp2 - " + ts1);		
	}
	
	@Test
	public void testCalendarData() {
		//Calendar calendar = new GregorianCalendar( 2015, 9, 22 );
		Calendar calendar = GregorianCalendar.getInstance();
		long ts1 = 1445324400;
		calendar.setTimeInMillis(ts1*1000);
		printCalData( calendar );
	}
	
	@Test
	public void printTimeZone1() {
		TimeZone tz = TimeZone.getTimeZone("PST");
		log.info("TimeZone=" + tz);
	}
	
	@Test
	public void printTimeZone2() {
		Calendar c = Calendar.getInstance();
		log.info( "TimeZone=" + c.getTimeZone() );
	}
	
	public static long getSimulatedTS() {
		
		Calendar techEdDay = new GregorianCalendar( 2015, 9, 20 );
		long techEdDayTS = techEdDay.getTimeInMillis() / 1000; // timestamp in seconds at 2015/10/22 00:00:00
		//log.info(techEdDayTS);
		
		Calendar now = new GregorianCalendar();
		long nowTS = now.getTimeInMillis() / 1000; // current timestamp in seconds
		//log.info(nowTS);
		
		Calendar today12am = new GregorianCalendar( now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH) );
		long today12amTS = today12am.getTimeInMillis() / 1000; // timestamp in seconds at 12am today
		//log.info(today12amTS);
		
		long secsBetween12amAndNow = nowTS - today12amTS;
		//log.info(secsBetween12amAndNow);
		
		long simulatedTechEdTS = techEdDayTS + secsBetween12amAndNow;
		//log.info( simulatedTechEdTS );
		
		return simulatedTechEdTS;
		
//		Calendar techEdDay10am = new GregorianCalendar( 2015, 9, 20, 10, 0, 0 );
//		long techEdDayTS10am = techEdDay10am.getTimeInMillis() / 1000; // timestamp in seconds at 2015/10/20 10:00:00
//		
//		Calendar now = new GregorianCalendar();
//		int currentMinute = now.get(Calendar.MINUTE);
//		
//		long simulatedTechEdTS = techEdDayTS10am + ( currentMinute * 60 );
//		
//		return simulatedTechEdTS;
	}
	
	
	public static void printCalData( Calendar calendar ) {
		
		// thanks to - http://www.mkyong.com/java/java-date-and-calendar-examples/
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		log.info( sdf.format(calendar.getTime()) );
		
		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);
		int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar.get(Calendar.MINUTE);
		int second     = calendar.get(Calendar.SECOND);
		int millisecond= calendar.get(Calendar.MILLISECOND);
		
		log.info("year \t\t: " + year);
		log.info("month \t\t: " + month);
		log.info("dayOfMonth \t: " + dayOfMonth);
		log.info("dayOfWeek \t: " + dayOfWeek);
		log.info("weekOfYear \t: " + weekOfYear);
		log.info("weekOfMonth \t: " + weekOfMonth);
		log.info("hour \t\t: " + hour);
		log.info("hourOfDay \t: " + hourOfDay);
		log.info("minute \t\t: " + minute);
		log.info("second \t\t: " + second);
		log.info("millisecond \t: " + millisecond);
	}
	
}
