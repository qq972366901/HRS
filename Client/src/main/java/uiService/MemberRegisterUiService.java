package uiService;

import UserView.MemberRegisterView;
import VO.UserVO;

public interface MemberRegisterUiService {
	public void setView(MemberRegisterView view);
	public void toLogView();
	public boolean createUser(UserVO vo);
	public void tocustomerMainView(String id);
}
