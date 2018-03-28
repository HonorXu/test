package com.honor.dal.mapper;

import java.util.List;

import com.honor.model.Record;

/**
 * 借阅记录数据访问
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface RecordMapper {

	int insert(Record record);

	int updateNotNull(Record record);

	Record load(Integer id);

	List<Record> loadAll();
	
	List<Record> selectByBookId(Integer bookId);
	
	List<Record> selectByUserId(Integer userId);
	
	List<Record> selectByStatus(Integer status);

}
