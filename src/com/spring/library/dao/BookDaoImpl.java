package com.spring.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.spring.library.model.Book;
import com.spring.library.passwordEncoder.PasswordEnCoder;

@Repository
public class BookDaoImpl implements BookDao {
	private DataSource dataSource;

	public BookDaoImpl(DataSource dataSource) {

		this.dataSource = dataSource;
	}

	@Override
	public void addBook(Book book) {
		String queryForUser = "insert into book(bookname,authorname,status) values(?,?,?)";
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(queryForUser);
			pst.setString(1, book.getBookname());
			pst.setString(2, book.getAuthorname());
			pst.setString(3, "available");

			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public List<Book> bookList() {
		List<Book> bookList = new ArrayList<Book>();
		String query = "select * from book";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Book book = new Book(rs.getInt("bookid"), rs.getString("bookname"), rs.getString("authorname"),
						rs.getString("status"));
				bookList.add(book);
			}

			return bookList;

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

	public List<Book> bookList(String bookname) {
		List<Book> bookList = new ArrayList<Book>();
		String query = "select * from book where bookname like ? and status=?";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, "%"+bookname+"%");
			pst.setString(2, "available");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("bookname"), rs.getString("authorname"), rs.getString("status"));
				bookList.add(book);
			}

			return bookList;

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

	public void removeBook(int bookid) {
		String query = "delete from book where bookid=?";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, bookid);
			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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

	public void returnBook(int borrowerid, String bookname) {
		String query = "delete from borrower where borrowerid=?";
		String queryForStatus ="update book set status=? where bookname=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			PreparedStatement pst2 = conn.prepareStatement(queryForStatus);
			pst.setInt(1, borrowerid);
			pst.execute();
			
			pst2.setString(1, "available");
			pst2.setString(2, bookname);
			pst2.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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
