package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**负责实现营销策略数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Promotion
 */
public interface PromotionDataService  extends DataService{
	/**
	 * 按ID进行查找返回相应的PromotionPO结果
	 * @param in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage枚举的一项
	 * @see data.Promotion
	 */
		public PromotionPO find(String id) throws RemoteException;
	/**
	 * 在数据库中增加一个po记录
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void insert(PromotionPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void delete(String id) throws RemoteException;
	/**
	 *在数据库中跟新一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void update(PromotionPO po) throws RemoteException;
	/**
	 * 按初始化持久化数据库
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void init() throws RemoteException;
		/**
		 *得到所有的酒店策略
		 */
	    public List<PromotionPO> getAllHotelPromotion() throws RemoteException;
	/**
	 *得到所有的网站策略
	 */
	    public List<PromotionPO> getAllWebPromotion() throws RemoteException;
	/**
	 *得到会员等级系统
	 */
	    public PromotionPO getMemberLevelSystem() throws RemoteException;
	}

