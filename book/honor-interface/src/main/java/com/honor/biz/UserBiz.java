package com.honor.biz;

import com.honor.model.User;
import java.util.List;

/**
 * 用户业务接口
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface UserBiz {
	/**
	 * 添加
	 * @param user
	 * @return 新增对象ID
	 */
	public int add(User user);
	
	/**
	 * 根据ID物理删除
	 * @param id
	 * @return
	 */
	public int removeById(Integer id);
	
	/**
	 * 更新不为空的属性
	 * @param user
	 * @return
	 */
	public int updateNotNull(User user);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
	
	/**
	 * 
	 * 查询所有
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 根据姓名查询
	 * @param name 姓名
	 * @return
	 */
	public List<User> findByName(String name);
	
}
