package hotelEverordered;
import java.util.ArrayList;

import VO.*;
import hotelBLService.HotelBLService;

public class HotelEverordered_Driver {
	public void drive(HotelBLService hotelBLService){
		ArrayList<HotelVO> result1=hotelBLService.historylook("121");
    	if(result1 ==new ArrayList<HotelVO>()) System.out.println("historylook success");
    	ArrayList<HotelVO> result2=hotelBLService.gethistoryhotel();
    	if(result2==new ArrayList<HotelVO>()) System.out.println("gethistoryhotel success");
	}
}
