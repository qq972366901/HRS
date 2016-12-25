package uiService;

import UserView.LogView;
/**
 * 修改个人信息的初始界面借口的实现接口
 * @author 刘宇翔
 *
 */
public interface LoginViewControllerService {
	/**
	 * 设置一个LogView的panel
	 * @param view
	 */
         public void setView(LogView view);
         /**
          * 用户登录
          * @param logid 登录账号
          * @param password 登录密码
          * @return 是否登录成功，成功为true，否则为false
          */
         public boolean login(String logid,String password);
         /**
          * 注册界面跳转
          * @return 跳转成功为true，否则为false
          */
         public boolean register();
         /**
          * 更新表单
          * @param selected 选择的项
          */
		public void updateRegisterButton(String selected);
		/**
		 * 更新所有超时的订单为异常
		 */
		public void updateOrderState();
}
