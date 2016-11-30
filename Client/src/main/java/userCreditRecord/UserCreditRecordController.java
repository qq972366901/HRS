package userCreditRecord;
import java.util.HashMap;
import VO.CreditRecordVO;
import userBLServiceImpl.Credit;
import userBLServiceImpl.CreditRecord;

public class UserCreditRecordController{
	/**
	* 显示信用值
	* @param in MessageInput型，界面输入用户ID
	* @return String型，返回客户的信用值
	* @see bussinesslogic.Customer
	*/
	public long showCredit(String userID) {
		return Credit.getInstance().showCredit(userID);
	}
	/**
	 * 信用记录显示
	 * @param id String型，界面传入的客户账号
	 * @return 返回信用记录列表
	 * @see Customer.User
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String userID) {
		return CreditRecord.getInstance().showCreditRecord(userID);
	}	
}
