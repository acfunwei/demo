package com.example.demo.sys.config.mybatis;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.apache.ibatis.mapping.SqlCommandType;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface FieldFill {

	SqlCommandType[] value();

}
