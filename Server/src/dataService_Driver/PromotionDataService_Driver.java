package dataService_Driver;

import java.rmi.RemoteException;

import PO.PromotionPO;
import dataService.PromotionDataService;

public class PromotionDataService_Driver {
	public void drive(PromotionDataService promotionDataService) throws RemoteException{
		PromotionPO po=promotionDataService.find("dewaf");
		promotionDataService.update(po);
		promotionDataService.insert(po);
		promotionDataService.delete(po);
		promotionDataService.init();
		promotionDataService.finish();
	}
}
