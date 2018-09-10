package cn.study.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author asus
 * @Title: DateConverter
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/5 18:42
 */
public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 把字符串转换为日期类型
            return simpleDateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果转换异常则返回空
        return null;
    }
}
