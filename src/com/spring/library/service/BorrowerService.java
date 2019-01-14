package com.spring.library.service;

import java.util.List;

import com.spring.library.model.Borrower;

public interface BorrowerService {
public void addBorrower(Borrower borrower);
public List<Borrower> getBorrowerList();
public List<Borrower> getBorrowedInfo(String name);
}
