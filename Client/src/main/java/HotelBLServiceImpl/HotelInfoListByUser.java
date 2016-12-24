package HotelBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.HotelPO;
import VO.HotelVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import rmi.RemoteHelper;


/**负责实现得到用户历史酒店列表的功能
 * @author 刘宗侃
 */
public class HotelInfoListByUser {

	private String userID;
	private List<HotelVO> list = new ArrayList<HotelVO>();
	
	private DataFactoryService df;
	private HotelDataService hds;
	
	private static HotelInfoListByUser hotelInfoListByUser;
	/**
	 * HotelInfoListByUser类的构造方法
	 */
	private HotelInfoListByUser(String userid) {
		userID = userid;
		df=RemoteHelper.getInstance().getDataFactoryService();
		list=new ArrayList<HotelVO>();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
			List<HotelPO> listpo = hds.getHistoryHotelByUser(userID);
			for(HotelPO hpo : listpo) {
				HotelVO vo = new HotelVO(hpo);
				list.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到HotelInfoListByUser对象
	 */
	public static HotelInfoListByUser getHotelInfoListByUserInstance(String userid) {
		if(hotelInfoListByUser == null) {
			hotelInfoListByUser = new HotelInfoListByUser(userid);
		}
		return hotelInfoListByUser;
	}
	/**
     * 查找用户的历史酒店并返回历史酒店列表
     * 
     * @return 返回酒店的一个列表
     */
	public List<HotelVO> getHistoryHotel() {
		return list;
	}
	
	
}
