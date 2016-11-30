package uiController;


import java.rmi.RemoteException;

import VO.MemberLevelSystemVO;
import WebPromotionView.MemberLevelSystemView;
import WebPromotionView.WebPromotionUserView;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import runner.ClientRunner;
import uiService.MemberLevelSystemUiService;
import uiService.webPromotionUserUiService;

public class MemberLevelSystemUiController implements MemberLevelSystemUiService{
	private MemberLevelSystemView view;
	private PromotionBLService proService;
	@Override
	public void setView(MemberLevelSystemView view) {
		// TODO Auto-generated method stub
		this.view=view;
		try {
			this.proService=new PromotionController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.showMemberLevelSystem(proService.getMemberLevelSystem());
	}
	@Override
	public void toWebPromotionUserView() {
		// TODO Auto-generated method stub
		webPromotionUserUiService controller=new webPromotionUserUiController();
		WebPromotionUserView view=new WebPromotionUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	@Override
	public void updateMemberLevelSystem(MemberLevelSystemVO vo) {
		// TODO Auto-generated method stub
		proService.updateMemberLevelSystem(vo.creditOfLevel,vo.discountOfLevel);
	}
	@Override
	public void addMemberLevelSystem(MemberLevelSystemVO vo) {
		// TODO Auto-generated method stub
		proService.addMemberLevelSystem(vo.creditOfLevel,vo.discountOfLevel);
	}
	@Override
	public MemberLevelSystemVO getMemberLevelSystem() {
		// TODO Auto-generated method stub
		return proService.getMemberLevelSystem();
	}


}
