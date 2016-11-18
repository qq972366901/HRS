package uiController;

import java.util.ArrayList;
import java.util.List;

import VO.PromotionVO;
import WebPromotionView.WebPromotionStrategyView;
import WebPromotionView.WebPromotionUserView;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionBLService_realize;
import runner.ClientRunner;
import uiService.WebPromotionStrategyUiService;
import uiService.webPromotionUserUiService;

public class WebPromotionStrategyUiController implements WebPromotionStrategyUiService{
	private WebPromotionStrategyView view;
	private PromotionBLService proService;
	public WebPromotionStrategyUiController(){
		proService=new PromotionBLService_realize();
	}
	@Override
	public void setView(WebPromotionStrategyView view) {
		// TODO Auto-generated method stub
		this.view=view;
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
	public List<PromotionVO> getAllWebPromotion() {
		// TODO Auto-generated method stub
		return proService.getAllWebPromotion();
	}

	@Override
	public void addButtonClicked() {
		// TODO Auto-generated method stub
		view.addButtonClicked();
	}

	@Override
	public void delButtonClicked() {
		// TODO Auto-generated method stub
		view.delButtonClicked();
	}

	@Override
	public boolean deleteStrategy(int strategyNo) {
		// TODO Auto-generated method stub
		return proService.deleteStrategy(strategyNo);
	}
	@Override
	public void addWebPromotion(PromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

}
