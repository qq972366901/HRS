package promotionBLServiceImpl;

import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.PromotionDataService;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.MemberLevelSystemVO;
/**
 * 获取会员等级制度的实现类
 * @author Administrator
 *
 */
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
		 getMemberLevelSystem= new GetMemberLevelSystem();
	     return getMemberLevelSystem;
    }
    public MemberLevelSystemVO getMemberLevelSystem(){
    	MemberLevelSystemVO tempvo=vo;
		return tempvo;   	
    }
	public double getDiscountOfLevel(int grade){
		MemberLevelSystemVO vo=GetMemberLevelSystem.getMemberLevelSystemInstance().getMemberLevelSystem();
		double[] discount=vo.discountOfLevel;
		if(grade==0){
			return 10;
		}
		else if(grade==1){
			return discount[0];
		}
		else if(grade==2){
			return discount[1];
		}
		else if(grade==3){
			return discount[2];
		}
		else if(grade==4){
			return discount[3];
		}
		else{
			return discount[4];
		}
	}
}
