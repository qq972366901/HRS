package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	private static CreditRecord creditRecord;
	private CreditRecord(){
		map=new HashMap<String,HashMap<String,CreditRecordVO>>();
		HashMap<String,CreditRecordVO> hm=new HashMap<String,CreditRecordVO>();
		Calendar cal=Calendar.getInstance();
		CreditRecordVO crvo=new CreditRecordVO("1",cal,"1",Operate.Done,-50,600);
		hm.put(crvo.orderID, crvo);
		map.put("1",hm);//暂时这样初始化，需要从数据层取数据
		//df=RemoteHelper.getInstance().getDataFactoryService();
		//CreditRecordDataService service=(CreditRecordDataService) df.getDataService("CreditRecord");
		//List<CreditRecordPO> list=service.getAllCreditRecord();
	}
	public static CreditRecord getInstance(){
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
		return map.get(id);
	}
	
	/**
	 * 更新信用记录
	 * @param id String型，界面层传来的用户ID
	 * @param vo CreditRecordVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.CreditRecordVO
	 */
	/*
	public void updateCreditRecord(String id,CreditRecordVO vo) throws RemoteException{
		map.get(id).get(vo.orderID).account=vo.account;
		map.get(id).get(vo.orderID).action=vo.action;
		map.get(id).get(vo.orderID).creditchange=vo.creditchange;
		map.get(id).get(vo.orderID).currentcredit=vo.currentcredit;
		map.get(id).get(vo.orderID).time=vo.time;
		CreditRecordPO po=new CreditRecordPO(vo.orderID,vo.time,vo.action,vo.creditchange,vo.currentcredit);
		//CreditRecordDataService dh=(CreditRecordDataService) df.getDataService("CreditRecord");
		//dh.update(po);
	}*/
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
			//CreditRecordPO po=new CreditRecordPO(vo.orderID,vo.time,vo.action,vo.creditchange,vo.currentcredit);
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
