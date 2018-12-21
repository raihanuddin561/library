<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div style="margin-left: 15%" class="limiter">
	<div class="container-login100"
		style="background-image: url('<c:url value="/static/loginstyle/images/bg-01.jpg"></c:url>');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54" style="width:80%">
			<span class="login100-form-title p-b-49"> Remove Book </span>

			<table class="table table-striped" border="1" >
				<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Status</th>
					<th>Options</th>
					
				</tr>
				<c:forEach var="row" items="${booklist}">
					<tr>
						<td><c:out value="${row.bookId}"></c:out></td>
						<td><c:out value="${row.bookname}"></c:out></td>
						<td><c:out value="${row.authorname}"></c:out></td>
						<td><c:out value="${row.status}"></c:out></td>
						
						<td><a
							href="${pageContext.request.contextPath}/borrowthisbook?bname=${row.bookname}">Borrow</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</div>





