package uiService;

import VO.CreditRecordVO;
import WebPromotionView.CreditManagementView;

public interface CreditManagementUiService {

	public void setView(CreditManagementView view);

	public void toWebPromotionUserView();

	public void updateCredit(CreditRecordVO vo);

	public long getCurrencredit(String acc);
}
