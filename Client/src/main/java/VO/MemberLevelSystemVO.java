package VO;

import java.util.Vector;

import PO.PromotionPO;

public class MemberLevelSystemVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long credit1;
	public long credit2;
	public long credit3;
	public long credit4;
	public long credit5;
	public double discount1;
	public double discount2;
	public double discount3;
	public double discount4;
	public double discount5;
	public MemberLevelSystemVO(long c1,long c2,long c3,long c4,long c5,double d1,double d2,double d3,double d4,double d5){
		credit1=c1;
		credit2=c2;
		credit3=c3;
		credit4=c4;
		credit5=c5;
		discount1=d1;
		discount2=d2;
		discount3=d3;
		discount4=d4;
		discount5=d5;
	}
	public MemberLevelSystemVO(PromotionPO po){
		
	}
}
