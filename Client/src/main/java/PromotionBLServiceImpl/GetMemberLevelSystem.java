package PromotionBLServiceImpl;

import java.rmi.RemoteException;

import PO.PromotionPO;
import VO.MemberLevelSystemVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class GetMemberLevelSystem {
	private DataFactoryService df;
	private PromotionDataService pds;
	private MemberLevelSystemVO vo;
	private static GetMemberLevelSystem getMemberLevelSystem;
	
	private GetMemberLevelSystem() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
			PromotionPO po = pds.getMemberLevelSystem();
			vo = new MemberLevelSystemVO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
    public static GetMemberLevelSystem getMemberLevelSystemInstance() {
	  if(getMemberLevelSystem== null) {
		  getMemberLevelSystem= new GetMemberLevelSystem();
	}
	     return getMemberLevelSystem;
    }
    public MemberLevelSystemVO getMemberLevelSystem(){
    	MemberLevelSystemVO tempvo=vo;
		return tempvo;
    	
    }
}
