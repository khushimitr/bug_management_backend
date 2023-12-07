package com.example.springbugtracker.config.annotation;

import com.example.springbugtracker.constant.AppConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.*;

@Target(value = {
        ElementType.ANNOTATION_TYPE,
        ElementType.TYPE,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER
})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@JsonFormat(pattern = AppConstant.LOCAL_DATE_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
@DateTimeFormat(pattern = AppConstant.LOCAL_DATE_TIME_FORMAT)
@JsonSerialize(using = LocalDateTimeSerializer.class)
@JsonDeserialize(using = LocalDateTimeDeserializer.class)
public @interface LocalDateTimeCustomFormat {
    String format() default AppConstant.LOCAL_DATE_TIME_FORMAT;
}
