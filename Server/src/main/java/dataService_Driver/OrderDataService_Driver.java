package dataService_Driver;

import java.rmi.RemoteException;

import PO.OrderPO;
import dataService.OrderDataService;

public class OrderDataService_Driver {
	public void drive(OrderDataService orderDataService) throws RemoteException{
		OrderPO po=orderDataService.find("f34444442t");
		orderDataService.update(po);
		orderDataService.insert(po);
		orderDataService.delete(po);
		orderDataService.init();
		orderDataService.finish();
		orderDataService.findByType("已执行");
	}
}
