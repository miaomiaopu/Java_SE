package pers.yzcam.dateclass.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cat
 */
public class FormatDateManagement {

    public static final String SHORT_TIME = "h:m:s";
    public static final String LONGTIME = "HH:mm:ss SSSS";
    public static final String SHORT_DATE = "yy-M-d";
    public static final String LONG_DATE = "yyyy-MM-dd";
    public static final String FULL_DATE_TIME_CHINA = "yyyy年MM月dd日 HH时mm分ss秒 SSSS毫秒";

    /**
     * 使源 Date 对象按照 pattern 的格式格式化成字符串
     *
     * @param source  源 Date 对象
     * @param pattern 格式化标志
     * @return 目标字符串
     */
    public static String formatDateByPattern(Date source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(source);
    }

    /**
     * 使源日期字符串按照 pattern 的格式格式化成 Date 对象
     *
     * @param dateStr 源字符串
     * @param pattern 格式化标志
     * @return Date 目标 Date 对象
     */
    public static Date formatStringByPattern(String dateStr, String pattern) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
