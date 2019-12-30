package dev.mvc.shopmenu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import nation.web.tool.Tool;
import nation.web.tool.Upload;

@Controller
public class ShopmenuCont {
  @Autowired
  @Qualifier("dev.mvc.shopmenu.ShopmenuProc")
  private ShopmenuProcInter shopmenuProc;

  @Autowired
  @Qualifier("dev.mvc.foodcategrp.FoodCategrpProc")
  private FoodCategrpProcInter foodcategrpProc;

  
  @RequestMapping(value = "/shopmenu/create.do", method = RequestMethod.GET)
  public ModelAndView create(int shopno, int foodcategrpno) {
    ModelAndView mav = new ModelAndView();
    
    FoodCategrpVO foodcategrpVO = foodcategrpProc.read(foodcategrpno);
    mav.addObject("foodcategrpVO", foodcategrpVO);

    mav.setViewName("/shopmenu/create"); // /webapp/attachfile/create.jsp

    return mav;
  }
  @RequestMapping(value = "/shopmenu/create.do", method = RequestMethod.POST)
  public ModelAndView create(RedirectAttributes ra,HttpServletRequest request,
                              ShopmenuVO shopmenuVO, int foodcategrpno) {
    ModelAndView mav = new ModelAndView();

    // -----------------------------------------------------
    // 파일 전송 코드 시작
    // -----------------------------------------------------
    String fname = ""; // 원본 파일명
    String fupname = ""; // 업로드된 파일명
    long size1 = 0;  // 파일 사이즈
    String thumb1 = ""; // Preview 이미지
    
    String upDir = Tool.getRealPath(request, "/shopmenu/storage");
    // 전송 파일이 없어서도 fnamesMF 객체가 생성됨.
    MultipartFile fnameMF = shopmenuVO.getFnameMF();
    size1 = fnameMF.getSize();  // 파일 크기
    if (size1 > 0) { // 파일 크기 체크
      fname = fnameMF.getOriginalFilename(); // 원본 파일명
      fupname = Upload.saveFileSpring(fnameMF, upDir); // 파일 저장
          
      if (Tool.isImage(fname)) { // 이미지인지 검사
        thumb1 = Tool.preview(upDir, fupname, 120, 80); // thumb 이미지 생성
      }
    }
    shopmenuVO.setMenuimg(fname);
    shopmenuVO.setUpimg(fupname);
    shopmenuVO.setThumb(thumb1);
    shopmenuVO.setFsize(size1);
        
      // -----------------------------------------------------
      // 파일 전송 코드 종료
      // -----------------------------------------------------
    int count = shopmenuProc.create(shopmenuVO);

    ra.addAttribute("count", count);
    ra.addAttribute("foodcategrpno", foodcategrpno);
    ra.addAttribute("shopno", shopmenuVO.getShopno());
    
    mav.setViewName("redirect:/shopmenu/create_msg.jsp");

    return mav;
  }
  

}
