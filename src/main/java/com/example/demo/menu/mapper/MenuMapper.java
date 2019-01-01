package com.example.demo.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.menu.pojo.Menu;

public interface MenuMapper {

	@Select("SELECT * FROM t_menu ORDER BY pid, view_order DESC, id DESC")
	List<Menu> selectAll();
	
	@Select("SELECT * FROM t_menu WHERE id = #{id}")
	Menu selectById(@Param("id")int id);
	
	@Select("SELECT count(*) FROM t_menu WHERE pid = #{pid}")
	int countByPid(@Param("pid")int pid);
	
	void insert(Menu menu);
	
	void updateById(Menu menu);
	
	@Update("UPDATE t_menu SET `show`=#{show} WHERE FIND_IN_SET(id,getMenuChildById(#{id}))")
	void updateShow(Menu menu);
	
	@Delete("DELETE FROM t_menu WHERE id = #{id}")
	void deleteById(int id);
	
}
