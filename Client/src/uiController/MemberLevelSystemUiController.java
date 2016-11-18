package uiController;

import VO.PromotionVO;
import WebPromotionView.MemberLevelSystemView;
import WebPromotionView.WebPromotionUserView;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionBLService_realize;
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
		this.proService=new PromotionBLService_realize();
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
	public void updateMemberLevelSystem(PromotionVO vo) {
		// TODO Auto-generated method stub
		proService.updateMemberLevelSystem(vo);
	}
	@Override
	public void addMemberLevelSystem(PromotionVO vo) {
		// TODO Auto-generated method stub
		proService.addMemberLevelSystem(vo);
	}
	@Override
	public PromotionVO getMemberLevelSystem() {
		// TODO Auto-generated method stub
		return proService.getMemberLevelSystem();
	}

}
