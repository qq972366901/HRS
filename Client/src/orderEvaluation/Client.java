package orderEvaluation;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderEvaluationController=new OrderEvaluationController(1);
		OrderEvaluation_Driver driver=new OrderEvaluation_Driver();
		driver.drive(orderEvaluationController);
	}
}
