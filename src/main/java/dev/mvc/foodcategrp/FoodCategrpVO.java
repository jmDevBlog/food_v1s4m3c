package dev.mvc.foodcategrp;

public class FoodCategrpVO {
  /*
  foodcategrpno                     NUMBER(7)    NOT NULL    PRIMARY KEY,
  foodname                          VARCHAR2(100)    NOT NULL,
  SEQNO                             NUMBER(7)    NOT NULL,
  VISIBLE                           CHAR(1)    NOT NULL,
  RDATE                             DATE     NOT NULL,
  CNT                               NUMBER(7)    DEFAULT 0     NOT NULL
  */
  /** ���� ī�װ� ��ȣ */
  private int foodcategrpno;
  /**  ���� ī�װ� �̸� */
  private String foodname;
  /** ��� ���� */
  private int seqno;
  /** ��� ��� */
  private String visible;
  /** ����� */
  private String rdate;
  /** ��ϵ� �ۼ�*/
  private int cnt;
  public int getFoodcategrpno() {
    return foodcategrpno;
  }
  public void setFoodcategrpno(int foodcategrpno) {
    this.foodcategrpno = foodcategrpno;
  }
  public String getFoodname() {
    return foodname;
  }
  public void setFoodname(String foodname) {
    this.foodname = foodname;
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
}
