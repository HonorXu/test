package com.honor.biz;

import com.honor.model.Record;
import java.util.List;

/**
 * 借阅记录业务接口
 *
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public interface RecordBiz {
	/**
	 * 添加
	 * @param record
	 * @return 新增对象ID
	 */
	public int add(Record record);
	
	/**
	 * 更新不为空的属性
	 * @param record
	 * @return
	 */
	public int updateNotNull(Record record);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public Record findById(Integer id);
	
	/**
	 * 
	 * 查询所有
	 * @return
	 */
	public List<Record> findAll();

	/**
	 * 根据查询
	 * @param bookId 
	 * @return
	 */
	public List<Record> findByBookId(Integer bookId);

	/**
	 * 根据查询
	 * @param userId 
	 * @return
	 */
	public List<Record> findByUserId(Integer userId);

	/**
	 * 根据状态(1-借出 2-归还)查询
	 * @param status 状态(1-借出 2-归还)
	 * @return
	 */
	public List<Record> findByStatus(Integer status);
	
}
