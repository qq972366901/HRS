package uiController;

import java.util.ArrayList;
import java.util.List;

import VO.PromotionVO;
import WebPromotionView.WebPromotionStrategyView;
import WebPromotionView.WebPromotionUserView;
import runner.ClientRunner;
import uiService.WebPromotionStrategyUiService;
import uiService.webPromotionUserUiService;

public class WebPromotionStrategyUiController implements WebPromotionStrategyUiService{
	private WebPromotionStrategyView view;
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
		List<PromotionVO> list=new ArrayList<PromotionVO>();
		return list;
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
		return true;
	}

}
