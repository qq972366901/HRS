package dataService_Driver;

import java.rmi.RemoteException;

import PO.RoomPO;
import dataService.RoomDataService;

public class RoomDataService_Driver {
	public void drive(RoomDataService roomDataService) throws RemoteException{
		RoomPO po=roomDataService.find("f3ff34");
		roomDataService.update(po);
		roomDataService.insert(po);
		roomDataService.delete(po);
	}
}
