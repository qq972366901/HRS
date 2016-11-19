package revisePasswordView;

import java.util.Vector;


public interface revisePasswordViewControllerService {
    public void setView(revisePasswordView view);
    public void exit();
    public void revisepassword(Vector<String> vector);
    public String getUserID();
    public boolean checkoldPassword(String password);
    public boolean checknewPassword(String password);
    public boolean checksame(String password1,String password2);
    public boolean checksame_old(String password1,String password2);
}
