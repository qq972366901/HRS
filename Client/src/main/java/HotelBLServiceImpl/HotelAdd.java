package hotelBLServiceImpl;

import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.HotelDataService;
import po.HotelPO;
import rmi.RemoteHelper;

/**负责实现添加酒店的功能
 * @author 刘宗侃
 */
public class HotelAdd {

	private DataFactoryService df;
	private HotelDataService hds;
	
	private static HotelAdd hotelAdd;
	
	/**
	 * HotelAdd类的构造方法
	 */
	private HotelAdd() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到HotelAdd对象
	 */
	public static HotelAdd getHotelAddInstance() {
		if(hotelAdd == null) {
			hotelAdd = new HotelAdd();
		}
		return hotelAdd;
	}
	
	/**
     * 网站管理人员添加酒店
     * 
     * @param hotelName String型，酒店名称
     * @param hotelCity String型，酒店城市
     * @param hotelArea String型，酒店商圈
     * @param hotelLocation String型，酒店地址
     * @param hotelStar int型，酒店星级
     * @param hotelService String型，酒店设施服务
     * @param hotelIntroduction String型，酒店简介
     * @param hotelPhone String型，酒店联系电话
     * @param hotelID String型，酒店账号ID
     * @param hotelScore double型，酒店评分
     */
	public void addHotel(String hotelName, String hotelCity, String hotelArea, String hotelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore) {
		HotelPO hpo = new HotelPO(hotelLocation, hotelCity, hotelArea, hotelStar,hotelIntroduction,
				hotelService,hotelName,hotelID,hotelScore,hotelPhone);
		
		try {
			hds.insert(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
