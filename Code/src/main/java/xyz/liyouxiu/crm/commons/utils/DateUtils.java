package xyz.liyouxiu.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyouxiu
 * @date 2022/10/17 15:38
 * 对data类型数据进行处理的工具类
 */
public class DateUtils {
    public static String formatDateTime(Date date){
        /**
         * 对指定的date对象进行格式化
         * yyyy-MM-dd HH:mm:ss
         */
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static String formatDate(Date date){
        /**
         * 对指定的date对象进行格式化
         * yyyy-MM-dd
         */
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static String formatTime(Date date){
        /**
         * 对指定的date对象进行格式化
         * HH:mm:ss
         */
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
