package com.example.demo.menu.pojo;

import java.util.Date;

/**
 * 菜单
 * @author ANNION
 *
 */
public class Menu {

	/**
	 *主键ID
	 */
	private Integer id;
	/**
	 *父ID
	 */
	private Integer pid;
	/**
	 *菜单名称
	 */
	private String name;
	/**
	 *菜单地址
	 */
	private String menuUrl;
	/**
	 *菜单图标
	 */
	private String icon;
	/**
	 *是否显示：1->显示；0->不显示;
	 */
	private Integer show;
	/**
	 *显示顺序
	 */
	private Integer viewOrder;
	/**
	 * 备注
	 */
	private String remark;
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
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getShow() {
		return show;
	}
	public void setShow(Integer show) {
		this.show = show;
	}
	public Integer getViewOrder() {
		return viewOrder;
	}
	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
