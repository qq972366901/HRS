package orderOverview;
import java.util.ArrayList;
import java.util.List;

import VO.*;
import orderBLService.OrderBLService;
public class OrderOverview_Driver {
	 public void drive(OrderBLService orderBLService){
		   List<OrderVO> result1=orderBLService.getAllOrders("1"); 
		   List<OrderVO> result2=orderBLService.getAbnormalOrders("1");
		    
		    List<OrderVO> result3=orderBLService.getUnfinishedOrders("1");
		    List<OrderVO> result4=orderBLService.getFinishedOrders("1");
	    	if(result1==new ArrayList<OrderVO>()) System.out.println("show success");
	    	if(result3 ==new ArrayList<OrderVO>()) System.out.println("gethistory success");
	    	if(result4 ==new ArrayList<OrderVO>()) System.out.println("findByType1 success");
	    	if(result2 ==new ArrayList<OrderVO>()) System.out.println("findByType2 success");
	 }
}
