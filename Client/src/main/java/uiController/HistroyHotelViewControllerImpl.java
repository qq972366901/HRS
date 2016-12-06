package uiController;

import java.util.ArrayList;
import java.util.List;

import UserView.HistroyHotelView;
import VO.HotelVO;
import VO.UserVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import uiService.HistroyHotelViewControllerService;

public class HistroyHotelViewControllerImpl implements HistroyHotelViewControllerService {
	private HistroyHotelView view;
	private String id;
	private HotelBLService hotel;
	//private UserVO vo1;
	private List<HotelVO> list;
	public HistroyHotelViewControllerImpl(String id){
		this.id=id;
		hotel=new HotelBLServiceController();
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
		//vo1=new UserVO();
		//vo1.id=id;vo1有用吗？
		list=hotel.getHistoryHotel(id);
		List<String> listi=new ArrayList<String>();
        for(HotelVO vo:list){
        	listi.add(vo.hotelName);
        }
        return listi;
	}
	@Override
	public String getUserID() {
		return id;
	}
	@Override
	public void intoOrderList(int index) {
		HotelVO vo=list.get(index);
		view.intoOrderList(vo.hotelAccount,id);
	}
}
