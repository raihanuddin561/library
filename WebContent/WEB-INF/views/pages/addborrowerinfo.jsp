<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div style="margin-left:15%" class="limiter">
		<div class="container-login100"
			style="background-image: url('<c:url value="/static/loginstyle/images/bg-01.jpg"></c:url>');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
		<sf:form class="form-horizontal" method="post"
				action="${pageContext.request.contextPath }/borrowthisbook" commandName = "borrower">
			<fieldset>
	
				<!-- Form Name -->
				<legend>Add Borrower Information</legend>
	
				
	
				<!-- Text input-->
				<%-- <div class="form-group">
					<label class="col-md-8 control-label" for="borrowername"></label>
					<div class="col-md-8">
						<sf:input id="borrowername" path="borrowername" name="borrowername" value="${principal.username }" type="text" placeholder=""
							class="form-control input-md" />
						<sf:errors path="borrowername" cssClass="alert-danger"></sf:errors>
					</div>
				</div> --%>
				
				<div class="form-group">
					<label class="col-md-8 control-label" for="bookname"> </label>
					<div class="col-md-8">
						<sf:input id="bookname" path="bookname" name="bookname" value="${param.bname }" type="hidden" placeholder=""
							class="form-control input-md" />
						<sf:errors path="bookname" cssClass="alert-danger"></sf:errors>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-md-8 control-label" for="address">Address </label>
					<div class="col-md-8">
						<sf:input id="address" path="address" name="address" type="text" placeholder=""
							class="form-control input-md" />
						<sf:errors path="address" cssClass="alert-danger"></sf:errors>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-md-8 control-label" for="contact">Contact</label>
					<div class="col-md-8">
						<sf:input id="contact" path="contact" name="contact" type="text" placeholder=""
							class="form-control input-md" />
						<sf:errors path="contact" cssClass="alert-danger"></sf:errors>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-md-8 control-label" for="duedate">Due date</label>
					<div class="col-md-8">
						<sf:input id="duedate" path="duedate" name="duedate" type="date" placeholder=""
							class="form-control input-md" />
						<sf:errors path="duedate" cssClass="alert-danger"></sf:errors>
					</div>
				</div>
				
				
				<!-- Button -->
				<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Add Book</button>
						</div>
					</div>
	
			</fieldset>
		</sf:form>
	</div>
		</div>
	</div>





