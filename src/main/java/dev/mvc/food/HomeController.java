package dev.mvc.food;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HomeController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home1() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:/index.jsp"); // 파일 확장자 포함
    
    return mav;
  }
  
  @RequestMapping(value = "/home.do", method = RequestMethod.GET)
  public ModelAndView home2() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:/index.jsp"); // 파일 확장자 포함
    
    return mav;
  }
  
  // http://localhost:9090/ojt/index.do
  /**
   * 시작 페이지
   * @param mno
   * @return
   */
  @RequestMapping(value = "/index.do", 
                            method = RequestMethod.GET)
  public ModelAndView home3() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/index"); // /webapp/index.jsp
 
    return mav;
  } 
  
}