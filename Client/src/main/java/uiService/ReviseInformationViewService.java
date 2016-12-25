package uiService;

import java.util.Vector;

import UserView.ReviseInformationView;
/**
 * 负责实现修改个人信息的初始界面
 * @author 刘宇翔
 *
 */
public interface ReviseInformationViewService {
	/**
	 * 设置一个reviseInformationView的panel
	 * @param view
	 */
     public void setView(ReviseInformationView view);
     /**
      * 返回跳转的实现
      */
     public void exit();
     /**
      * 更新客户修改的信息
      * @param vector 客户修改的信息
      */
     public void updateinformation(Vector<String> vector);
     /**
      * 获得客户ID
      * @return 客户ID
      */
     public String getUserID();
}
