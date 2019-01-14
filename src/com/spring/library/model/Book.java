package com.spring.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="book")
@Table(name="book")
public class Book {
	@Id
	@Column(name="bookid")
	private int bookId;
	@Column(name="bookname")
	private String bookname;
	@Column(name="authorname")
	private String authorname;
	@Column(name="status")
	private String status;
	public Book() {
		
	}
	public Book(int bookId, String bookname, String authorname, String status) {
		super();
		this.bookId = bookId;
		this.bookname = bookname;
		this.authorname = authorname;
		this.status = status;
	}
	public Book(String bookname, String authorname, String status) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.status = status;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
