package com.example.demo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

public class FbpEmployee {

//	@FieldFill({ SqlCommandType.INSERT })
	@TableField(value = "id", fill = FieldFill.INSERT)
	private String id;
//	@FieldFill({ SqlCommandType.INSERT })
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;
//	@FieldFill({ SqlCommandType.INSERT })
	@TableField(value = "create_by", fill = FieldFill.INSERT)
	private String createBy;
//	@FieldFill({ SqlCommandType.INSERT })
	@TableField(value = "enable_flag", fill = FieldFill.INSERT)
	private Byte enableFlag;
//	@FieldFill({ SqlCommandType.INSERT, SqlCommandType.UPDATE })
	@TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
	private String updateBy;
//	@FieldFill({ SqlCommandType.INSERT, SqlCommandType.UPDATE })
	@TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

	private String employeeName;

	private String employeeNumber;

	private Integer age;

	private String address;

	private Byte sax;

	private String orgName;

	private String positionName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Byte getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(Byte enableFlag) {
		this.enableFlag = enableFlag;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getSax() {
		return sax;
	}

	public void setSax(Byte sax) {
		this.sax = sax;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "FbpEmployee [id=" + id + ", createDate=" + createDate + ", createBy=" + createBy + ", enableFlag="
				+ enableFlag + ", updateBy=" + updateBy + ", updateDate=" + updateDate + ", employeeName="
				+ employeeName + ", employeeNumber=" + employeeNumber + "]";
	}

}
