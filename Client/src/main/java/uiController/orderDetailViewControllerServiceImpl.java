package uiController;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import UserView.orderDetailView;
import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import uiService.orderDetailViewControllerService;

public class orderDetailViewControllerServiceImpl implements orderDetailViewControllerService {
	  private orderDetailView view;
	    private String UserID;
	    private String OrderID;
	    private OrderBLService order;
	    private HotelBLService hotel;
	    private int from;
	    private String HotelID;
	    public orderDetailViewControllerServiceImpl(String UserID,String OrderID,String hotelID,int f) throws RemoteException{
	    	this.UserID=UserID;
	    	from=f;
	    	this.OrderID=OrderID;
	    	this.HotelID=hotelID;
	    	order=new OrderBLServiceController();
	    	hotel=new HotelBLServiceController();
	    }
		@Override
		public void setView(orderDetailView view) {
			this.view=view;
		}
        public String getHotelID(){
        	return this.HotelID;
        }
        public String getOrderID(){
        	return this.OrderID;
        }
		@Override
		public void exit() {
			if(from==1){
			try {
				view.exit();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else{
				view.exit2();
			}
		}
		@Override
		public String getUserID() {
			return UserID;
		}
		public  List<String> getDetail(){
			OrderVO vo=order.showDetail(UserID,OrderID);
			HotelVO vo1=hotel.findByHotelID(vo.hotelID);
			List<String> list=new ArrayList<String>();
			list.add(vo1.hotelName);
			list.add(vo.roomType);
			list.add(vo.orderNumber);
			list.add(""+vo.orderValue);
			list.add(""+vo.numOfPerson);
			list.add(""+vo.roomNumber);
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			list.add(sdf.format(vo.expectedCheckIn));
			list.add(sdf.format(vo.expectedCheckOut));
			list.add(""+vo.score);
			list.add(vo.comment);
			return list;
		}
}
