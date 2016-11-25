package uiService;

import UserView.revisePasswordView;


public interface revisePasswordViewControllerService {
    public void setView(revisePasswordView view);
    public void exit();
    public String getUserID();
    public boolean checkoldPassword(String password);
    public boolean checknewPassword(String password);
    public boolean checksame(String password1,String password2);
    public boolean checksame_old(String password1,String password2);
	public void revisepassword(String userID, String password);
}
