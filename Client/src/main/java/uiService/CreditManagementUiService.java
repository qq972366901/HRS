package uiService;

import vo.CreditRecordVO;
import webPromotionView.CreditManagementView;

public interface CreditManagementUiService {

	public void setView(CreditManagementView view);

	public void toWebPromotionUserView();

	public void updateCredit(CreditRecordVO vo);

	public long getCurrencredit(String acc);
}
