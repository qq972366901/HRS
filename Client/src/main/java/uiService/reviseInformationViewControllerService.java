package uiService;

import java.util.Vector;

import UserView.reviseInformationView;

public interface reviseInformationViewControllerService {
     public void setView(reviseInformationView view);
     public void exit();
     public void updateinformation(Vector<String> vector);
     public String getUserID();
}
