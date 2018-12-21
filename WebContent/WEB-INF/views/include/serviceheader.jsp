<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<section id="body" class="width">
	<aside id="sidebar" class="column-left">

		<header>
			<h1>
				<a href="#"><sec:authentication
								property="principal.username" /></a>
			</h1>

			<h2>Welcome to my Library!</h2>

		</header>

		<nav id="mainnav">
			<ul>
				<li class=""><a href="<c:url value='/'></c:url>">Home</a></li>
				<li class=""><a href="<c:url value='/searchbook'></c:url>">Search Book</a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="<c:url value='/addbook'></c:url>">Add Book</a></li></sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="<c:url value='/removebook'></c:url>">Remove Book</a></li></sec:authorize>
				<li><a href="<c:url value='/borrowbook'></c:url>">Borrow Book</a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="<c:url value='/borrowerlist'></c:url>">Borrower List</a></li></sec:authorize>
				<li><a href="<c:url value='/returnbookform'></c:url>">Return Book</a></li>
			</ul>
		</nav>



	</aside>
	