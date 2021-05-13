package com.baidu.fsg.uid.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = SnowFlakeUidGeneratorProperties.PREFIX)
public class SnowFlakeUidGeneratorProperties {

	public static final String PREFIX = "snow-flake";

	private Long dataCenterId;

	private Long machineId;

	public Long getDataCenterId() {
		return dataCenterId;
	}

	public void setDataCenterId(Long dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	public Long getMachineId() {
		return machineId;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

}
