package VO;
import Object.Hotel;

/**
 * 酒店的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Hotel
 */
public class HotelVO extends VO {

	public String hotelAddress;
	public String hotelDistrict;
	public int hotelStar;
	public String hotelProfile;
	public String hotelService;
	public String hotelName;
	public String hotelPhone;
	public String hotelReservation;
	public String hotelAccount;
	public double score;
	
	/**
     * 更新酒店信息
     * 
     * @param hotel Hotel型，一个用来更新数据的酒店对象
     * @return 
     * @see Object.Hotel
     */
	public void update(Hotel hotel) {
		
	}
	
	/**
     * 创建酒店对象
     * 
     * @return 一个新录入的酒店
     * @see Object.Hotel
     */
	public Hotel makeHotel() {
		
		return new Hotel();
	}
	
}

