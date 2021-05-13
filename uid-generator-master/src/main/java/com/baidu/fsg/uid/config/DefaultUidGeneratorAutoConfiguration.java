package com.baidu.fsg.uid.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baidu.fsg.uid.UidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerIdAssigner;

@Configuration
@EnableConfigurationProperties(DefaultUidGeneratorProperties.class)
@AutoConfigureAfter(SqlSessionFactory.class)
public class DefaultUidGeneratorAutoConfiguration {

	@Autowired
	private DefaultUidGeneratorProperties defaultUidGeneratorProperties;

	@Bean
	@ConditionalOnMissingBean
	public WorkerIdAssigner disposableWorkerIdAssigner() {
		return new DisposableWorkerIdAssigner();
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix = "baidu.uid.generator", name = "type", havingValue = "defaultuid")
	public UidGenerator uidGenerator(WorkerIdAssigner workerIdAssigner) {
		DefaultUidGenerator defaultUidGenerator = new DefaultUidGenerator();
		defaultUidGenerator.setWorkerIdAssigner(workerIdAssigner);
		if (StringUtils.isNotBlank(defaultUidGeneratorProperties.getEpochStr())) {
			defaultUidGenerator.setEpochStr(defaultUidGeneratorProperties.getEpochStr());
		}
		if (defaultUidGeneratorProperties.getSeqBits() != null) {
			defaultUidGenerator.setSeqBits(defaultUidGeneratorProperties.getSeqBits());
		}
		if (defaultUidGeneratorProperties.getTimeBits() != null) {
			defaultUidGenerator.setTimeBits(defaultUidGeneratorProperties.getTimeBits());
		}
		if (defaultUidGeneratorProperties.getWorkerBits() != null) {
			defaultUidGenerator.setWorkerBits(defaultUidGeneratorProperties.getWorkerBits());
		}
		return defaultUidGenerator;
	}

}
