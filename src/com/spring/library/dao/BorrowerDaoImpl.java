package com.spring.library.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.library.model.Borrower;
@Repository
public class BorrowerDaoImpl implements BorrowerDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	
	@Override
	public void addBorrower(Borrower borrower) {
		String queryForBorrower = "insert into borrower(borrowername,bookname,address,contact,duedate) values(?,?,?,?,?)";
		String queryForStatus = "update book set status=? where bookname=?";
	
		
		Session session = sessionFactory.getCurrentSession();
		session.save(borrower);
		Query queryForUpdate= (Query) session.createQuery("update book set status=:status where bookname=:bookname");
		queryForUpdate.setParameter("status","borrowed");
		queryForUpdate.setParameter("bookname", borrower.getBookname());
		queryForUpdate.executeUpdate();
		
	

	}

	@Override
	public List<Borrower> getBorrowerList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Borrower> query = (Query<Borrower>) session.createQuery("from borrower");
		List<Borrower> getBorrowerList = query.getResultList();
		return getBorrowerList;
	}

	public List<Borrower> getBorrowedInfo(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Borrower> query = (Query<Borrower>) session.createQuery("from borrower where borrowername=:borrowername");
		query.setParameter("borrowername", name);
		List<Borrower> getBorrowedInfo = query.getResultList();
		return getBorrowedInfo;
	}

}
