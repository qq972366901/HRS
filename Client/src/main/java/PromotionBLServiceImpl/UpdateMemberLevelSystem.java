package PromotionBLServiceImpl;

import java.rmi.RemoteException;

import PO.PromotionPO;
import VO.MemberLevelSystemVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;
/**
 * 更新会员等级制度的实现类
 * @author Administrator
 *
 */
public class UpdateMemberLevelSystem {
	private DataFactoryService df;
	private PromotionDataService pds;
	private MemberLevelSystemVO vo;
	
	private static UpdateMemberLevelSystem updateMemberLevelSystem;
	
	private UpdateMemberLevelSystem() throws RemoteException {
		df=RemoteHelper.getInstance().getDataFactoryService();
		pds=(PromotionDataService) df.getDataService("Promotion");
		PromotionPO po;
		try {
			po = pds.getMemberLevelSystem();
			vo = new MemberLevelSystemVO(po);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static UpdateMemberLevelSystem getUpdateMemberLevelSystemInstance() {
		if(updateMemberLevelSystem == null) {
			try {
				updateMemberLevelSystem = new UpdateMemberLevelSystem();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return updateMemberLevelSystem;
	}
	
	
	public void updateMemberLevelSystem(long credit[],double discount[]){
		vo.creditOfLevel=credit;
		vo.discountOfLevel=discount;
		PromotionPO po = new PromotionPO(vo.creditOfLevel,vo.discountOfLevel);
		
		try {
			pds.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
