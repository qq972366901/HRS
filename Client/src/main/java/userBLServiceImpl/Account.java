package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.HashMap;

import PO.UserPO;
import VO.UserVO;
import common.UserType;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 负责对于账户的操作
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public class Account{
	private AccountList al;
	private DataFactoryService df;
	private HashMap<String,UserVO> map;
	private UserType type;
	public Account(UserType i){
		al=new AccountFactory();
		map=al.getAccountList(i);
		df=RemoteHelper.getInstance().getDataFactoryService();
		type=i;
	}
	/**
	 * 获取持有此账号的客户的信息
	 * @param account String型，界面层传来的账户编号
	 * @return 返回持有此账号的用户信息
	 * @see VO.UserVO
	 */
	public UserVO getUser(String account){
		if(map.get(account) != null){
			return map.get(account);
		}
		else{
			return null;
		}
	}
	/**
	 * 更新账户信息
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void update(UserVO vo) throws RemoteException{
		if(type==vo.type){
			if(map.get(vo.useraccount) != null){
				map.get(vo.useraccount).update(vo);
				UserPO userpo=new UserPO(vo.username,vo.userpassword,vo.useraccount,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
				//UserDataService dh=(UserDataService) df.getDataService("User");
				//dh.update(userpo);
			}
		}
	}
	/**
	 * 删除某个账户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void delete(UserVO vo) throws RemoteException{
		if(type==vo.type){
			if(map.get(vo.useraccount) != null){
				map.remove(vo.useraccount);
				UserPO userpo=new UserPO(vo.username,vo.userpassword,vo.useraccount,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
				//UserDataService dh=(UserDataService) df.getDataService("User");
				//dh.delete(userpo);
			}
		}
	}
	/**
	 * 增加一个账户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void add(UserVO vo) throws RemoteException{
		if(type==vo.type){
			if(map.get(vo.useraccount)==null){
				map.put(vo.useraccount, vo);
				UserPO userpo=new UserPO(vo.username,vo.userpassword,vo.useraccount,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
				//UserDataService dh=(UserDataService) df.getDataService("User");
				//dh.insert(userpo);
			}
		}
	}
}
