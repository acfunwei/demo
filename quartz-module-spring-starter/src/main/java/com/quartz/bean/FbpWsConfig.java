package com.quartz.bean;

import java.util.Date;

public class FbpWsConfig {

	private String id;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private Byte enableFlag;

	private String wsCode;

	private String wsName;

	private String wsUrl;

	private String sysCode;

	private String wsType;

	private String description;

	private String wsParams;

	private String className;

	private String methodName;

	private Date lastCallTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getWsCode() {
		return wsCode;
	}

	public void setWsCode(String wsCode) {
		this.wsCode = wsCode;
	}

	public String getWsName() {
		return wsName;
	}

	public void setWsName(String wsName) {
		this.wsName = wsName;
	}

	public String getWsUrl() {
		return wsUrl;
	}

	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getWsType() {
		return wsType;
	}

	public void setWsType(String wsType) {
		this.wsType = wsType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWsParams() {
		return wsParams;
	}

	public void setWsParams(String wsParams) {
		this.wsParams = wsParams;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getLastCallTime() {
		return lastCallTime;
	}

	public void setLastCallTime(Date lastCallTime) {
		this.lastCallTime = lastCallTime;
	}

	public Byte getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(Byte enableFlag) {
		this.enableFlag = enableFlag;
	}

}
