package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.HashMap;

import PO.CreditRecordPO;
import VO.CreditRecordVO;
import dataService.CreditRecordDataService;
import dataService.DataFactoryService;
import rmi.RemoteHelper;
/**
 * 负责对于信用记录的操作
 * @author LZ
 *@version 1.0
 *@see VO.CreditRecordVO
 */
public class CreditRecord {
	private HashMap<String,HashMap<String,CreditRecordVO>> map;
	private DataFactoryService df;
	public CreditRecord(){
		map=new HashMap<String,HashMap<String,CreditRecordVO>>();
		df=RemoteHelper.getInstance().getDataFactoryService();
	}
	/**
	 * 显示信用记录
	 * @param id String型，界面层传来的客户ID
	 * @return 返回属于此ID的所有信用记录
	 * @see VO.CreditRecordVO
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String id){
		return map.get(id);
	}
	/**
	 * 更新信用记录
	 * @param id String型，界面层传来的用户ID
	 * @param vo CreditRecordVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.CreditRecordVO
	 */
	public void updateCreditRecord(String id,CreditRecordVO vo) throws RemoteException{
		map.get(id).get(vo.orderID).account=vo.account;
		map.get(id).get(vo.orderID).action=vo.action;
		map.get(id).get(vo.orderID).creditchange=vo.creditchange;
		map.get(id).get(vo.orderID).currentcredit=vo.currentcredit;
		map.get(id).get(vo.orderID).time=vo.time;
		CreditRecordPO po=new CreditRecordPO(vo.orderID,vo.time,vo.action,vo.creditchange,vo.currentcredit);
		//CreditRecordDataService dh=(CreditRecordDataService) df.getDataService("CreditRecord");
		//dh.update(po);
	}
	/**
	 * 增加信用记录
	 * @param userID String型，界面层传来的客户ID
	 * @param vo CreditRecordVO型，界面层传来的vo对象
	 * @throws RemoteException
	 * @see VO.CreditRecordVO
	 */
	public void add(String userID,CreditRecordVO vo) throws RemoteException{
		if(map.containsKey(userID)){
			map.get(userID).put(vo.orderID, vo);
			CreditRecordPO po=new CreditRecordPO(vo.orderID,vo.time,vo.action,vo.creditchange,vo.currentcredit);
			//CreditRecordDataService dh=(CreditRecordDataService) df.getDataService("CreditRecord");
			//dh.insert(po);
		}
		else{
			HashMap<String,CreditRecordVO> m=new HashMap<String,CreditRecordVO>();
			m.put(vo.orderID, vo);
			map.put(userID, m);
		}
	}
	/**
	 * 获取某位客户的某条信用记录
	 * @param userID String型，界面层传来的客户ID
	 * @param orderID String型，界面层传来的记录编号
	 * @return 返回属于此客户ID和记录编号的VO对象
	 * @see VO.CreditRecordVO
	 */
	public CreditRecordVO getCreditRecord(String userID,String orderID){
		return map.get(userID).get(orderID);
	}
}
