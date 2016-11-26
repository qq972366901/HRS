package orderEvaluation;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
public class OrderEvaluation_Driver {
	 public void drive(OrderBLService orderBLService){
		 orderBLService=new OrderBLServiceController();
		 orderBLService.updatecomment("very good", 100, "xxx", "001");
		 System.out.println(orderBLService.showDetail("001", "001").comment);
	 }
}
