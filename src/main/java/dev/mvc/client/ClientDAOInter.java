package dev.mvc.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClientDAOInter {
  
  /**
   * 중복 아이디 검사
   * @param id 아이디
   * @return 중복 아이디 갯수
   */
  public int checkId(String id);
  
  /**
   * 회원 가입
   * @param memberVO
   * @return 가입된 회원 수
   */
  public int create(ClientVO clientVO); 
 
  /**
   * 목록
   * @return
   */
  public List<ClientVO> list();
  
  /**
   * 회원 번호를 통한 조회
   * @param memberno 회원 번호
   * @return
   */
  public ClientVO read(int clientno);
  
  /**
   * 아이디를 통한 조회
   * @param id 아이디
   * @return
   */
  public ClientVO readById(String id);
  
  /**
   * 회원 정보 수정
   * @param memberVO
   * @return 수정된 회원 수
   */
  public int update(ClientVO clientVO);
  
  /**
   * 패스워드 검사
   * @param map
   * @return 0: 일치하지 않음, 1: 일치함
   */
  public int passwd_check(HashMap<Object, Object> map);
  
  /**
   * 패스워드 변경
   * @param map
   * @return 변경된 패스워드 갯수
   */
  public int passwd_update(HashMap<Object, Object> map);
 
  /**
   * 회원 삭제
   * @param memberno
   * @return 삭제된 회원수
   */
  public int delete(int clientno);
  
  /**
   * 로그인
   * @param map
   * @return
   */
  public int login(Map<Object, Object> map);
  

}
