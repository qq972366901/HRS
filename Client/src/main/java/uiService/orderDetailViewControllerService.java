package uiService;

import java.util.List;

import UserView.orderDetailView;
/**
 * 负责实现订单详情的初始界面
 * @author 刘宇翔
 *
 */
public interface orderDetailViewControllerService {
	/**
	 * 设置一个OrderDetailView的panel
	 * @param view
	 */
	 public void setView(orderDetailView view);
	 /**
	  * 返回按钮的实现
	  */
     public void exit();
     /**
      * 获得客户id
      * @return 客户id
      */
     public String getUserID();
     /**
      * 获得订单详情
      * @return 订单详情
      */
     public List<String> getDetail();
     /**
      * 获得酒店id
      * @return 酒店id
      */
     public String getHotelID();
     /**
      * 获得订单id
      * @return 订单id
      */
     public String getOrderID();
}
