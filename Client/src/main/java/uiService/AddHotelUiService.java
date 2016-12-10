package uiService;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import UserView.AddHotelView;
import VO.UserVO;

public interface AddHotelUiService {
	public void setView(AddHotelView view);
	public void toWebAdminUserView(String id) throws RemoteException;
	public void toUserManagementView(String id) throws RemoteException;
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore);
	public String getUserID();
	public List<String> getCity();
	public Vector<String> getCircle(String city);
	public void register(UserVO vo,String password);
}
