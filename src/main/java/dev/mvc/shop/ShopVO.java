package dev.mvc.shop;

import org.springframework.web.multipart.MultipartFile;

public class ShopVO {
  /* 
    shopno                           NUMBER(7)    NOT NULL    PRIMARY KEY,
    name                              VARCHAR2(10)     NOT NULL,
    shopaddress                       VARCHAR2(100)    NULL ,
    SEQNO                             NUMBER(7)    NOT NULL,
    VISIBLE                           CHAR(1)    NOT NULL,
    RDATE                             DATE     NOT NULL,
    CNT                               NUMBER(7)    NULL ,
    foodcategrpno                     NUMBER(7)    NULL ,
   */
  private int shopno;
  private String name;
  private String shopaddress;
  private int seqno;
  private String visible;
  private String rdate;
  private int cnt;
  private int foodcategrpno;
  private String fname;
  private String fupname;
  private String thumb1;
  private long size1;
  
  private MultipartFile fnameMF;
  private String flabel;
  
  
  public MultipartFile getFnameMF() {
    return fnameMF;
  }
  public void setFnameMF(MultipartFile fnameMF) {
    this.fnameMF = fnameMF;
  }
  public String getFlabel() {
    return flabel;
  }
  public void setFlabel(String flabel) {
    this.flabel = flabel;
  }
  public int getShopno() {
    return shopno;
  }
  public void setShopno(int shopno) {
    this.shopno = shopno;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getShopaddress() {
    return shopaddress;
  }
  public void setShopaddress(String shopaddress) {
    this.shopaddress = shopaddress;
  }
  public int getSeqno() {
    return seqno;
  }
  public void setSeqno(int seqno) {
    this.seqno = seqno;
  }
  public String getVisible() {
    return visible;
  }
  public void setVisible(String visible) {
    this.visible = visible;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  public int getFoodcategrpno() {
    return foodcategrpno;
  }
  public void setFoodcategrpno(int foodcategrpno) {
    this.foodcategrpno = foodcategrpno;
  }
  public String getFname() {
    return fname;
  }
  public void setFname(String fname) {
    this.fname = fname;
  }
  public String getFupname() {
    return fupname;
  }
  public void setFupname(String fupname) {
    this.fupname = fupname;
  }
  public String getThumb1() {
    return thumb1;
  }
  public void setThumb1(String thumb1) {
    this.thumb1 = thumb1;
  }
  public long getSize1() {
    return size1;
  }
  public void setSize1(long size1) {
    this.size1 = size1;
  }
  
  

}
