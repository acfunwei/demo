package com.baidu.fsg.uid.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.baidu.fsg.uid.buffer.RejectedPutBufferHandler;
import com.baidu.fsg.uid.buffer.RejectedTakeBufferHandler;

@ConfigurationProperties(prefix = "baidu.uid.cache")
public class CachedUidGeneratorProperties {

	private Integer boostPower;

	private Integer paddingFactor;

	private Long scheduleInterval;

	private Class<? extends RejectedPutBufferHandler> rejectedPutBufferHandler;

	private Class<? extends RejectedTakeBufferHandler> rejectedTakeBufferHandler;

	public Integer getBoostPower() {
		return boostPower;
	}

	public void setBoostPower(Integer boostPower) {
		this.boostPower = boostPower;
	}

	public Integer getPaddingFactor() {
		return paddingFactor;
	}

	public void setPaddingFactor(Integer paddingFactor) {
		this.paddingFactor = paddingFactor;
	}

	public Long getScheduleInterval() {
		return scheduleInterval;
	}

	public void setScheduleInterval(Long scheduleInterval) {
		this.scheduleInterval = scheduleInterval;
	}

	public Class<? extends RejectedPutBufferHandler> getRejectedPutBufferHandler() {
		return rejectedPutBufferHandler;
	}

	public void setRejectedPutBufferHandler(Class<? extends RejectedPutBufferHandler> rejectedPutBufferHandler) {
		this.rejectedPutBufferHandler = rejectedPutBufferHandler;
	}

	public Class<? extends RejectedTakeBufferHandler> getRejectedTakeBufferHandler() {
		return rejectedTakeBufferHandler;
	}

	public void setRejectedTakeBufferHandler(Class<? extends RejectedTakeBufferHandler> rejectedTakeBufferHandler) {
		this.rejectedTakeBufferHandler = rejectedTakeBufferHandler;
	}

}
