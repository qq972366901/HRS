package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import dataService.DataFactoryService;
import dataService.UserDataService;
import po.UserPO;
import rmi.RemoteHelper;
import vo.LogVO;
import vo.UserVO;
/**
 * 负责对客户的操作
 * @author LZ
 * @version 1.0
 * @see vo.UserVO
 */
public class Customer {
	private HashMap<String,UserVO> map;
	private DataFactoryService df;
	UserDataService dh;
	public Customer() throws RemoteException{ 
		map=new HashMap<String,UserVO>();
		df=RemoteHelper.getInstance().getDataFactoryService();
		dh=(UserDataService) df.getDataService("User");
		init();
	}
	private void init() throws RemoteException{
		List<UserPO> list=dh.getAllCustomer();
		for(UserPO po:list){
			map.put(po.getAccount(), new UserVO(po));
		}
	}
	/**
	 * 判断账号是否存在
	 * @param id
	 * @return
	 */
	public boolean hasCustomer(String id){
		if(map.containsKey(id)){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 删除一个用户
	 * @param userID
	 * @throws RemoteException 
	 */
	public void deleteCustomer(String userID) throws RemoteException{
		if(map.containsKey(userID)){
			map.remove(userID);
			UserDataService dh=(UserDataService) df.getDataService("User");
			dh.delete(userID);
		}
	}
	/**
	 * 按ID查找用户
	 * @param userID String型，界面层传来的用户ID
	 * @return 返回属于此ID的用户信息
	 * @see vo.UserVO
	 */
	public  UserVO findByID(String userID){
		UserVO user=map.get(userID);
		return user;
	}
	/**
	 * 更新用户信息
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see vo.UserVO
	 */
	public void updateUserInfo(UserVO vo) throws RemoteException{
		if(map.containsKey(vo.id)){
			map.put(vo.id, vo);
			Log log=new Log();
			UserPO userpo=new UserPO(vo.username,log.getPassword(vo.id),vo.id,vo.contactway,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			UserDataService dh=(UserDataService) df.getDataService("User");
			dh.update(userpo);
		}
	}
	
	/**
	 * 创建新用户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @return 
	 * @throws RemoteException
	 * @see vo.UserVO
	 */
	public boolean create(UserVO vo,String password) throws RemoteException{
		if(!map.containsKey(vo.id)){
			map.put(vo.id, vo);
			Log log=new Log();
			log.add(vo.id, new LogVO(password,vo.id,true));
			UserPO userpo=new UserPO(vo.username,password,vo.id,vo.contactway,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			UserDataService dh=(UserDataService) df.getDataService("User");
			dh.insert(userpo);
			return true;
		}
		else{
			return false;
		}
	}
}
