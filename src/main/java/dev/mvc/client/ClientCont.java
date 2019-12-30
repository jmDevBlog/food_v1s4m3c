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
   * ȸ�� ���� ��
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
   * �ߺ� ID �˻�
   * http://localhost:9090/ojt/client/checkId.do?id=user1
   * ���: {"count":1}
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
    ra.addAttribute("count", count); // redirect parameter ����
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
   * ��ȸ http://localhost:9090/ojt/client/read.do?clientno=1
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
  
  // ���� ó��
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
   * �н����带 �����մϴ�.
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
   * �н����带 �����մϴ�.
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
    
    // ���� �н����� �˻�
    HashMap<Object, Object> map = new HashMap<Object, Object>();
    map.put("clientno", clientno);
    map.put("passwd", passwd);
    
    int count = clientProc.passwd_check(map);
    int update_count = 0; // ����� �н����� ��
    
    if (count == 0) { // ���� �н����尡 ��ġ���� �ʴ� ���
      ra.addAttribute("count", count);
      mav.setViewName("redirect:/client/passwd_update_fail_msg.jsp");  
    } else { // ���� �н����尡 ��ġ�ϴ� ���
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
   * �α��� ��
   * @return
   */
  // http://localhost:9090/ojt/client/login.do 
  @RequestMapping(value = "/client/login.do", 
                             method = RequestMethod.GET)
  public ModelAndView login(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;

    String ck_id = ""; // id ���� ����
    String ck_id_save = ""; // id ���� ���θ� üũ�ϴ� ����
    String ck_passwd = ""; // passwd ���� ����
    String ck_passwd_save = ""; // passwd ���� ���θ� üũ�ϴ� ����

    if (cookies != null) {
      for (int i=0; i < cookies.length; i++){
        cookie = cookies[i]; // ��Ű ��ü ����
        
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
   * �α��� ó��
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
    if (count == 1) { // �α��� ����
      // System.out.println(id + " �α��� ����");
      ClientVO clientVO = clientProc.readById(id);
      session.setAttribute("clientno", clientVO.getClientno());
      session.setAttribute("id", id);
      session.setAttribute("mname", clientVO.getCname());
      
      // -------------------------------------------------------------------
      // id ���� ��� ����
      // -------------------------------------------------------------------
      if (id_save.equals("Y")) { // id�� ������ ���
        Cookie ck_id = new Cookie("ck_id", id);
        ck_id.setMaxAge(60 * 60 * 72 * 10); // 30 day, �ʴ���
        response.addCookie(ck_id);
      } else { // N, id�� �������� �ʴ� ���
        Cookie ck_id = new Cookie("ck_id", "");
        ck_id.setMaxAge(0);
        response.addCookie(ck_id);
      }
      // id�� �������� �����ϴ�  CheckBox üũ ����
      Cookie ck_id_save = new Cookie("ck_id_save", id_save);
      ck_id_save.setMaxAge(60 * 60 * 72 * 10); // 30 day
      response.addCookie(ck_id_save);
      // -------------------------------------------------------------------

      // -------------------------------------------------------------------
      // Password ���� ��� ����
      // -------------------------------------------------------------------
      if (passwd_save.equals("Y")) { // �н����� ������ ���
        Cookie ck_passwd = new Cookie("ck_passwd", passwd);
        ck_passwd.setMaxAge(60 * 60 * 72 * 10); // 30 day
        response.addCookie(ck_passwd);
      } else { // N, �н����带 �������� ���� ���
        Cookie ck_passwd = new Cookie("ck_passwd", "");
        ck_passwd.setMaxAge(0);
        response.addCookie(ck_passwd);
      }
      // passwd�� �������� �����ϴ�  CheckBox üũ ����
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
   * �α׾ƿ� ó��
   * @param session
   * @return
   */
  @RequestMapping(value="/client/logout.do", 
                             method=RequestMethod.GET)
  public ModelAndView logout(HttpSession session){
    ModelAndView mav = new ModelAndView();
    session.invalidate(); // ��� session ���� ����
    
    mav.setViewName("redirect:/client/logout_msg.jsp");
    
    return mav;
  }

}
