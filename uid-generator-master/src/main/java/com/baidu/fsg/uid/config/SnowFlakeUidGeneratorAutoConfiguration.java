package com.baidu.fsg.uid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix = "baidu.uid.generator", name = "type", havingValue = "snowflakeuid")
	public SnowFlakeUidGenerator snowFlakeUidGenerator() {
		return new SnowFlakeUidGenerator(snowFlakeUidGeneratorProperties.getDataCenterId(),
				snowFlakeUidGeneratorProperties.getMachineId());
	}

}
