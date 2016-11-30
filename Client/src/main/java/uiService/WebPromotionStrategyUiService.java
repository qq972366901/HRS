package uiService;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import VO.WebPromotionVO;
import WebPromotionView.WebPromotionStrategyView;

public interface WebPromotionStrategyUiService {

	public void setView(WebPromotionStrategyView view);

	public void toWebPromotionUserView();

	public Vector<Vector<String> > getAllWebPromotion();

	public void addButtonClicked();

	public void delButtonClicked();

	public boolean deleteStrategy(String strategyNo);

	public void addWebPromotion(WebPromotionVO vo);

	public void addCircle(String city);

	public List<String> addCity();

	public void updateListModel();

}
