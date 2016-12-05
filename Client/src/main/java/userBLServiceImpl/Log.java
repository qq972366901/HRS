package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import PO.UserPO;
import VO.LogVO;
import VO.UserVO;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;

public class Log {
	private HashMap<String,LogVO> list;
	private HashMap<String,String> key;//维护未加密的id和对应密钥
	private DataFactoryService df;
	UserDataService dh;
	private static Log log;
	private Log() throws RemoteException{
		list=new HashMap<String,LogVO>();
		df=RemoteHelper.getInstance().getDataFactoryService();
		dh=(UserDataService) df.getDataService("User");
		key=dh.getAllKeys();
		List<UserPO> l=dh.getAllUser();
		for(UserPO user:l){
			list.put(user.getAccount(), new LogVO(user));
		}
	}
	public static Log getLogInstance() throws RemoteException{
		if(log==null){
			log=new Log();
		}
		return log;
	}
	/**
	 * 登出
	 * @param id String型，界面层传来的用户ID
	 */
	public void logout(String id){
		if(list.containsKey(id)){
			list.get(id).inorout=false;
		}
	}
	/**
	 * 登录
	 * @param id String型，界面层传来的用户ID
	 */
	public boolean login(String id,String password){
		if(list.containsKey(id)&&passwordIsValid(id,password)){
			list.get(id).inorout=true;
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 验证登录密码是否正确
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean passwordIsValid(String id,String password){
		if(list.get(id).userpassword.equals(password)){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 修改密码
	 * @param userID
	 * @param password
	 * @throws RemoteException 
	 */
	public void revisepassword(String userID, String password) throws RemoteException {
		if(list.containsKey(userID)){
			list.get(userID).userpassword=password;
			dh.modifyPassword(userID,userID);
		}
	}
	/**
	 * 提供密码
	 * @param userID
	 * @return
	 */
	public String getPassword(String userID){
		if(list.containsKey(userID)){
			return list.get(userID).userpassword;
		}
		else{
			return "No Such User";
		}
	}
	/**
	 * 删除一个用户
	 * @param id
	 */
	public void delete(String id){
		if(list.containsKey(id)){
			String ID=DES.decryptDES(id,key.get(id));  
			try {
				key.remove(ID);
				dh.deleteKey(ID);
				list.remove(id);
			} catch (RemoteException e) {
				System.out.println("删除密钥失败");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增加一个用户
	 * @param id
	 */
	public void add(String id,LogVO vo){
		if(!list.containsKey(id)){
			list.put(id, vo);
		}
	}
	/**
	 * 增加一个密钥
	 * @param id
	 * @param k
	 * @throws  
	 */
	public void addKey(String id,String k){
		if(!key.containsKey(id)){
			try {
				key.put(id, k);
				dh.addKey(id,k);
			} catch (RemoteException e) {
				System.out.println("增加失败");
				e.printStackTrace();
			}
		}
	}
}
