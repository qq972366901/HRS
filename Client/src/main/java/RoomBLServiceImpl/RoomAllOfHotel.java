package RoomBLServiceImpl;

import java.rmi.RemoteException;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

public class RoomAllOfHotel {

	private String hotelID;
	private List<RoomVO> list;
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static RoomAllOfHotel roomAllOfHotel;
	
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
	
	public static RoomAllOfHotel getRoomAllOfHotelInstance(String id) {
		if(roomAllOfHotel == null) {
			roomAllOfHotel = new RoomAllOfHotel(id);
		}
		return roomAllOfHotel;
	}
	
	public List<RoomVO> getAllRooms() {
		return this.list;
	}
	
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
	
}
