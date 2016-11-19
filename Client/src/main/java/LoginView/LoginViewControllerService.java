package LoginView;

import common.UserType;

public interface LoginViewControllerService {
         public void updatemodel(String str);
         public void setView(LoginView view);
         public boolean login(String logid,String password);
         public boolean register();
         public boolean find();
         public void error();
}
