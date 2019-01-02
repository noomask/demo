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
	private String real_name;
	/**
	 *身份证号
	 */
	private String id_card;
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
	private Integer add_user;
	/**
	 *修改人
	 */
	private Integer upd_user;
	/**
	 *添加时间
	 */
	private Date add_date;
	/**
	 *修改时间
	 */
	private Date upd_date;
	/**
	 *删除标识：1->未删除；0->已删除；
	 */
	private Integer del_flag;
	
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
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
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
	public Integer getAdd_user() {
		return add_user;
	}
	public void setAdd_user(Integer add_user) {
		this.add_user = add_user;
	}
	public Integer getUpd_user() {
		return upd_user;
	}
	public void setUpd_user(Integer upd_user) {
		this.upd_user = upd_user;
	}
	public Date getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
	public Date getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	
}
