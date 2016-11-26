package orderManagement;
import java.util.ArrayList;
import java.util.List;

import VO.*;
import orderBLService.OrderBLService;
public class OrderManagement_Driver {
	 public void drive(OrderBLService orderBLService){
		    String a="1";
		    List<OrderVO> result1=orderBLService.showAllorder("1");
		    List<OrderVO> result2=orderBLService.showAbnormalorder(a);		    
		    List<OrderVO> result3=orderBLService.showCancelorder(a);
		    List<OrderVO> result4=orderBLService.showDoneorder(a);
		    List<OrderVO> result5=orderBLService.showUndoneorder(a);
	    	if(result1==new ArrayList<OrderVO>()) System.out.println("show1 success");
	    	if(result3 ==new ArrayList<OrderVO>()) System.out.println("show2 success");
	    	if(result4 ==new ArrayList<OrderVO>()) System.out.println("show3 success");
	    	if(result2 ==new ArrayList<OrderVO>()) System.out.println("show4 success");
	    	if(result5 ==new ArrayList<OrderVO>()) System.out.println("show5 success");
	    	OrderVO result6=orderBLService.showDetail(a, a);
	    	if(result6==new OrderVO()) System.out.println("show6 success");
	 }
}
