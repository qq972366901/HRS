package PO;

import java.io.Serializable;

/**
 * 信用的数据实体
 * @author LZ
 *
 */
public class CreditPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private long credit;
	private int level;
	public CreditPO(String id,long cr,int le){
		userID=id;
		credit=cr;
		level=le;
	}
	/**
	 * 获取客户账号
	 * @param
	 * @return 返回客户账号
	 * @throws
	 * @see
	 */
	public String getAccount(){
		return userID;
	}
	/**
	 * 设置客户账号
	 * @param ua String型，逻辑层传来的客户账号
	 * @return
	 * @throws
	 * @see
	 */
	public void setAccount(String ua){
		userID=ua;
	}
	/**
	 * 获取客户信用值
	 * @return 返回客户信用值
	 */
	public long getCredit(){
		return credit;
	}
	/**
	 * 设置客户信用值
	 * @param cr
	 */
	public void setCredit(long cr){
		credit=cr;
	}
	/**
	 * 获取客户会员等级
	 * @param
	 * @return 返回客户会员等级
	 * @throws
	 * @see
	 */
	public int getLevel(){
		return level;
	}
	/**
	 * 设置客户会员等级
	 * @param l int型，逻辑层传来的客户会员等级
	 * @return 
	 * @throws
	 * @see
	 */
	public void setLevel(int l){
		level=l;
	}
}
