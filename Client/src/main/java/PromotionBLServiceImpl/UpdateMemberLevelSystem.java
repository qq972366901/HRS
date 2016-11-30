package PromotionBLServiceImpl;

import java.rmi.RemoteException;

import PO.PromotionPO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class UpdateMemberLevelSystem {
	private DataFactoryService df;
	private PromotionDataService pds;
	
	private static UpdateMemberLevelSystem updateMemberLevelSystem;
	
	private UpdateMemberLevelSystem() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static UpdateMemberLevelSystem getUpdateMemberLevelSystemInstance() {
		if(updateMemberLevelSystem == null) {
			updateMemberLevelSystem = new UpdateMemberLevelSystem();
		}
		return updateMemberLevelSystem;
	}
	
	
	public void updateMemberLevelSystem(long credit[],double discount[]){
		PromotionPO po = new PromotionPO(credit,discount);
		
		try {
			pds.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
