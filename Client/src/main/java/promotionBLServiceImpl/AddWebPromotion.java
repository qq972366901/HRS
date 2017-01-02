package promotionBLServiceImpl;

import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.PromotionDataService;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.WebPromotionVO;
/**
 * 添加网站策略实现类
 * @author Administrator
 *
 */
public class AddWebPromotion {

	private DataFactoryService df;
	private PromotionDataService pds;
	
	private static AddWebPromotion addWebPromotion;
	
	private AddWebPromotion() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static AddWebPromotion getAddWebPromotionInstance() {
		if(addWebPromotion == null) {
			addWebPromotion = new AddWebPromotion();
		}
		return addWebPromotion;
	}
	
	
	public void addWebPromotion(WebPromotionVO vo) throws RemoteException{
		PromotionPO po = new PromotionPO(vo.promotionNumber,vo.promotionName,vo.promotionBegintime,vo.promotionEndtime,vo.applyCity,vo.applyBussinesscircle,vo.applyMemberGrade,vo.discount);
		
		try {
			pds.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
