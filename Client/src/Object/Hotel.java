package Object;

import java.io.Serializable;

import LineItem.HotelLineItem;
import List.HotelList;
import List.OrderList;
import List.RoomList;
import common.ResultMessage;
/**
 * 酒店
 * @author LZ
 * @version 1.0
 * @see
 */
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String hotelAddress;
	private String hotelDistrict;
	private int hotelStar;
	private String hotelProfile;
	private String hotelService;
	private String hotelName;
	private String hotelPhone;
	private String hotelReservation;
	private String hotelAccount;
	private double score;
	/**
	 * 构造酒店数据实体
	 * @param hAddress String型，逻辑层传来的酒店地址
	 * @param hDistrict String型，逻辑层传来的酒店所在商圈
	 * @param hStar int型，逻辑层传来的酒店星级
	 * @param hProfile String型，逻辑层传来的酒店简介
	 * @param hService String型，逻辑层传来的酒店服务
	 * @param hName String型，逻辑侧传来的酒店名称
	 * @param hPhone String型，逻辑侧传来的酒店
	 * @param hReservation String型，逻辑侧传来的酒店预订状态
	 * @param hAccount String型，逻辑侧传来的酒店账号
	 * @param sco double型，逻辑侧传来的酒店评分
	 * @return
	 * @throws
	 * @see
	 */
	public Hotel (String hAddress,String hDistrict,int hStar,String hProfile,String hService,String hName,String hPhone,String hReservation,String hAccount,double sco) {
		
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
	 * 构造酒店数据实体
	 * @return
	 */
	public Hotel () {
		
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
	 * 获取酒店联系方式
	 * @param
	 * @return 返回酒店联系方式
	 * @throws
	 * @see
	 */
	public String gethotelPhone() {
		return hotelPhone;
	}
	/**
	 * 设置酒店联系方式
	 * @param hPhone String型，逻辑层传来的酒店联系方式
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelPhone (String hPhone){
		hotelPhone=hPhone;
	}
    /**
	 * 获取酒店预订状态
	 * @param
	 * @return 返回酒店状态
	 * @throws
	 * @see
	 */
	public String gethotelReservation() {
		return hotelReservation;
	}
	/**
	 * 设置酒店状态
	 * @param hReservation String型，逻辑层传来的酒店状态
	 * @return
	 * @throws
	 * @see
	 */
    public void sethotelReservation (String hReservation){
		hotelReservation=hReservation;
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
    
    
    private HotelList hotelList;
    private RoomList roomList;
    private OrderList orderList;
    /**
   	 * 获得房间列表
   	 * @param rl RoomList型，对应的房间列表
   	 * @return
   	 */
    public void addRoomList(RoomList rl) {
    	roomList = rl;
    }
    /**
   	 * 获得订单列表
   	 * @param ol OrderList型，对应的订单列表
   	 * @return
   	 */
    public void addOrderList(OrderList ol) {
    	orderList = ol;
    }
    /**
   	 * 获得房间列表
   	 * @param rl RoomList型，对应的房间列表
   	 * @return
   	 */
    public void addHotelList(HotelList hl) {
    	hotelList = hl;
    }
    /**
   	 * 添加酒店帐号
   	 * @param h Hotel型，要添加的酒店
   	 * @return 添加结果
   	 */
    public ResultMessage acountAdmin(Hotel h) {
    	hotelList.addHotelLineItems(new HotelLineItem(h));
    	return ResultMessage.Exist;
    }
    /**
   	 * 得到客户的历史预定酒店
   	 * @return 酒店个数
   	 */
    public int getHistoryHotel() {
    	return hotelList.getHotel();
    }
    /**
   	 * 得到客户的历史预定订单
   	 * @return 订单个数
   	 */
    public int getHistoryOrder() {
    	return orderList.getOrder();
    }
    /**
   	 * 得到客户的房间信息
   	 * @return 房间个数
   	 */
    public int getRoomInfo() {
    	return roomList.getRoomInfo();
    }
    /**
   	 * 查找符合条件的酒店
   	 * @param location String型，酒店商圈
   	 * @return 符合条件的酒店个数
   	 */
    public int messageLook(String location) {
    	return hotelList.messageLook(location);
    }
    /**
   	 * 维护酒店信息
   	 * @param h Hotel型，酒店的新的数据
   	 * @return 更改后的结果
   	 */
    public ResultMessage messageMaintain(Hotel h) {
    	return hotelList.messageMaintain(h);
    }
    /**
	 * 搜索酒店
	 * @param name String型，酒店名称
	 * @return 返回酒店数量
	 */
    public int messageSearch(String name) {
    	return hotelList.messageSearch(name);
    }
    /**
	 * 按价格给酒店排序
	 * @return 返回排序结果
	 */
    public ResultMessage priceSort() {
    	return hotelList.priceSort();
    }
    /**
	 * 按评分给酒店排序
	 * @return 返回排序结果
	 */
    public ResultMessage scoreSort() {
    	return hotelList.scoreSort();
    }
    /**
	 * 按星级给酒店排序
	 * @return 返回排序结果
	 */
    public ResultMessage starSort() {
    	return hotelList.starSort();
    }
    /**
	 * 给酒店评价
	 * @param comment String型，评论内容
	 * @return 返回评价结果
	 */
    public ResultMessage setComment(String comment) {
    	return hotelList.setComment(comment);
    }
    /**
	 * 给酒店评分
	 * @param score int型，评分
	 * @return 返回评分结果
	 */
    public ResultMessage setScore(int score) {
    	return hotelList.setScore(score);
    }
    
    
    

}

