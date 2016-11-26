package datafactory;

import java.io.Serializable;

import creditrecordData.CreditRecordDataServiceMySqlImpl_Stub;
import dataService.DataService;
import dataService.OrderDataService;
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
	public DataService getDataService(String type) {
		// TODO Auto-generated method stub
		DataService dataService;
		OrderDataService order;
		if(type.equals("User")){
			dataService=new UserDataServiceMySqlImpl_Stub();
			System.out.println("UserData!");
		}
		else if(type.equals("CreditRecord")){
			dataService=new CreditRecordDataServiceMySqlImpl_Stub();
			System.out.println("CreditRecordData!");
		}
		else if(type.equals("Hotel")){
			dataService=new HotelDataServiceMySqlImpl_Stub();
			System.out.println("HotelData!");
		}
		else if(type.equals("Promotion")){
			dataService=new PromotionDataServiceMySqlImpl_Stub();
			System.out.println("PromotionData!");
		}
		else if(type.equals("Room")){
			dataService=new RoomDataServiceMySqlImpl_Stub();
			System.out.println("RoomData!");
		}
		else if(type.equals("Order")){
			dataService=new OrderDataServiceMySqlImpl_Stub();
			System.out.println("OrderData1111111111!");
		}
		else{
			dataService=null;
		}
		return dataService;
	}
}
