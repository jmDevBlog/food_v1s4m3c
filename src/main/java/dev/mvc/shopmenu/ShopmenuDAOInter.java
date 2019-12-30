package dev.mvc.shopmenu;

import java.util.List;

public interface ShopmenuDAOInter {
  /**
   * 메뉴 등록
   * @param shopmenuVO
   * @return
   */
  public int create(ShopmenuVO shopmenuVO);
  
  /**
   * shopno별 목록
   * @param shopno
   * @return
   */
  public List<ShopmenuVO> list_by_shopno(int shopno);

}
