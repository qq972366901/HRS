package hotelInformationOverview;
import java.util.ArrayList;

import Object.Hotel;
import VO.*;
import hotelBLService.HotelBLService;

public class HotelInformationOverview_Driver {
	public void drive(HotelBLService hotelBLService){
		boolean result1=hotelBLService.getroominfo(new HotelVO());
    	if(result1) System.out.println("getroominfo success");
    	HotelVO result2=hotelBLService.pricesort(new ArrayList<Hotel>());
    	if(result2==new HotelVO()) System.out.println("pricesort success");
    	HotelVO result3=hotelBLService.starsort(new ArrayList<Hotel>());
    	if(result3==new HotelVO()) System.out.println("starsort success");
    	HotelVO result4=hotelBLService.scoresort(new ArrayList<Hotel>());
    	if(result4==new HotelVO()) System.out.println("scoresort success");
    	OrderVO result5=hotelBLService.gethistoryorder(new HotelVO());
    	if(result5==new OrderVO()) System.out.println("gethistoryorder success");
	}
}
