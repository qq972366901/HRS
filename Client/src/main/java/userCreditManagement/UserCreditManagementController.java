package userCreditManagement;

import java.rmi.RemoteException;

import Mock.MockMemberGrade;
import VO.CreditRecordVO;
import VO.UserVO;
import common.ResultMessage;
import userBLServiceImpl.Credit;
import userBLServiceImpl.Customer;
import userBLServiceImpl.MemberGrade;
import userBLServiceImpl.PromotionInfo;


public class UserCreditManagementController {
		/**
		 * 更新会员等级
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @throws RemoteException 
		 * @see bussinesslogic.Customer
		 */
		public void updateLevel(String id, long credit) throws RemoteException {
			Credit.getInstance().updateLevel(id, credit);
		}
		/**
		 * 根据信用记录更新信用值
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @throws RemoteException 
		 * @see bussinesslogic.Customer
		 */
		public void updateCreditRecord(CreditRecordVO vo) throws RemoteException {
			Credit.getInstance().updateCredit(vo);
		}
		/**
		 * 根据会员等级提供折扣
		 * @param level
		 * @return
		 */
		public Double getDiscount(Integer level) {
			PromotionInfo mg=new MockMemberGrade();
			return mg.getDiscount(level);
		}
}
