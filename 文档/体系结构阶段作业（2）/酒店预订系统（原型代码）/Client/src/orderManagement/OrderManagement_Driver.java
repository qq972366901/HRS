package orderManagement;
import java.util.ArrayList;

import Object.Order;
import VO.*;
import common.*;
import orderBLService.OrderBLService;
public class OrderManagement_Driver {
	 public void drive(OrderBLService orderBLService){
		 ArrayList<OrderVO> result=orderBLService.findByType("121");
	    	if(result ==new ArrayList<OrderVO>()) System.out.println("findByType2 success");
	    	System.out.println("update success");
	 }
}
