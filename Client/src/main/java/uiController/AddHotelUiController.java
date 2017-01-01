package uiController;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import UserView.AddHotelView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import VO.UserVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
/**
 * 添加酒店界面的控制器
 * @author lw
 *
 */
public class AddHotelUiController implements  AddHotelUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private HotelBLService hotel;
	private String UserID;
	private PromotionBLService promotion;
	private UserBLService user;

	public AddHotelUiController(String id) throws RemoteException{
    	this.UserID=id;
    	this.promotion=new PromotionController();
    	this.user=new UserBLServiceController();
    	this.hotel=new HotelBLServiceController();
    }
	@Override
	/**
	 * 设置界面
	 */
	public void setView(AddHotelView view) {
		this.view=view;
}
	/**
	 * 跳转到网站管理人员主界面
	 */
	public void toWebAdminUserView(String id) throws RemoteException{
		WebAdminUserUiService controller=new WebAdminUserUiController(id);
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到用户管理界面
	 */
	public void toUserManagementView(String id) throws RemoteException{
		UserManagementUiService controller = null;
		controller = new UserManagementUiController(id);
		UserManagementView view=new UserManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 保存酒店的基本信息
	 */
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore){
		hotel.saveHotelInfo(hotelName,hotelCity, hotelArea,hoelLocation,hotelStar,hotelService,hotelIntroduction,hotelPhone, hotelID,hotelScore);
	}
	/**
	 * 从上一界面获取用户ID
	 */
	public String getUserID(){
		return UserID;
	}
	/**
	 * 获取多有的城市
	 */
	public List<String> getCity(){
		return promotion.getCity();
	}
	/**
	 * 获取城市拥有的商圈
	 */
	public Vector<String> getCircle(String city){
		return promotion.getCircle(city);
	}
	/**
	 * 保存用户的注册信息
	 */
	public void register(UserVO vo,String password){
		user.add(vo,password);
	}
	/**
	 * 保存客户ID，加密后的ID和密钥
	 */
	public boolean addLog(String id,String k,String secretid){
		return user.addLog(id,k,secretid);
	}
}
