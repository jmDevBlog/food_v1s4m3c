package dev.mvc.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.mvc.admin.AdminProcInter;
@Controller
public class ClientCont {
  @Autowired
  @Qualifier("dev.mvc.client.ClientProc")
  private ClientProcInter clientProc;
  
  @Autowired
  @Qualifier("dev.mvc.admin.AdminProc")
  private AdminProcInter adminProc;
  
  public ClientCont() {
    System.out.println("--> ClientCont created.");
  }
  
  /**
   * 회원 가입 폼
   * @return
   */
  // http://localhost:9090/ojt/client/create.do
  @RequestMapping(value = "/client/create.do", 
                             method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/client/create"); // /webapp/client/create.jsp
    
    return mav;
  }
  
  /**
   * 중복 ID 검사
   * http://localhost:9090/ojt/client/checkId.do?id=user1
   * 결과: {"count":1}
   * @param id
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/client/checkId.do",
                            method = RequestMethod.GET,
                            produces = "text/plain;charset=UTF-8")
  public String checkId(String id) {
    // System.out.println("--> id: " + id);
    int count = clientProc.checkId(id);
    
    JSONObject obj = new JSONObject();
    obj.put("count",count);
 
    return obj.toString(); // {"count":1}

  }
  
  @RequestMapping(value="/client/create.do", 
                             method=RequestMethod.POST)
  public ModelAndView create(RedirectAttributes ra,
                                           HttpServletRequest request,
                                           ClientVO clientVO){
    ModelAndView mav = new ModelAndView();

    int count = clientProc.create(clientVO);
    ra.addAttribute("count", count); // redirect parameter 적용
    mav.setViewName("redirect:/client/create_msg.jsp");

    return mav;
  }
  
  @RequestMapping(value="/client/list.do", method=RequestMethod.GET)
  public ModelAndView list(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    
    if (adminProc.isAdmin(session)) {
      List<ClientVO> list = clientProc.list();
      
      mav.addObject("list", list);
      mav.setViewName("/client/list"); // /webapp/client/list.jsp

    } else {
      mav.setViewName("redirect:/admin/login_need.jsp"); // /webapp/admin/login_need.jsp
    }
    
    return mav;
  }
  
  /**
   * 조회 http://localhost:9090/ojt/client/read.do?clientno=1
   * @param clientno
   * @return
   */
  @RequestMapping(value = "/client/read.do", 
                                          method = RequestMethod.GET)
  public ModelAndView read(int clientno) {
    ModelAndView mav = new ModelAndView();

    ClientVO clientVO = clientProc.read(clientno);
    mav.addObject("clientVO", clientVO);

    mav.setViewName("/client/read");

    return mav;
  }
  
  // 수정 처리
  @RequestMapping(value="/client/update.do", 
                              method=RequestMethod.POST)
  public ModelAndView update(RedirectAttributes ra,
                                            ClientVO clientVO) {
    ModelAndView mav = new ModelAndView();
    
    int count = clientProc.update(clientVO);
    ra.addAttribute("count", count);
    ra.addAttribute("clientno", clientVO.getClientno());
    mav.setViewName("redirect:/client/update_msg.jsp");
                               
    return mav;
  }
  
  /**
   * 패스워드를 변경합니다.
   * @param clientno
   * @return
   */
  @RequestMapping(value="/client/passwd_update.do",
                            method=RequestMethod.GET)
  public ModelAndView passwd_update(int clientno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/client/passwd_update");
    
    return mav;
  }
  
  /**
   * 패스워드를 변경합니다.
   * @param clientno
   * @return
   */
  @RequestMapping(value="/client/passwd_update.do",
                            method=RequestMethod.POST)
  public ModelAndView passwd_update(RedirectAttributes ra,
                                                       int clientno, 
                                                       String passwd,
                                                       String new_passwd){
    ModelAndView mav = new ModelAndView();
    
    // 현재 패스워드 검사
    HashMap<Object, Object> map = new HashMap<Object, Object>();
    map.put("clientno", clientno);
    map.put("passwd", passwd);
    
    int count = clientProc.passwd_check(map);
    int update_count = 0; // 변경된 패스워드 수
    
    if (count == 0) { // 현재 패스워드가 일치하지 않는 경우
      ra.addAttribute("count", count);
      mav.setViewName("redirect:/client/passwd_update_fail_msg.jsp");  
    } else { // 현재 패스워드가 일치하는 경우
      map.put("passwd", new_passwd);
      update_count = clientProc.passwd_update(map);
      ra.addAttribute("update_count", update_count);
      mav.setViewName("redirect:/client/passwd_update_success_msg.jsp"); 
    }
        
    return mav;
  }
  
  @RequestMapping(value="/client/delete.do",
                             method=RequestMethod.GET)
  public ModelAndView delete(int clientno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/client/delete");
    
    ClientVO clientVO = clientProc.read(clientno);
    mav.addObject("clientVO", clientVO);
        
    return mav;
  }
  
  @RequestMapping(value = "/client/delete.do", 
                             method = RequestMethod.POST)
  public ModelAndView delete(RedirectAttributes ra,
                                           int clientno) {
    ModelAndView mav = new ModelAndView();

    String mname = clientProc.read(clientno).getCname();
    ra.addAttribute("mname", mname);
    
    int count = clientProc.delete(clientno);
    ra.addAttribute("count", count);
    
    mav.setViewName("redirect:/client/delete_msg.jsp?count=" + count);    

    return mav;
  }

  /**
   * 로그인 폼
   * @return
   */
  // http://localhost:9090/ojt/client/login.do 
  @RequestMapping(value = "/client/login.do", 
                             method = RequestMethod.GET)
  public ModelAndView login(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;

    String ck_id = ""; // id 저장 변수
    String ck_id_save = ""; // id 저장 여부를 체크하는 변수
    String ck_passwd = ""; // passwd 저장 변수
    String ck_passwd_save = ""; // passwd 저장 여부를 체크하는 변수

    if (cookies != null) {
      for (int i=0; i < cookies.length; i++){
        cookie = cookies[i]; // 쿠키 객체 추출
        
        if (cookie.getName().equals("ck_id")){
          ck_id = cookie.getValue(); 
        }else if(cookie.getName().equals("ck_id_save")){
          ck_id_save = cookie.getValue();  // Y, N
        }else if (cookie.getName().equals("ck_passwd")){
          ck_passwd = cookie.getValue();         // 1234
        }else if(cookie.getName().equals("ck_passwd_save")){
          ck_passwd_save = cookie.getValue();  // Y, N
        }
      }
    }
    
    mav.addObject("ck_id", ck_id);
    mav.addObject("ck_id_save", ck_id_save);
    mav.addObject("ck_passwd", ck_passwd);
    mav.addObject("ck_passwd_save", ck_passwd_save);
    
    mav.setViewName("/client/login_ck_form");
    return mav;
  }
  
  /**
   * 로그인 처리
   * @return
   */
  // http://localhost:9090/ojt/client/login.do 
  @RequestMapping(value = "/client/login.do", 
                             method = RequestMethod.POST)
  public ModelAndView login_proc(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 HttpSession session,
                                                 String id, String passwd,
                                                 @RequestParam(value="id_save", defaultValue="") String id_save,
                                                 @RequestParam(value="passwd_save", defaultValue="") String passwd_save) {
    ModelAndView mav = new ModelAndView();
    Map<Object, Object> map = new HashMap<Object, Object>();
    map.put("id", id);
    map.put("passwd", passwd);
    
    int count = clientProc.login(map);
    if (count == 1) { // 로그인 성공
      // System.out.println(id + " 로그인 성공");
      ClientVO clientVO = clientProc.readById(id);
      session.setAttribute("clientno", clientVO.getClientno());
      session.setAttribute("id", id);
      session.setAttribute("mname", clientVO.getCname());
      
      // -------------------------------------------------------------------
      // id 관련 쿠기 저장
      // -------------------------------------------------------------------
      if (id_save.equals("Y")) { // id를 저장할 경우
        Cookie ck_id = new Cookie("ck_id", id);
        ck_id.setMaxAge(60 * 60 * 72 * 10); // 30 day, 초단위
        response.addCookie(ck_id);
      } else { // N, id를 저장하지 않는 경우
        Cookie ck_id = new Cookie("ck_id", "");
        ck_id.setMaxAge(0);
        response.addCookie(ck_id);
      }
      // id를 저장할지 선택하는  CheckBox 체크 여부
      Cookie ck_id_save = new Cookie("ck_id_save", id_save);
      ck_id_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
      response.addCookie(ck_id_save);
      // -------------------------------------------------------------------

      // -------------------------------------------------------------------
      // Password 관련 쿠기 저장
      // -------------------------------------------------------------------
      if (passwd_save.equals("Y")) { // 패스워드 저장할 경우
        Cookie ck_passwd = new Cookie("ck_passwd", passwd);
        ck_passwd.setMaxAge(60 * 60 * 72 * 10); // 30 day
        response.addCookie(ck_passwd);
      } else { // N, 패스워드를 저장하지 않을 경우
        Cookie ck_passwd = new Cookie("ck_passwd", "");
        ck_passwd.setMaxAge(0);
        response.addCookie(ck_passwd);
      }
      // passwd를 저장할지 선택하는  CheckBox 체크 여부
      Cookie ck_passwd_save = new Cookie("ck_passwd_save", passwd_save);
      ck_passwd_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
      response.addCookie(ck_passwd_save);
      // -------------------------------------------------------------------
      
      mav.setViewName("redirect:/index.do");  
    } else {
      mav.setViewName("redirect:/client/login_fail_msg.jsp");
    }
        
    return mav;
  }
  
  /**
   * 로그아웃 처리
   * @param session
   * @return
   */
  @RequestMapping(value="/client/logout.do", 
                             method=RequestMethod.GET)
  public ModelAndView logout(HttpSession session){
    ModelAndView mav = new ModelAndView();
    session.invalidate(); // 모든 session 변수 삭제
    
    mav.setViewName("redirect:/client/logout_msg.jsp");
    
    return mav;
  }

}
