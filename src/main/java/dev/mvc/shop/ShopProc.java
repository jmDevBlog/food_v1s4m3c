package dev.mvc.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.shop.ShopProc")
public class ShopProc implements ShopProcInter{
  @Autowired
  private ShopDAOInter shopDAO;

  @Override
  public int create(ShopVO shopVO) {
    int count = shopDAO.create(shopVO);
    return count;
  }

  @Override
  public List<ShopVO> list_all() {
    List<ShopVO> list = shopDAO.list_all();
    return list;
  }

  @Override
  public List<ShopVO> list_by_categrpno(int shopno) {
    List<ShopVO> list = shopDAO.list_by_categrpno(shopno);
    return list;
  }

  @Override
  public ShopVO read(int shopno) {
    ShopVO shopVO = shopDAO.read(shopno);
    
    return shopVO;
  }

  @Override
  public int update(ShopVO shopVO) {
    int count = shopDAO.update(shopVO);
    return count;
  }

  @Override
  public int delete(int shopno) {
    int count = shopDAO.delete(shopno);
    return count;
  }

}
