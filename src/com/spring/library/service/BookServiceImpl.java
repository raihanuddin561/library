package com.spring.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.BookDaoImpl;
import com.spring.library.model.Book;
@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
	@Autowired
private BookDaoImpl bookDao;
	@Override
	public void addBook(Book book) {
		
		bookDao.addBook(book);
	}

	@Override
	public List<Book> bookList() {
		// TODO Auto-generated method stub
		return bookDao.bookList();
	}

	public List<Book> bookList(String bookname) {
		// TODO Auto-generated method stub
		return bookDao.bookList(bookname);
	}

	public void removeBook(int bookid) {
		bookDao.removeBook(bookid);
		
	}

	public void returnBook(int borrowerid, String bookname) {
		bookDao.returnBook(borrowerid,bookname);
	}

}
