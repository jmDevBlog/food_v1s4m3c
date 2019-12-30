<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 
</head>
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <ASIDE style='float: left;'>
    <A href='../foodcategrp/list.do'>카테고리 그룹</A> > 
    <A href='./list.do?foodcategrpno=${foodcategrpVO.foodcategrpno }'>${foodcategrpVO.foodname }</A> 
  </ASIDE>
  <ASIDE style='float: right;'>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' >│</span>
    <A href="./create.do?foodcategrpno=${foodcategrpVO.foodcategrpno}">등록</A>
  </ASIDE> 
  <DIV class='menu_line' style='clear: both;'></DIV>
  
    
  
    
    <%int count=0; %>
      <c:forEach var="shopVO" items="${list }">
        <%
        if(count%2==0){
         %>
         <div class="row">
         <div class="col-md-1 col-lg-1"></div>
         <%
        }
        %>
        <c:set var="thumb" value="${shopVO.thumb1.toLowerCase() }" />
        <div class="col-md-5 col-lg-5">
          <DIV style='float: left; width: 30%;'>
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
              <li><a href="./read.do?shopno=${shopVO.shopno}&foodcategrpno=${shopVO.foodcategrpno}">${shopVO.name} - ${shopVO.shopaddress} </a></li>
              <li style='text-align: left;'>${shopVO.cnt}</li>
              <li><a href="./update.do?shopno=${shopVO.shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}"><img src="./images/update.png" title="수정" border='0'/></a></li>
              <li><a href="./delete.do?shopno=${shopVO.shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}"><img src="./images/delete.png" title="삭제"  border='0'/></a></li>
              <li><a href="../shopmenu/create.do?shopno=${shopVO.shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}"><img src="./images/upload.png" title="파일업로드"  border='0'/></a></li>
            </UL>
          </DIV>
        </div>
        <%
        if(count%2==1){
         %>
         <div class="col-md-1 col-lg-1"></div>
         </div>
         <%
        }
        count++;
        %>
        
      </c:forEach>
    
    
    
    
  
  
  
<%--   <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 10%;"></col>
        <col style="width: 65%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 15%;"></col>
        
      </colgroup>
      table 컬럼
      <thead>
        <tr>
          <th style='text-align: center;'>대표이미지</th>
          <th style='text-align: center;'>제목</th>
          <th style='text-align: center;'>추천</th>
          <th style='text-align: center;'>기타</th>
        </tr>
      
      </thead>
      
      table 내용
      <tbody>
        <c:forEach var="shopVO" items="${list }">
        <c:set var="thumb" value="${shopVO.thumb1.toLowerCase() }" />
          <tr> 
            <td style='text-align: center;'>
              <c:choose>
                <c:when test="${thumb.endsWith('jpg') || thumb.endsWith('gif') || thumb.endsWith('png')}">
                  <IMG src = './storage/${shopVO.thumb1}' style='width: 100%; display: block;'>
                </c:when>
                <c:otherwise>
                  <IMG src='./images/none1.png' style='width: 100%; display: block;'>
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <a href="./read.do?shopno=${shopVO.shopno}&foodcategrpno=${shopVO.foodcategrpno}">${shopVO.name} </a> 
            </td> 
            <td style='text-align: center;'>${shopVO.cnt}</td>
            <td style='text-align: center;'>
              <a href="./update.do?shopno=${shopVO.shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}"><img src="./images/update.png" title="수정" border='0'/></a>
              <a href="./delete.do?shopno=${shopVO.shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}"><img src="./images/delete.png" title="삭제"  border='0'/></a>
              <a href="../shopmenu/create.do?shopno=${shopVO.shopno}&foodcategrpno=${foodcategrpVO.foodcategrpno}"><img src="./images/upload.png" title="파일업로드"  border='0'/></a>
            </td>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <br><br>
  </div> --%>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>