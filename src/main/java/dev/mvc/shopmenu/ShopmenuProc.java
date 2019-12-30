package dev.mvc.shopmenu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.shopmenu.ShopmenuProc")
public class ShopmenuProc implements ShopmenuProcInter{

  @Autowired
  private ShopmenuDAOInter shopmenuDAO;
  
  @Override
  public int create(ShopmenuVO shopmenuVO) {
    int count = shopmenuDAO.create(shopmenuVO);
    return count;
  }

  @Override
  public List<ShopmenuVO> list_by_shopno(int shopno) {
    List<ShopmenuVO> list = shopmenuDAO.list_by_shopno(shopno);
    return list;
  }

}
