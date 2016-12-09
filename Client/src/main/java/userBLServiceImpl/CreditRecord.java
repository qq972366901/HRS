package userBLServiceImpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import PO.CreditRecordPO;
import VO.CreditRecordVO;
import common.Operate;
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
	private HashMap<String,HashMap<String,CreditRecordVO>> map;//一个用户ID对应其自身的一系列信用记录
	private DataFactoryService df;
	CreditRecordDataService dh;
	private static CreditRecord creditRecord;
	private CreditRecord() throws RemoteException, ParseException{
		map=new HashMap<String,HashMap<String,CreditRecordVO>>();
		df=RemoteHelper.getInstance().getDataFactoryService();
		dh=(CreditRecordDataService) df.getDataService("CreditRecord");
		List<CreditRecordPO> list=dh.getAllCreditRecord();
		for(int i=0;i<list.size();i++){
			CreditRecordPO po=list.get(i);
			if(map.containsKey(po.getUserID())){
				map.get(po.getUserID()).put(po.getID(), new CreditRecordVO(po));
			}
			else{
				HashMap<String,CreditRecordVO> h=new HashMap<String,CreditRecordVO>();
				h.put(po.getID(), new CreditRecordVO(po));
				map.put(po.getUserID(), h);
			}
		}
	}
	public static CreditRecord getInstance() throws RemoteException, ParseException{
		if(creditRecord==null){
			creditRecord=new CreditRecord();
		}
		return creditRecord;
	}
	/*
	public HashMap<String,Long> getCurrentCredit(){
		HashMap<String, Long> list=new HashMap<String,Long>();
		for (Entry<String, HashMap<String,CreditRecordVO>> entry : map.entrySet()) {
		    String id=entry.getKey();
		    HashMap<String,CreditRecordVO> hashmap=entry.getValue();
		    Iterator<String> it=hashmap.keySet().iterator();//这是取得键对象
		    CreditRecordVO vo=null;
		    while(it.hasNext()){   
		        vo=hashmap.get(it.next());  
		    }
		    list.put(id, vo.currentcredit);
		}
		return list;
	}*/
	/**
	 * 显示信用记录
	 * @param id String型，界面层传来的客户ID
	 * @return 返回属于此ID的所有信用记录
	 * @see VO.CreditRecordVO
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String id){
		//System.out.println("show");
		//System.out.println(map.size());
		return map.get(id);
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
		}
		else{
			HashMap<String,CreditRecordVO> m=new HashMap<String,CreditRecordVO>();
			m.put(vo.orderID, vo);
			map.put(userID, m);
		}
		CreditRecordPO po=new CreditRecordPO(vo.account,vo.orderID,vo.time,vo.action,vo.creditchange,vo.currentcredit);
		dh.insert(po);
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
	/**
	 * 返回某客户信用记录的条数，仅用于测试，无业务需求
	 * @param id
	 * @return
	 */
	public int sizeOfRecord(String id){
		return map.get(id).size();
	}
}
