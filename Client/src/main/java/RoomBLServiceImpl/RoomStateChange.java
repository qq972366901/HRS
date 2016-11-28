package RoomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

public class RoomStateChange {

	private String hotelID;
	private List<RoomVO> list;
	
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
		return roomStateChange;
	}
	
	public void updateRoomState(String rNumber, String rType, String rState) {
		if(rState == "空闲") {
			for(RoomVO rvo: list) {
				if(rvo.roomType == rType && rvo.roomStatue == "已入住" && rvo.roomId == rNumber) {
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
		
		if(rState == "已入住") {
			boolean containRoomNum = false;
			RoomVO temp = null;
			for(RoomVO rvo: list) {
				if(rvo.roomType == rType && rvo.roomStatue != "已入住" && rvo.roomId == rNumber) {
					containRoomNum = true;
					temp = rvo;
					break;
				}
			}
			if(containRoomNum) {
				temp.roomId = rNumber;
				temp.roomStatue = "已入住";
				RoomPO rpo = new RoomPO(temp.hotelID,temp.roomId,"已入住",temp.roomType,temp.roomPrice);
				try {
					rds.update(rpo);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			} else {
				for(RoomVO rvo: list) {
					if(rvo.roomType == rType && rvo.roomStatue != "已入住" ) {
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
	
}
