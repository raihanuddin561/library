package com.spring.library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.library.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		book.setStatus("available");
		session.save(book);

	}

	@Override
	public List<Book> bookList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> queryForBook = (Query<Book>) currentSession.createQuery("from book where status=:status");
		queryForBook.setParameter("status", "available");

		List<Book> bookList = queryForBook.getResultList();

		return bookList;
	}

	public List<Book> bookList(String bookname) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Book> queryForBook = (Query<Book>) currentSession.createQuery("from book where bookname like :bookname and status=:status");
		queryForBook.setParameter("bookname", "%"+bookname+"%");
		queryForBook.setParameter("status","available");
		List<Book> bookList = queryForBook.getResultList();

		return bookList;

	}
	


	public void removeBook(int bookid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("delete from book where bookid=:bookid");
		query.setParameter("bookid", bookid);
		query.executeUpdate();
	}

	public void returnBook(int borrowerid, String bookname) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = (Query) currentSession.createQuery("delete from borrower where borrowerid=:borrowerid");
		query.setParameter("borrowerid", borrowerid);
		Query queryForUpdate = (Query) currentSession.createQuery("update book set status=:status where bookname=:bookname");
		queryForUpdate.setParameter("status","available");
		queryForUpdate.setParameter("bookname", bookname);
		query.executeUpdate();
		queryForUpdate.executeUpdate();
 }

}
