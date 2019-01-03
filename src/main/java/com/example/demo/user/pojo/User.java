package com.example.demo.user.pojo;

import java.util.Date;

public class User {

	/**
	 *主键ID
	 */
	private Integer id;
	/**
	 *账号
	 */
	private String account;
	/**
	 *密码
	 */
	private String password;
	/**
	 *昵称
	 */
	private String name;
	/**
	 *真实姓名
	 */
	private String realName;
	/**
	 *身份证号
	 */
	private String idCard;
	/**
	 *性别
	 */
	private Integer sex;
	/**
	 *邮箱
	 */
	private String email;
	/**
	 *手机号
	 */
	private String phone;
	/**
	 *QQ
	 */
	private String qq;
	/**
	 *微信
	 */
	private String wechat;
	/**
	 *头像
	 */
	private String icon;
	/**
	 *添加人
	 */
	private Integer addUser;
	/**
	 *修改人
	 */
	private Integer updUser;
	/**
	 *添加时间
	 */
	private Date addDate;
	/**
	 *修改时间
	 */
	private Date updDate;
	/**
	 *删除标识：1->未删除；0->已删除；
	 */
	private Integer delFlag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
