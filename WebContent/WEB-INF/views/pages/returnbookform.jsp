<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div style="margin-left: 15%" class="limiter">
	<div class="container-login100"
		style="background-image: url('<c:url value="/static/loginstyle/images/bg-01.jpg"></c:url>');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54"
			style="width: 80%">
			<span class="login100-form-title p-b-49"> Return Book </span>
			<c:choose>
				<c:when test="${hasBook }">
					<table class="table table-striped" border="1">
						<tr>
							<th>Borrower Id</th>
							<th>Borrower Name</th>
							<th>Book Name</th>
							<th>Address</th>
							<th>Contact</th>
							<th>Due Date</th>
							<th>Option</th>

						</tr>


						<c:forEach var="row" items="${borrowedbooklist}">
							<tr>
								<td><c:out value="${row.borrowerid}"></c:out></td>
								<td><c:out value="${row.borrowername}"></c:out></td>
								<td><c:out value="${row.bookname}"></c:out></td>
								<td><c:out value="${row.address}"></c:out></td>
								<td><c:out value="${row.contact}"></c:out></td>
								<td><c:out value="${row.duedate}"></c:out></td>

								<td><a
									href="${pageContext.request.contextPath}/returnbook?bid=${row.borrowerid}&bname=${row.bookname}">Return</a></td>
							</tr>
						</c:forEach>
					</table>

				</c:when>
				<c:otherwise>You have not borrowed any book.</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>





