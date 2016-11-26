package userCreditRecord;
import java.util.ArrayList;
import java.util.List;

import VO.CreditRecordVO;

public class UserCreditRecordController{
		/**
		 * 显示信用值
		 * @param in MessageInput型，界面输入用户ID
		 * @return String型，返回客户的信用值
		 * @see bussinesslogic.Customer
		 */
		public long showCredit(String userID) {
			return 200;
		}
			/**
			 * 信用记录显示
			 * @param in MessageInput型，界面选择的信息
			 * @return 返回ResultMessage的一个枚举值
			 * @see bussinesslogic.Customer
			 */
			public List<CreditRecordVO> showCreditRecord(String userID) {
				List<CreditRecordVO> cr=new ArrayList<CreditRecordVO>();
				return cr;
			}	
}
