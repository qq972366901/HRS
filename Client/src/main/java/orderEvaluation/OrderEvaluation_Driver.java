package orderEvaluation;
import java.util.ArrayList;

import Object.Order;
import VO.*;
import common.*;
import orderBLService.OrderBLService;
public class OrderEvaluation_Driver {
	 public void drive(OrderBLService orderBLService){
		 System.out.println("update success");
		 OrderVO result=orderBLService.findByID("121");
	    	if(result ==new OrderVO()) System.out.println("findByID success");
	 }
}
