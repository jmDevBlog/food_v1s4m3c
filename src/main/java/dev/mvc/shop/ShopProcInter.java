package dev.mvc.shop;

import java.util.List;

public interface ShopProcInter {
  /**
   * 식당등록
   * @param shopVO
   * @return
   */
  public int create(ShopVO shopVO);
  
  /**
   * 전체 목록
   * @return
   */
  public List<ShopVO> list_all();

  /**
   * foodcategrpno별 전체 목록
   * @param shopno
   * @return
   */
  public List<ShopVO> list_by_categrpno(int shopno);
  
  /**
   * 조회
   * @param shopno
   * @return
   */
  public ShopVO read(int shopno);
  
  /**
   * 수정
   * @param shopVO
   * @return
   */
  public int update(ShopVO shopVO);
  
  /**
   * 삭제
   * @param shopno
   * @return
   */
  public int delete(int shopno);

}
