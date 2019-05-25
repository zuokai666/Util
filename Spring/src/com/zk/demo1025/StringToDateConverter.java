package com.zk.demo1025;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToDateConverter implements Converter<String, Date> {

    private String[] patterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss.SSS"};

    @Override
    public Date convert(String source) {
        if ( StringUtils.isEmpty( source ) ) {
            return null;
        }
        for ( String pattern : patterns ) {
            try {
                return new SimpleDateFormat( pattern ).parse( source );
            } catch (Exception e) {
                // ignore exception, do next pattern parse.
            }
        }
        return null;
    }
}