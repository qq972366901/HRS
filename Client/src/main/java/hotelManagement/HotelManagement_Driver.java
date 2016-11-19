package hotelManagement;

import common.*;
import hotelBLService.HotelBLService;

public class HotelManagement_Driver {
	 public void drive(HotelBLService hotelBLService){
		 ResultMessage result=hotelBLService.messagemaintain(null);
	    	if(result ==ResultMessage.Exist) System.out.println("messagemaintain success");
	 }
}
