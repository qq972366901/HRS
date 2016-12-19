package PO;

import java.io.Serializable;
/**
 * 信用记录的数据实体
 * @author LZ
 * @version 1.0
 * @see
 */
public class CreditRecordPO  extends PO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String time;
	private int action;
	private long creditchange;
	private long currentcredit;
	/**
	 * 构造信用记录实体
	 * 
	 * @param t String型，逻辑层传来的信用记录时间
	 * @param act int型，逻辑层传来的动作
	 * @param ch long型，逻辑层传来的信用变化
	 * @param cu long型，逻辑层传来的当前信用值
	 * 
	 */
	public CreditRecordPO(String t,int act,long ch,long cu){
		time=t;
		action=act;
		creditchange=ch;
		currentcredit=cu;
	}
	/**
	 * 获取时间
	 * @param
	 * @return 返回信用记录时间
	 * @throws
	 * @see
	 */
	public String getTime(){
		return time;
	}
	/**
	 * 设置信用记录时间
	 * @param t String型，逻辑层传来的时间
	 * @return
	 * @throws
	 * @see
	 */
	public void setTime(String t){
		time=t;
	}
	/**
	 * 获取行为
	 * @param
	 * @return action int型
	 * @throws 返回行为
	 * @see
	 */
	public int getAction(){
		return action;
	}
	/**
	 * 设置信用记录的行为
	 * @param act int型，逻辑层传来的行为
	 * @return
	 * @throws
	 * @see
	 */
	public void setAction(int act){
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
