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
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
/**
 * 制定会员等级系统控制器
 * @author LZ
 *
 */
public class MemberLevelSystemUiController implements MemberLevelSystemUiService{
	private MemberLevelSystemView view;
	private PromotionBLService proService;
	private UserBLService userService;
	@Override
	public void setView(MemberLevelSystemView view) {
		this.view=view;
		try {
			this.proService=new PromotionController();
			this.userService=new UserBLServiceController();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		view.showMemberLevelSystem(proService.getMemberLevelSystem());
	}
	@Override
	public void toWebPromotionUserView() {
		webPromotionUserUiService controller=new webPromotionUserUiController();
		WebPromotionUserView view=new WebPromotionUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	@Override
	public void updateMemberLevelSystem(MemberLevelSystemVO vo) {
		proService.updateMemberLevelSystem(vo.creditOfLevel,vo.discountOfLevel);
	}
	@Override
	public void addMemberLevelSystem(MemberLevelSystemVO vo) {
		proService.addMemberLevelSystem(vo.creditOfLevel,vo.discountOfLevel);
	}
	@Override
	public MemberLevelSystemVO getMemberLevelSystem() {
		return proService.getMemberLevelSystem();
	}
	/**
	 * 由于会员等级系统的更新，需要更新所有客户的会员等级
	 */
	@Override
	public boolean updateAllLevel() {
		return userService.updateAllLevel();
	}


}
