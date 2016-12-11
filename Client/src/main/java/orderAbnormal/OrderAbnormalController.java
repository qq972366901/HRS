package orderAbnormal;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;

import VO.CreditRecordVO;
import common.Operate;
import orderBLImpl.OrderState;
import userBLServiceImpl.Credit;
/**
 * 网站人员对于异常订单申诉成功的订单进行撤销操作
 * 
 * @author lyx
 *
 */
public class OrderAbnormalController{
	OrderState state;
	Credit credit;
	public OrderAbnormalController() throws RemoteException{
	      credit=Credit.getInstance();
	}
	/**
     * 撤销异常订单
     * 
     * @param String orderID,订单的id
	 * @ 
     * @see bussinesslogic.Order
     */
	public void cancelAbnormalOrder(String orderID)  {
	     state=new OrderState(orderID);
	     state.cancelAbnormalOrder();
	}
	/**
	 * 当申诉成功后，为客户恢复信用值
	 * @param userID String,客户id
	 * @param orderID String,订单编号
	 * @param value int,订单的价值
	 */
	public void updateCredit(String userID,String orderID,int value){		
	      try {
			credit.updateCredit(new CreditRecordVO(null,userID,Calendar.getInstance(),orderID,Operate.Appeal, value/2, credit.showCredit(userID)+value/2));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
