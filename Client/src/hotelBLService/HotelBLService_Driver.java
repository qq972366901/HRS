package hotelBLService;

import java.util.ArrayList;

import Object.Hotel;
import VO.*;
import common.*;

public class HotelBLService_Driver {

    public void drive(HotelBLService hotelBLService){
    	ResultMessage result1=hotelBLService.messagelook(new HotelVO());
    	if(result1 ==ResultMessage.Exist) System.out.println("look success");
    	ArrayList<HotelVO> result2=hotelBLService.messagesearch(null);
    	if(result2 ==new ArrayList<HotelVO>()) System.out.println("search success");
    	ArrayList<HotelVO> result3=hotelBLService.historylook("121");
    	if(result3 ==new ArrayList<HotelVO>()) System.out.println("historylook success");
    	ResultMessage result4=hotelBLService.messagemaintain(null);
    	if(result4 ==ResultMessage.Exist) System.out.println("messagemaintain success");
    	ResultMessage result5=hotelBLService.accuntadmin(null);
    	if(result5 ==ResultMessage.Exist) System.out.println("accuntadmin success");
    	boolean result6=hotelBLService.setscore(4);
    	if(result6) System.out.println("setscore success");
    	boolean result7=hotelBLService.setcomment("123");
    	if(result7) System.out.println("setcomment success");
    	boolean result8=hotelBLService.getroominfo(new HotelVO());
    	if(result8) System.out.println("getroominfo success");
    	HotelVO result9=hotelBLService.pricesort(new ArrayList<Hotel>());
    	if(result9==new HotelVO()) System.out.println("pricesort success");
    	HotelVO result10=hotelBLService.starsort(new ArrayList<Hotel>());
    	if(result10==new HotelVO()) System.out.println("starsort success");
    	HotelVO result11=hotelBLService.scoresort(new ArrayList<Hotel>());
    	if(result11==new HotelVO()) System.out.println("scoresort success");
    	OrderVO result12=hotelBLService.gethistoryorder(new HotelVO());
    	if(result12==new OrderVO()) System.out.println("gethistoryorder success");
    	ArrayList<HotelVO> result13=hotelBLService.gethistoryhotel();
    	if(result13==new ArrayList<HotelVO>()) System.out.println("gethistoryhotel success");
    }
}
