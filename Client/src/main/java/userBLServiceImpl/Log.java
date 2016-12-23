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
/**
 * 管理用户的登录以及加密
 * @author LZ
 *
 */
public class Log {
	private HashMap<String,LogVO> list;
	private HashMap<String,String> key;//维护未加密的id和对应密钥
	private HashMap<String,String> skey;//维护已加密的id和对应密钥
	private DataFactoryService df;
	UserDataService dh;
	public Log() throws RemoteException{
		list=new HashMap<String,LogVO>();
		df=RemoteHelper.getInstance().getDataFactoryService();
		dh=(UserDataService) df.getDataService("User");
		init();
	}
	private void init() throws RemoteException{
		key=dh.getAllKeys();
		skey=dh.getAllSKeys();
		List<UserPO> l=dh.getAllUser();
		for(UserPO user:l){
			list.put(user.getAccount(), new LogVO(user));
		}
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
			dh.modifyPassword(userID,password);
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
	 * 得到LogVO列表的长度
	 * @return
	 */
	public int getNumber(){
		return list.size();
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
	 * @return 
	 * 增加一个密钥
	 * @param id
	 * @param k
	 * @throws  
	 */
	public boolean addKey(String id,String k,String secretid){
		if(!key.containsKey(id)){
			try {
				key.put(id, k);
				skey.put(secretid, k);
				dh.addKey(id,k,secretid);
				return true;
			} catch (RemoteException e) {
				System.out.println("增加失败");
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 根据原始ID提供密钥
	 * @param id
	 * @return
	 */
	public String getKey(String id){
		if(key.containsKey(id)){
			return key.get(id);
		}
		return null;
	}
	/**
	 * 根据加密账号提供密钥
	 * @param secretid
	 * @return
	 */
	public String getSKey(String secretid){
		if(skey.containsKey(secretid)){
			return skey.get(secretid);
		}
		return null;
	}
	/**
	 * 返回此账号的登录情况，仅用于测试，无业务需求
	 * @param id String 测试部分传入的用户账号
	 * @return 此账号的登录情况
	 */
	public boolean logstate(String id){
		if(list.containsKey(id)){
			return list.get(id).inorout;
		}
		return false;
	}
}
