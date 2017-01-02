package roomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.DataFactoryService;
import dataService.RoomDataService;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.RoomVO;

/**
 * 更新房间状态的类
 * @author 刘宗侃
 *
 */
public class RoomsReserved {

	private static String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomsReserved roomsReserved;
	/**
	 * 更新房间状态的构造方法
	 * @param id
	 */
	private RoomsReserved(String id) {
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
	 * 得到更新房间状态的类
	 * @param id
	 * @return
	 */
	public static RoomsReserved getRoomsReservedInstance(String id) {
		if(roomsReserved == null) {
			roomsReserved = new RoomsReserved(id);
		}
		if(hotelID != id) {
			roomsReserved = new RoomsReserved(id);
		}
		return roomsReserved;
	}
	/**
     * 客户下单更新酒店被预定的房间的状态
     * 
     * @param type String型，房型
     * @param number int型，预定的房间数量
     */
	public void updateRoomsState(String type,int number) {
		for(RoomVO rvo : list) {
			if(rvo.roomType.equals(type) && rvo.roomStatue.equals("空闲")) {
				rvo.roomStatue = "已预订";
				RoomPO rpo = new RoomPO(rvo.hotelID,rvo.roomId,"已预订",rvo.roomType,rvo.roomPrice);
				try {
					rds.update(rpo);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				number--;
			}
			if(number == 0) {
				break;
			}
		}
	}
	
}
