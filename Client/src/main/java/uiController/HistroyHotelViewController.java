package uiController;

import java.util.ArrayList;
import java.util.List;

import UserView.HistroyHotelView;
import VO.HotelVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import uiService.HistroyHotelViewControllerService;
/**
 * 历史酒店的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class HistroyHotelViewController implements HistroyHotelViewControllerService {
	private HistroyHotelView view;
	private String id;
	private HotelBLService hotel;
	private List<HotelVO> list;
	public HistroyHotelViewController(String id){
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
