<%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <%@ include file="include/taglib.jsp" %>

<!doctype html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
 <!--<![endif]-->
 <!-- Head BEGIN -->
 <head> 
  <title>Metronic Shop UI</title> 
  <head th:replace="frontend/include/csslib"/>
 
 </head> 
 <!-- Head END --> 
 
 <!-- Body BEGIN --> 
 <body class="ecommerce"> 
 	 
 	<div th:replace="frontend/include/themeMode"/> 
 	<div th:replace="frontend/include/top"/> 
 	<div th:replace="frontend/include/header"/> 
 
  
  <div class="main"> 
   <div class="container"> 
   
   	<!-- BEGIN SALE PRODUCT & NEW ARRIVALS --> 
    <div class="row margin-bottom-40"> 
    	<div class="col-md-12 sale-product">
    		<h2>New Arrivals</h2>
    		<div class="owl-carousel owl-carousel5">
    		  	<div th:each="item : ${productList}">
    		  		<div class="product-item"> 
			         <div class="pi-img-wrapper"> 
			          <img src="../../assets/frontend/pages/img/products/model1.jpg" class="img-responsive" alt="Berry Lace Dress" th:src="@{/assets/frontend/pages/img/products/} + ${item.image}"> 
			          <div> 
			           <a href="../../assets/frontend/pages/img/products/model1.jpg" class="btn btn-default fancybox-button" th:href="@{/assets/frontend/pages/img/products/} + ${item.image}">Zoom</a> 
			           <a th:pid="${item.id}" th:href="'#product-pop-up' + ${item.id}" href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a> 
			          
			          </div> 
			         </div> 
			         <h3><a href="shop-item.html" th:text="${item.name}">Berry Lace Dress</a></h3> 
			         <div class="pi-price" th:text="'$'+${item.promotePrice}">
			          $29.00
			         </div> 
			         <a href="#" class="btn btn-default add2cart">Add to cart</a> 
			         <div class="sticker sticker-sale"></div> 
			        </div> 
    		  	</div> 
    		</div>
    	</div>
    </div> 
    <!-- END SALE PRODUCT & NEW ARRIVALS -->
   </div> 
  </div> 
  
  <div th:each="item : ${productList}">
    <div th:replace="frontend/include/productPopupItem"/>
  </div>
  
  <div th:replace="frontend/include/brands"/>
  <div th:replace="frontend/include/footer"/>
  <div th:replace="frontend/include/productPopup"/>
  <div th:replace="frontend/include/jslib"/>  
  <!-- END BODY --> 
 </body>
</html>
