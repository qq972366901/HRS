package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import VO.LogVO;
import VO.UserVO;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;

public class Log {
	private HashMap<String,LogVO> list;
	private DataFactoryService df;
	private static Log log;
	private Log(){
		list=new HashMap<String,LogVO>();//暂时这样初始化，事实上需要从数据层取
		list.put("1", new LogVO("1","1",false));
		df=RemoteHelper.getInstance().getDataFactoryService();
	}
	public static Log getLogInstance(){
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
		list.get(id).inorout=false;
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
	 */
	public void revisepassword(String userID, String password) {
		// TODO Auto-generated method stub
		list.get(userID).userpassword=password;
		//由于修改了密码，需要对数据层进行持久化
	}
}
