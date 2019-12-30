<%@ page contentType="text/html; charset=UTF-8" %>
 
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
 
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript">
function send() {
  var msg = '';
  if ($('#new_passwd').val() != $('#new_passwd2').val()) {
    msg = '입력된 패스워드가 일치하지 않습니다.<br>';
    msg += "패스워드를 다시 입력해주세요.<br>"; 
    
    $('#modal_content').attr('class', 'alert alert-danger'); // CSS 변경
    $('#modal_title').html('패스워드 일치 여부  확인'); // 제목 
    $('#modal_content').html(msg);  // 내용
    $('#modal_panel').modal();         // 다이얼로그 출력
    
    return false; // submit 중지
  }
  
  frm.submit(); // submit 진행
}
</script> 
 
</head> 
 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
 
  <!-- Modal -->
  <div class="modal fade" id="modal_panel" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title" id='modal_title'></h4>
        </div>
        <div class="modal-body">
          <p id='modal_content'></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div> <!-- Modal END -->
 
  <ASIDE style='float: left;'>
      <A href='./member/list.do'>회원 목록</A>  
  </ASIDE>
  <ASIDE style='float: right;'>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' >│</span> 
    <A href='./create.do'>회원 가입</A>
    <span class='menu_divide' >│</span> 
    <A href='./list.do'>목록</A>
  </ASIDE> 
 
  <div class='menu_line'></div>
    
  <DIV class='title_line'>패스워드 변경</DIV>
 
  <FORM name='frm' id='frm' method='POST' action='./passwd_update.do' 
              class="form-horizontal">
    <input type='hidden' name='memberno' value='${param.memberno }'>
              
    <div class="form-group">
      <label class="col-md-6 control-label" style="font-size: 0.8em;">현재 패스워드</label>    
      <div class="col-md-6">
        <input type='password' class="form-control input-lg" name='passwd' 
                  id='passwd' value='' required="required" 
                  style='width: 30%;' placeholder="패스워드">
      </div>
    </div>   
                    
    <div class="form-group">
      <label class="col-md-6 control-label" style="font-size: 0.8em;">새로운 패스워드</label>    
      <div class="col-md-6">
        <input type='password' class="form-control input-lg" name='new_passwd' 
                  id='new_passwd' value='' required="required" 
                  style='width: 30%;' placeholder="패스워드">
      </div>
    </div>   
 
    <div class="form-group">
      <label class="col-md-6 control-label" style="font-size: 0.8em;">새로운 패스워드 확인</label>    
      <div class="col-md-6">
        <input type='password' class="form-control input-lg" name='new_passwd2' 
                  id='new_passwd2' value='' required="required" 
                  style='width: 30%;' placeholder="패스워드">
      </div>
    </div>   
    
    <div class="form-group">
      <div class="col-md-offset-6 col-md-6">
        <button type="button" onclick="send();" class="btn btn-primary btn-md">변경</button>
        <button type="button" onclick="location.href='./list.do'" class="btn btn-primary btn-md">취소</button>
 
      </div>
    </div>   
</FORM>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html> 
 
 