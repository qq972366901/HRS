package userCreditRecord;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import VO.CreditRecordVO;
import userBLServiceImpl.Credit;
import userBLServiceImpl.CreditRecord;
/**
 * 用户信用记录控制器
 * @author LZ
 *
 */
public class UserCreditRecordController{
	private Credit c;
	private CreditRecord cr;
	public UserCreditRecordController(){
		try {
			c=new Credit();
			cr=new CreditRecord();
		} catch (RemoteException | ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	* 显示信用值
	* @param userID String型，界面输入用户ID
	* @return 返回此用户的信用值
	 * @throws RemoteException 
	* @see bussinesslogic.Customer
	*/
	public long showCredit(String userID) throws RemoteException {
		return c.showCredit(userID);
	}
	/**
	 * 信用记录显示
	 * @param id String型，界面传入的客户账号
	 * @return 返回信用记录列表
	 * @throws RemoteException 
	 * @see Customer.User
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String userID) throws RemoteException, ParseException {
		return cr.showCreditRecord(userID);
	}	
}
