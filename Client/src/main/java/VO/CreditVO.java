package VO;

import java.util.Vector;

import PO.UserPO;
/**
 * 信用的属性及数据创建
 * @author LZ
 *
 */
public class CreditVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String customerID;
	public long credit;
	public int level;
	public CreditVO(String id,long cr,int le){
		customerID=id;
		credit=cr;
		level=le;
	}
	public CreditVO(UserPO po){
		
	}
}
