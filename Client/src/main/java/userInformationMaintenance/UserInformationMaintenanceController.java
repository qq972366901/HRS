package userInformationMaintenance;

import java.rmi.RemoteException;

import VO.UserVO;
import userBLServiceImpl.Credit;
import userBLServiceImpl.Customer;
import userBLServiceImpl.Log;


public class UserInformationMaintenanceController{
	private Customer c;
	private Credit cr;
	public UserInformationMaintenanceController(){
		try {
			c=new Customer();
			cr=new Credit();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据客户ID查找客户信息并返回
	 * @param  userID String型，界面输入的客户ID
	 * @return 返回UserVO
	 * @throws  
	 * @see Customer.User
	 */
	public UserVO findByID(String userID) throws RemoteException{
		return c.findByID(userID);
	}
	/**
	 * 更新客户信息
	 * @param vo UserVO型，界面输入的更新信息
	 * @param passwordo String型，用户的密码
	 * @see Customer.User
	 */
	public void update(UserVO vo) throws RemoteException{
		c.updateUserInfo(vo);
	}
	/**
	 * 显示信用等级
	 * @param id String 型，界面层传入的客户账户
	 * @return 返回此账号的信用等级
	 */
	public int showLevel(String id){
		return cr.showLevel(id);
	}
}
