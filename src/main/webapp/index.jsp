<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Soldesk5 배달 고¿</title>
<link href="./css/style.css" rel='Stylesheet' type='text/css'>
 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
</head>
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  
  <!-- <DIV style='width: 70%; margin: 30px auto;'>
    <IMG src='./menu/images/crown.png' style='width: 100%;'>
  </DIV>

  <DIV style='margin: 0px auto; width: 90%;'>
    <DIV style='float: left; width: 50%;'>
     </DIV>
     <DIV style='float: left; width: 50%;'>
    </DIV>  
  </DIV>
 
  <DIV style='width: 94.8%; margin: 0px auto;'>
  </DIV> -->  
  <div class="container-fluid">
  <!-- 첫번째 라인 시작 -->
    <div class="row">
      <div class="col-md-2 col-lg-2"></div>
      <div class="col-md-2 col-lg-2">
        <a href='./shop/list.do?foodcategrpno=6'>
            <img class="img-fluid" src="img/portfolio/franchise.png" alt="프랜차이즈" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2">
        <a href='./shop/list.do?foodcategrpno=4'>
        <img class="img-fluid" src="img/portfolio/chicken.png" alt="치킨" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2">
      <a href='./shop/list.do?foodcategrpno=5'>
        <img class="img-fluid" src="img/portfolio/pizza_WesternFood.png" alt="피자/양식" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2">
      <a href='./shop/list.do?foodcategrpno=2'>
        <img class="img-fluid" src="img/portfolio/chineseFood.png" alt="중국집" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2"></div>
    </div>
    <!-- 첫번째 라인 종료 -->
    <!-- 두번째 라인 시작 -->
    <div class="row">
      <div class="col-md-2 col-lg-2"></div>
      <div class="col-md-2 col-lg-2">
        <a href='./shop/list.do?foodcategrpno=1'>
            <img class="img-fluid" src="img/portfolio/koreanFood.png" alt="한식" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2">
        <a href='./shop/list.do?foodcategrpno=3'>
        <img class="img-fluid" src="img/portfolio/japaneseFood.png" alt="일식/돈까스" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2">
      <a href='./shop/list.do?foodcategrpno=5'>
        <img class="img-fluid" src="img/portfolio/pizza_WesternFood.png" alt="피자/양식" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2">
      <a href='./shop/list.do?foodcategrpno=2'>
        <img class="img-fluid" src="img/portfolio/chineseFood.png" alt="중국집" style='width: 100%; height: 100%;'>
        </a>
      </div>
      <div class="col-md-2 col-lg-2"></div>
    </div>
    <!-- 두번째 라인 종료 -->
    
  </div>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
 
</body>
</html>
  
         