package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.HashMap;

import Mock.MockMemberGrade;
import PO.UserPO;
import VO.UserVO;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 负责对用户的操作
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public class User {
	private HashMap<String,UserVO> map;
	private DataFactoryService df;
	private PromotionInfo pi;
	private static User user; 
	private User(){ 
		map=new HashMap<String,UserVO>();//暂时这样初始化，事实上需要从数据层取
		df=RemoteHelper.getInstance().getDataFactoryService();
	}
	public static User getUserInstance(){
		if(user==null){
			user=new User();
		}
		return user;
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
	 * 更新用户信用值
	 * @param UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void updateLevel(UserVO vo) throws RemoteException{
		pi=new MockMemberGrade();
		HashMap<Integer,Long> level=pi.getLevelSystem();
		if(map.containsKey(vo.id)){
			if(vo.credit<level.get(1)){
				vo.level=0;
			}
			else if(vo.credit>=level.get(5)){
				vo.level=5;
			}
			else if(level.get(1)<=vo.credit&&vo.credit<level.get(2)){
				vo.level=1;
			}
			else if(level.get(2)<=vo.credit&&vo.credit<level.get(3)){
				vo.level=2;
			}
			else if(level.get(3)<=vo.credit&&vo.credit<level.get(4)){
				vo.level=3;
			}
			else{
				vo.level=4;
			}
			map.put(vo.id, vo);
			UserPO userpo=new UserPO(map.get(vo.id).username,map.get(vo.id).userpassword,map.get(vo.id).id,map.get(vo.id).contactway,map.get(vo.id).level,map.get(vo.id).membertype,map.get(vo.id).type,map.get(vo.id).birthday,map.get(vo.id).enterprise);
			//UserDataService dh=(UserDataService) df.getDataService("User");
			//dh.update(userpo);
		}
	}
	/**
	 * 更新用户信息
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void updateUserInfo(UserVO vo) throws RemoteException{
		if(map.containsKey(vo.id)){
			map.put(vo.id, vo);
			UserPO userpo=new UserPO(vo.username,map.get(vo.id).userpassword,vo.id,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
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
	public boolean create(UserVO vo) throws RemoteException{
		if(!map.containsKey(vo.id)){
			map.put(vo.id, vo);
			UserPO userpo=new UserPO(vo.username,map.get(vo.id).userpassword,vo.id,vo.contactway,vo.level,vo.membertype,vo.type,vo.birthday,vo.enterprise);
			//UserDataService dh=(UserDataService) df.getDataService("User");
			//dh.insert(userpo);
			return true;
		}
		else{
			return false;
		}
	}
}
