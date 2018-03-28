package com.honor.dal.mapper;

import java.util.List;


import com.honor.model.BookType;

/**
 * 书籍分类数据访问
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface BookTypeMapper {

	int insert(BookType bookType);

	int remove(Integer id);

	int updateNotNull(BookType bookType);

	BookType load(Integer id);

	List<BookType> loadAll();

}
