package com.honor.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honor.biz.BookBiz;
import com.honor.dal.mapper.BookMapper;
import com.honor.model.Book;

/**
 * 书籍分类业务实现
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
@Service
public class BookBizImpl implements BookBiz {
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public int add(Book book) {
		bookMapper.insert(book);
		return book.getId();
	}
	
	@Override
	public int removeById(Integer id) {
		return bookMapper.remove(id);
	}
	
	@Override
	public int updateNotNull(Book book) {
		return bookMapper.updateNotNull(book);
	}
	
	@Override
	public List<Book> findAll() {
		return bookMapper.loadAll();
	}
	
	@Override
	public Book findById(Integer id) {
		return bookMapper.load(id);
	}
	
	@Override
	public List<Book> findByTypeId(Integer typeId) {
		return bookMapper.selectByTypeId(typeId);
	}

	@Override
	public Book findByIsbn(String isbn) {
		return bookMapper.selectByIsbn(isbn);
	}
	
}
