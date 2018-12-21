package com.spring.library.service;

import java.util.List;

import com.spring.library.model.Book;


public interface BookService {
	public void addBook(Book book);
	public List<Book> bookList();
	
}
