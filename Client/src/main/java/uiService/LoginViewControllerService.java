package uiService;

import UserView.LogView;

public interface LoginViewControllerService {
         public void setView(LogView view);
         public boolean login(String logid,String password);
         public boolean register();
		public void updateRegisterButton(String selected);
		public void updateOrderState();
}
