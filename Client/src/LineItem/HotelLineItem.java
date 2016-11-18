package LineItem;

import VO.HotelVO;
/**
 * H单个酒店
 * @author 刘宗侃
 * @version 1.0
 */
public class HotelLineItem {

	HotelVO hotelVO;
	
	/**
	 * 单个酒店
	 * @param h Hotel型，传入酒店对象
	 * @return 单个酒店
	 */
	public HotelLineItem (HotelVO hvo) {
		hotelVO = hvo;
	}
	
	/**
	 * 单个酒店
	 * @return 酒店商圈
	 */
	public String location () {
		return hotelVO.hotelDistrict;	
	}
	
	/**
	 * 单个酒店
	 * @return 酒店名称
	 */
	public String name () {
		return hotelVO.hotelName;	
	}
	
}
