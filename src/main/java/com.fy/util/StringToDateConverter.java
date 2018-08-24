package com.fy.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 用于SpringMVC配置的日期转换工具
 *
 */
public class StringToDateConverter implements Converter<String,Date>{
	
	public Date convert(String source) {
		return StringUtils.isEmpty(source)?null:DateUtil.parseDate(source); 
	}
}
