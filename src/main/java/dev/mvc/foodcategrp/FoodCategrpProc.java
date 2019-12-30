package dev.mvc.foodcategrp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//빈의 이름 지정
@Component("dev.mvc.foodcategrp.FoodCategrpProc")
public class FoodCategrpProc implements FoodCategrpProcInter{
  
  @Autowired
  private FoodCategrpDAOInter foodcategrpDAO;

  @Override
  public int create(FoodCategrpVO foodcategrpVO) {
    int count = foodcategrpDAO.create(foodcategrpVO);
    return count;
  }

  @Override
  public List<FoodCategrpVO> list_foodcategrpno_asc() {
    List<FoodCategrpVO> list = foodcategrpDAO.list_foodcategrpno_asc();
    return list;
  }

  @Override
  public FoodCategrpVO read(int foodcategrpno) {
    FoodCategrpVO foodcategrpVO = foodcategrpDAO.read(foodcategrpno);
    return foodcategrpVO;
  }

  @Override
  public int update(FoodCategrpVO foodcategrpVO) {
    int count = foodcategrpDAO.update(foodcategrpVO);
    return count;
  }

  @Override
  public int delete(int foodcategrpno) {
    int count = foodcategrpDAO.delete(foodcategrpno);
    return count;
  }

}
