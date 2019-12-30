package dev.mvc.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.client.ClientProc")
public class ClientProc implements ClientProcInter{
  @Autowired
  private ClientDAOInter clientDAO;

  @Override
  public int checkId(String id) {
    int count = clientDAO.checkId(id);
    return count;
  }

  @Override
  public int create(ClientVO clientVO) {
    int count = clientDAO.create(clientVO);
    return count;
  }

  @Override
  public List<ClientVO> list() {
    List<ClientVO> list = clientDAO.list();
    return list;
  }

  @Override
  public ClientVO read(int clientno) {
    ClientVO clientVO = clientDAO.read(clientno);
    return clientVO;
  }

  @Override
  public ClientVO readById(String id) {
    ClientVO clientVO = clientDAO.readById(id);
    return clientVO;
  }

  @Override
  public int update(ClientVO clientVO) {
    int count = clientDAO.update(clientVO);
    return count;
  }

  @Override
  public int passwd_check(HashMap<Object, Object> map) {
    int count = clientDAO.passwd_check(map);
    return count;
  }

  @Override
  public int passwd_update(HashMap<Object, Object> map) {
    int count = clientDAO.passwd_update(map);
    return count;
  }

  @Override
  public int delete(int clientno) {
    int count = clientDAO.delete(clientno);
    return count;
  }

  @Override
  public int login(Map<Object, Object> map) {
    int count = clientDAO.login(map);
    return count;
  }

  @Override
  public boolean isMember(HttpSession session) {
    boolean sw = false;
    
    String id = (String)session.getAttribute("id");
    
    if (id != null){
      sw = true;
    }
    return sw;
  }

}
