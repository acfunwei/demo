package com.baidu.fsg.uid.config;

import java.lang.reflect.InvocationTargetException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;

@Configuration
@EnableConfigurationProperties({ CachedUidGeneratorProperties.class, DefaultUidGeneratorProperties.class,
		SnowFlakeUidGeneratorProperties.class })
@AutoConfigureAfter(SqlSessionFactory.class)
public class CachedUidGeneratorAutoConfiguration {

	@Autowired
	private CachedUidGeneratorProperties cachedUidGeneratorProperties;

	@Bean
	@ConditionalOnMissingBean
	public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
		return new DisposableWorkerIdAssigner();
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix = "baidu.uid.generator", name = "type", havingValue = "cacheduid")
	public CachedUidGenerator cachedUidGenerator(@Autowired DisposableWorkerIdAssigner disposableWorkerIdAssigner)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
		cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner);
		if (cachedUidGeneratorProperties.getBoostPower() != null) {
			cachedUidGenerator.setBoostPower(cachedUidGeneratorProperties.getBoostPower());
		}
		if (cachedUidGeneratorProperties.getPaddingFactor() != 0) {
			cachedUidGenerator.setPaddingFactor(cachedUidGeneratorProperties.getPaddingFactor());
		}
		if (cachedUidGeneratorProperties.getScheduleInterval() != 0) {
			cachedUidGenerator.setScheduleInterval(cachedUidGeneratorProperties.getScheduleInterval());
		}
		if (cachedUidGeneratorProperties.getRejectedPutBufferHandler() != null) {
			cachedUidGenerator.setRejectedPutBufferHandler(
					cachedUidGeneratorProperties.getRejectedPutBufferHandler().getDeclaredConstructor().newInstance());
		}
		if (cachedUidGeneratorProperties.getRejectedTakeBufferHandler() != null) {
			cachedUidGenerator.setRejectedTakeBufferHandler(
					cachedUidGeneratorProperties.getRejectedTakeBufferHandler().getDeclaredConstructor().newInstance());
		}
		return cachedUidGenerator;
	}

}
