package orderAbnormal;
import java.util.ArrayList;

import Object.Order;
import VO.*;
import common.*;
import orderBLService.OrderBLService;
public class OrderAbnormal_Driver {
	 public void drive(OrderBLService orderBLService){
		 ArrayList<OrderVO> result1=orderBLService.findByType("121");
	    	if(result1 ==new ArrayList<OrderVO>()) System.out.println("findByType2 success");
	    ResultMessage result2=orderBLService.getRoomInfo(new OrderVO());
	    	if(result2 ==ResultMessage.Exist) System.out.println("getRoomInfo success");
	    System.out.println("cancel success");
	    OrderVO result3=orderBLService.showDetail("121");
	    	if(result3 ==new OrderVO()) System.out.println("showDetail success");
	    	System.out.println("update success");
	    	System.out.println("update success");
	    	System.out.println("update success");
	    	System.out.println("update success");
	    	System.out.println("update success");
	 }
}
