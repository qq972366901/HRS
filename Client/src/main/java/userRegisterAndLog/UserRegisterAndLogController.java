package userRegisterAndLog;
import java.rmi.RemoteException;

import userBLServiceImpl.Credit;
import userBLServiceImpl.Log;
import userBLServiceImpl.Register;
import vo.CreditVO;
import vo.LogVO;
import vo.UserVO;
/**
 * 用户注册与登录控制器
 * @author LZ
 *
 */
public class UserRegisterAndLogController{
	private Register r;
	private Log log;
	public UserRegisterAndLogController(){
		try {
			r=new Register();
			log=new Log();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 客户注册
	 * @param vo UserVO型，界面传入的用户信息
	 * @param password String型，界面传入的秘密
	 * @throws RemoteException 
	 * @see bussinesslogic.Customer
	 */
	public void register(UserVO vo,String password) throws RemoteException {
		r.add(vo,password);
		CreditVO cvo=new CreditVO(vo.id,0,0);
		Credit c=new Credit();
		c.add(cvo);
		log.add(vo.id, new LogVO(password,vo.id,true));
	}
	/**
	 * 客户登录
	 * @param ID String型，界面输入的用户账号
	 * @param password String型，界面输入的用户账号
	 * @see Customer.User
	 */
		public boolean login(String ID, String password)throws RemoteException {
			return log.login(ID,password);
		}
		/**
		 * 客户登出
		 * @param ID String型，界面选择的信息
		 * @see bussinesslogic.Customer
		 */
		public void logout(String ID) {
			log.logout(ID);
		}
			 /**
		     * 修改密码
		     * @param userID String型，界面层传入的用户账号
		     * @param password String 型，界面层传入的用户密码
		     */
		public void revisepassword(String userID, String password) {
			try {
				log.revisepassword(userID,password);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 检查密码是否正确
		 * @param userID String型，界面层传入的用户账号
	     * @param password String 型，界面层传入的用户密码
	     * @return 返回布尔值表示密码是否正确
		 */
		public boolean checkoldPassword(String userID, String password) {
			return log.passwordIsValid(userID,password);
		}
		/**
		 * 为Log类增加原始账号，密钥，加密账号
		 * @param id
		 * @param k
		 * @param secretid
		 */
		public boolean addLog(String id, String k, String secretid) {
			return log.addKey(id, k, secretid);
		}
}
