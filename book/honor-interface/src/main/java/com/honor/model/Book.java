package com.honor.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 书籍分类
 * 
 * @创建者：honor
 * @创建时间：2018-03-13
 */
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	// 书名
	private String title;
	
	// 副标题
	private String subtitle;
	
	// 作者
	private String author;
	
	// 分类ID
	private Integer typeId;
	
	// 出版时间2018-03
	private LocalDate publishDate;
	
	// 出版社
	private String publisher;
	
	// 封面
	private String coverPic;
	
	// 精装,平装
	private String binding;
	
	// 书籍页数
	private Integer pages;
	
	// 定价
	private Double price;
	
	// isbn
	private String isbn;
	
	// 作者生平
	private String authorIntro;
	
	// 概要
	private String summary;
	
	// 借阅数量
	private Integer borrowTimes;
	
	// s书籍总数
	private Integer bookTotal;
	
	// 借出数量
	private Integer bookBorrowed;
	
	// 状态(1-正常 2-下架)
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCoverPic() {
		return coverPic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorIntro() {
		return authorIntro;
	}

	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getBorrowTimes() {
		return borrowTimes;
	}

	public void setBorrowTimes(Integer borrowTimes) {
		this.borrowTimes = borrowTimes;
	}

	public Integer getBookTotal() {
		return bookTotal;
	}

	public void setBookTotal(Integer bookTotal) {
		this.bookTotal = bookTotal;
	}

	public Integer getBookBorrowed() {
		return bookBorrowed;
	}

	public void setBookBorrowed(Integer bookBorrowed) {
		this.bookBorrowed = bookBorrowed;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

