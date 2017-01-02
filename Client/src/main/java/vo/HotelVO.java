package vo;
import po.HotelPO;

/**
 * 酒店的属性及数据创建与更新
 * @author 刘宗侃
 */
public class HotelVO{

	public String hotelAddress;
	public String hotelDistrict;
	public int hotelStar;
	public String hotelProfile;
	public String hotelService;
	public String hotelName;
	public String hotelAccount;
	public double score;
	public String hotelPhone;
	public String hotelCity;
	
	/**
	 * 酒店数据
	 * @param hpo HotelPO型，数据层传来的酒店
	 * @return
	 */
	public HotelVO(HotelPO hpo) {
		hotelAccount = hpo.gethotelAccount();
		hotelName = hpo.gethotelName();
		hotelAddress = hpo.gethotelAddress();
		hotelService = hpo.gethotelService();
		hotelCity = hpo.gethotelCity();
		hotelDistrict = hpo.gethotelDistrict();
		hotelProfile = hpo.gethotelProfile();
		hotelStar = hpo.gethotelStar();
		hotelPhone=hpo.getHotelPhone();
		score = hpo.getScore();
	}
	
	/**
	 * 酒店数据
	 * @param hAddress String型，逻辑层传来的酒店地址
	 * @param hDistrict String型，逻辑层传来的酒店所在商圈
	 * @param hStar int型，逻辑层传来的酒店星级
	 * @param hProfile String型，逻辑层传来的酒店简介
	 * @param hService String型，逻辑层传来的酒店服务
	 * @param hName String型，逻辑侧传来的酒店名称
	 * @param hAccount String型，逻辑侧传来的酒店账号
	 * @param sco double型，逻辑侧传来的酒店评分
	 * @param phone String型，逻辑层传来的酒店联系方式
	 * @return
	 */

	public HotelVO (String hCity,String hAddress,String hDistrict,int hStar,String hProfile,String hService,String hName,String hAccount,double sco,String phone) {
		hotelCity=hCity;
		hotelAddress=hAddress;
		hotelDistrict=hDistrict;
		hotelStar=hStar;
		hotelProfile=hProfile;
		hotelService=hService;
		hotelName=hName;
		hotelAccount=hAccount;
	    score=sco;
	    hotelPhone=phone;
	}
	
}

