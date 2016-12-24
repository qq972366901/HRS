package HotelBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.RoomPO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.RoomDataService;
import rmi.RemoteHelper;

/**负责实现添加房间和得到酒店房间信息的功能
 * @author 刘宗侃
 */
public class HotelRoom {
	
	private static String hotelID;
	private List<RoomVO> list = new ArrayList<RoomVO>();
	
	private DataFactoryService df;
	private RoomDataService rds;
	
	private static HotelRoom hotelRoom;
	/**
	 * HotelRoom类的构造方法
	 */
	private HotelRoom(String id) {
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
	 * 得到HotelRoom对象
	 */
	public static HotelRoom getHotelRoomInstance(String id) {
		if(hotelRoom == null) {
			hotelRoom = new HotelRoom(id);
		}
		if(hotelID != id) {
			hotelRoom = new HotelRoom(id);
		}
		return hotelRoom;
	}
	/**
     * 更新酒店拥有的房间类型、数量、原始价格
     * 
     * @param roomType String型，房间类型
     * @param roomNumber int型，房间数量
     * @param roomPrice int型，房间原始价格
     * @param roomNNN String型，房间号
     */
	public void updateHotelRooms(String roomType, int roomNumber, int roomPrice,String roomNNN) {
		int endIndex = roomNNN.indexOf("-");
		String rNNN = roomNNN.substring(0, endIndex).trim();
		int num = Integer.parseInt(rNNN);
		for(int i=0;i<roomNumber;i++) {
			String NNN = "" + num;
			num = num + 1;
			RoomVO rvo = new RoomVO(hotelID,NNN,"空闲",roomType,roomPrice);
			list.add(rvo);
			RoomPO rpo = new RoomPO(hotelID,NNN,"空闲",roomType,roomPrice);
			try {
				rds.insert(rpo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	/**
     * 得到酒店的空闲房间的房型列表
     * 
     * @return String型，房型列表
     */
	public List<String> getRoomType() {
		List<String> type = new ArrayList<String>();
		for(RoomVO vo : list) {
			if(vo.roomStatue.equals("空闲")) {
				if(!type.contains(vo.roomType)) {
					type.add(vo.roomType);
				}
			}
		}
		return type;
	}
	/**
     * 得到酒店空闲的此房型的剩余数量
     * 
     * @param rType String型，房间类型
     * @return  int型，订单总的原价
     */
	public int getMaxRoomNumber(String rType) {
		int num = 0;
		for(RoomVO vo : list) {
			if(vo.roomStatue.equals("空闲") && vo.roomType.equals(rType)) {
				num++;
			}
		}
		return num;
	}
	/**
     * 得到客户酒店房间订单的总原价
     * 
     * @param rType String型，房间类型
     * @param roomNumber int型，预定房间数量
     * @return  int型，订单总的原价
     */
	public int getOrderPrice(String rType, int roomNumber) {
		int onePrice = 0;
		for(RoomVO vo : list) {
			if(vo.roomType.equals(rType)) {
				onePrice = vo.roomPrice;
			}
		}
		int allPrice = onePrice * roomNumber;
		return allPrice;
	}
	
}
