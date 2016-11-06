package orderOverview;
import java.util.ArrayList;

import Object.Hotel;
import Object.Order;
import VO.*;
import common.*;
import orderBLService.OrderBLService;
public class OrderOverview_Driver {
	 public void drive(OrderBLService orderBLService){
		 ArrayList<OrderVO> result1=orderBLService.show();
	    	if(result1==new ArrayList<OrderVO>()) System.out.println("show success");
	    	ResultMessage result2=orderBLService.getRoomInfo(new OrderVO());
	    	if(result2 ==ResultMessage.Exist) System.out.println("getRoomInfo success");
	    	ArrayList<Hotel> result3=orderBLService.gethistory(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"∆’Õ®ª·‘±",1,"1981/2/2",""));
	    	if(result3 ==new ArrayList<Hotel>()) System.out.println("gethistory success");
	    	ArrayList<OrderVO> result4=orderBLService.findByType(new HotelVO());
	    	if(result4 ==new ArrayList<OrderVO>()) System.out.println("findByType1 success");
	    	ArrayList<OrderVO> result5=orderBLService.findByType("121");
	    	if(result5 ==new ArrayList<OrderVO>()) System.out.println("findByType2 success");
	    	OrderVO result6=orderBLService.showDetail("121");
	    	if(result6 ==new OrderVO()) System.out.println("showDetail success");
	    	OrderVO result7=orderBLService.findByID("121");
	    	if(result7 ==new OrderVO()) System.out.println("findByID success");
	    	long result8=orderBLService.getPrice(new OrderVO(),"121");
	    	if(result8==10000) System.out.println("getPrice success");
	    	ResultMessage result9=orderBLService.payment(new OrderVO());
	    	if(result9==ResultMessage.Exist) System.out.println("payment success");
	 }
}
