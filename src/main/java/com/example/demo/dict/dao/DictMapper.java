package com.example.demo.dict.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dict.entity.Dict;

public interface DictMapper {

	@Select("SELECT * FROM t_dict")
	List<Dict> selectAll();
	
	@Select("SELECT * FROM t_dict WHERE id = #{id}")
	Dict selectById(@Param("id")int id);
	
	@Insert("INSERT INTO t_dict (pid,name,add_user,add_date)Values(#{pid},#{name},#{addUser},now())")
	void insert(Dict dict);
	
	@Update("UPDATE t_dict SET name = #{name}, upd_user = #{updUser}, upd_date = now() WHERE id = #{id}")
	void updateById(Dict dict);
	
	@Delete("DELETE FROM t_dict WHERE id = #{id}")
	void deleteById(@Param("id")int id);
	
}
