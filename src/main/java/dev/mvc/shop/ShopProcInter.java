package dev.mvc.shop;

import java.util.List;

public interface ShopProcInter {
  /**
   * �Ĵ���
   * @param shopVO
   * @return
   */
  public int create(ShopVO shopVO);
  
  /**
   * ��ü ���
   * @return
   */
  public List<ShopVO> list_all();

  /**
   * foodcategrpno�� ��ü ���
   * @param shopno
   * @return
   */
  public List<ShopVO> list_by_categrpno(int shopno);
  
  /**
   * ��ȸ
   * @param shopno
   * @return
   */
  public ShopVO read(int shopno);
  
  /**
   * ����
   * @param shopVO
   * @return
   */
  public int update(ShopVO shopVO);
  
  /**
   * ����
   * @param shopno
   * @return
   */
  public int delete(int shopno);

}
