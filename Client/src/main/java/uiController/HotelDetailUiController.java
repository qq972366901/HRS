package uiController;

import java.util.ArrayList;
import java.util.List;

import UserView.HotelDetailView;
import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import uiService.HotelDetailUiService;
/**
 * 酒店详细信息与酒店下的订单的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class HotelDetailUiController implements HotelDetailUiService {
     private HotelDetailView view;
     private HotelBLService hotel;
     private String UserID;
     private String HotelID;
     public HotelDetailUiController(String hotelid,String userid){
    	 hotel=new HotelBLServiceController();
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
		return hotel.findByHotelID(hotelID);
	}
	@Override
	public List<OrderVO> getOrderList() {
		List<OrderVO> list=new ArrayList<OrderVO>();
		list=hotel.findByHotelIDAndUserID(UserID, HotelID);
		for(OrderVO vo: list){
			vo.addorderNumber();
			vo.addorderState();
			vo.addnumOfPerson();
			vo.addorderValue();
			vo.addroomType();
			vo.addroomNumber();
			vo.addexpectedCheckIn();
			vo.addexpectedCheckOut();
			vo.addscore();
		}
		return list;
	}
}
