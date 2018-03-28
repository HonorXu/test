package com.honor.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honor.biz.UserBiz;
import com.honor.dal.mapper.UserMapper;
import com.honor.model.User;

/**
 * 用户业务实现
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
@Service
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int add(User user) {
		userMapper.insert(user);
		return user.getId();
	}
	
	@Override
	public int removeById(Integer id) {
		return userMapper.remove(id);
	}
	
	@Override
	public int updateNotNull(User user) {
		return userMapper.updateNotNull(user);
	}
	
	@Override
	public List<User> findAll() {
		return userMapper.loadAll();
	}
	
	@Override
	public User findById(Integer id) {
		return userMapper.load(id);
	}
	
	@Override
	public List<User> findByName(String name) {
		return userMapper.selectByName(name);
	}
	
}
