package po;

import java.io.Serializable;
import java.util.Calendar;

import common.Operate;
/**
 * 信用记录的数据实体
 * @author LZ
 * @version 1.0
 * @see
 */
public class CreditRecordPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String crid;
	private String userID;
	private String orderID;
	private Calendar time;
	private Operate action;
	private long creditchange;
	private long currentcredit;
	/**
	 * 构造信用记录实体
	 * 
	 * @param t String型，逻辑层传来的信用记录时间
	 * @param act Operate型，逻辑层传来的动作
	 * @param ch long型，逻辑层传来的信用变化
	 * @param cu long型，逻辑层传来的当前信用值
	 * 
	 */
	public CreditRecordPO(String recordID,String user,String id,Calendar t,Operate act,long ch,long cu){
		crid=recordID;
		userID=user;
		orderID=id;
		time=t;
		action=act;
		creditchange=ch;
		currentcredit=cu;
	}
	public String getOrderID(){
		return orderID;
	}
	public void setOrderID(String s){
		orderID=s;
	}
	/**
	 * 获取客户账号
	 * @return
	 */
	public String getUserID(){
		return userID;
	}
	/**
	 * 设置客户账号
	 * @param id
	 */
	public void setUserID(String id){
		userID=id;
	}
	/**
	 * 获取ID
	 * @return 返回信用记录ID
	 */
	public String getID(){
		return crid;
	}
	/**
	 * 设置信用记录ID
	 * @param id String型，逻辑层传来的ID
	 */
	public void setID(String id){
		crid=id;
	}
	/**
	 * 获取时间
	 * @param
	 * @return 返回信用记录时间
	 * @throws
	 * @see
	 */
	public Calendar getTime(){
		return time;
	}
	/**
	 * 设置信用记录时间
	 * @param t String型，逻辑层传来的时间
	 * @return
	 * @throws
	 * @see
	 */
	public void setTime(Calendar t){
		time=t;
	}
	/**
	 * 获取行为
	 * @param
	 * @return action Operate型
	 * @throws 返回行为
	 * @see
	 */
	public Operate getAction(){
		return action;
	}
	/**
	 * 设置信用记录的行为
	 * @param act Operate型，逻辑层传来的行为
	 * @return
	 * @throws
	 * @see
	 */
	public void setAction(Operate act){
		action=act;
	}
	/**
	 * 获取信用值变化
	 * @param
	 * @return 返回信用变化
	 * @throws
	 * @see
	 */
	public long getCreditchange(){
		return creditchange;
	}
	/**
	 * 设置信用记录的信用值变化
	 * @param ch long型，逻辑层传来啊的信用变化值
	 * @return
	 * @throws
	 * @see
	 */
	public void setCreditchange(long ch){
		creditchange=ch;
	}
	/**
	 * 获取当前信用值
	 * @param
	 * @return 返回当前信用值
	 * @throws
	 * @see
	 */
	public long getCurrentcredit(){
		return currentcredit;
	}
	/**
	 * 设置信用记录的当前信用值
	 * @param cu long型，逻辑层传来的当前信用值
	 * @return
	 * @throws
	 * @see
	 */
	public void setCurrentcredit(long cu){
		currentcredit=cu;
	}

}
