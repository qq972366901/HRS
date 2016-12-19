package promotionHotel;
import java.rmi.RemoteException;
import java.util.Calendar;

import PromotionBLServiceImpl.AddHotelPromotion;
import PromotionBLServiceImpl.GetHotelPromotionByHotelIDAndTime;
import PromotionBLServiceImpl.GetHotelPromotionDiscount;
import VO.HotelPromotionVO;
import VO.UserVO;
import VO.WebPromotionVO;
import userBLServiceImpl.Customer;
public class PromotionHotelController {
	  /**
     * 添加一种新的酒店营销策略，并公布
     * 
     * @param vo HotelPromotionVO型，界面输入的营销策略
     * @return
     * @see bussinesslogic.Promotion
     */
	public void madebyhotel (String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount) {
		AddHotelPromotion.getAddHotelPromotionInstance().addHotelPromotion(hotelid,promotionname,promotionbegintime,promotionendtime,promotiondiscount,birthdaydiscount,roomdiscount,enterprisediscount);
	}
	/**
	 * 得到在下订单时客户能获得的酒店营销策略折扣
	 * @throws RemoteException 
     */
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime,Calendar begintime,Calendar endtime) throws RemoteException {
		return GetHotelPromotionDiscount.getGetHotelPromotionDiscountInstance().getHotelPromotionDiscount(hotelid,userID,roomNumber,orderbuildtime,begintime,endtime);
	}
	/**
	 * 通过酒店ID查找酒店策略
     */
	public HotelPromotionVO getHotelPromotionByHotelIDAndTime(String hotelid,Calendar time){
		return GetHotelPromotionByHotelIDAndTime.getHotelPromotionByHotelIDInstance().getHotelPromotionByHotelIDAndTime(hotelid,time);
	}
}
