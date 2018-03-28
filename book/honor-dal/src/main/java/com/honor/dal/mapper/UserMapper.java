package com.honor.dal.mapper;

import java.util.List;

import com.honor.model.User;

/**
 * 用户数据访问
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface UserMapper {

	int insert(User user);

	int remove(Integer id);

	int updateNotNull(User user);

	User load(Integer id);

	List<User> loadAll();
	
	List<User> selectByName(String name);

}
