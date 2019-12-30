package dev.mvc.foodcategrp;

import java.util.List;

public interface FoodCategrpProcInter {
  /**
   * <Xmp>
   * 음식 카테고리 그룹 등록
   * <insert id="create" parameterType="FoodCategrpVO">
   * </Xmp>
   * @param foodcategrpVO
   * @return 처리된 레코드 갯수
   */
  public int create(FoodCategrpVO foodcategrpVO);
  
  /**
   * 목록
   * <xmp>
   * <select id="list" resultType="FoodCategrpVO">
   * </xmp> 
   * @return
   */
  public List<FoodCategrpVO> list_foodcategrpno_asc();
  
  /**
   * 조회
   * @param foodcategrpno
   * @return
   */
  public FoodCategrpVO read(int foodcategrpno);
  
  /**
   * 수정
   * @param foodcategrpVO
   * @return
   */
  public int update(FoodCategrpVO foodcategrpVO);
  
  /**
   * 삭제
   * @param foodcategrpno
   * @return
   */
  public int delete(int foodcategrpno);


}
