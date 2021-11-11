package pers.yzcam.calendarclass.utils;

import pers.yzcam.calendarclass.entity.Employee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author cat
 */
public class CalendarSupport {
    public static final int ONE = 1;
    public static final int TWO = 2;

    /**
     * 根据给定 tag，对给定年、月、日组合为 String 或 Date 对象返回
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @param tag   标志(0 返回 Date，1 返回 String)
     * @return (String OR Date)目标对象
     */
    public Object formatDateByTag(int year, int month, int day, int tag) {
        month--;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (tag == 0) {
            return calendar.getTime();
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 对给定的员工生日进行操作，对年或者月或者日进行增减
     *
     * @param employee 员工对象
     * @param num      增减幅度
     * @param dateTag  对哪部分日期进行修改(1 表示年，2 表示月，3 表示日)
     * @param addOrSub 增减还是减少的标识符(1 表示增加，-1 表示减少)
     */
    public static void modifyBirth(Employee employee, int num, int dateTag, int addOrSub) {
        Date birth = employee.getBirth();

        Calendar calendar = Calendar.getInstance();
        // 设置日历的毫秒值
        calendar.setTimeInMillis(birth.getTime());

        if (addOrSub > 0) {
            if (dateTag == ONE) {
                calendar.add(Calendar.YEAR, num);
            } else if (dateTag == TWO) {
                calendar.add(Calendar.MONTH, num);
            } else {
                calendar.add(Calendar.DATE, num);
            }
        } else {
            if (dateTag == ONE) {
                calendar.add(Calendar.YEAR, (-1) * num);
            } else if (dateTag == TWO) {
                calendar.add(Calendar.MONTH, (-1) * num);
            } else {
                calendar.add(Calendar.DATE, (-1) * num);
            }
        }

        employee.setBirth(calendar.getTime());
    }

    /**
     * 比较两个日期的天数差
     *
     * @param date1 日期
     * @param date2 另一个日期
     * @return (long)返回的天数差，为正数
     */
    public long compareDate(Date date1, Date date2) {
        long date1Long = date1.getTime();
        long date2Long = date2.getTime();

        long sub = Math.abs(date1Long - date2Long);

        return (((sub / 1000) / 60) / 60) / 24;
    }

}
