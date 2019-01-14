<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body onload='document.f.username.focus();'>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('<c:url value="/static/loginstyle/images/bg-01.jpg"></c:url>');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
		You have logged out!!!
		<p>Go to <a class="btn btn-success" href="${pageContext.request.contextPath }/">Home page</a></p>
			
			<%--  <div class="card text-center bg-dark">
			 	<img class="mx-auto bg-dark" style="hight:200px;width:200px;border-radius:50%" src='<c:url value="/static/images/raihanuddin.jpg"></c:url>' alt="">
			 	<div class="card-header bg-success">
			 		<h3 style="color:purple"><b>HAPPY NEW YEAR</b></h3>
			 	</div>
			 	<div class="card-body" style="background:purple;">
			 		<p style="color:white">By learning from 2018, go ahead in this 2019. May ALLAH bless you and best wishes for you.</p>
			 	</div>
			 </div> --%>
			 </div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>
</body>
