package uiService;

import userView.MemberRegisterView;
import vo.UserVO;
/**
 * 会员注册界面接口的实现接口
 * @author 刘伟
 *
 */
public interface MemberRegisterUiService {
	/**
	 * 设置一个MemberRegisterView的panel
	 * @param view
	 */
	public void setView(MemberRegisterView view);
	/**
	 * 跳转到登录界面
	 * @param view
	 */
	public void toLogView();
	/**
	 * 跳转到用户主界面
	 * @param view
	 */
	public void tocustomerMainView(String id);
	/**
	 * 保存客户的注册信息
	 * @param view
	 */
	public void register(UserVO vo,String password);
	/**保存客户的ID，加密后的ID和密钥
	 * @param view
	 */
	public boolean addLog(String id,String k,String secretid);
}
