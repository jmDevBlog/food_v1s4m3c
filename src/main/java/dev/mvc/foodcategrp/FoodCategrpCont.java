package dev.mvc.foodcategrp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class FoodCategrpCont {
  @Autowired
  @Qualifier("dev.mvc.foodcategrp.FoodCategrpProc")
  private FoodCategrpProcInter foodcategrpProc;
  
  public FoodCategrpCont() {
    System.out.println("--> FoodCategrpCont created.");
  }
  
//http://localhost:9090/team5/foodcategrp/create.do
 @RequestMapping(value="/foodcategrp/create.do", method=RequestMethod.GET)
 public ModelAndView create() {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/foodcategrp/create"); // /webapp/categrp/create.jsp
   
   return mav;
 }
//��� ó��
  @RequestMapping(value="/foodcategrp/create.do", method=RequestMethod.POST)
  public ModelAndView create(FoodCategrpVO foodcategrpVO) {
    ModelAndView mav = new ModelAndView();
    
    int count = foodcategrpProc.create(foodcategrpVO);
    
    // type 1
     //mav.addObject("count", count);
     //mav.setViewName("/foodcategrp/create_msg"); // /webapp/categrp/create_msg.jsp
  
    // type 2
    mav.setViewName("redirect:/foodcategrp/create_msg.jsp?count=" + count);
    
    // type 3: ����ó��: list.do, ������ �߻�: create_msg.jsp�� ��� 
    //if (count == 0) {
    //  mav.setViewName("redirect:/foodcategrp/create_msg.jsp?count=" + count);
    //} else {
    //  mav.setViewName("redirect:/foodcategrp/list.do"); // list.jsp X
    //}
        
    return mav;
  }
  @RequestMapping(value="/foodcategrp/list.do", method=RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    
    List<FoodCategrpVO> list = foodcategrpProc.list_foodcategrpno_asc();
    
    mav.addObject("list", list);
    mav.setViewName("/foodcategrp/list"); // /webapp/categrp/list.jsp
  
    // mav.setViewName("redirect:/categrp/create_msg.jsp?count=" + count);
        
    return mav;
  }
  
  // ������ + ��ȸ
  @RequestMapping(value="/foodcategrp/update.do", method=RequestMethod.GET)
  public ModelAndView update(int foodcategrpno) {
    ModelAndView mav = new ModelAndView();
    
    FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);
    
    mav.addObject("foodcategrpVO", foodcategrpVO);
    mav.setViewName("/foodcategrp/update"); // /webapp/categrp/update.jsp

    // mav.setViewName("redirect:/categrp/create_msg.jsp?count=" + count);
        
    return mav;
  }
 
  // ���� ó��
  @RequestMapping(value="/foodcategrp/update.do", method=RequestMethod.POST)
  public ModelAndView update(FoodCategrpVO foodcategrpVO) {
    ModelAndView mav = new ModelAndView();
    
    int count = foodcategrpProc.update(foodcategrpVO);
    String url = "redirect:/foodcategrp/update_msg.jsp?count=" + count +
                      "&foodcategrpno=" + foodcategrpVO.getFoodcategrpno();
    mav.setViewName(url);
                               
    return mav;
  }
  
//������
 @RequestMapping(value="/foodcategrp/delete.do", method=RequestMethod.GET)
 public ModelAndView delete(int foodcategrpno) {
   ModelAndView mav = new ModelAndView();
   
   FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);
   
   /*int count_by_categrpno = foodcontentsProc.count_by_categrpno(foodcategrpno);
   mav.addObject("count_by_categrpno", count_by_categrpno);
   */
   mav.addObject("foodcategrpVO", foodcategrpVO);
   mav.setViewName("/foodcategrp/delete"); // /webapp/categrp/delete.jsp

   // mav.setViewName("redirect:/categrp/create_msg.jsp?count=" + count);
       
   return mav;
 }
 
 // ���� ó��
 @RequestMapping(value="/foodcategrp/delete.do", method=RequestMethod.POST)
 public ModelAndView delete_proc(int foodcategrpno) {
   ModelAndView mav = new ModelAndView();
   
   int count = foodcategrpProc.delete(foodcategrpno);
   String url = "redirect:/foodcategrp/delete_msg.jsp?count=" + count +
                     "&foodcategrpno=" + foodcategrpno;
   mav.setViewName(url);
                              
   return mav;
 }
  
}
