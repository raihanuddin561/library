package com.spring.library.model;

import org.springframework.stereotype.Repository;

@Repository
public class Book {
	private int bookId;
	private String bookname;
	private String authorname;
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
