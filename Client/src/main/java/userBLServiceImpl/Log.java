package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataService.DataFactoryService;
import dataService.UserDataService;

public class Log {
	private List<String> peopleInSystem;
	private DataFactoryService df;
	private HashMap<String,String> list;
	public Log() throws RemoteException{
		//UserDataService dh=(UserDataService) df.getDataService("User");
		//this.list=dh.getAllCustomerIDAndPassword();
		list=new HashMap<String,String>();//暂时这样初始化
		list.put("1", "1");
		this.peopleInSystem=new ArrayList<String>();
	}
	/**
	 * 登出
	 * @param id String型，界面层传来的用户ID
	 */
	public void logout(String id){
		if(peopleInSystem.contains(id))peopleInSystem.remove(id);
	}
	/**
	 * 登录
	 * @param id String型，界面层传来的用户ID
	 */
	public boolean login(String id,String password){
		if(!peopleInSystem.contains(id)&&passwordIsValid(id,password)){
			peopleInSystem.add(id);
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
	private boolean passwordIsValid(String id,String password){
		if(list.get(id).equals(password)){
			return true;
		}
		else{
			return false;
		}
	}
}
