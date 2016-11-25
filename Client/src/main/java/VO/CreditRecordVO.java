package VO;
/**
 * 信用记录的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.CreditRecord
 */

public class CreditRecordVO extends VO {

	public String account;
	public String time;
	public String orderID;
	public int action;
	public long creditchange;
	public long currentcredit;
	public CreditRecordVO(String a,String t,String id,int act,long cre,long cur){
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
     * @see Object.CreditRecord
     */
	public CreditRecordVO makeCreditRecord() {
		
		return new CreditRecordVO();
	}
	
}

