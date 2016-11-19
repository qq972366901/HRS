package Service.Impl;

import java.util.ArrayList;
import java.util.List;

import Object.Hotel;
import Object.RoomType;
import Object.Time;
import VO.HotelVO;
import VO.OrderVO;
import VO.UserVO;
import common.Choice;
import common.ResultMessage;
import orderBLService.OrderBLService;

public class OrderBLServiceImpl implements OrderBLService {
    public OrderBLServiceImpl(String id){
    	
    }
	@Override
	public ArrayList<OrderVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getRoomInfo(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Hotel> gethistory(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> findByType(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO showDetail(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelOrder(String orderID, Time currentTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void duduct(OrderVO order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean whetherDeduct(Time currentTime, String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeOrder(Time currentTime, Time in, Time out, Time ddl, RoomType roomType, int num, int numOfPerson,
			boolean haveChild) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean whetherMake(String uerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void done(String orderID, String userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void abnormalOrder(String orderID, String userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delayIn(String orderID, String userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void comment(String comment, OrderVO order) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderVO findByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regain(OrderVO vo, Choice choice) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getPrice(OrderVO vo, String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage payment(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrderVO> show(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderVO> getUnfinishedOrders(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderVO> getFinishedOrders(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderVO> getAbnormalOrders(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
