package hotelBLService;

import java.util.List;

import HotelRoomAdd.HotelRoomAddController;
import HotelRoomInfo.HotelRoomInfoController;
import VO.HotelVO;
import VO.OrderVO;
import hotelEverordered.HotelEverorderedController;
import hotelInformationMaintenance.HotelInformationMaintenanceController;
import hotelInformationOverview.HotelInformationOverviewController;
import hotelInformationSearch.HotelInformationSearchController;

/**
 * 负责实现酒店功能的服务接口
 * @author 刘宗侃
 */
public class HotelBLServiceController implements HotelBLService {
	
	HotelRoomAddController hotelRoomAddController;
	HotelInformationMaintenanceController hotelInformationMaintenanceController;
	HotelInformationOverviewController hotelInformationOverviewController;
	HotelEverorderedController hotelEverorderedController;
	HotelInformationSearchController hotelInformationSearchController;
	HotelRoomInfoController hotelRoomInfoController;
	
	public HotelBLServiceController(){
		hotelRoomAddController=new HotelRoomAddController();
		hotelInformationMaintenanceController=new HotelInformationMaintenanceController();
		hotelInformationOverviewController=new HotelInformationOverviewController();
		hotelEverorderedController=new HotelEverorderedController();
		hotelInformationSearchController=new HotelInformationSearchController();
		hotelRoomInfoController = new HotelRoomInfoController();
	}
	/**
     * 更新酒店拥有的房间类型、数量、原始价格
     * 
     * @param id String型，酒店帐号
     * @param roomType String型，房间类型
     * @param roomNumber int型，房间数量
     * @param roomPrice int型，房间原始价格
     * @param roomNNN String型，房间号范围
     */
	public void updateHotelRooms(String id,String roomType, int roomNumber, int roomPrice, String roomNNN) {
		hotelRoomAddController.updateHotelRooms(id,roomType, roomNumber, roomPrice, roomNNN);
	}
	/**
     * 更新酒店的基本信息
     * 
     * @param id String型，酒店帐号
     * @param hotelName String型，酒店名称
     * @param hotelLocation String型，酒店地址
     * @param hotelService String型，酒店设施服务
     * @param hotelCity String型，酒店城市
     * @param hotelArea String型，酒店商圈
     * @param hotelIntroduction String型，酒店简介
     * @param hotelStar int型，酒店星级
     */
	public void updateHotelInfo(String id,String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone){
		hotelInformationMaintenanceController.updateHotelInfo(id, hotelName, hotelLocation, hotelService, hotelCity, hotelArea, hotelIntroduce, hotelStar, hotelPhone);
	}
	/**
     * 根据酒店帐号返回酒店详细信息
     * 
     * @param hotelID String型，酒店帐号
     * @return 返回此酒店的详细信息
     */
	public HotelVO findByHotelID(String hotelID) {
		return hotelInformationOverviewController.findByHotelID(hotelID);
	}
	/**
     * 获得用户的历史酒店
     * @param userID String型，用户帐号
     * @return 返回用户住过的历史酒店列表
     */
	public List<HotelVO> getHistoryHotel(String userID) {
		return hotelEverorderedController.getHistoryHotel(userID);
	}
	/**
     * 网站管理人员添加酒店
     * 
     * @param hotelName String型，酒店名称
     * @param hotelCity String型，酒店城市
     * @param hotelArea String型，酒店商圈
     * @param hotelLocation String型，酒店地址
     * @param hotelStar int型，酒店星级
     * @param hotelService String型，酒店设施服务
     * @param hotelIntroduction String型，酒店简介
     * @param hotelPhone String型，酒店联系电话
     * @param hotelID String型，酒店账号ID
     * @param hotelScore double型，酒店评分
     */
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore) {
		hotelInformationMaintenanceController.saveHotelInfo(hotelName, hotelCity, hotelArea, hoelLocation, hotelStar, hotelService, hotelIntroduction, hotelPhone, hotelID, hotelScore);
	}
	/**
     * 查找符合客户选择条件的酒店列表
     * 
     * @param city String型，酒店城市，若未选择，值为null
     * @param businessCircle String型，商圈，若未选择，值为null
     * @param roomType String型，房型，若未选择，值为null
     * @param roomNumber int型，房间数量，若未选择，值为-1
     * @param priceLow int型，房间最低价格，若未选择，值为-1
     * @param priceHigh int型，房间最高价格，若未选择，值为-1
     * @param hotelStar int型，酒店星级，若未选择，值为-1
     * @param scoreLow int型，搜索选择的最低评分，若未选择，值为-1
     * @param scoreHigh int型，搜索选择的最高评分，若未选择，值为-1
     * @param everBooked String型，选择搜索的范围：全部，预定过，未预定过，若未选择，值为null
     * @param userid String型，客户的id
     * 
     * @return 返回符合条件的酒店ID列表
     */
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid) {
		return hotelInformationSearchController.getHotelID(city, businessCircle, roomType, roomNumber, priceLow, priceHigh, hotelStar, scoreLow, scoreHigh, everBooked, userid);
	}
	/**
     * 网站工作人员更新酒店的联系方式
     * 
     * @param hotelid String型，酒店帐号
     * @param hotelPhone String型，房间类型
     */
	public void updateHotelPhone(String hotelid, String hotelPhone) {
		hotelInformationMaintenanceController.updateHotelPhone(hotelid, hotelPhone);
	}
	/**
     * 订单评价评分后更新酒店评分
     * 
     * @param hotelid String型，酒店帐号
     * @param score double型，订单评分
     */
	public void changeHotelScore(String hotelid, int score) {
		hotelInformationMaintenanceController.changeHotelScore(hotelid, score);
	}
	/**
     * 酒店信息浏览得到酒店平均评分
     * 
     * @param hotelid String型，酒店帐号
     * @return 返回此酒店的平均评分
     */
	public double getHotelScore(String hotelid) {
		return hotelInformationOverviewController.getHotelScore(hotelid);
	}
	
	/**
     * 根据用户id和酒店id查找该用户在该酒店的所有订单
     * 
     * @param String UserID，客户的id
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，客户的订单列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> findByHotelIDAndUserID (String userID,String hotelID){
		return hotelEverorderedController.findByHotelID(userID, hotelID);
	}
	/**
     * 得到酒店的空闲房间的房型列表
     * 
     * @param hotelid String型，酒店帐号
     * @return String型，房型列表
     */
	public List<String> getRoomType(String hotelid) {
		return hotelRoomInfoController.getRoomType(hotelid);
	}
	/**
     * 得到酒店空闲的此房型的剩余数量
     * 
     * @param hotelid String型，酒店帐号
     * @param roomType String型，房间类型
     * @return  int型，订单总的原价
     */
	public int getMaxRoomNumber(String hotelid, String roomType) {
		return hotelRoomInfoController.getMaxRoomNumber(hotelid, roomType);
	}
	/**
     * 得到客户酒店房间订单的总原价
     * 
     * @param hotelid String型，酒店帐号
     * @param roomType String型，房间类型
     * @param roomNumber int型，预定房间数量
     * @return  int型，订单总的原价
     */
	public int getOrderPrice(String hotelid, String roomType, int roomNumber) {
		return hotelRoomInfoController.getOrderPrice(hotelid, roomType, roomNumber);
	}
	
	
	
	
	
	
	//---------------------------------------------------------------------------------
//	/**
//     * 根据地址和商圈获得范围内的酒店信息
//     * 
//     * @param hvo HotelVO型，界面传递来的hotel值对象
//     * @return 返回ResultMessage枚举值中的一项
//     * @see bussinesslogic.Hotel
//     */
//	public ResultMessage messagelook(HotelVO hvo){
//		return ResultMessage.Exist;
//	}
//	
//	
//	/**
//     * 根据输入的条件返回符合的酒店列表
//     * 
//     * @param in MessageInput型，界面输入的条件
//     * @return 返回HotelVO的一个列表
//     * @see bussinesslogic.Hotel 
//     */
//	public ArrayList<HotelVO> messagesearch(MessageInput in){
//		return new ArrayList<HotelVO>();
//	}
//	
//	
//	/**
//     * 查找用户的历史订单的酒店并返回历史酒店列表
//     * 
//     * @param id String型，客户id
//     * @return 返回HotelVO的一个列表
//     * @see bussinesslogic.Hotel
//     */
//	public  ArrayList<HotelVO> historylook(String  id){
//		return new ArrayList<HotelVO>();
//	}
//	
//	
//	/**
//     * 维护酒店的基本信息，更新酒店数据
//     * 
//     * @param in MessageInput型，界面输入的修改信息
//     * @return 返回ResultMessage枚举值中的一项
//     * @see bussinesslogic.Hotel
//     */
//	public ResultMessage messagemaintain(MessageInput  in){
//		return ResultMessage.Exist;
//	}
//	
//	
//	/**
//     * 增加酒店账号名称并且创建一个该酒店工作人员的账号
//     * 
//     * @param in MessageInput型，界面输入的酒店相关信息
//     * @return 返回ResultMessage枚举值中的一项
//     * @see bussinesslogic.Hotel
//     */
//	public ResultMessage accuntadmin(MessageInput  in){
//		return ResultMessage.Exist;
//	}
//	
//	
//	/**
//     * 增加该酒店的评分记录，更新评分的均值
//     * 
//     * @param socre int型，用户对酒店作出的评分
//     * @return boolean型，更新成功则返回true，否则返回false
//     * @see bussinesslogic.Hotel
//     */
//	public boolean setscore(int  score){
//		return true;
//	}
//	
//	/**
//     * 增加该酒店下的评价记录
//     * 
//     * @param cooment String型，用户对酒店作出的评价
//     * @return boolean型，更新成功则返回true，否则返回false
//     * @see bussinesslogic.Hotel
//     */
//	public boolean setcomment(String  comment){
//		return true;
//	}
//	
//	
//	/**
//     * 显示酒店的详细信息
//     * 
//     * @param vo HotelVO型，一个酒店的值对象
//     * @return boolean型，显示成功则返回true，否则返回false
//     * @see bussinesslogic.Hotel
//     */
//	public boolean getroominfo(HotelVO vo){
//		return true;
//	}
//	
//	
//	/**
//     * 按价格从低到高显示酒店列表
//     * 
//     * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
//     * @return 一个HotelVO值对象
//     * @see bussinesslogic.Hotel
//     */
//	public HotelVO pricesort(ArrayList<Hotel>  ah){
//		return new HotelVO();
//	}
//	
//	
//	/**
//     * 按星级从低到高显示酒店列表
//     * 
//     * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
//     * @return 一个HotelVO值对象
//     * @see bussinesslogic.Hotel
//     */
//	public HotelVO starsort(ArrayList<Hotel>  ah){
//		return new HotelVO();
//	}
//	
//	
//	/**
//     * 按评分从低到高显示酒店列表
//     * 
//     * @param ah ArrayList<Hotel>型，一个酒店值对象的列表
//     * @return 一个HotelVO值对象
//     * @see bussinesslogic.Hotel
//     */
//	public HotelVO scoresort(ArrayList<Hotel>  ah){
//		return new HotelVO();
//	}
//	
//	
//	/**
//     * 显示客户在酒店的细节以及历史订单
//     * 
//     * @param vo HotelVO型，一个酒店值对象
//     * @return 一个OrderVO值对象
//     * @see bussinesslogic.Hotel
//     */
//	public OrderVO gethistoryorder(HotelVO  vo){
//		return new OrderVO();
//	}
//	
//	
//	/**
//     * 显示客户的历史预订酒店
//     * 
//     * @return 一个ArrayList<HotelVO>，酒店值对象列表
//     * @see bussinesslogic.Hotel
//     */
//	public ArrayList<HotelVO> gethistoryhotel(){
//		return new ArrayList<HotelVO>();
//	}


}
