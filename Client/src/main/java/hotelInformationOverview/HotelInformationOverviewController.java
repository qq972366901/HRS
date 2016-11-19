package hotelInformationOverview;
import java.util.ArrayList;

import Object.Hotel;
import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService_realize;
public class HotelInformationOverviewController extends HotelBLService_realize{
	/**
     * 显示酒店的详细信息
     * 
     * @param vo HotelVO型，一个酒店的值对象
     * @return boolean型，显示成功则返回true，否则返回false
     * @see bussinesslogic.Hotel
     */
public boolean getroominfo(HotelVO vo) {
		return false;
	}


/**
 * 按价格从低到高显示酒店列表
 * 
 * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
 * @return 一个HotelVO值对象
 * @see bussinesslogic.Hotel
 */
public HotelVO pricesort(ArrayList<Hotel>  ah) {
	HotelVO hv=new HotelVO();
	return hv;
}


/**
 * 按星级从低到高显示酒店列表
 * 
 * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
 * @return 一个HotelVO值对象
 * @see bussinesslogic.Hotel
 */
public HotelVO starsort(ArrayList<Hotel>  ah) {
	HotelVO hv=new HotelVO();
	return hv;
}


/**
 * 按评分从低到高显示酒店列表
 * 
 * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
 * @return 一个HotelVO值对象
 * @see bussinesslogic.Hotel
 */
public HotelVO scoresort(ArrayList<Hotel>  ah) {
	HotelVO hv=new HotelVO();
	return hv;
}
/**
 * 显示客户在酒店的细节以及历史订单
 * 
 * @param vo HotelVO型，一个酒店值对象
 * @return 一个OrderVO值对象
 * @see bussinesslogic.Hotel
 */
public OrderVO gethistoryorder(HotelVO  vo) {
	OrderVO hv=new OrderVO();
	return hv;
}


}
