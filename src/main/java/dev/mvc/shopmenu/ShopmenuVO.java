package dev.mvc.shopmenu;

import org.springframework.web.multipart.MultipartFile;

public class ShopmenuVO {
  /*
  menuno                           NUMBER(7)    NOT NULL    PRIMARY KEY,
  menuname                          VARCHAR2(30)     NOT NULL,
  price                             NUMBER(7)    NOT NULL,
  menuimg                           VARCHAR2(100)    NULL ,
  upimg                             VARCHAR2(100)    NULL ,
  thumb                             VARCHAR2(100)    NULL ,
  fsize                             NUMBER(7)    NULL ,
  shopno                            NUMBER(7)    NULL ,
  */
  private int menuno;
  private String menuname;
  private int price;
  private String menuimg;
  private String upimg;
  private String thumb;
  private long fsize;
  private int shopno;
  
  private MultipartFile fnameMF;
  
  public MultipartFile getFnameMF() {
    return fnameMF;
  }
  public void setFnameMF(MultipartFile fnameMF) {
    this.fnameMF = fnameMF;
  }
  
  public int getMenuno() {
    return menuno;
  }
  public void setMenuno(int menuno) {
    this.menuno = menuno;
  }
  public String getMenuname() {
    return menuname;
  }
  public void setMenuname(String menuname) {
    this.menuname = menuname;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getMenuimg() {
    return menuimg;
  }
  public void setMenuimg(String menuimg) {
    this.menuimg = menuimg;
  }
  public String getUpimg() {
    return upimg;
  }
  public void setUpimg(String upimg) {
    this.upimg = upimg;
  }
  public String getThumb() {
    return thumb;
  }
  public void setThumb(String thumb) {
    this.thumb = thumb;
  }
  public long getFsize() {
    return fsize;
  }
  public void setFsize(long fsize) {
    this.fsize = fsize;
  }
  public int getShopno() {
    return shopno;
  }
  public void setShopno(int shopno) {
    this.shopno = shopno;
  }

  
}
