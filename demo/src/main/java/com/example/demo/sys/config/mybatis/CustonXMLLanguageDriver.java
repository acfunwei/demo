package com.example.demo.sys.config.mybatis;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

public class CustonXMLLanguageDriver extends XMLLanguageDriver {

	@Override
	public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject,
			BoundSql boundSql) {
		return new CustomParameterHandler(mappedStatement, parameterObject, boundSql);
	}

}
