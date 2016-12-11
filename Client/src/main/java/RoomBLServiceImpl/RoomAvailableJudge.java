package RoomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

public class RoomAvailableJudge {

	private String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomAvailableJudge roomAvailableJudge;
	
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
	
	public static RoomAvailableJudge getRoomAvailableJudgeInstance(String id) {
		if(roomAvailableJudge == null) {
			roomAvailableJudge = new RoomAvailableJudge(id);
		}
		return roomAvailableJudge;
	}
	
	public boolean whetherSuccess(String type,int number) {
		boolean success = false;
		for(RoomVO rvo : list) {
			if(rvo.roomType == type && rvo.roomStatue == "空闲") {
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
