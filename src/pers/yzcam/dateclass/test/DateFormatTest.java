package pers.yzcam.dateclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.dateclass.utils.FormatDateManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author cat
 */
public class DateFormatTest {

    @Test
    void useDateFormatTest() {
        Date date = new Date(12345678228L);

        // 以默认形式实现对给定的 Date 对象格式化
        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println(dateFormat.format(date));
        // 以给定形式实现对给定的 Date 对象格式化
        DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(dateFormat1.format(date));
    }

    @Test
    void useSimpleDateFormatTest() {
        Date date = new Date(12345678228L);
        // 默认格式化标记和环境
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(simpleDateFormat.format(date));
        // 给定格式化标记和默认环境
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(simpleDateFormat1.format(date));
        // 给定格式化标记和环境
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd a", Locale.JAPAN);
        System.out.println(simpleDateFormat2.format(date));
    }

    @Test
    void formatDateByPatternMethodTest() {
        Date date = new Date();
        System.out.println(FormatDateManagement.formatDateByPattern(date, FormatDateManagement.FULL_DATE_TIME_CHINA));
    }

    @Test
    void formatStringByPatternMethodTest() {
        String dateStr = "2021年11月10日 15时38分30秒 0130毫秒";
        Date resDate = FormatDateManagement.formatStringByPattern(dateStr, FormatDateManagement.FULL_DATE_TIME_CHINA);
        System.out.println(resDate);
    }
}
