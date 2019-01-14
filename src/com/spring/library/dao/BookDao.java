package com.spring.library.dao;

import java.util.List;

import com.spring.library.model.Book;

public interface BookDao {
	public void addBook(Book book);
	public List<Book> bookList();
	public List<Book> bookList(String bookname);
	public void removeBook(int bookid);
	public void returnBook(int borrowerid, String bookname);
	
}
