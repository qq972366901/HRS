package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.AdminRoomUiService;
import uiService.LoginViewControllerService;
import uiService.MemberRegisterUiService;
import uiService.CustomerMainViewService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.Customer;
import userView.AddHotelView;
import userView.CustomerMainView;
import userView.LogView;
import userView.MemberRegisterView;
import vo.UserVO;
import webPromotionView.WebPromotionUserView;
/**
 * 会员注册界面的控制器
 * @author lw
 *
 */
public class MemberRegisterUiController implements MemberRegisterUiService {
	private JPanel view;
	private UserBLService user;
	/**
	 * 会员注册界面的控制器构造方法
	 * @param id
	 */
	public MemberRegisterUiController() throws RemoteException{
		this.user=new UserBLServiceController();
	}
	@Override
	/**
	 * 设置会员注册界面的panel
	 * @param 
	 */
	public void setView(MemberRegisterView view) {
		this.view=view;
}
	/**
	 * 跳转到用户主界面
	 * @param 
	 */
	public void tocustomerMainView(String id){
		CustomerMainViewService controller=new CustomerMainViewController(id);
		CustomerMainView view =new CustomerMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到登录界面
	 * @param 
	 */
    public void toLogView(){
    	LoginViewControllerService controller;
		controller = new LoginViewController();
		LogView view=new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 保存注册信息
	 * @param 
	 */
	public void register(UserVO vo,String password){
		user.register(vo,password);
	}
	/**
	 * 保存客户的ID，加密后的ID和密钥
	 * @param 
	 */
	public boolean addLog(String id,String k,String secretid){
		return user.addLog(id,k,secretid);
	}
}
