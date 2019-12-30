package dev.mvc.foodcategrp;

import java.util.List;

public interface FoodCategrpProcInter {
  /**
   * <Xmp>
   * ���� ī�װ� �׷� ���
   * <insert id="create" parameterType="FoodCategrpVO">
   * </Xmp>
   * @param foodcategrpVO
   * @return ó���� ���ڵ� ����
   */
  public int create(FoodCategrpVO foodcategrpVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list" resultType="FoodCategrpVO">
   * </xmp> 
   * @return
   */
  public List<FoodCategrpVO> list_foodcategrpno_asc();
  
  /**
   * ��ȸ
   * @param foodcategrpno
   * @return
   */
  public FoodCategrpVO read(int foodcategrpno);
  
  /**
   * ����
   * @param foodcategrpVO
   * @return
   */
  public int update(FoodCategrpVO foodcategrpVO);
  
  /**
   * ����
   * @param foodcategrpno
   * @return
   */
  public int delete(int foodcategrpno);


}
