package pers.yzcam.calendarclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.calendarclass.entity.Employee;
import pers.yzcam.calendarclass.utils.CalendarSupport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author cat
 */
public class CalendarTest {

    CalendarSupport calendarSupport = new CalendarSupport();

    @Test
    void createCalendarTest() {
        Calendar calendar = Calendar.getInstance();
        // 月份 +1，星期 -1
        System.out.println("当前时间 " + calendar.get(Calendar.YEAR) + " 年 " +
                (calendar.get(Calendar.MONTH) + 1) + " 月 " +
                calendar.get(Calendar.DATE) + " 日");

        Calendar calendar1 = Calendar.getInstance(Locale.UK);
        Date date = calendar1.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss", Locale.JAPAN).format(date));
    }

    @Test
    void formatDateByTagTest() {
        int year = 1977;
        int month = 10;
        int day = 9;

        Object object = calendarSupport.formatDateByTag(year, month, day, 1);
        System.out.println(object);
    }

    @Test
    void modifyBirthTest() {
        Employee employee = new Employee("玛卡巴卡", new Date());
        System.out.println("未修改的生日 " + new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirth()));

        CalendarSupport.modifyBirth(employee, 3, 1, 1);
        System.out.println("修改后的生日 " + new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirth()));
    }

    @Test
    void compareDateTest() {
        Date birth1 = new Date(222222222L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(birth1));
        Date birth2 = new Date(333333333L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(birth2));

        System.out.println("最后比较的天数差为 " + calendarSupport.compareDate(birth1, birth2));
    }
}
