package dev.mvc.shopmenu;

import java.util.List;

public interface ShopmenuDAOInter {
  /**
   * �޴� ���
   * @param shopmenuVO
   * @return
   */
  public int create(ShopmenuVO shopmenuVO);
  
  /**
   * shopno�� ���
   * @param shopno
   * @return
   */
  public List<ShopmenuVO> list_by_shopno(int shopno);

}
