package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {

	@Select(value = "select count(*) from sequence")
	Map<String, Object> test();

	@Insert("insert into sequence(value) values(#{id})")
	int insert(long id);
}
