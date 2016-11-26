package orderBLService;
import VO.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class OrderBLService_Driver {
	public void drive(OrderBLService orderBLService){
		 boolean flag=orderBLService.whetherMake(Calendar.getInstance(), Calendar.getInstance(), 5, "1", "110");
		 if(flag==true)System.out.println("make success");
		 System.out.println("update success");
		 System.out.println("duduct success");
		 System.out.println("delay success");
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
	    	List<OrderVO> result11=orderBLService.getAllOrders("1"); 
			   List<OrderVO> result12=orderBLService.getAbnormalOrders("1");
			    
			    List<OrderVO> result13=orderBLService.getUnfinishedOrders("1");
			    List<OrderVO> result14=orderBLService.getFinishedOrders("1");
		    	if(result11==new ArrayList<OrderVO>()) System.out.println("show success");
		    	if(result13 ==new ArrayList<OrderVO>()) System.out.println("gethistory success");
		    	if(result14 ==new ArrayList<OrderVO>()) System.out.println("findByType1 success");
		    	if(result12 ==new ArrayList<OrderVO>()) System.out.println("findByType2 success");
    }
}
