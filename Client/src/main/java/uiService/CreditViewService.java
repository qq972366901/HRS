package uiService;

import java.util.Vector;

import userView.CreditView;
/**
 * 负责实现信用查看的初始界面
 * @author 刘宇翔
 *
 */
public interface CreditViewService {
	/**
	 * 设置一个CreditView panel
	 * @param view
	 */
	public void setView(CreditView view);
	/**
	 * 获得客户的信用值
	 * @param id 客户的账号
	 * @return 客户的信用值
	 */
	public long getcredit(String id);
	/**
	 * 返回按钮的实现
	 */
	public void exit();
	/**
	 * 获得用户的id
	 * @return 用户id
	 */
	public String getUserID();
	/**
	 * 获得客户的信用记录
	 * @param id 客户的id
	 * @return 客户所有的信用记录
	 */
	public Vector<Vector<String>> getCreditRecord(String id);
}
