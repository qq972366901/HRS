package VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import PO.CreditRecordPO;
import common.Operate;

/**
 * 信用记录的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.CreditRecord
 */

public class CreditRecordVO{

	public String account;//即客户ID
	public Calendar time;
	public String orderID;
	public Operate action;
	public long creditchange;
	public long currentcredit;
	public CreditRecordVO(String a,Calendar t,String id,Operate act,long cre,long cur){
		account=a;
		time=t;
		orderID=id;
		action=act;
		creditchange=cre;
		currentcredit=cur;
	}

	public CreditRecordVO() {
		// TODO Auto-generated constructor stub
	}

	/**
     * 更新信用记录信息
     * 
     * @param creRco CreditRecord型，一个用来更新数据的信用记录对象
     * @return 
     * @see Object.CreditRecord
     */
	public void update(CreditRecordVO creRco) {
		
	}
	
	/**
     * 创建信用记录对象
     * 
     * @return 一个新用户的信用记录
	 * @throws ParseException 
     * @see Object.CreditRecord
     */
	public CreditRecordVO(CreditRecordPO po) throws ParseException {
		account=po.getUserID();
		time=po.getTime();
		orderID=po.getID();
		action=po.getAction();
		creditchange=po.getCreditchange();
		currentcredit=po.getCurrentcredit();
	}
	
}

