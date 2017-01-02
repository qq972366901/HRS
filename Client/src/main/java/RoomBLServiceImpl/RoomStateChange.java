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
public class RoomStateChange {

	private static String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomStateChange roomStateChange;
	/**
	 * 更新房间状态类的构造方法
	 * @param id
	 */
	private RoomStateChange(String id) {
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
	 * 得到更新房间状态的类s
	 * @param id
	 * @return
	 */
	public static RoomStateChange getRoomStateChangeInstance(String id) {
		if(roomStateChange == null) {
			roomStateChange = new RoomStateChange(id);
		}
		if(hotelID != id) {
			roomStateChange = new RoomStateChange(id);
		}
		return roomStateChange;
	}
	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param rNumber String型，房间号
     * @param rState String型，房间状态
     */
	public void updateRoomState(String rNumber, String rState) {
		if(rState.equals("空闲")) {
			for(RoomVO rvo: list) {
				if(rvo.roomStatue.equals("已入住") && rvo.roomId.equals(rNumber)) {
					rvo.roomStatue = "空闲";
					RoomPO rpo = new RoomPO(rvo.hotelID,rvo.roomId,"空闲",rvo.roomType,rvo.roomPrice);
					try {
						rds.update(rpo);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		
		if(rState.equals("已入住")) {
			for(RoomVO rvo: list) {
				if(!rvo.roomStatue.equals("已入住") && rvo.roomId.equals(rNumber)) {
					rvo.roomStatue = "已入住";
					RoomPO rpo = new RoomPO(rvo.hotelID,rvo.roomId,"已入住",rvo.roomType,rvo.roomPrice);
					try {
						rds.update(rpo);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	/**
     * 房间是否存在
     * 
     * @param roomNumber String型，房间号
     */
	public boolean exist(String roomNumber) {
		boolean outcome = false;
		for(RoomVO rvo: list) {
			if(rvo.roomId.equals(roomNumber)) {
				outcome = true;
				break;
			}
		}
		return outcome;
	}
	
}
