package RoomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

public class RoomStateChange {

	private static String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomStateChange roomStateChange;
	
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
	
	public static RoomStateChange getRoomStateChangeInstance(String id) {
		if(roomStateChange == null) {
			roomStateChange = new RoomStateChange(id);
		}
		if(hotelID != id) {
			roomStateChange = new RoomStateChange(id);
		}
		return roomStateChange;
	}
	
	public void updateRoomState(String rNumber, String rType, String rState) {
		if(rState.equals("空闲")) {
			for(RoomVO rvo: list) {
				if(rvo.roomType.equals(rType) && rvo.roomStatue.equals("已入住") && rvo.roomId.equals(rNumber)) {
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
				if(rvo.roomType.equals(rType) && !rvo.roomStatue.equals("已入住") && rvo.roomId.equals(rNumber)) {
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
	
}
