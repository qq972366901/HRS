package uiService;

import UserView.InformationView;

public interface InformationViewControllerService {

	public void exit();
	public void setView(InformationView view);
    public void getname();
    public void getbirth();
    public void gettel();
    public void getenterprise();
    public void getemail();
    public void getlevel();
    public void gettype();
    public void getcredit();
    public void reviseinformation();
    public void revisepassword();
    public String getUserID();
}
