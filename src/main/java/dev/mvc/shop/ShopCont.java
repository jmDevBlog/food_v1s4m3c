package dev.mvc.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.mvc.foodcategrp.FoodCategrpProcInter;
import dev.mvc.foodcategrp.FoodCategrpVO;
import dev.mvc.shopmenu.ShopmenuProcInter;
import dev.mvc.shopmenu.ShopmenuVO;
import nation.web.tool.Tool;
import nation.web.tool.Upload;

@Controller
public class ShopCont {
  @Autowired
  @Qualifier("dev.mvc.shop.ShopProc")
  private ShopProcInter shopProc;
  
  @Autowired
  @Qualifier("dev.mvc.foodcategrp.FoodCategrpProc")
  private FoodCategrpProcInter foodcategrpProc;
  
  @Autowired
  @Qualifier("dev.mvc.shopmenu.ShopmenuProc")
  private ShopmenuProcInter shopmenuProc;
  
  @RequestMapping(value = "/shop/create.do", method = RequestMethod.GET)
  public ModelAndView create(int foodcategrpno) {
    ModelAndView mav = new ModelAndView();
    
    FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);

    mav.addObject("foodcategrpVO", foodcategrpVO);
    mav.setViewName("/shop/create");

    return mav;
  }
  
  @RequestMapping(value = "/shop/create.do", method = RequestMethod.POST)
  public ModelAndView create(RedirectAttributes ra,HttpServletRequest request,
                              ShopVO shopVO, int foodcategrpno) {
    ModelAndView mav = new ModelAndView();

    System.out.println(foodcategrpno);

    // -----------------------------------------------------
    // 파일 전송 코드 시작
    // -----------------------------------------------------
    String fname = ""; // 원본 파일명
    String fupname = ""; // 업로드된 파일명
    long size1 = 0;  // 파일 사이즈
    String thumb1 = ""; // Preview 이미지
    
    String upDir = Tool.getRealPath(request, "/shop/storage");
    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
    MultipartFile fnameMF = shopVO.getFnameMF();
    size1 = fnameMF.getSize();  // 파일 크기
    if (size1 > 0) { // 파일 크기 체크
      fname = fnameMF.getOriginalFilename(); // 원본 파일명
      fupname = Upload.saveFileSpring(fnameMF, upDir); // 파일 저장
          
      if (Tool.isImage(fname)) { // 이미지인지 검사
        thumb1 = Tool.preview(upDir, fupname, 120, 80); // thumb 이미지 생성
      }
    }
    shopVO.setFname(fname);
    shopVO.setFupname(fupname);
    shopVO.setThumb1(thumb1);
    shopVO.setSize1(size1);
        
      // -----------------------------------------------------
      // 파일 전송 코드 종료
      // -----------------------------------------------------
    int count = shopProc.create(shopVO);

    ra.addAttribute("count", count);
    ra.addAttribute("foodcategrpno", foodcategrpno);
    
    mav.setViewName("redirect:/shop/create_msg.jsp");

    return mav;
  }
  
  @RequestMapping(value = "/shop/list_all.do", method = RequestMethod.GET)
  public ModelAndView list_all() {
    ModelAndView mav = new ModelAndView();

    List<ShopVO> list = shopProc.list_all();
    mav.addObject("list", list);
    mav.setViewName("/shop/list_all"); // /webapp/contents/list_all.jsp

    return mav;
  }

  /**
   * 카테고리 그룹별 목록
   * @param foodcategrpno
   * @return
   */
  @RequestMapping(value = "/shop/list.do", method = RequestMethod.GET)
  public ModelAndView list_by_categrpno(int foodcategrpno) {
    ModelAndView mav = new ModelAndView();

    List<ShopVO> list = shopProc.list_by_categrpno(foodcategrpno);
    mav.addObject("list", list);
    // /webapp/contents/list.jsp

    FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);
    mav.addObject("foodcategrpVO", foodcategrpVO);

    mav.setViewName("/shop/list"); // 카테고리 그룹별 목록

    return mav;
  }
  
  /**
   * 조회 http://localhost:9090/team5/shop/read.do?shopno=1
   * 
   * @param contentsno
   * @return
   */
  @RequestMapping(value = "/shop/read.do", method = RequestMethod.GET)
  public ModelAndView read(int shopno) {
    ModelAndView mav = new ModelAndView();

    ShopVO shopVO = shopProc.read(shopno);
    mav.addObject("shopVO", shopVO);
    
    FoodCategrpVO foodcategrpVO = foodcategrpProc.read(shopVO.getFoodcategrpno());
    mav.addObject("foodcategrpVO", foodcategrpVO);
    
    List<ShopmenuVO> shopmenu_list = shopmenuProc.list_by_shopno(shopno); 
    mav.addObject("shopmenu_list", shopmenu_list);
    
    mav.setViewName("/shop/read");

    return mav;
  }
//http://localhost:9090/ojt/shop/update.do?shopno=1&foodcategrpno=1
 @RequestMapping(value = "/shop/update.do", method = RequestMethod.GET)
 public ModelAndView update(int foodcategrpno, int shopno) {
   ModelAndView mav = new ModelAndView();

   FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);
   mav.addObject("foodcategrpVO", foodcategrpVO);

   ShopVO shopVO = shopProc.read(shopno);
   mav.addObject("shopVO", shopVO);

   mav.setViewName("/shop/update"); // /webapp/shop/update.jsp

   return mav;
 }

 /**
  * 수정 처리
  * @param shopVO
  * @return
  */
 @RequestMapping(value = "/shop/update.do", 
                            method = RequestMethod.POST)
 public ModelAndView update(RedirectAttributes ra,
                                           ShopVO shopVO) {
   ModelAndView mav = new ModelAndView();

   int count = shopProc.update(shopVO);

   // mav.setViewName("/contents/create"); // /webapp/contents/create.jsp
   // redirect: form에서 보낸 데이터 모두 삭제됨, 새로고침 중복 등록 방지용.
   ra.addAttribute("count", count);
   ra.addAttribute("foodcategrpno", shopVO.getFoodcategrpno());
   ra.addAttribute("shopno", shopVO.getShopno());
   
   mav.setViewName("redirect:/shop/update_msg.jsp");

   return mav;
 }
 
  @RequestMapping(value = "/shop/delete.do", 
       method = RequestMethod.GET)
  public ModelAndView delete(int foodcategrpno, int shopno) {
  ModelAndView mav = new ModelAndView();
  
  FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);
  mav.addObject("foodcategrpVO", foodcategrpVO);
  
  ShopVO shopVO = shopProc.read(shopno);
  mav.addObject("shopVO", shopVO);
  
  
  mav.setViewName("/shop/delete"); // /webapp/contents/delete.jsp
  
  return mav;
  }
  /**
   * 한건 삭제 처리
   * @param ra
   * @param foodcategrpno
   * @param shopsno
   * @return
   */
  @RequestMapping(value = "/shop/delete.do", 
       method = RequestMethod.POST)
  public ModelAndView delete(RedirectAttributes ra,
                      int foodcategrpno,
                      int shopno) {
  ModelAndView mav = new ModelAndView();
  
  // 현재 로그인한 사용자와 글 등록자가 같은지 검사
  int count = shopProc.delete(shopno);
  
  ra.addAttribute("count", count);
  ra.addAttribute("foodcategrpno", foodcategrpno);
  ra.addAttribute("shopno", shopno);
  
  mav.setViewName("redirect:/shop/delete_msg.jsp");
  
  return mav;
  }

  

}
