package po;

import java.io.Serializable;
/**
 * 酒店的数据实体
 * @author LZ
 * @version 1.0
 * @see
 */
public class HotelPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String hotelAddress;
	private String hotelCity;
	private String hotelDistrict;
	private int hotelStar;
	private String hotelProfile;
	private String hotelService;
	private String hotelName;
	private String hotelAccount;
	private double score;
	private String hotelPhone;
	/**
	 * 构造酒店数据实体
	 * @param hAddress String型，逻辑层传来的酒店地址
	 * @param hCity String型，酒店所在城市
	 * @param hDistrict String型，逻辑层传来的酒店所在商圈
	 * @param hStar int型，逻辑层传来的酒店星级
	 * @param hProfile String型，逻辑层传来的酒店简介
	 * @param hService String型，逻辑层传来的酒店服务
	 * @param hName String型，逻辑侧传来的酒店名称
	 * @param hAccount String型，逻辑侧传来的酒店账号
	 * @param sco double型，逻辑侧传来的酒店评分
	 * @param phone String型，逻辑层传来的酒店联系方式
	 * @return
	 * @throws
	 * @see
	 */
	public HotelPO (String hAddress,String hCity, String hDistrict,int hStar,String hProfile,String hService,String hName,String hAccount,double sco,String phone) {
		
		hotelAddress=hAddress;
		hotelCity = hCity;
		hotelDistrict=hDistrict;
		hotelStar=hStar;
		hotelProfile=hProfile;
		hotelService=hService;
		hotelName=hName;
		hotelAccount=hAccount;
	    score=sco;
	    hotelPhone=phone;
	}
	/**
	 * 获取酒店地址
	 * @param
	 * @return 返回酒店地址
	 * @throws
	 * @see
	 */
	public String gethotelAddress() {
		return hotelAddress;
	}
	/**
	 * 设置酒店地址
	 * @param hAddress String型，逻辑层传来的酒店地址
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelAddress(String hAddress){
        hotelAddress=hAddress;
    }
	/**
	 * 设置酒店城市
	 * @param hCity String型，逻辑层传来的酒店城市
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelCity(String hCity){
        hotelCity=hCity;
    }
    /**
	 * 获取酒店城市
	 * @param
	 * @return 返回酒店城市
	 * @throws
	 * @see
	 */
	public String gethotelCity() {
		return hotelCity;
	}
    /**
	 * 获取酒店所在商圈
	 * @param
	 * @return 返回酒店所在商圈
	 * @throws
	 * @see
	 */
	public String gethotelDistrict() {
		return hotelDistrict;
	}
	/**
	 * 设置酒店所在商圈
	 * @param hDistrict String型，逻辑层传来的酒店所在商圈
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelDistrict(String hDistrict){
        hotelDistrict=hDistrict;
    }
    /**
	 * 获取酒店星级
	 * @param
	 * @return 返回酒店星级
	 * @throws
	 * @see
	 */
	public int gethotelStar() {
		return hotelStar;
	}
	/**
	 * 设置酒店星级
	 * @param hStar int型，逻辑层传来的酒店星级
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelStar(int hStar){
                hotelStar=hStar;
    }
    /**
	 * 获取酒店简介
	 * @param
	 * @return 返回酒店简介
	 * @throws
	 * @see
	 */
	public String gethotelProfile() {
		return hotelProfile;
	}
	/**
	 * 设置酒店简介
	 * @param hProfile String 型，逻辑层传来的酒店简介
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelProfile(String hProfile){
        hotelProfile=hProfile;
    }
    /**
	 * 获取酒店服务信息
	 * @param
	 * @return 返回酒店服务信息
	 * @throws
	 * @see
	 */
	public String gethotelService(){
		return hotelService;
	}
	/**
	 * 设置酒店服务信息
	 * @param hService String型，逻辑层传来的酒店服务信息
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelService(String hService){
		hotelService=hService;
	}
    /**
	 * 获取酒店名称
	 * @param
	 * @return 返回酒店名称
	 * @throws
	 * @see
	 */
	public String gethotelName() {
		return hotelName;
	}
	/**
	 * 设置酒店名称
	 * @param hName String 型，逻辑层传来的酒店名称
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelName (String hName){
		hotelName=hName;
	}
    /**
	 * 获取酒店评分
	 * @param
	 * @return 返回酒店评分
	 * @throws
	 * @see
	 */
    public double getScore() {
		return score;
	}
    /**
	 *  设置酒店评分
	 * @param sco double 型，逻辑层传来的酒店评分
	 * @return
	 * @throws
	 * @see
	 */
    public void setScore(double sco) {
		score=sco;
	}
    /**
	 * 获取酒店账号
	 * @param
	 * @return 返回酒店账号
	 * @throws
	 * @see
	 */ 
    public String gethotelAccount() {
		return hotelAccount;
	}
    /**
	 *  设置酒店账号
	 * @param hAcc String型，逻辑层传来的酒店账号
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelAccount (String hAcc){
		hotelAccount=hAcc;
	}
    /**
	 * 获取酒店联系电话
	 * @param
	 * @return 返回酒店联系电话
	 */ 
    public String getHotelPhone() {
		return hotelPhone;
	}
    /**
	 *  设置酒店联系电话
	 * @param hPhone String型，逻辑层传来的酒店联系电话
	 * @return
	 */
    public void setHotelPhone (String hPhone){
		hotelPhone = hPhone;
	}
}
