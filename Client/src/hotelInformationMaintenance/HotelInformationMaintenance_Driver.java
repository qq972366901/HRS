package hotelInformationMaintenance;
import java.util.ArrayList;

import Object.Hotel;
import VO.*;
import common.*;
import hotelBLService.HotelBLService;

public class HotelInformationMaintenance_Driver {
	public void drive(HotelBLService hotelBLService){
		ResultMessage result1=hotelBLService.messagemaintain(null);
    	if(result1 ==ResultMessage.Exist) System.out.println("messagemaintain success");
    	ResultMessage result2=hotelBLService.accuntadmin(null);
    	if(result2 ==ResultMessage.Exist) System.out.println("accuntadmin success");
	}
}
