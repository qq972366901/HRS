package hotelInformationSearch;
import java.util.ArrayList;

import Object.Hotel;
import VO.*;
import common.*;
import hotelBLService.HotelBLService;

public class HotelInformationSearch_Driver {
	 public void drive(HotelBLService hotelBLService){
		 ResultMessage result1=hotelBLService.messagelook(new HotelVO());
	    	if(result1 ==ResultMessage.Exist) System.out.println("look success");
	    	ArrayList<HotelVO> result2=hotelBLService.messagesearch(null);
	    	if(result2 ==new ArrayList<HotelVO>()) System.out.println("search success");
	 }
}
