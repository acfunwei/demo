package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

@SpringBootApplication
@RestController
@MapperScan({ "com.example.demo.mapper", "com.baidu.fsg.uid.worker.dao", "com.quartz.mapper" })
@ComponentScan("com.*")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/druid/stat")
	public Object druidStat() {
		return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
	}

}
