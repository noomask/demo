package com.example.demo.role.pojo;

import java.util.Date;

/**
 * 用户角色
 */
public class Role {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 菜单权限
     */
    private String menuPrivilege;
    /**
     * 模块权限
     */
    private String modulePrivilege;
    /**
     * 数据权限
     */
    private String dataPrivilege;
    /**
     * 操作权限
     */
    private String visblePrivilege;
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getMenuPrivilege() {
        return menuPrivilege;
    }
    public void setMenuPrivilege(String menuPrivilege) {
        this.menuPrivilege = menuPrivilege;
    }
    public String getModulePrivilege() {
        return modulePrivilege;
    }
    public void setModulePrivilege(String modulePrivilege) {
        this.modulePrivilege = modulePrivilege;
    }
    public String getDataPrivilege() {
        return dataPrivilege;
    }
    public void setDataPrivilege(String dataPrivilege) {
        this.dataPrivilege = dataPrivilege;
    }
    public String getVisblePrivilege() {
        return visblePrivilege;
    }
    public void setVisblePrivilege(String visblePrivilege) {
        this.visblePrivilege = visblePrivilege;
    }
}
