package uiController;

import java.rmi.RemoteException;
import java.util.Vector;

import UserView.InformationView;
import VO.UserVO;
import uiService.InformationViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class InformationViewControllerImpl implements InformationViewControllerService{
    private InformationView view;
    private UserBLService user;
    private String UserID;
    private UserVO vo;
    public InformationViewControllerImpl(String id) throws RemoteException{
    	user=new UserBLServiceController();
    	UserID=id;
    	vo=new UserVO();
    }
    public void setView(InformationView view){
    	this.view=view;
    }
	@Override
	public void exit() {
		view.exit();
	}
	@Override
	public void reviseinformation() {
		// TODO Auto-generated method stub
		view.reviseinformation();
	}
	@Override
	public void revisepassword() {
		// TODO Auto-generated method stub
		view.revisepassword();
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return UserID;
	}
	@Override
	public Vector<String> getInformation(String UserID) {
		Vector<String> data=new Vector<String>();
		//data=user.findByID(userID);
		return null;
	}
}
