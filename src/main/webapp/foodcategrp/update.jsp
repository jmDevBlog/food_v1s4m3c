<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
  $(function(){
 
  });
</script>
 
</head> 
 
<body>

<FORM name='frm' method='POST' action='./update.do'>
  <input type='hidden' name='foodcategrpno' value='${foodcategrpVO.foodcategrpno }'>
  <fieldset class='fieldset_basic'>
    <ul>
      <li class='li_none'>
        <label class='label_basic'>카테고리 그룹 이름</label>
        <input type='text' name='foodname' value='${foodcategrpVO.foodname }' required="required" autofocus="autofocus">
      </li>
      <li class='li_none'>
        <label class='label_basic'>출력 순서</label>
        <input type='number' name='seqno' value='${foodcategrpVO.seqno }' required="required" placeholder="${seqno }" min="1" max="1000" step="1" style='width: 20%;'>
      </li>
      <li class='li_none'>
        <label class='label_basic'>출력 형식</label>
        <select name='visible'>
         <option value='Y' ${foodcategrpVO.visible == 'Y' ? "selected='selected'":"" }>Y</option>
          <option value='N' ${foodcategrpVO.visible == 'N' ? "selected='selected'":"" }>N</option>
        </select>
      </li>
      <li class='li_right'>
        <button type="submit">수정 진행</button>
        <button type="button" onclick="window.close();">닫기</button>
      </li>         
    </ul>
  </fieldset>
</FORM>
 
</body>
 
</html> 
  
   