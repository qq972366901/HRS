package uiController;

import UserView.HotelDetailView;
import VO.HotelVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLService_realize;
import uiService.HotelDetailUiService;

public class HotelDetailUiController implements HotelDetailUiService {
     private HotelDetailView view;
     private HotelBLService hotel;
     private String UserID;
     private String HotelID;
     public HotelDetailUiController(String hotelid,String userid){
    	 hotel=new HotelBLService_realize();
    	 UserID=userid;
    	 HotelID=hotelid;
     }
     public void setView(HotelDetailView view){
    	 this.view=view;
     }
     public void exit(){
    	 view.exit();
     }
     public String getUserID(){
    	 return UserID;
     }
     public String getHotelID(){
    	 return HotelID;
     }
	public HotelVO findByhotelID(String hotelID) {
		//return hotel.findByhotelID(hotelID);
		return null;
	}
	public void intoOrderList() {
		view .intoOrderList();
	}
}
