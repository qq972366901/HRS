package LineItem;

import VO.CreditRecordVO;

public class CreditRecordLineItem {
   CreditRecordVO c;
   public CreditRecordLineItem(CreditRecordVO c){
	   this.c=c;
   }
   public CreditRecordVO getUser(){
	   return c;
   }
}
