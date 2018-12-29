package com.example.demo.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.menu.pojo.Menu;

public interface MenuMapper {

	@Select("SELECT * FROM t_menu")
	List<Menu> selectAll();
	
	@Select("SELECT * FROM t_menu WHERE id = #{id}")
	Menu selectById(@Param("id")int id);
	
	void insert(Menu menu);
	
	@Update("UPDATE t_menu SET name = #{name} WHERE id = #{id}")
	void updateById(Menu menu);
	
	@Delete("DELETE FROM t_menu WHERE id = #{id}")
	void deleteById(int id);
	
}
