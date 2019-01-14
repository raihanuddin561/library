package com.spring.library.dao;

import java.util.List;

import com.spring.library.model.Borrower;

public interface BorrowerDao {
public void addBorrower(Borrower borrower);
public List<Borrower> getBorrowerList();
public List<Borrower> getBorrowedInfo(String name);

}
