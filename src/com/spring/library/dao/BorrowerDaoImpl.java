package com.spring.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.spring.library.model.Book;
import com.spring.library.model.Borrower;
@Repository
public class BorrowerDaoImpl implements BorrowerDao {
	private DataSource dataSource;

	public BorrowerDaoImpl(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate){
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		return date;
	}
	
	@Override
	public void addBorrower(Borrower borrower) {
		String queryForBorrower = "insert into borrower(borrowername,bookname,address,contact,duedate) values(?,?,?,?,?)";
		
		/*
		 * Convert String to date
		 * 
		 */
		java.util.Date uDate = new java.util.Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		String borrowDate = borrower.getDuedate();
		
		try {
			uDate = new SimpleDateFormat("yyyy-MM-dd").parse(borrowDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date dueDate = convertUtilToSql(uDate);
		//end of convert date format
		
		
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(queryForBorrower);
			pst.setString(1, borrower.getBorrowername());
			pst.setString(2, borrower.getBookname());
			pst.setString(3, borrower.getAddress());
			pst.setString(4, borrower.getContact());
			pst.setDate(5, dueDate);
			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public List<Borrower> getBorrowerList() {
		List<Borrower> borrowerList = new ArrayList<Borrower>();
		String query = "select * from borrower";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Borrower borrower = new Borrower(rs.getInt("borrowerid"), rs.getString("borrowername"), rs.getString("bookname"),
						rs.getString("address"),rs.getString("contact"),rs.getDate("duedate").toString());
				borrowerList.add(borrower);
			}

			return borrowerList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
