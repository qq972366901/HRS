package LineItem;

import Object.Hotel;

public class HotelLineItem {

	Hotel hotel;
	
	/**
	 * 单个酒店
	 * @param h Hotel型，传入酒店对象
	 * @return 单个酒店
	 */
	public HotelLineItem (Hotel h) {
		hotel = h;
	}
	
	/**
	 * 单个酒店
	 * @return 酒店商圈
	 */
	public String location () {
		return hotel.gethotelDistrict();	
	}
	
	/**
	 * 单个酒店
	 * @return 酒店名称
	 */
	public String name () {
		return hotel.gethotelName();	
	}
	
}
