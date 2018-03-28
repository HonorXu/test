package com.honor.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 借阅记录
 * 
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public class Record implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	
	private Integer bookId;
	
	
	private Integer userId;
	
	// 借出时间
	private Date lendTime;
	
	// 归还时间
	private Date returnTime;
	
	// 状态(1-借出 2-归还)
	private Integer status;
	
	// 管理员ID
	private Integer createUserId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getLendTime() {
		return lendTime;
	}
	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

}

