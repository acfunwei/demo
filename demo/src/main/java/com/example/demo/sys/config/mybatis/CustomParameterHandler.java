package com.example.demo.sys.config.mybatis;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

public class CustomParameterHandler extends DefaultParameterHandler {

	private static final Byte save = Byte.valueOf("1");

	public CustomParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
		super(mappedStatement, fieldFill(parameterObject, mappedStatement), boundSql);
	}

	public static Object fieldFill(Object params, MappedStatement mappedStatement) {
		if (mappedStatement.getSqlCommandType().equals(SqlCommandType.INSERT)) {
			return fieldInsertFill(params, mappedStatement.getSqlCommandType());
		}
		if (mappedStatement.getSqlCommandType().equals(SqlCommandType.UPDATE)) {
			return fieldUpdateFill(params, mappedStatement.getSqlCommandType());
		}
		return params;
	}

	private static Object fieldUpdateFill(Object params, SqlCommandType update) {
		Date date = new Date();
		setFillValue("updateBy", "-1", update, params);
		setFillValue("updateDate", date, update, params);
		return params;
	}

	// 失败，参数封装是在生成mappered之后的
	private static Object fieldInsertFill(Object params, SqlCommandType insert) {
		Date date = new Date();
		setFillValue("id", UUID.randomUUID().toString(), insert, params);
		setFillValue("createBy", "-1", insert, params);
		setFillValue("updateBy", "-1", insert, params);
		setFillValue("createDate", date, insert, params);
		setFillValue("updateDate", date, insert, params);
		setFillValue("enableFlag", save, insert, params);
		return params;
	}

	private static void setFillValue(String filedName, Object value, SqlCommandType sqlCommandType, Object param) {
		try {
			Class<?> clazz = param.getClass();
			Field field = null;
			try {
				field = clazz.getField(filedName);
			} catch (Exception e) {
				field = clazz.getDeclaredField(filedName);
			}
			if (field.isAnnotationPresent(FieldFill.class)) {
				SqlCommandType[] sqlCommandTypes = field.getAnnotation(FieldFill.class).value();
				for (int i = 0; i < sqlCommandTypes.length; i++) {
					if (sqlCommandTypes[i].equals(sqlCommandType)) {
						field.setAccessible(true);
						field.set(param, value);
						return;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private <T> T getFillValue(String filedName, T clazz, Object param) {

		return clazz;
	}

}
