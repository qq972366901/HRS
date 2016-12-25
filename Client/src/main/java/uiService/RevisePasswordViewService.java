package uiService;

import UserView.RevisePasswordView;

/**
 * 负责实现修改密码的初始界面
 * @author 刘宇翔
 *
 */
public interface RevisePasswordViewService {
	/**
	 * 设置一个revisePasswordView的panel
	 * @param view
	 */
    public void setView(RevisePasswordView view);
    /**
     * 返回跳转的实现
     */
    public void exit();
    /**
     * 修改密码
     * @param password 新密码
     */
    public void revisepassword(String password);
    /**
     * 获得客户id
     * @return 客户id
     */
    public String getUserID();
    /**
     * 判断旧密码是否正确
     * @param password 旧密码
     * @return 正确则返回true，否则为false
     */
    public boolean checkoldPassword(String password);
    /**
     * 判断新密码是否合法
     * @param password 新密码
     * @return 合法返回true，否则为false
     */
    public boolean checknewPassword(String password);
    /**
     * 判断新密码与重复密码是否一致
     * @param password1 新密码
     * @param password2 重复密码
     * @return 一致则为true，否则为false
     */
    public boolean checksame(String password1,String password2);
    /**
     * 判断新密码与旧密码是否一致
     * @param password1 旧密码
     * @param password2 新密码
     * @return 不一致返回true，否则为false
     */
    public boolean checksame_old(String password1,String password2);
}
