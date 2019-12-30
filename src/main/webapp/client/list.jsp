<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 
 
<script type="text/javascript">
  $(function(){
 
  });
</script>
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
 
  <ASIDE style='float: left;'>
      <A href='./member/list.do'>회원 목록</A>  
  </ASIDE>
  <ASIDE style='float: right;'>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' >│</span> 
    <A href='./create.do'>회원 가입</A>
    <span class='menu_divide' >│</span> 
    <A href='./create.do'>목록</A>
  </ASIDE> 
 
  <div class='menu_line'></div>
  
 
  <table class="table table-striped" style='width: 100%;'>
  <caption>관리자만 접근가능합니다.</caption>
  <colgroup>
    <col style='width: 5%;'/>
    <col style='width: 10%;'/>
    <col style='width: 10%;'/>
    <col style='width: 20%;'/>
    <col style='width: 30%;'/>
    <col style='width: 15%;'/>
    <col style='width: 10%;'/>
  </colgroup>
  <TR>
    <TH class='th_basic'>번호</TH>
    <TH class='th_basic'>ID</TH>
    <TH class='th_basic'>성명</TH>
    <TH class='th_basic'>전화번호</TH>
    <TH class='th_basic'>주소</TH>
    <TH class='th_basic'>등록일</TH>
    <TH class='th_basic'>기타</TH>
  </TR>
 
  <c:forEach var="memberVO" items="${list }">
    <c:set var="memberno" value ="${memberVO.memberno}" /> 
  <TR>
    <TD class='td'>${memberno}</TD>
    <TD class='td'><A href="./read.do?memberno=${memberno}">${memberVO.id}</A></TD>
    <TD class='td'><A href="./read.do?memberno=${memberno}">${memberVO.mname}</A></TD>
    <TD class='td'>${memberVO.tel}</TD>
    <TD class='td'>
      <c:choose>
        <c:when test="${memberVO.address1.length() > 15 }">
          ${memberVO.address1.substring(0, 15) }...
        </c:when>
        <c:otherwise>
          ${memberVO.address1}
        </c:otherwise>
      </c:choose>
    </TD>
    <TD class='td'>${memberVO.mdate.substring(0, 10)}</TD> <!-- 년월일 -->
    <TD class='td'>
      <A href="./passwd_update.do?memberno=${memberno}"><IMG src='./images/passwd.png' title='패스워드 변경'></A>
      <A href="./read.do?memberno=${memberno}"><IMG src='./images/update.png' title='수정'></A>
      <A href="./delete.do?memberno=${memberno}"><IMG src='./images/delete.png' title='삭제'></A>
    </TD>
    
  </TR>
  </c:forEach>
  
</TABLE>
 
<DIV class='bottom_menu'>
  <button type='button' onclick="location.href='./create.do'">등록</button>
  <button type='button' onclick="location.reload();">새로 고침</button>
</DIV>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
  
  