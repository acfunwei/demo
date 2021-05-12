package com.example.demo.sys.config.mybatis;

import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		Date date = new Date();
		this.strictInsertFill(metaObject, "id", String.class, UUID.randomUUID().toString());
		this.strictInsertFill(metaObject, "createBy", String.class, "-1");
		this.strictInsertFill(metaObject, "createDate", Date.class, date);
		this.strictInsertFill(metaObject, "updateBy", String.class, "-1");
		this.strictInsertFill(metaObject, "updateDate", Date.class, date);
		this.strictInsertFill(metaObject, "enableFlag", Byte.class, Byte.valueOf("1"));
		System.out.println(JSON.toJSONString(metaObject.getOriginalObject()));
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "updateDate", Date.class, new Date());
	}

}
