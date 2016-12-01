package promotionHotel;
import java.rmi.RemoteException;
import java.util.Calendar;

import PromotionBLServiceImpl.AddHotelPromotion;
import PromotionBLServiceImpl.SearchHotelPromotion;
import VO.HotelPromotionVO;
import VO.UserVO;
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
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime) throws RemoteException {
		UserVO vo1=Customer.getUserInstance().findByID(userID);
		Calendar birthday=vo1.birthday;
		String membertype=vo1.membertype;
		HotelPromotionVO vo2=SearchHotelPromotion.getSearchHotelPromotionInstance().getHotelPromotion(hotelid,orderbuildtime);
		double discount=vo2.discount;
		if(birthday.compareTo(vo2. promotionBegintime)>=0&&birthday.compareTo(vo2. promotionEndtime)<=0){
			discount=discount*(vo2.birthdayDiscount);
		}
		if(roomNumber>=3){
			discount=discount*(vo2.roomDiscount);
		}
		if(membertype.equals("企业会员")){
			discount=discount*(vo2.enterpriseDiscount);
		}
		return discount;
	}
}
