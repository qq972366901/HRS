package CreditView;

import java.util.List;

import VO.CreditRecordVO;
import VO.OrderVO;

public interface CreditViewControllerService {
public void setView(CreditView view);
public long getcredit();
public void exit();
public String getUserID();
public List<CreditRecordVO> getCreditRecord(String id);
}
