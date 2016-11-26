package uiService;

import UserView.MemberRegisterView;

public interface MemberRegisterUiService {
	public void setView(MemberRegisterView view);
	public void tocustomerMainView();
	public void toLogView();
	public boolean createUser(UserVO vo,String password);
	public void tocustomerMainView(String id);
}
