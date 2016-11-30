package uiController;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import VO.PromotionVO;
import WebPromotionView.WebPromotionStrategyView;
import WebPromotionView.WebPromotionUserView;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import runner.ClientRunner;
import uiService.WebPromotionStrategyUiService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class WebPromotionStrategyUiController implements WebPromotionStrategyUiService{
	private WebPromotionStrategyView view;
	private PromotionBLService proService;
	private UserBLService user;
	public WebPromotionStrategyUiController() throws RemoteException{
		this.proService=new PromotionController();
		this.user=new UserBLServiceController();
	}
	@Override
	public void setView(WebPromotionStrategyView view) {
		this.view=view;
	}

	@Override
	public void toWebPromotionUserView() {
		webPromotionUserUiService controller=new webPromotionUserUiController();
		WebPromotionUserView view=new WebPromotionUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public Vector<Vector<String> > getAllWebPromotion() {
		return proService.getAllWebPromotion();

	}

	@Override
	public void addButtonClicked() {
		view.addButtonClicked();
	}

	@Override
	public void delButtonClicked() {
		view.delButtonClicked();
	}

	@Override
	public boolean deleteStrategy(String strategyNo) {
		return proService.deleteStrategy(strategyNo);
	}
	@Override
	public void addWebPromotion(PromotionVO vo) {
		proService.madebyweb(vo);
	}

	@Override
	public void addCircle(String city) {
		Vector<String> circles=proService.getCircle(city);
		view.addCircle(circles);
	}
    public List<String> addCity(){
    	return proService.getCity();
    }
	@Override
	public void updateListModel() {
		view.updateListModel();	
	}
	@Override
	public Double getDiscount(int level) {
		return user.getDiscount(level);
	}
}
