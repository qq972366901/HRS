package HotelorderlistView;

import java.util.List;

import Service.Impl.OrderBLServiceImpl;
import VO.OrderVO;
import orderBLService.OrderBLService;

public class HotelorderlistViewControllerImpl implements HotelorderlistViewControllerService {
	private HotelorderlistView view;
	private OrderBLService order;
	String hotelid;
	String userid;
	public HotelorderlistViewControllerImpl(String HotelID,String UserID){
		hotelid=HotelID;
		userid=UserID;
		order=new OrderBLServiceImpl(UserID);
	}
	@Override
	public void setView(HotelorderlistView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		view.exit();
	}

	@Override
	public List<OrderVO> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return userid;
	}

}
