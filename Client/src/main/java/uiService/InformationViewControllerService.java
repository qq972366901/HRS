package uiService;

import java.util.Vector;

import UserView.InformationView;

public interface InformationViewControllerService {

	public void exit();
	public void setView(InformationView view);
    public Vector<String> getInformation(String UserID);
    public void reviseinformation();
    public void revisepassword();
    public String getUserID();
}
