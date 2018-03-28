package com.honor.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.honor.model.Book;

/**
 * 书籍分类数据访问
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
@Mapper
public interface BookMapper {

	int insert(Book book);

	int remove(Integer id);

	int updateNotNull(Book book);

	Book load(Integer id);

	List<Book> loadAll();
	
	List<Book> selectByTypeId(Integer typeId);

	Book selectByIsbn(String isbn);

}
