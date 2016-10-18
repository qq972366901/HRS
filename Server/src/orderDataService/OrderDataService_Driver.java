package orderDataService;

import java.rmi.RemoteException;

import PO.OrderPO;

public class OrderDataService_Driver {
	public void drive(OrderDataService orderDataService) throws RemoteException{
		OrderPO po=orderDataService.find("f34444442t");
		orderDataService.update(po);
		orderDataService.insert(po);
		orderDataService.delete(po);
		orderDataService.init();
		orderDataService.finish();
		orderDataService.findByType("ÒÑÖ´ÐÐ");
	}
}
