package com.honor.biz;

import java.util.List;

import com.honor.model.Book;

/**
 * 书籍分类业务接口
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface BookBiz {
	/**
	 * 添加
	 * @param book
	 * @return 新增对象ID
	 */
	public int add(Book book);
	
	/**
	 * 根据ID物理删除
	 * @param id
	 * @return
	 */
	public int removeById(Integer id);
	
	/**
	 * 更新不为空的属性
	 * @param book
	 * @return
	 */
	public int updateNotNull(Book book);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public Book findById(Integer id);
	
	/**
	 * 
	 * 查询所有
	 * @return
	 */
	public List<Book> findAll();

	/**
	 * 根据分类ID查询
	 * @param typeId 分类ID
	 * @return
	 */
	public List<Book> findByTypeId(Integer typeId);
	
	/**
	 * 根据isbn查询数据
	 * @param isbn
	 * @return
	 */
	public Book findByIsbn(String isbn);
	
}
