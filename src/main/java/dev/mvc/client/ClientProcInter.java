package dev.mvc.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface ClientProcInter {
  /**
   * �ߺ� ���̵� �˻�
   * @param id ���̵�
   * @return �ߺ� ���̵� ����
   */
  public int checkId(String id);
  
  /**
   * ȸ�� ����
   * @param ClientVO
   * @return ���Ե� ȸ�� ��
   */
  public int create(ClientVO clientVO); 
  
  /**
   * ���
   * @return
   */
  public List<ClientVO> list();
  
  /**
   * ȸ�� ��ȣ�� ���� ��ȸ
   * @param clientno ȸ�� ��ȣ
   * @return
   */
  public ClientVO read(int clientno);
  
  /**
   * ���̵� ���� ��ȸ
   * @param id ���̵�
   * @return
   */
  public ClientVO readById(String id);
  
  /**
   * ȸ�� ���� ����
   * @param ClientVO
   * @return ������ ȸ�� ��
   */
  public int update(ClientVO clientVO);
  
  /**
   * �н����� �˻�
   * @param map
   * @return 0: ��ġ���� ����, 1: ��ġ��
   */
  public int passwd_check(HashMap<Object, Object> map);
  
  /**
   * �н����� ����
   * @param map
   * @return ����� �н����� ����
   */
  public int passwd_update(HashMap<Object, Object> map);
  
  /**
   * ȸ�� ����
   * @param clientno
   * @return ������ ȸ����
   */
  public int delete(int clientno);
  
  /**
   * �α���
   * @param map
   * @return
   */
  public int login(Map<Object, Object> map);
  
  /**
   * �α��ε� ȸ�� �������� �˻��մϴ�.
   * @param session
   * @return true: ������
   */
  public boolean isMember(HttpSession session);   

}