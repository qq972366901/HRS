package reviseInformationView;

import java.util.Vector;

public interface reviseInformationViewControllerService {
     public void setView(reviseInformationView view);
     public void exit();
     public void updateinformation(Vector<String> vector);
     public String getUserID();
}
