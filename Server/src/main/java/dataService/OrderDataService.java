package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**负责实现订单数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Order
 */
public interface OrderDataService  extends DataService{
/**
 * 按ID进行查找返回相应的OrderPO结果
 * @param in MessageInput型，界面输入的订单类型
 * @return 返回ResultMessage枚举的一项
 * @see data.Order
 */
		public OrderPO find(String id) throws RemoteException;
		/**
		 * 找到一个客户的所有制定类型的订单（0为全部订单，1为已执行订单，2为未执行订单，3为异常订单，4为撤销订单）
	     * @param userID String,客户id
		 * @param orderstate int,订单的状态
		 * @return List<OrderPO> 订单列表
		 */
		public List<OrderPO> findByUserID(String userID,int orderstate) throws RemoteException;
		/**
		 * 更新订单的状态，将超时的订单设置为异常
		 */
		public List<OrderPO> updateOrderState()throws RemoteException;
		/**
		 * 找到一家酒店下的所有指定类型的订单（0为全部订单，1为已执行订单，2为未执行订单，3为异常订单，4为撤销订单）
		 * @param hotelID String,酒店id
		 * @param orderstate int,订单的状态
		 * @return List<OrderPO> 订单列表
		 */
		
		public List<OrderPO> findByHotelID(String hotelID,int orderstate) throws RemoteException;
		/**
		 * 生成一个随机的订单编号
		 * @return String 订单编号
		 */
		public String generateOrderID() throws RemoteException;
		/**
		 * 找到一个客户在一个酒店的历史订单
		 * @param userID String,客户id
		 * @param hotelID String,酒店id
		 * @return List<OrderPO> 一个订单的列表
		 */
		public List<OrderPO> getUserOrderlistinHotel(String userID,String hotelID)throws RemoteException;
/**
 * 在数据库中增加一个po记录
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void insert(OrderPO po) throws RemoteException;
/**
 * 在数据库中删除一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void delete(OrderPO po) throws RemoteException;
/**
 *在数据库中跟新一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void update(OrderPO po) throws RemoteException;
/**
 * 按初始化持久化数据库
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void init() throws RemoteException;
/**
 * 结束持久化数据库的使用
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void finish() throws RemoteException;
	}

