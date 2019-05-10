package _4_date_api_update;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author: yuhaifeng
 * @create: 2019-01-07 15:04
 **/
public class DateTest {
	public static void main(String[] args) {
		/**
		 * now相关的方法可以获取当前日期或时间，
		 * of方法可以创建对应的日期或时间，
		 * parse方法可以解析日期或时间，
		 * get方法可以获取日期或时间信息，
		 * with方法可以设置日期或时间信息(调整时间)，
		 * plus或minus方法可以增减日期或时间信息
		 */
		//格式化当前时间
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(dtf.format(dt));
		LocalDateTime of1 = LocalDateTime.of(2019, 1, 7, 15, 31);
		System.out.println(dtf.format(of1));

		//创建当前时间
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		LocalTime of = LocalTime.of(14, 22);
		System.out.println(of);
		//创建当前日期
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);


		/**
		 * 操作时间
		 */
		// 取本月第1天：
		LocalDateTime firstDayOfThisMonth = dt.with(TemporalAdjusters.firstDayOfMonth());
		// 取本月第2天：
		LocalDateTime secondDayOfThisMonth = dt.withDayOfMonth(2);
		// 取本月最后一天，再也不用计算是28，29，30还是31：
		LocalDateTime lastDayOfThisMonth = dt.with(TemporalAdjusters.lastDayOfMonth());
		// 取下一天：
		LocalDateTime firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
		// 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
		LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));


		//Date->LocalDateTime
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		String format = dtf.format(localDateTime);
		System.out.println(format);
		//LocalDateTime->Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Instant instant1 = localDateTime.atZone(zoneId).toInstant();
		Date from = Date.from(instant1);
		String format1 = sdf.format(from);
		System.out.println(format1);

	}
}
