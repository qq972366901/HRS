package VO;

import PO.CreditPO;
/**
 * 信用的属性及数据创建
 * @author LZ
 *
 */
public class CreditVO{
	public String customerID;
	public long credit;
	public int level;
	public CreditVO(String id,long cr,int le){
		customerID=id;
		credit=cr;
		level=le;
	}
	
	public CreditVO(CreditPO po) {
		customerID=po.getAccount();
		credit=po.getCredit();
		level=po.getLevel();
	}
}
