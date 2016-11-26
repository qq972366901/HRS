package uiController;

import javax.swing.JPanel;

import UserView.MemberRegisterView;
import WebPromotionView.WebPromotionUserView;
import UserView.AddHotelView;
import UserView.AdminRoomView;
import UserView.LogView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.AdminRoomUiService;
import uiService.LoginViewControllerService;
import uiService.MemberRegisterUiService;
import uiService.webPromotionUserUiService;

public class MemberRegisterUiController implements MemberRegisterUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(MemberRegisterView view) {
		// TODO Auto-generated method stub
		this.view=view;
}

	public void tocustomerMainView(String id){
		try {
			customerMainViewControllerService controller=new customerMainViewControllerImpl(id);
			customerMainView view =new customerMainView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void toLogView(){
    	LoginViewControllerService controller;
		try {
			controller = new LoginViewControllerImpl();
			LogView view=new LogView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * 新建一个用户
     * @return 
     */
	@Override
	public boolean createUser(UserVO vo,String password) {
		// TODO Auto-generated method stub
		return user.add(vo,password);
	}
}
