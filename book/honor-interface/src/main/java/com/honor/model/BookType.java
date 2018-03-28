package com.honor.model;

import java.io.Serializable;

/**
 * 书籍分类
 * 
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public class BookType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	// 分类
	private Integer typeName;
	
	// 父级id
	private Integer parentId;
	
	// 等级(1-大分类 2-细分类)
	private Integer level;
	
	// 排序
	private Integer sort;
	
	// 描述
	private String desc;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeName() {
		return typeName;
	}
	public void setTypeName(Integer typeName) {
		this.typeName = typeName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}

