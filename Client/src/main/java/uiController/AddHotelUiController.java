package uiController;

import javax.swing.JPanel;

import UserView.AddHotelView;
import UserView.MemberRegisterView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import common.MessageInput;
import common.ResultMessage;
import hotelBLService.HotelBLService;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.MemberRegisterUiService;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;

public class AddHotelUiController implements  AddHotelUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private HotelBLService hotel;
	@Override
	public void setView(AddHotelView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(String id){
		WebAdminUserUiService controller=new WebAdminUserUiController();
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toUserManagementView(String id){
		UserManagementUiService controller=new UserManagementUiController();
		UserManagementView view=new UserManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore){
		hotel.saveHotelInfo(hotelName,hotelCity, hotelArea,hoelLocation,hotelStar,hotelService,hotelIntroduction,hotelPhone, hotelID,hotelScore);
	}
}
