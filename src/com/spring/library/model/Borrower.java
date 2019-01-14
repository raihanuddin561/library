package com.spring.library.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="borrower")
@Table(name="borrower")
public class Borrower {
	@Id
	@Column(name="borrowerid")
	private int borrowerid;
	@Column(name="borrowername")
	private String borrowername;
	@Column(name="bookname")
	private String bookname;
	@Column(name="address")
	private String address;
	@Column(name="contact")
	private String contact;
	@Column(name="duedate")
	private Date duedate;
	public Borrower() {
	}
	public Borrower(int borrowerid, String borrowername, String bookname, String address, String contact,
			Date duedate) {
		super();
		this.borrowerid = borrowerid;
		this.borrowername = borrowername;
		this.bookname = bookname;
		this.address = address;
		this.contact = contact;
		this.duedate = duedate;
	}
	
	
	public Borrower(String address, String contact, Date duedate) {
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
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	
	
	
	
}
