package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**负责实现信用记录数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.CreditRecord
 */
public interface CreditRecordDataService extends DataService{
/**
 * 按ID进行查找返回相应的CreditRecordPO结果
 * @param in MessageInput型，界面输入的客户ID
 * @return 返回ResultMessage枚举的一项
 * @see data.CreditRecord
 */
	public CreditRecordPO find(String id) throws RemoteException;
/**
 * 在数据库中增加一个po记录
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.CreditRecord
 */
	public void insert(CreditRecordPO po) throws RemoteException;
/**
 * 在数据库中删除一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.CreditRecord
 */
	public void delete(CreditRecordPO po) throws RemoteException;
/**
 *在数据库中更新一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.CreditRecord
 */
	public void update(CreditRecordPO po) throws RemoteException;
/**
 * 按初始化持久化数据库
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.CreditRecord
 */
	public void init() throws RemoteException;
/**
 * 结束持久化数据库的使用
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.CreditRecord
 */
	public void finish() throws RemoteException;
}
