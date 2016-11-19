package orderBuild;
import java.util.ArrayList;

import Object.Order;
import VO.*;
import common.*;
import orderBLService.OrderBLService;
public class OrderBuild_Driver {
	 public void drive(OrderBLService orderBLService){
		 System.out.println("make success");
	 boolean result1=orderBLService.whetherMake("13");
	    if(result1) System.out.println("whetherMake success");
	 long result2=orderBLService.getPrice(new OrderVO(),"121");
    	if(result2==10000) System.out.println("getPrice success");
     ResultMessage result3=orderBLService.payment(new OrderVO());
    	if(result3==ResultMessage.Exist) System.out.println("payment success");
	 }
}


