package dataService_Driver;

import java.rmi.RemoteException;

import PO.UserPO;
import dataService.UserDataService;

public class UserDataService_Driver {
	public void drive(UserDataService userDataService) throws RemoteException{
		UserPO po=userDataService.find("r342255");
		userDataService.update(po);
		userDataService.insert(po);
		userDataService.delete(po);
		userDataService.init();
		userDataService.finish();
	}
}
