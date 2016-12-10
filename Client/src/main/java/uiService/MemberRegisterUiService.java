package uiService;

import UserView.MemberRegisterView;
import VO.UserVO;

public interface MemberRegisterUiService {
	public void setView(MemberRegisterView view);
	public void toLogView();
	public void tocustomerMainView(String id);
	public void register(UserVO vo,String password);
}
