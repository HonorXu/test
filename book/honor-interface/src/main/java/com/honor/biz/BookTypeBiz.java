package com.honor.biz;

import com.honor.model.BookType;
import java.util.List;

/**
 * 书籍分类业务接口
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface BookTypeBiz {
	/**
	 * 添加
	 * @param bookType
	 * @return 新增对象ID
	 */
	public int add(BookType bookType);
	
	/**
	 * 根据ID物理删除
	 * @param id
	 * @return
	 */
	public int removeById(Integer id);
	
	/**
	 * 更新不为空的属性
	 * @param bookType
	 * @return
	 */
	public int updateNotNull(BookType bookType);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public BookType findById(Integer id);
	
	/**
	 * 
	 * 查询所有
	 * @return
	 */
	public List<BookType> findAll();
	
}
