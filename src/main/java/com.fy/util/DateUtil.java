package com.fy.util;/**
 * Created by yk on 2018/07/19
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author kai
 * @Description 日期处理
 * @Create 2018-07-19 11:07
 **/
public class DateUtil {
    //获取date（包含date）及之前days天之间的全部日期，共取days天
    public static List<String> listDatesBackwards(Date date, Integer days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取days天前的日期
        cal.add(Calendar.DATE, -days + 1);
        Date beginDate = cal.getTime();
        //将时间设置为起始日期
        cal.setTime(beginDate);
        //用于将日期格式化为字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd");
        List<String> dateList = new ArrayList<>();
        // 测试此日期是否在date之后
        while (date.after(cal.getTime())) {
            // 没有超过date则加一天
            dateList.add(dateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        //加上date
        dateList.add(dateFormat.format(date));
        return dateList;
    }

    //将秒数转换为日时分秒（字符串）
    public static String secondToTime(long second) {
        if (second > 86400) {
            //时间在一天以上
            long days = second / 86400;            //转换天数
            second = second % 86400;            //剩余秒数
            long hours = second / 3600;            //转换小时
            second = second % 3600;                //剩余秒数
            long minutes = second / 60;            //转换分钟
            second = second % 60;                //剩余秒数
            return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
        } else if (second > 3600) {
            //一天以内，一小时以上
            long hours = second / 3600;            //转换小时
            second = second % 3600;                //剩余秒数
            long minutes = second / 60;            //转换分钟
            second = second % 60;                //剩余秒数
            return hours + "小时" + minutes + "分" + second + "秒";
        } else if (second > 60) {
            //一小时以内， 一分钟以上
            long minutes = second / 60;            //转换分钟
            second = second % 60;                //剩余秒数
            return minutes + "分" + second + "秒";
        } else {
            //一分钟以内
            return second + "秒";
        }
    }

}
