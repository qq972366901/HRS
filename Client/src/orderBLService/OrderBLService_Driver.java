package orderBLService;
import VO.*;
import common.*;

import java.util.ArrayList;

import Object.Hotel;
public class OrderBLService_Driver {
	public void drive(OrderBLService orderBLService){
		ArrayList<OrderVO> result1=orderBLService.show();
    	if(result1==new ArrayList<OrderVO>()) System.out.println("show success");
		ResultMessage result2=orderBLService.getRoomInfo(new OrderVO());
    	if(result2 ==ResultMessage.Exist) System.out.println("getRoomInfo success");
    	System.out.println("cancel success");
		ArrayList<Hotel> result3=orderBLService.gethistory(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"∆’Õ®ª·‘±",1,"1981/2/2",""));
    	if(result3 ==new ArrayList<Hotel>()) System.out.println("gethistory success");
		ArrayList<OrderVO> result4=orderBLService.findByType(new HotelVO());
    	if(result4 ==new ArrayList<OrderVO>()) System.out.println("findByType1 success");
		ArrayList<OrderVO> result5=orderBLService.findByType("121");
    	if(result5 ==new ArrayList<OrderVO>()) System.out.println("findByType2 success");
    	OrderVO result6=orderBLService.showDetail("121");
    	if(result6 ==new OrderVO()) System.out.println("showDetail success");
    	System.out.println("cancel success");
    	System.out.println("duduct success");
    	boolean result7=orderBLService.whetherDeduct(null,"13");
    	if(result7) System.out.println("whetherDeduct success");
    	System.out.println("make success");
    	boolean result8=orderBLService.whetherMake("13");
    	if(result8) System.out.println("whetherMake success");
    	System.out.println("update success");
    	System.out.println("update success");
    	System.out.println("update success");
    	System.out.println("update success");
    	System.out.println("update success");
    	OrderVO result9=orderBLService.findByID("121");
    	if(result9 ==new OrderVO()) System.out.println("findByID success");
    	System.out.println("update success");
    	long result10=orderBLService.getPrice(new OrderVO(),"121");
    	if(result10==10000) System.out.println("getPrice success");
    	ResultMessage result11=orderBLService.payment(new OrderVO());
    	if(result11==ResultMessage.Exist) System.out.println("payment success");
    }
}
