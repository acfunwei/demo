package com.baidu.fsg.uid.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "baidu.uid.default")
public class DefaultUidGeneratorProperties {

	private Integer timeBits;

	private Integer workerBits;

	private Integer seqBits;

	private String epochStr;

	public Integer getTimeBits() {
		return timeBits;
	}

	public void setTimeBits(Integer timeBits) {
		this.timeBits = timeBits;
	}

	public Integer getWorkerBits() {
		return workerBits;
	}

	public void setWorkerBits(Integer workerBits) {
		this.workerBits = workerBits;
	}

	public Integer getSeqBits() {
		return seqBits;
	}

	public void setSeqBits(Integer seqBits) {
		this.seqBits = seqBits;
	}

	public String getEpochStr() {
		return epochStr;
	}

	public void setEpochStr(String epochStr) {
		this.epochStr = epochStr;
	}

}
