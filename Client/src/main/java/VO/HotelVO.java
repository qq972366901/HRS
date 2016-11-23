package VO;

/**
 * 酒店的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Hotel
 */
public class HotelVO extends VO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String hotelAddress;
	public String hotelDistrict;
	public String hotelCity;
	public int hotelStar;
	public String hotelProfile;
	public String hotelService;
	public String hotelName;
	public String hotelPhone;
	public String hotelReservation;
	public String hotelAccount;
	public double score;
	public HotelVO(){};
	public HotelVO(String id){
		hotelName=id;
	}
	/**
	 * 酒店数据
	 * @param hCity String型，逻辑层传来的酒店所在城市
	 * @param hAddress String型，逻辑层传来的酒店地址
	 * @param hDistrict String型，逻辑层传来的酒店所在商圈
	 * @param hStar int型，逻辑层传来的酒店星级
	 * @param hProfile String型，逻辑层传来的酒店简介
	 * @param hService String型，逻辑层传来的酒店服务
	 * @param hName String型，逻辑侧传来的酒店名称
	 * @param hPhone String型，逻辑侧传来的酒店联系方式
	 * @param hReservation String型，逻辑侧传来的酒店预订状态
	 * @param hAccount String型，逻辑侧传来的酒店账号
	 * @param sco double型，逻辑侧传来的酒店评分
	 * @return
	 * @throws
	 * @see
	 */
	public HotelVO (String hCity,String hAddress,String hDistrict,int hStar,String hProfile,String hService,String hName,String hPhone,String hReservation,String hAccount,double sco) {
		hotelCity=hCity;
		hotelAddress=hAddress;
		hotelDistrict=hDistrict;
		hotelStar=hStar;
		hotelProfile=hProfile;
		hotelService=hService;
		hotelName=hName;
		hotelPhone=hPhone;
		hotelReservation=hReservation;
		hotelAccount=hAccount;
	    score=sco;
	}
	/**
     * 更新酒店信息
     * 
     * @param hotel Hotel型，一个用来更新数据的酒店对象
     * @return 
     * @see Object.Hotel
     */
	public void update(HotelVO hotel) {
		
	}
}

