package orderAbnormal;
import common.*;
import orderBLService.OrderBLService;
public class OrderAbnormal_Driver {
	 public void drive(OrderBLService orderBLService){
		    orderBLService.cancelAbnormalOrder("000");
	        orderBLService.updateCredit("000", 100, Operate.Abnormal);
	 }
}
