package uiController;

import java.rmi.RemoteException;

import UserView.customerMainView;
import uiService.customerMainViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class customerMainViewControllerImpl implements customerMainViewControllerService{
	private customerMainView view;
	private UserBLService user;
	private String UserID;
	public customerMainViewControllerImpl(String id) throws RemoteException{
    	user=new UserBLServiceController();
    	UserID=id;
    }
	@Override
	public void setView(customerMainView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}
	@Override
	public void information() {
	    view.information();
	}
	@Override
	public void credit() {
		view.credit();
	}
	@Override
	public void exit() {
		view.exit();
	}
	@Override
	public void search() {
		view.search();	
	}
	@Override
	public void histroy() {
		view.histroy();
	}
	@Override
	public void order() {
		view.order();
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return UserID;
	}

}
