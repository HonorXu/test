package com.honor.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honor.biz.BookTypeBiz;
import com.honor.dal.mapper.BookTypeMapper;
import com.honor.model.BookType;

/**
 * 书籍分类业务实现
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
@Service
public class BookTypeBizImpl implements BookTypeBiz {
	
	@Autowired
	private BookTypeMapper bookTypeMapper;

	@Override
	public int add(BookType bookType) {
		bookTypeMapper.insert(bookType);
		return bookType.getId();
	}
	
	@Override
	public int removeById(Integer id) {
		return bookTypeMapper.remove(id);
	}
	
	@Override
	public int updateNotNull(BookType bookType) {
		return bookTypeMapper.updateNotNull(bookType);
	}
	
	@Override
	public List<BookType> findAll() {
		return bookTypeMapper.loadAll();
	}
	
	@Override
	public BookType findById(Integer id) {
		return bookTypeMapper.load(id);
	}
	
}
