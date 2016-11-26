package orderBuild;
import java.util.Calendar;

import VO.*;
import orderBLService.OrderBLService;
public class OrderBuild_Driver {
	 public void drive(OrderBLService orderBLService){
		 boolean flag=orderBLService.whetherMake(Calendar.getInstance(), Calendar.getInstance(), 5, "1", "110");
		 if(flag==true)System.out.println("make success");
	     orderBLService.saveOrderInfo(new OrderVO());
	 }
}


