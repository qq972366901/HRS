package dataService_Driver;

import java.rmi.RemoteException;

import PO.CreditRecordPO;
import dataService.CreditRecordDataService;

public class CreditRecordDataService_Driver {
	public void drive(CreditRecordDataService creditRecordDataService) throws RemoteException{
		CreditRecordPO po = creditRecordDataService.find("3425425");
		creditRecordDataService.insert(po);
		creditRecordDataService.update(po);
		creditRecordDataService.delete(po);
		creditRecordDataService.init();
		creditRecordDataService.finish();
	}
}
