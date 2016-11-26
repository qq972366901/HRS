package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import Mock.MockMemberGrade;
import PO.UserPO;
import VO.UserVO;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 负责对客户的操作
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public class Customer {
	private HashMap<String,UserVO> map;
	private DataFactoryService df;
	private PromotionInfo pi;
	private static Customer user; 
	private Customer(){ 
		map=new HashMap<String,UserVO>();//暂时这样初始化，事实上需要从数据层取
		df=RemoteHelper.getInstance().getDataFactoryService();
		//UserDataService dh=(UserDataService) df.getDataService("User");
		//List<UserPO> list=dh.getAllCustomer();
		//for(UserPO user:list){map.put(user.id,new UserVO(user);}
	}
	public static Customer getUserInstance(){
		if(user==null){
			user=new Customer();
		}
		return user;
	}
	/**
	 * 提供所有客户信息给Account类使用
	 * @return
	 */
	public List<UserVO> getAllCustomer(){
		List<UserVO> list=new Vector<UserVO>();
		Collection<UserVO> values = map.values();  
		for (Iterator<UserVO> iterator=values.iterator(); iterator.hasNext();){  
			UserVO value = iterator.next();  
		    list.add(value); 
		} 
		return list;
	}
	/**
	 * 删除一个用户
	 * @param userID
	 */
	public void deleteCustomer(String userID){
		map.remove(userID);
		//UserDataService dh=(UserDataService) df.getDataService("User");
		//dh.delete(userID);
	}
	/**
	 * 按ID查找用户
	 * @param userID String型，界面层传来的用户ID
	 * @return 返回属于此ID的用户信息
	 * @see VO.UserVO
	 */
	public  UserVO findByID(String userID){
		UserVO user=map.get(userID);
		return user;
	}
	/**
	 * 更新用户等级
	 * @param UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void updateLevel(String id ,long credit) throws RemoteException{
		pi=new MockMemberGrade();
		HashMap<Integer,Long> level=pi.getLevelSystem();
		if(map.containsKey(id)){
			if(credit<level.get(1)){
				map.get(id).level=0;
			}
			else if(credit>=level.get(5)){
				map.get(id).level=5;
			}
			else if(level.get(1)<=credit&&credit<level.get(2)){
				map.get(id).level=1;
			}
			else if(level.get(2)<credit&&credit<level.get(3)){
				map.get(id).level=2;
			}
			else if(level.get(3)<=credit&&credit<level.get(4)){
				map.get(id).level=3;
			}
			else{
				map.get(id).level=4;
			}
			updateUserInfo(map.get(id),Log.getLogInstance().getPassword(id));
			Account.getInstance().update(map.get(id),Log.getLogInstance().getPassword(id));
		}
	}
	/**
	 * 更新用户信息
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void updateUserInfo(UserVO vo,String password) throws RemoteException{
		if(map.containsKey(vo.id)){
			map.put(vo.id, vo);
			UserPO userpo=new UserPO(vo.username,password,vo.id,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			//UserDataService dh=(UserDataService) df.getDataService("User");
			//dh.update(userpo);
		}
	}
	/**
	 * 创建新用户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @return 
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public boolean create(UserVO vo,String password) throws RemoteException{
		if(!map.containsKey(vo.id)){
			map.put(vo.id, vo);
			UserPO userpo=new UserPO(vo.username,password,vo.id,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			//UserDataService dh=(UserDataService) df.getDataService("User");
			//dh.insert(userpo);
			return true;
		}
		else{
			return false;
		}
	}
}
