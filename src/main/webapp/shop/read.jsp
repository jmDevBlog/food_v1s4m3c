<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var='root' value='${pageContext.request.contextPath}'/>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>

<!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="../css/freelancer.css" rel="stylesheet">

<link href="../css/style.css" rel="Stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<body>
<c:set var="foodcategrpno" value="${foodcategrpVO.foodcategrpno}" />
<c:set var="shopno" value="${shopVO.shopno }" />

<jsp:include page="/menu/top.jsp" flush='false' />
  <ASIDE style='float: left;'>
    <A href='../foodcategrp/list.do'>카테고리 그룹</A> > 
    <A href='./list.do?foodcategrpno=${foodcategrpno }'>${foodcategrpVO.foodname }</A>
  </ASIDE>
  <ASIDE style='float: right;'>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' > | </span> 
    <A href='./list.do?foodcategrpno=${foodcategrpno }'>목록</A>
    <span class='menu_divide' > | </span> 
    <A href='./update.do?foodcategrpno=${foodcategrpno }&shopno=${shopno}'>수정</A>
    <span class='menu_divide' > | </span> 
    <a href="../attachfile/create.do?shopno=${shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}">첨부파일 등록</a>
    <span class='menu_divide' > | </span> 
    <a href="./file_delete.do?shopno=${shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}">첨부파일 삭제</a>
    <span class='menu_divide' > | </span> 
    <A href='./delete.do?foodcategrpno=${foodcategrpno }&shopno=${shopno}'>삭제</A>
    
  </ASIDE> 
  
  <div class='menu_line'></div>

  <FORM name='frm' method="get" action='./update.do'>
      <input type="hidden" name="shopno" value="${shopno}">
      <fieldset class="fieldset">
      
      <c:set var="thumb" value="${shopVO.thumb1.toLowerCase() }" />
      
      <DIV class="li_none" style='border-bottom: solid 1px #AAAAAA;'>
            <span class="glyphicon glyphicon-list-alt"></span>
            <span>${shopVO.name}</span>
            (<span>${shopVO.cnt}</span>)
            <span>${shopVO.rdate.substring(0, 16)}</span>
      </DIV>
      <DIV style='width: 98%; margin: 0px auto;'>
        <DIV style='float: left; width: 20%;'>
          <c:choose>
            <c:when test="${thumb.endsWith('jpg') || thumb.endsWith('gif') || thumb.endsWith('png')}">
              <IMG src = './storage/${shopVO.thumb1}' style='width: 100%; display: block;'>
            </c:when>
            <c:otherwise>
              <IMG src='./images/none1.png' style='width: 100%; display: block;'>
            </c:otherwise>
          </c:choose>
        </DIV>
        <DIV style='float: left; width: 50%;'>
          <UL style='padding-left: 30px;'>
            <li>평점 -> </li>
            <li>최소주문금액 10,000원</li>
            <li>주소: ${shopVO.shopaddress }</li>
            <li>결제 신용카드, 현금 </li>
            <li>배달시간 50~60분</li>
          </UL>
        </DIV>
        <DIV style='float: left; width: 30%;'>
        -결제 주문표-
        </DIV>
        <DIV style='clear: both; width: 100%;'>
        <HR>
        <c:forEach var="shopmenuVO" items="${shopmenu_list }">
        <c:set var="thumb" value="${shopmenuVO.thumb.toLowerCase() }" />
        
        <DIV style='float: left; width: 80%;'>
          <UL style='padding-left: 30px;'>
            <li>메뉴이름 : ${shopmenuVO.menuname} </li>
            <li>가격 ${shopmenuVO.price} 원</li>
          </UL>
        </DIV>
        
        <DIV style='float: left; width: 20%;'>
          <c:choose>
            <c:when test="${thumb.endsWith('jpg') || thumb.endsWith('gif') || thumb.endsWith('png')}">
              <IMG src = '../shopmenu/storage/${shopmenuVO.thumb}' style='width: 50%; display: block;'>
            </c:when>
            <c:otherwise>
              <!-- <IMG src='./images/none1.png' style='width: 100%; display: block;'> -->
            </c:otherwise>
          </c:choose>
        </DIV>
        
        </c:forEach>
        </DIV>
      </DIV>
        
      </fieldset>
  </FORM>

<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>

</html>
  