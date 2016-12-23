package uiService;

import java.util.Vector;

import UserView.OrderView;
import VO.OrderVO;
/**
 * 负责实现订单管理的初始界面
 * @author 刘宇翔
 *
 */
public interface OrderViewControllerService {
    /**
     * 返回按钮的实现
     */
	public void exit();
	/**
	 * 设置一个OrderView 的panel
	 * @param view
	 */
    public void setView(OrderView view);
    /**
     * 更新订单表源
     * @param type 所选的订单类型
     */
    public void updateList(String type);
    /**
     * 评论界面跳转
     */
    public void comment();
    /**
     * 撤销一个顶大
     * @param orderID 订单id
     */
    public void cancel(String orderID);
    /**
     * 获得客户id 
     * @return 客户id
     */
    public String getUserID();
    /**
     * 订单详情界面的跳转
     * @param orderID 订单id
     */
    public void showDetail(String orderID);
    /**
     * 获得所有订单
     * @return 订单列表
     */
	public Vector<OrderVO> getAllOrder();
}
