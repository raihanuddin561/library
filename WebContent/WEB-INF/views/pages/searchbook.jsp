<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div style="margin-left: 15%" class="limiter">
	<div class="container-login100"
		style="background-image: url('<c:url value="/static/loginstyle/images/bg-01.jpg"></c:url>');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54" style="width:80%">



			<form class="login100-form validate-form" 
					action='${pageContext.request.contextPath }/booklist' method='POST'>
					<span class="login100-form-title p-b-49"> Search Book </span>
					
					<div class="wrap-input100 validate-input m-b-23"
						data-validate="bookname is reauired">
						<span class="label-input100">bookname</span> <input
							class="input100" type="text" name='bookname'
							placeholder="Type your bookname"> <span
							class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Search</button>
						</div>
					</div>
					<div>
						<input name="${_csrf.parameterName}" type="hidden"
							value="${_csrf.token}" />
					</div>


				</form>
<br>
<hr>
			<c:choose>
				<c:when test="${hasList }">
					<table class="table table-striped" border="1">
						<tr>
							<th>Book Name</th>
							<th>Author name</th>
							<th>Status</th>
						</tr>
						<c:forEach var="row" items="${booklist}">
							<tr>
								<td><c:out value="${row.bookname}"></c:out></td>
								<td><c:out value="${row.authorname}"></c:out></td>
								<td><c:out value="${row.status}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>Enter any book name you want</c:otherwise>
			</c:choose>


		</div>
	</div>
</div>





