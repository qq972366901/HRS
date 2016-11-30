package PromotionBLServiceImpl;

import java.rmi.RemoteException;

import PO.PromotionPO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class AddMemberLevelSystem {
	private DataFactoryService df;
	private PromotionDataService pds;
	
	private static AddMemberLevelSystem addMemberLevelSystem;
	
	private AddMemberLevelSystem() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static AddMemberLevelSystem getAddMemberLevelSystemInstance() {
		if(addMemberLevelSystem == null) {
			addMemberLevelSystem = new AddMemberLevelSystem();
		}
		return addMemberLevelSystem;
	}
	
	
	public void addMemberLevelSystem(long credit[],double discount[]){
		PromotionPO po = new PromotionPO(credit,discount);
		
		try {
			pds.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
