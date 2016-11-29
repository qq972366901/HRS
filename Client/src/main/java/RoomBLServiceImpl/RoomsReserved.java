package RoomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

public class RoomsReserved {

	private String hotelID;
	private List<RoomVO> list;
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomsReserved roomsReserved;
	
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
	
	public static RoomsReserved getRoomsReservedInstance(String id) {
		if(roomsReserved == null) {
			roomsReserved = new RoomsReserved(id);
		}
		return roomsReserved;
	}
	
	public void updateRoomsState(String type,int number) {
		for(RoomVO rvo : list) {
			if(rvo.roomType == type && rvo.roomStatue == "空闲") {
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
