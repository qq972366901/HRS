package uiController;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import uiService.OrderDetailViewService;
import userBLServiceImpl.Log;
import userView.OrderDetailView;
import vo.HotelVO;
import vo.OrderVO;
/**
 * 订单详情的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class OrderDetailViewController implements OrderDetailViewService {
	  private OrderDetailView view;
	    private String UserID;
	    private String OrderID;
	    private OrderBLService order;
	    private HotelBLService hotel;
	    private int from;
	    private String HotelID;
	    private String key;
	    public OrderDetailViewController(String UserID,String OrderID,String hotelID,int f) throws RemoteException{
	    	Log log=new Log();
	    	key=log.getSKey(hotelID);
	    	this.UserID=UserID;
	    	from=f;
	    	this.OrderID=OrderID;
	    	this.HotelID=hotelID;
	    	order=new OrderBLServiceController();
	    	hotel=new HotelBLServiceController();
	    }
		@Override
		public void setView(OrderDetailView view) {
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
			OrderVO vo=order.showDetail(OrderID);
			HotelVO vo1=hotel.findByHotelID(vo.hotelID);
			List<String> list=new ArrayList<String>();
			list.add(vo1.hotelName);
			list.add(vo.roomType);
			list.add(vo.orderNumber);
			list.add(""+vo.orderValue);
			list.add(""+vo.numOfPerson);
			list.add(""+vo.roomNumber);
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
			list.add(sdf.format(vo.expectedCheckIn.getTime()));
			list.add(sdf.format(vo.expectedCheckOut.getTime()));
			if(vo.score==0){
				list.add("未评价");
			}
			else{
				list.add(""+vo.score);
			}	
			list.add(vo.comment);
			return list;
		}
}
