package com.spring.library;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.library.model.Book;
import com.spring.library.model.Borrower;
import com.spring.library.service.BookService;
import com.spring.library.service.BorrowerService;

@Controller
public class AppController {
	@Autowired
	private BookService bookService;
	@Autowired
	private BorrowerService borrowerService;
	
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
		List<Book> getBookList = bookService.bookList(bookname);
		model.addAttribute("booklist", getBookList);
		
		boolean hasList = true;
		model.addAttribute("hasList",hasList);
		if(!getBookList.isEmpty()) {
			boolean hasBook = true;
			model.addAttribute("hasBook",hasBook);
		
		}
		return "searchbook";
	}


	
@RequestMapping("/removebook")
public String bookList(Model model){
	List<Book> getBooks = bookService.bookList();
	model.addAttribute("booklist",getBooks);
	return "removebook";
}


@RequestMapping("/remove")
public String removeBook(Model model,@RequestParam("bid")int bookid){
	bookService.removeBook(bookid);
	
	return "forward:/removebook";
}
@RequestMapping("/borrowerlist")
public String borrowerList(Model model) {
	List<Borrower> getBorrower = borrowerService.getBorrowerList();
	model.addAttribute("borrowerlist",getBorrower);
	return "borrowerlist";
}

@RequestMapping("/borrowbook")
public String getBooks(Model model){
	List<Book> getBooks = bookService.bookList();
	model.addAttribute("booklist",getBooks);
	return "borrowbooklist";
}

@RequestMapping("/returnbook")
public String returnBook(Model model,@RequestParam("bid") int borrowerid,@RequestParam("bname") String bookname) {
	bookService.returnBook(borrowerid,bookname);
	return "bookreturnedsuccess";
}


@RequestMapping("/returnbookform")
public String returnBookform(Model model,Principal principal) {
	System.out.println(principal.getName());
	List<Borrower> getBorrowedInfo = borrowerService.getBorrowedInfo(principal.getName());
	boolean hasBooks = false;
	if(!getBorrowedInfo.isEmpty()) {
		hasBooks = true;
		model.addAttribute("borrowedbooklist",getBorrowedInfo);
		model.addAttribute("hasBook",hasBooks);
	}
	return "returnbookform";
}

@RequestMapping("/borrowthisbook")
public String borrow(Principal principal,Model model, @Valid Borrower borrower,BindingResult result) {
	
	if(result.hasErrors()) {
		model.addAttribute("borrower",borrower);
		return "addborrowerinfo";
	}else {
		if(borrower.getAddress()!=null) {
			borrower.setBorrowername(principal.getName());
			System.out.println(borrower.getBookname());
			borrowerService.addBorrower(borrower);
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
				
				bookService.addBook(book);
				return "bookadded";
			}else {
				System.out.println("form loading");
				return "addbook";
			}
		}
		
	}
}
