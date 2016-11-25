package uiController;

import java.util.ArrayList;
import java.util.List;

import Object.Hotel;
import Service.Impl.OrderBLServiceImpl;
import UserView.HistroyHotelView;
import VO.HotelVO;
import VO.OrderVO;
import VO.UserVO;
import orderBLService.OrderBLService;
import uiService.HistroyHotelViewControllerService;

public class HistroyHotelViewControllerImpl implements HistroyHotelViewControllerService {
	private HistroyHotelView view;
	private String id;
	private OrderBLService order;
	private OrderVO vo;
	private UserVO vo1;
	public HistroyHotelViewControllerImpl(String id){
		this.id=id;
		order=new OrderBLServiceImpl(id);
	}
	public void setView(HistroyHotelView view){
		this.view=view;
	}
	@Override
	public void exit() {
		view.exit();
	}
	@Override
	public List<String> getHotelName(String id) {		
		vo1=new UserVO();
		vo1.id=id;
		List<Hotel> list=order.gethistory(vo1);
		List<String> listi=new ArrayList<String>();
        for(int i=0;i<5;i++){
        	listi.add("hhh"+i);
        }
        return listi;
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void intoOrderList(String HotelName) {
		// TODO Auto-generated method stub
	    //order.findByType(vo)
		//Vector<OrderVO> list=new Vector<OrderVO>(); 
		view.intoOrderList("110",id);
	}
}
