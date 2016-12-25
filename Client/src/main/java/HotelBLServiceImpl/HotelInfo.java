package HotelBLServiceImpl;

import java.rmi.RemoteException;
import java.util.List;

import PO.HotelPO;
import VO.HotelVO;
import VO.OrderVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import rmi.RemoteHelper;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

/**负责实现更新与得到酒店信息的功能
 * @author 刘宗侃
 */
public class HotelInfo {
	
	private String hotelID;
	
	private HotelVO hvo;
	
	private DataFactoryService df;
	private HotelDataService hds;
	
	private String key = null;
	
//	private static HotelInfo hotelInfo;
	/**
	 * HotelInfo类的构造方法
	 */
	public HotelInfo(String id) {
		hotelID = id;
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
			Log log=new Log();
			key=log.getSKey(id);
			HotelPO hpo = hds.find(hotelID);
			hvo = new HotelVO(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
//	public static HotelInfo getHotelInfoInstance(String id) {
//		if(hotelInfo == null) {
//			hotelInfo = new HotelInfo(id);
//		}
//		return hotelInfo;
//	}
	/**
     * 更新酒店的基本信息
     * 
     * @param hotelName String型，酒店名称
     * @param hotelLocation String型，酒店地址
     * @param hotelService String型，酒店设施服务
     * @param hotelCity String型，酒店城市
     * @param hotelArea String型，酒店商圈
     * @param hotelIntroduction String型，酒店简介
     * @param hotelStar int型，酒店星级
     * @param hotelPhone String型，酒店联系电话
     */
	public void updateHotelInfo(String hName, String hLocation, String hService, String hCity,
			String hArea, String hIntroduce, int hStar, String hPhone) {
		hvo.hotelName = hName;
		hvo.hotelAddress = hLocation;
		hvo.hotelService = hService;
		hvo.hotelCity = hCity;
		hvo.hotelDistrict = hArea;
		hvo.hotelProfile = hIntroduce;
		hvo.hotelStar = hStar;
		if(key!=null){
			hvo.hotelPhone = DES.encryptDES(hPhone, key);
		}
		else{
			System.out.println("加密失败");
		}
		
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,hvo.score,hvo.hotelPhone);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
     * 根据酒店帐号返回酒店详细信息
     * 
     * @return 返回此酒店的详细信息
     */
	public HotelVO getHotelVO() {
		return this.hvo;
	}
	/**
     * 网站工作人员更新酒店的联系方式
     * 
     * @param hotelPhone String型，房间类型
     */
	public void updateHotelPhone(String hotelPhone) {
		hvo.hotelPhone = hotelPhone;
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,hvo.score,hotelPhone);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
     * 订单评价评分后更新酒店评分
     * 
     * @param sco double型，订单评分
     */
	public void updateHotelScore(int sco) {
		double newScore = sco;
//		if(hvo.score - 0 < 0.001) {
//			newScore = sco;
//		} else {
//			int num = 1;
//			while(hvo.score * num % 1 > 0.01) {
//				num++;
//			}
//			newScore = (hvo.score*num + sco) / (num + 1);
//		}
		OrderBLService obls;
		List<OrderVO> list;
		double num = 0.0;
		int has = 0;
		try {
			obls = new OrderBLServiceController();
			list = obls.getAllOrders(hotelID);
			if(list == null || list.size() < 1) {
				newScore = sco;
			} else {
				for(OrderVO vo : list) {
					if(vo.orderState == 1) {
						num = num + vo.score;
						has++;
					}
				}
				newScore = num / has;
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,newScore,hvo.hotelPhone);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
     * 酒店信息浏览得到酒店平均评分
     * 
     * @return 返回此酒店的平均评分
     */
	public double getHotelScore() {
		return hvo.score;
	}

}
