
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="top-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-5 col1">
                <h5>My Library</h5>
            </div>
            <div class="col-sm-6 col-7 col2">
                <div class="row">
                   <div class="col-sm-12">
                      <a href="#"><i class="fa fa-facebook-official" aria-hidden="true"></i></a>
                      <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                      
                      <a href="#"><i class="fa fa-youtube" aria-hidden="true"></i></a>
                      
                      <a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
                   </div>
                </div>
            </div>
        </div>
    </div>
   </div>
    <!-- Navigation -->
    <nav id="myHeader" class="header navbar navbar-expand-lg navbar-dark">
      <div class="container">
        <a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="logo"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value='/'></c:url>">Home
						<span class="sr-only">(current)</span>
				</a>
				</li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/services'></c:url>">our services</a>
            </li>
            
            
            <li class="nav-item"><sec:authorize access="!isAuthenticated()">
					<p>
						<a href="<c:url value='/login'/>">Login</a>
					</p>
				</sec:authorize></li>
			<li class="nav-item"><sec:authorize access="isAuthenticated()">
					<div class="dropdown">
						<a class="btn  btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<sec:authentication
								property="principal.username" /> </a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<c:url var="logoutUrl"
									value="/loggedout"></c:url>
								<form action="${logoutUrl }" method="post" class="dropdown-item ">
									<input type="submit"  value="Logout" /> <input type="hidden"
										name="${_csrf.parameterName}" value="${_csrf.token}" />
								</form>

						</div>
					</div>

					
				</sec:authorize></li>
          </ul>
        </div>
      </div>
    </nav>
