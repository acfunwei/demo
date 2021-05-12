package com.example.demo.sys.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisLanguageDriverAutoConfigution {

//	@Autowired
	private SqlSessionFactory sqlSessionFactory;

//	@PostConstruct
	public void config() {
		sqlSessionFactory.getConfiguration().setDefaultScriptingLanguage(CustonXMLLanguageDriver.class);
	}

}
