package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import uiService.LoginViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userView.LogView;
/**
 * 登录的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class LoginViewController implements LoginViewControllerService{
    private LogView view;
    private UserBLService user;
    private OrderBLService order;
	public LoginViewController(){
    	try {
			user=new UserBLServiceController();
			order=new OrderBLServiceController();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	Timer timer = new Timer();
    	timer.schedule(new TimerTask() {
    	        public void run() {
    	            if((Calendar.getInstance().get(Calendar.HOUR_OF_DAY)==0)&&
    	            		(Calendar.getInstance().get(Calendar.MINUTE)==0)&&
                                (Calendar.getInstance().get(Calendar.SECOND)==0)){
    	            	order.updateOrderState();
    	            }
    	        }
    	}, 0 , 1000);
    }
	@Override
	public void setView(LogView view) {
		this.view=view;
	}

	@Override
	public boolean login(String id,String password) {		
            return user.login(id, password);
	}

	@Override
	public boolean register()  {
		try {
			view.register();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void updateRegisterButton(String selected) {
		view.updateRegisterButton(selected);
	}
	@Override
	public void updateOrderState() {
		order.updateOrderState();
	}
}
