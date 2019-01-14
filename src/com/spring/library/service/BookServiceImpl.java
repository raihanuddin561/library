package com.spring.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.BookDao;
import com.spring.library.dao.BookDaoImpl;
import com.spring.library.model.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
private BookDao bookDao;
	@Override
	@Transactional
	public void addBook(Book book) {
		
		bookDao.addBook(book);
	}

	@Override
	@Transactional
	public List<Book> bookList() {
		// TODO Auto-generated method stub
		return bookDao.bookList();
	}
	@Transactional
	public List<Book> bookList(String bookname) {
		// TODO Auto-generated method stub
		return bookDao.bookList(bookname);
	}
	@Transactional
	public void removeBook(int bookid) {
		bookDao.removeBook(bookid);
		
	}
	@Transactional
	public void returnBook(int borrowerid, String bookname) {
		bookDao.returnBook(borrowerid,bookname);
	}

	

}
