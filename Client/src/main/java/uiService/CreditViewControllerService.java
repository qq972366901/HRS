package uiService;

import java.util.Vector;

import UserView.CreditView;

public interface CreditViewControllerService {
public void setView(CreditView view);
public long getcredit(String id);
public void exit();
public String getUserID();
public Vector<Vector<String>> getCreditRecord(String id);
}
