<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}" />

<DIV class='container' style='width: 100%;'> 
  <!-- 화면 상단 메뉴 -->
  <DIV class='top_menu'>
    <IMG src='./menu/images/crown.png' style="padding-left: 0.5%; margin: 3px 3px; height: 70px; float: left">
    <p style="float: left; color:white; font-weight: bold; font-size: 2em; margin: 20px 20px;">무엇을 주문하시겠어요?</p>
    <p style="float: right; font-weight: bold; font-size: 2em; margin: 20px 20px;">
      <c:choose>
        <c:when test="${sessionScope.id == null}">
          <button type="button" class="btn btn-danger" ><A href='${root}/client/login.do' style="color: white; font-size: 1.3em;">Login</A></button>
        </c:when>
        <c:otherwise>
          <button type="button" class="btn btn-danger"><A href='${root}/client/logout.do' style="color: white; font-size: 1.3em;"">${sessionScope.id } Logout</A></button>
        </c:otherwise>
      </c:choose>

      <c:choose>
        <c:when test="${sessionScope.id_admin == null}">
          <button type="button" class="btn btn-danger"><A href='${root}/admin/login.do' style="color: white; font-size: 1.3em;"">관리자 Login</A></button>
        </c:when>
        <c:otherwise>
          <button type="button" class="btn btn-danger"><A href='${root}/admin/logout.do' style="color: white; font-size: 1.3em;"">${sessionScope.id_admin } 관리자 Logout</A></button>          
        </c:otherwise>
      </c:choose>
      
    </p>
  </DIV>

  <NAV style="background-color: #C099A3;">
    <span style='padding: 0.5% 0.5%;'>
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >HOME</A></button> <span class='top_menu1'> | </span>
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >전체 보기</A></button> <span class='top_menu1'> | </span>    
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >프랜차이즈</A></button> <span class='top_menu1'> | </span>  
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >치킨</A></button> <span class='top_menu1'> | </span> 
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >피자/양식</A></button> <span class='top_menu1'> | </span> 
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >중국집</A></button> <span class='top_menu1'> | </span> 
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >한식</A></button> <span class='top_menu1'> | </span> 
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >일식/돈까스</A></button> <span class='top_menu1'> | </span>        
      <button type="button" class="btn btn-light" style="margin: 5px 5px;"><A href='${root}' style="font-size: 1.3em;" >전체 리뷰</A></button> <span class='top_menu1'> | </span>     
    </span>     
  </NAV>


