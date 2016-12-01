package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import PO.UserPO;
import VO.CreditVO;
import VO.LogVO;
import VO.UserVO;
import common.UserType;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 负责网站管理人员对于账户的操作，维护除了客户以外的所有用户类型，修改客户信息则调用Customer类的方法
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public class Account{
	private static Account account;
	private DataFactoryService df;
	private HashMap<String,AccountInfo> worker;
	UserDataService dh;
	private Account() throws RemoteException{
		worker=new HashMap<String,AccountInfo>();
		df=RemoteHelper.getInstance().getDataFactoryService();
		dh=(UserDataService) df.getDataService("User");
		List<UserPO> list=dh.getAllWorker();
		for(int i=0;i<list.size();i++){
			worker.put(list.get(i).getAccount(), new AccountInfo(list.get(i)));
		}
	}
	public static Account getInstance() throws RemoteException{
		if(account==null){
			account=new Account();
		}
		return account;
	}
	/**
	 * 获取持有此账号的客户的信息
	 * @param account String型，界面层传来的账户编号
	 * @return 返回持有此账号的用户信息
	 * @throws  
	 * @see VO.UserVO
	 */
	public AccountInfo getUser(UserType type,String account){
		if(!type.equals(UserType.Customer)){
			return worker.get(account);
		}
		else{
			try {
				UserVO userVO=Customer.getUserInstance().findByID(account);
				String password=Log.getLogInstance().getPassword(account);
				long credit=Credit.getInstance().showCredit(account);
				int level=Credit.getInstance().showLevel(account);
				AccountInfo user=new AccountInfo(userVO.username,password,userVO.id,userVO.contactway,userVO.membertype,UserType.Customer,userVO.birthday,userVO.enterprise,credit,level);
				return user;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return null;
			
		}
	}
	/**
	 * 更新账户基本信息
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void update(UserVO vo,String password) throws RemoteException{
		if(vo.type.equals(UserType.Customer)){
			Customer.getUserInstance().updateUserInfo(vo);
			Log.getLogInstance().revisepassword(vo.id, password);
		}
		else{
			AccountInfo user=new AccountInfo(vo.username,password,vo.id,vo.contactway,vo.membertype,vo.type,vo.birthday,vo.enterprise,(long)-1,-1);
			worker.put(vo.id, user);
			UserPO po=new UserPO(vo.username,password,vo.id,vo.contactway,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			dh.update(po);
		}
	}
	/**
	 * 删除某个账户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void delete(String id) throws RemoteException{
		if(worker.containsKey(id)){
			worker.remove(id);
			dh.delete(id);
		}
		else{
			Customer.getUserInstance().deleteCustomer(id);
		}
		Log.getLogInstance().delete(id);
	}
	/**
	 * 增加一个账户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void add(UserVO vo,String password) throws RemoteException{
		if(worker.containsKey(vo.id)){
			AccountInfo user=new AccountInfo(vo.username,password,vo.id,vo.contactway,vo.membertype,vo.type,vo.birthday,vo.enterprise,(long)-1,-1);
			worker.put(vo.id, user);
			Log.getLogInstance().add(vo.id, new LogVO(password,vo.id,false));
			UserPO po=new UserPO(vo.username,password,vo.id,vo.contactway,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			dh.update(po);
		}
	}
	/**
	 * 判断账户是否存在
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	public boolean judgeAccount(String id) throws RemoteException {
		if(worker.containsKey(id)){
			return true;
		}
		else{
			if(Customer.getUserInstance().hasCustomer(id)){
				return true;
			}
			else{
				return false;
			}
		}
	}
}
