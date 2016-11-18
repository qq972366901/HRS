package uiService;

import java.util.List;

import VO.PromotionVO;
import WebPromotionView.WebPromotionStrategyView;

public interface WebPromotionStrategyUiService {

	public void setView(WebPromotionStrategyView view);

	public void toWebPromotionUserView();

	public List<PromotionVO> getAllWebPromotion();

	public void addButtonClicked();

	public void delButtonClicked();

	public boolean deleteStrategy(int strategyNo);

}
