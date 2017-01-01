package VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import PO.CreditRecordPO;
import common.Operate;

/**
 * 信用记录的属性及数据创建与更新
 * @author 刘宗侃
 */

public class CreditRecordVO{
	public String cid;
	public String account;//即客户ID
	public Calendar time;
	public String orderID;
	public Operate action;
	public long creditchange;
	public long currentcredit;
	public CreditRecordVO(String c,String a,Calendar t,String id,Operate act,long cre,long cur){
		cid=c;
		account=a;
		time=t;
		orderID=id;
		action=act;
		creditchange=cre;
		currentcredit=cur;
	}
	
	/**
     * 创建信用记录对象
     * 
     * @return 一个新用户的信用记录
	 * @throws ParseException 
     * @see Object.CreditRecord
     */
	public CreditRecordVO(CreditRecordPO po) throws ParseException {
		cid=po.getID();
		account=po.getUserID();
		time=po.getTime();
		orderID=po.getOrderID();
		action=po.getAction();
		creditchange=po.getCreditchange();
		currentcredit=po.getCurrentcredit();
	}
	
	public Vector<String> getVector(){
		Vector<String> v=new Vector<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time1 = sdf.format(time.getTime());
		v.add(time1);
		v.add(orderID);
		v.add(translate(action));
		v.add(String.valueOf(creditchange));
		v.add(String.valueOf(currentcredit));
		return v;
	}
	private String translate(Operate operate){
		String str="";
		if(operate.equals(Operate.Done)){
			str="执行订单";
		}
		else if(operate.equals(Operate.Appeal)){
			str="订单申诉";
		}
		else if(operate.equals(Operate.Cancel)){
			str="订单撤销";
		}
		else if(operate.equals(Operate.Recharge)){
			str="信用充值";
		}
		else if(operate.equals(Operate.Abnormal)){
			str="订单超时/异常";
		}
		else if(operate.equals(Operate.Delayed)){
			str="订单延时";
		}
		return str;
	}
}

