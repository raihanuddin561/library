package com.spring.library.model;

public class Borrower {
	private int borrowerid;
	private String borrowername;
	private String bookname;
	private String address;
	private String contact;
	private String duedate;
	public Borrower() {
	}
	public Borrower(int borrowerid, String borrowername, String bookname, String address, String contact,
			String duedate) {
		super();
		this.borrowerid = borrowerid;
		this.borrowername = borrowername;
		this.bookname = bookname;
		this.address = address;
		this.contact = contact;
		this.duedate = duedate;
	}
	
	
	public Borrower(String address, String contact, String duedate) {
		super();
		this.address = address;
		this.contact = contact;
		this.duedate = duedate;
	}
	public int getBorrowerid() {
		return borrowerid;
	}
	public void setBorrowerid(int borrowerid) {
		this.borrowerid = borrowerid;
	}
	public String getBorrowername() {
		return borrowername;
	}
	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	
	
	
	
}
