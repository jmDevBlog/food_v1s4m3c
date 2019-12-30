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
    // ���� ���� �ڵ� ����
    // -----------------------------------------------------
    String fname = ""; // ���� ���ϸ�
    String fupname = ""; // ���ε�� ���ϸ�
    long size1 = 0;  // ���� ������
    String thumb1 = ""; // Preview �̹���
    
    String upDir = Tool.getRealPath(request, "/shopmenu/storage");
    // ���� ������ ����� fnamesMF ��ü�� ������.
    MultipartFile fnameMF = shopmenuVO.getFnameMF();
    size1 = fnameMF.getSize();  // ���� ũ��
    if (size1 > 0) { // ���� ũ�� üũ
      fname = fnameMF.getOriginalFilename(); // ���� ���ϸ�
      fupname = Upload.saveFileSpring(fnameMF, upDir); // ���� ����
          
      if (Tool.isImage(fname)) { // �̹������� �˻�
        thumb1 = Tool.preview(upDir, fupname, 120, 80); // thumb �̹��� ����
      }
    }
    shopmenuVO.setMenuimg(fname);
    shopmenuVO.setUpimg(fupname);
    shopmenuVO.setThumb(thumb1);
    shopmenuVO.setFsize(size1);
        
      // -----------------------------------------------------
      // ���� ���� �ڵ� ����
      // -----------------------------------------------------
    int count = shopmenuProc.create(shopmenuVO);

    ra.addAttribute("count", count);
    ra.addAttribute("foodcategrpno", foodcategrpno);
    ra.addAttribute("shopno", shopmenuVO.getShopno());
    
    mav.setViewName("redirect:/shopmenu/create_msg.jsp");

    return mav;
  }
  

}
