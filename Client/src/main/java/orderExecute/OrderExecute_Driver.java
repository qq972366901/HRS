package orderExecute;
import java.util.ArrayList;

import Object.Order;
import VO.*;
import common.*;
import orderBLService.OrderBLService;
public class OrderExecute_Driver {
	 public void drive(OrderBLService orderBLService){
		 System.out.println("cancel success");
		 System.out.println("duduct success");
		 boolean result=orderBLService.whetherDeduct(null,"13");
	    	if(result) System.out.println("whetherDeduct success");
	    	System.out.println("update success");
	    	System.out.println("update success");
	    	System.out.println("update success");
	 }
}
