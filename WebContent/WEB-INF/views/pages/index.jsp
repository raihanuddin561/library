<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <header class="content">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
         <div class="carousel-item active">
           <img src="<c:url value='/static/images/banner-1.jpg'></c:url>" alt="...">
           <div class="gradient"></div>
           <div class="carousel-caption">
            <h3>MY LIBRARY</h3>
              <h1>Hello and welcome to my Library</h1>
              <h2>Enrich Your Knowledge </h2>
              <h5>A library is a place where many books are kept. Most libraries are public and let people take the books to use in their home</h5>
              
            </div>
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
         <div class="carousel-item">
           <img src="<c:url value='/static/images/banner-2.jpg'></c:url>" alt="...">
           <div class="gradient"></div>
           <div class="carousel-caption">
             <h3>MY LIBRARY</h3>
              <h1>Hello and welcome to my Library</h1>
              <h2>Enrich Your Knowledge </h2>
              <h5>A library is a place where many books are kept. Most libraries are public and let people take the books to use in their home</h5>
             
            </div>
          </div>
          <!-- Slide Three - Set the background image for this slide in the line below -->
         <div class="carousel-item">
           <img src="<c:url value='/static/images/banner-3.jpg'></c:url>" alt="...">
           <div class="gradient"></div>
           <div class="carousel-caption">
             <h3>MY LIBRARY</h3>
              <h1>Hello and welcome to my Library</h1>
              <h2>Enrich Your Knowledge </h2>
              <h5>A library is a place where many books are kept. Most libraries are public and let people take the books to use in their home</h5>
             
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </header>