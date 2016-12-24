package RoomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

/**
 * 得到酒店房间具体信息的类
 * @author 刘宗侃
 *
 */
public class RoomAllOfHotel {

	private static String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomAllOfHotel roomAllOfHotel;
	
	/**
	 * 得到酒店所有房间的构造方法
	 * @param id
	 */
	private RoomAllOfHotel(String id) {
		hotelID = id;
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			rds = (RoomDataService)df.getDataService("Room");
			List<RoomPO> listpo = rds.getAllRooms(hotelID);
			for(RoomPO rpo :listpo) {
				RoomVO rvo = new RoomVO(rpo);
				list.add(rvo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到酒店所有房间的类
	 * 
	 * @param id
	 * @return
	 */
	public static RoomAllOfHotel getRoomAllOfHotelInstance(String id) {
		if(roomAllOfHotel == null) {
			roomAllOfHotel = new RoomAllOfHotel(id);
		}
		if(hotelID != id) {
			roomAllOfHotel = new RoomAllOfHotel(id);
		}
		return roomAllOfHotel;
	}
	
	public List<RoomVO> getAllRooms() {
		return this.list;
	}
	/**
     * 得到酒店的所有空闲房间的最低价格，若无空闲房间，返回 -1 
     * 
     * @return 此酒店的所有空闲房间的最低价格
     */
	public int getLowestPrice() {
		int low = -1;
		for(RoomVO rvo : list) {
			if(rvo.roomStatue.equals("空闲")) {
				low = rvo.roomPrice;
				break;
			}
		}
		for(RoomVO rvo : list) {
			if(rvo.roomStatue.equals("空闲") && rvo.roomPrice < low) {
				low = rvo.roomPrice;
			}
		}
		return low;
	}
	/**
     * 得到酒店的某房间类型的价格
     * 
     * @param rType String型，一种房间类型
     * @return 返回酒店的某房间类型的价格
     */
	public int getPrice(String rType) {
		int price = -1;
		for(RoomVO rvo : list) {
			if(rvo.roomType.equals(rType)) {
				price = rvo.roomPrice;
				break;
			}
		}
		return price;
	}
	
}
