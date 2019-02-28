package com.example.demo.role.mapper;

import com.example.demo.role.pojo.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT * FROM t_role")
    List<Role> selectAll();

    @Select("SELECT * FROM t_role WHERE id = #{id}")
    Role selectById(@Param("id") int id);

    int insert(Role role);

    void updateById(Role role);

    @Delete("DELETE FROM t_role WHERE id = #{id}")
    void deleteById(@Param("id") int id);

    void updatePrivilege(Role role);

    @Update("UPDATE t_role SET menu_privilege = #{menuPrivilege} WHERE id = #{id}")
    void updateMenuPrivilege(Role role);

    @Select("SELECT * FROM t_role WHERE id = #{id}")
    Role selectPrivilege(@Param("id") int id);

    @Select("SELECT * FROM t_role WHERE id IN (${ids})")
    List<Role> selectSelfRole(@Param("ids") String ids);

}
