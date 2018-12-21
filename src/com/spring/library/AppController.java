package com.spring.library;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.library.config.AppConfig;
import com.spring.library.dao.BookDaoImpl;
import com.spring.library.dao.UserDaoImpl;
import com.spring.library.model.Book;
import com.spring.library.model.Borrower;
import com.spring.library.model.User;
import com.spring.library.service.BookServiceImpl;
import com.spring.library.service.BorrowerServiceImpl;

@Controller
public class AppController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	@Autowired
	private BorrowerServiceImpl borrowerServiceImpl;
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	@RequestMapping("/services")
	public String servicePage() {
		return "services";
	}
	
	@RequestMapping(value = "/searchbook" , method = RequestMethod.GET)
	public String searchBook(Model model) {
		boolean hasList = false;
		model.addAttribute("hasList",hasList);
		return "searchbook";
	}
	
	
	@RequestMapping(value = "/booklist",method = RequestMethod.POST)
	public String showBookList(Model model,String bookname) {
		
		
		System.out.println(bookname);
		List<Book> getBookList = bookServiceImpl.bookList(bookname);
		model.addAttribute("booklist", getBookList);
		boolean hasList = true;
		model.addAttribute("hasList",hasList);
		return "searchbook";
	}


	
@RequestMapping("/removebook")
public String bookList(Model model){
	List<Book> getBooks = bookServiceImpl.bookList();
	model.addAttribute("booklist",getBooks);
	return "removebook";
}


@RequestMapping("/remove")
public String removeBook(Model model,@RequestParam("bid")int bookid){
	 bookServiceImpl.removeBook(bookid);
	
	return "forward:/removebook";
}
@RequestMapping("/borrowerlist")
public String borrowerList(Model model) {
	List<Borrower> getBorrower = borrowerServiceImpl.getBorrowerList();
	model.addAttribute("borrowerlist",getBorrower);
	return "borrowerlist";
}

@RequestMapping("/borrowbook")
public String getBooks(Model model){
	List<Book> getBooks = bookServiceImpl.bookList();
	model.addAttribute("booklist",getBooks);
	return "borrowbooklist";
}

@RequestMapping("/borrowthisbook")
public String borrow(Principal principal,Model model, @Valid Borrower borrower,BindingResult result) {
	if(result.hasErrors()) {
		model.addAttribute("borrower",borrower);
		return "addborrowerinfo";
	}else {
		if(borrower.getAddress()!=null) {
			
			borrowerServiceImpl.addBorrower(borrower);
			return "borrowedsuccess";
		}else {
			System.out.println("form loading");
			return "addborrowerinfo";
		}
	}
	
}

	
	@RequestMapping("/addbook")
	public String addBook(Model model,@Valid Book book,BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("book",book);
			return "addbook";
		}else {
			if(book.getBookname()!=null && book.getAuthorname()!=null) {
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				BookDaoImpl bookDao = context.getBean("bookDao",BookDaoImpl.class);
				bookDao.addBook(book);
				return "bookadded";
			}else {
				System.out.println("form loading");
				return "addbook";
			}
		}
		
	}
}
