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
 * 判断酒店能否提供足够房间的类
 * @author 刘宗侃
 *
 */
public class RoomAvailableJudge {

	private static String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomAvailableJudge roomAvailableJudge;
	/**
	 * 判断酒店能否提供足够房间的类的构造方法
	 * @param id
	 */
	private RoomAvailableJudge(String id) {
		hotelID = id;
		df = RemoteHelper.getInstance().getDataFactoryService();
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
	 * 得到判断酒店能否提供足够房间的类
	 * @param id
	 * @return
	 */
	public static RoomAvailableJudge getRoomAvailableJudgeInstance(String id) {
		if(roomAvailableJudge == null) {
			roomAvailableJudge = new RoomAvailableJudge(id);
		}
		if(hotelID != id) {
			roomAvailableJudge = new RoomAvailableJudge(id);
		}
		return roomAvailableJudge;
	}
	/**
     * 判断能否酒店是否有足够房间
     * 
     * @param type String型，房型
     * @param number String型，预定的房间数量
     */
	public boolean whetherSuccess(String type,int number) {
		boolean success = false;
		for(RoomVO rvo : list) {
			if(rvo.roomType.equals(type) && rvo.roomStatue.equals("空闲")) {
				number--;
			}
			if(number == 0) {
				success = true;
				break;
			}
		}
		return success;
	}
	
}
