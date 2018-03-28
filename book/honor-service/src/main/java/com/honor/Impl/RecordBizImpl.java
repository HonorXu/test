package com.honor.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honor.biz.RecordBiz;
import com.honor.dal.mapper.RecordMapper;
import com.honor.model.Record;

/**
 * 借阅记录业务实现
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
@Service
public class RecordBizImpl implements RecordBiz {
	
	@Autowired
	private RecordMapper recordMapper;

	@Override
	public int add(Record record) {
		recordMapper.insert(record);
		return record.getId();
	}
	
	@Override
	public int updateNotNull(Record record) {
		return recordMapper.updateNotNull(record);
	}
	
	@Override
	public List<Record> findAll() {
		return recordMapper.loadAll();
	}
	
	@Override
	public Record findById(Integer id) {
		return recordMapper.load(id);
	}
	
	@Override
	public List<Record> findByBookId(Integer bookId) {
		return recordMapper.selectByBookId(bookId);
	}
	
	@Override
	public List<Record> findByUserId(Integer userId) {
		return recordMapper.selectByUserId(userId);
	}
	
	@Override
	public List<Record> findByStatus(Integer status) {
		return recordMapper.selectByStatus(status);
	}
	
}
