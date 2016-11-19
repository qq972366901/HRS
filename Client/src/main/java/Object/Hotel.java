package Object;

import LineItem.HotelLineItem;
import List.HotelList;
import List.OrderList;
import List.RoomList;
import VO.HotelVO;
import common.ResultMessage;
/**
 * 酒店
 * @author 刘宗侃
 * @version 1.0
 * @see
 */
public class Hotel {
    
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
    public ResultMessage acountAdmin(HotelVO hvo) {
    	hotelList.addHotelLineItems(new HotelLineItem(hvo));
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

