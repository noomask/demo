package com.example.demo.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.user.pojo.User;

public interface UserMapper {

	@Select("SELECT * FROM t_user")
	List<User> selectAll();
	
	List<User> select4Page(@Param("limit")int limit, @Param("offset")int offset);
	
	int count4Page();
	
	@Select("SELECT * FROM t_user WHERE id = #{id}")
	User selectById(@Param("id") int id);
	
	void insert(User user);
	
	void updateById(User user);
	
	@Delete("DELETE FROM t_user WHERE id = #{id}")
	void deleteById(@Param("id") int id);

	int register(User user);

	User selectIsRegister(User user);

	List<User> selectForLogin(User user);
	
}
