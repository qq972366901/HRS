package hotelBLService;

import java.util.ArrayList;
import java.util.List;

import Object.Hotel;
import VO.HotelVO;
import VO.OrderVO;
import common.MessageInput;
import common.ResultMessage;

public class HotelBLService_realize implements HotelBLService{
	/**
     * 根据地址和商圈获得范围内的酒店信息
     * 
     * @param hvo HotelVO型，界面传递来的hotel值对象
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Hotel
     */
	public ResultMessage messagelook(HotelVO hvo) {
		return null;
	}
	
	
	/**
     * 根据输入的条件返回符合的酒店列表
     * 
     * @param in MessageInput型，界面输入的条件
     * @return 返回HotelVO的一个列表
     * @see bussinesslogic.Hotel 
     */
	public ArrayList<HotelVO> messagesearch(MessageInput in) {
		return null;
	}
	
	
	/**
     * 查找用户的历史订单的酒店并返回历史酒店列表
     * 
     * @param id String型，客户id
     * @return 返回HotelVO的一个列表
     * @see bussinesslogic.Hotel
     */
	public  ArrayList<HotelVO> historylook(String  id) {
		return null;
	}
	
	
	/**
     * 维护酒店的基本信息，更新酒店数据
     * 
     * @param in MessageInput型，界面输入的修改信息
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Hotel
     */
	public ResultMessage messagemaintain(MessageInput  in) {
		return null;
	}
	
	
	/**
     * 增加酒店账号名称并且创建一个该酒店工作人员的账号
     * 
     * @param in MessageInput型，界面输入的酒店相关信息
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Hotel
     */
	public ResultMessage accuntadmin(MessageInput  in){
		return null;
	}
	
	
	/**
     * 增加该酒店的评分记录，更新评分的均值
     * 
     * @param socre int型，用户对酒店作出的评分
     * @return boolean型，更新成功则返回true，否则返回false
     * @see bussinesslogic.Hotel
     */
	public boolean setscore(int  score){
		return true;
	}
	
	
	/**
     * 增加该酒店下的评价记录
     * 
     * @param cooment String型，用户对酒店作出的评价
     * @return boolean型，更新成功则返回true，否则返回false
     * @see bussinesslogic.Hotel
     */
	public boolean setcomment(String  comment){
		return true;
	}
	
	
	/**
     * 显示酒店的详细信息
     * 
     * @param vo HotelVO型，一个酒店的值对象
     * @return boolean型，显示成功则返回true，否则返回false
     * @see bussinesslogic.Hotel
     */
	public boolean getroominfo(HotelVO vo){
		return true;
	}
	
	
	/**
     * 按价格从低到高显示酒店列表
     * 
     * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
     * @return 一个HotelVO值对象
     * @see bussinesslogic.Hotel
     */
	public HotelVO pricesort(ArrayList<Hotel>  ah) {
		return null;
	}
	
	
	/**
     * 按星级从低到高显示酒店列表
     * 
     * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
     * @return 一个HotelVO值对象
     * @see bussinesslogic.Hotel
     */
	public HotelVO starsort(ArrayList<Hotel>  ah) {
		return null;
	}
	
	
	/**
     * 按评分从低到高显示酒店列表
     * 
     * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
     * @return 一个HotelVO值对象
     * @see bussinesslogic.Hotel
     */
	public HotelVO scoresort(ArrayList<Hotel>  ah) {
		return null;
	}
	
	
	/**
     * 显示客户在酒店的细节以及历史订单
     * 
     * @param vo HotelVO型，一个酒店值对象
     * @return 一个OrderVO值对象
     * @see bussinesslogic.Hotel
     */
	public OrderVO gethistoryorder(HotelVO  vo) {
		return null;
	}
	
	
	/**
     * 显示客户的历史预订酒店
     * 
     * @return 一个ArrayList<HotelVO>，酒店值对象列表
     * @see bussinesslogic.Hotel
     */
	public ArrayList<HotelVO> gethistoryhotel() {
		return null;
	}


	@Override
	public void updateHotelRooms(String id,String roomType, int roomNumber, int roomPrice) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateHotelInfo(String id,String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public HotelVO findByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelVO> getHistoryHotel(String userID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation, int hotelStar,
			String hotelService, String hotelIntroduction, String hotelPhone, String hotelID, double hotelScore) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber, int priceLow,
			int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
