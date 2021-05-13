package com.baidu.fsg.uid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baidu.fsg.uid.impl.SnowFlakeUidGenerator;

@Configuration
@EnableConfigurationProperties(SnowFlakeUidGeneratorProperties.class)
public class SnowFlakeUidGeneratorAutoConfiguration {

	@Autowired
	private SnowFlakeUidGeneratorProperties snowFlakeUidGeneratorProperties;

	@Bean
	public SnowFlakeUidGenerator snowFlakeUidGenerator() {
		return new SnowFlakeUidGenerator(snowFlakeUidGeneratorProperties.getDataCenterId(),
				snowFlakeUidGeneratorProperties.getMachineId());
	}

}
