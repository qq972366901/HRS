package uiController;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import UserView.AddHotelView;
import UserView.MemberRegisterView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import VO.UserVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.MemberRegisterUiService;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class AddHotelUiController implements  AddHotelUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private HotelBLService hotel;
	private String UserID;
	private PromotionBLService promotion;
	private UserBLService user;
	public AddHotelUiController(String id) throws RemoteException{
    	//user=new UserBLServiceImpl();
    	this.UserID=id;
    	this.promotion=new PromotionController();
    	this.user=new UserBLServiceController();
    	this.hotel=new HotelBLServiceController();
    }
	@Override
	public void setView(AddHotelView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(String id) throws RemoteException{
		WebAdminUserUiService controller=new WebAdminUserUiController(id);
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toUserManagementView(String id) throws RemoteException{
		UserManagementUiService controller = null;
		controller = new UserManagementUiController(id);
		UserManagementView view=new UserManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore){
		hotel.saveHotelInfo(hotelName,hotelCity, hotelArea,hoelLocation,hotelStar,hotelService,hotelIntroduction,hotelPhone, hotelID,hotelScore);
	}
	public String getUserID(){
		return UserID;
	}
	public List<String> getCity(){
		return promotion.getCity();
	}
	public Vector<String> getCircle(String city){
		return promotion.getCircle(city);
	}
	public void register(UserVO vo,String password){
		user.register(vo,password);
	}
	public boolean addLog(String id,String k,String secretid){
		return user.addLog(id,k,secretid);
	}
}
