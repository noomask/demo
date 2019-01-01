package com.example.demo.dict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dict.pojo.Dict;

public interface DictMapper {

	@Select("SELECT * FROM t_dict ORDER BY pid, id DESC")
	List<Dict> selectAll();
	
	@Select("SELECT * FROM t_dict WHERE id = #{id}")
	Dict selectById(@Param("id")int id);
	
	@Select("SELECT count(*) FROM t_dict WHERE pid = #{pid}")
	int countByPid(@Param("pid")int pid);
	
	@Insert("INSERT INTO t_dict (pid,name,remark,`show`,add_user,add_date)Values(#{pid},#{name},#{remark},#{show},#{addUser},now())")
	void insert(Dict dict);
	
	void updateById(Dict dict);
	
	@Update("UPDATE t_dict SET `show`=#{show} WHERE FIND_IN_SET(id,getDictChildById(#{id}))")
	void updateShow(Dict dict);
	
	@Delete("DELETE FROM t_dict WHERE id = #{id}")
	void deleteById(@Param("id")int id);
	
}
