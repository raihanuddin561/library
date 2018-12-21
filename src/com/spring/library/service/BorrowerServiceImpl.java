package com.spring.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.BorrowerDaoImpl;
import com.spring.library.model.Borrower;

@Service("borrowerServiceImpl")
public class BorrowerServiceImpl implements BorrowerService {
	@Autowired
	private BorrowerDaoImpl borrowerDao;

	@Override
	public void addBorrower(Borrower borrower) {
		borrowerDao.addBorrower(borrower);

	}

	@Override
	public List<Borrower> getBorrowerList() {
		
		return borrowerDao.getBorrowerList();
	}

	public List<Borrower> getBorrowedInfo(String name) {
		// TODO Auto-generated method stub
		return borrowerDao.getBorrowedInfo(name);
	}

}
