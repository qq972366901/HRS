package datafactory;

import java.io.Serializable;

import creditrecordData.CreditRecordDataServiceMySqlImpl_Stub;
import dataService.DataService;
import hotelData.HotelDataServiceMySqlImpl_Stub;
import orderData.OrderDataServiceMySqlImpl_Stub;
import promotionData.PromotionDataServiceMySqlImpl_Stub;
import roomData.RoomDataServiceMySqlImpl_Stub;
import userData.UserDataServiceMySqlImpl_Stub;

public class DataFactoryMySqlImpl_Stub implements dataService.DataFactoryService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public DataService getUserData() {
		// TODO Auto-generated method stub
		DataService userData=new UserDataServiceMySqlImpl_Stub();
		System.out.println("UserData!");
		return userData;
	}

	@Override
	public DataService getCreditRecordData() {
		// TODO Auto-generated method stub
		DataService creditRecordData=new CreditRecordDataServiceMySqlImpl_Stub();
		System.out.println("CreditRecordData!");
		return creditRecordData;
	}

	@Override
	public DataService getPromotionData() {
		// TODO Auto-generated method stub
		DataService promotionData=new PromotionDataServiceMySqlImpl_Stub();
		System.out.println("PromotionData!");
		return promotionData;
	}

	@Override
	public DataService getOrderData() {
		// TODO Auto-generated method stub
		DataService orderData=new OrderDataServiceMySqlImpl_Stub();
		System.out.println("OrderData!");
		return orderData;
	}

	@Override
	public DataService getHotelData() {
		// TODO Auto-generated method stub
		DataService hotelData=new HotelDataServiceMySqlImpl_Stub();
		System.out.println("HotelData!");
		return hotelData;
	}

	@Override
	public DataService getRoomData() {
		// TODO Auto-generated method stub
		DataService roomData=new RoomDataServiceMySqlImpl_Stub();
		System.out.println("RoomData!");
		return roomData;
	}

}
