package com.spring.library.dao;

import java.util.List;

import com.spring.library.model.Book;

public interface BookDao {
	public void addBook(Book book);
	public List<Book> bookList();
}
