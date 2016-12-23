package uiController;


import java.rmi.RemoteException;

import UserView.customerMainView;
import uiService.customerMainViewControllerService;
import userBLServiceImpl.Log;
/**
 * 客户的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class customerMainViewControllerImpl implements customerMainViewControllerService{
	private customerMainView view;
	private String UserID;
	public customerMainViewControllerImpl(String id){
		String key=null;
		try {
			key=Log.getLogInstance().getSKey(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(key!=null){
			UserID = id;
		}
		else{
			System.out.println("加密失败");
		}
    }
	@Override
	public void setView(customerMainView view) {
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
		try {
			view.order();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getUserID() {
		return UserID;
	}

}
