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
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class orderDetailViewControllerServiceImpl implements orderDetailViewControllerService {
	  private orderDetailView view;
	    private String UserID;
	    private String OrderID;
	    private OrderBLService order;
	    private HotelBLService hotel;
	    private int from;
	    private String HotelID;
	    private String key1;
	    public orderDetailViewControllerServiceImpl(String UserID,String OrderID,String hotelID,int f) throws RemoteException{
	    	key1=Log.getLogInstance().getKey(hotelID);
			hotelID=DES.encryptDES(hotelID, key1);
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
			list.add(DES.decryptDES(vo1.hotelName,key1));
			list.add(vo.roomType);
			list.add(vo.orderNumber);
			list.add(""+vo.orderValue);
			list.add(""+vo.numOfPerson);
			list.add(""+vo.roomNumber);
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
			list.add(sdf.format(vo.expectedCheckIn.getTime()));
			list.add(sdf.format(vo.expectedCheckOut.getTime()));
			if(vo.score==0){
				list.add("");
			}
			else{
				list.add(""+vo.score);
			}	
			list.add(vo.comment);
			return list;
		}
}
