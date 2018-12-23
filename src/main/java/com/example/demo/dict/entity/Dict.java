package com.example.demo.dict.entity;

import java.util.Date;

public class Dict {

	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 父ID
	 */
	private Integer pid;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 添加人
	 */
	private Integer addUser;
	/**
	 * 修改人	
	 */
	private Integer updUser;
	/**
	 * 添加时间
	 */
	private Date addDate;
	/**
	 * 修改时间
	 */
	private Date updDate;
	/**
	 * 删除标识：1->未删除；0->已删除；
	 */
	private Integer delFlag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAddUser() {
		return addUser;
	}
	public void setAddUser(Integer addUser) {
		this.addUser = addUser;
	}
	public Integer getUpdUser() {
		return updUser;
	}
	public void setUpdUser(Integer updUser) {
		this.updUser = updUser;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	
}
