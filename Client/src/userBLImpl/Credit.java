package userBLImpl;

import java.rmi.RemoteException;
import java.util.HashMap;

import VO.CreditRecordVO;
/**
 * 负责对于信用值的操作
 * @author LZ
 * @version 1.0
 * @see VO.CreditRecordVO
 */
public class Credit {
	private HashMap<String,Long> map;
	CreditRecord cr=new CreditRecord();
	public Credit(){
		map=new HashMap<String,Long>();
	}
	/**
	 * 显示信用值
	 * @param id String型，界面层传来的客户ID
	 * @return 返回属于此ID的信用值
	 */
	public long showCredit(String id){
		return map.get(id);
	}
	/**
	 * 更新信用值
	 * @param userID String型，界面层传来的客户ID
	 * @param vo CreditRecordVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.CreditRecordVO
	 */
	public void updateCredit(String userID,CreditRecordVO vo) throws RemoteException{
		map.put(userID, vo.currentcredit);
		cr.add(userID, vo);
	}
}
