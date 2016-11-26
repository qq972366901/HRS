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
	private DataService dataService;
	@Override
	public DataService getDataService(String type) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
=======
		DataService dataService;
		OrderDataService order;
>>>>>>> 64ce4aa6f6a13a8dc5dce09c5d801c08a1f94fd1
		if(type.equals("User")){
			if(dataService==null){
				dataService=new UserDataServiceMySqlImpl_Stub();
			}
			System.out.println("UserData!");
		}
		else if(type.equals("CreditRecord")){
			if(dataService==null){
				dataService=new CreditRecordDataServiceMySqlImpl_Stub();
			}
			System.out.println("CreditRecordData!");
		}
		else if(type.equals("Hotel")){
			if(dataService==null){
				dataService=new HotelDataServiceMySqlImpl_Stub();
			}
			System.out.println("HotelData!");
		}
		else if(type.equals("Promotion")){
			if(dataService==null){
				dataService=new PromotionDataServiceMySqlImpl_Stub();
			}
			System.out.println("PromotionData!");
		}
		else if(type.equals("Room")){
			if(dataService==null){
				dataService=new RoomDataServiceMySqlImpl_Stub();
			}
			System.out.println("RoomData!");
		}
		else if(type.equals("Order")){
<<<<<<< HEAD
			if(dataService==null){
				dataService=new OrderDataServiceMySqlImpl_Stub();
			}
			System.out.println("OrderData!");
=======
			dataService=new OrderDataServiceMySqlImpl_Stub();
			System.out.println("OrderData1111111111!");
>>>>>>> 64ce4aa6f6a13a8dc5dce09c5d801c08a1f94fd1
		}
		else{
			dataService=null;
			System.out.println("Failure!");
		}
		return dataService;
	}
}
