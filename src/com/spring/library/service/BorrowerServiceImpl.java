package com.spring.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.BorrowerDao;
import com.spring.library.model.Borrower;

@Service
public class BorrowerServiceImpl implements BorrowerService {
	@Autowired
	private BorrowerDao borrowerDao;

	@Override
	@Transactional
	public void addBorrower(Borrower borrower) {
		borrowerDao.addBorrower(borrower);

	}

	@Override
	@Transactional
	public List<Borrower> getBorrowerList() {
		
		return borrowerDao.getBorrowerList();
	}
	@Transactional
	public List<Borrower> getBorrowedInfo(String name) {
		// TODO Auto-generated method stub
		return borrowerDao.getBorrowedInfo(name);
	}

}
