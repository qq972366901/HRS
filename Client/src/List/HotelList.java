package List;

import java.util.*;

import LineItem.HotelLineItem;
import Object.Hotel;
import common.ResultMessage;

public class HotelList {

	List<HotelLineItem> hotels;
	
	/**
	 * 酒店列表
	 * @param
	 * @return
	 */
	public HotelList () {
		
		hotels = new ArrayList<HotelLineItem>();
		
	}
	
	/**
	 * 添加单个酒店
	 * @param hli HotelLineItem型，添加的单个酒店 
	 * @return 
	 */
	public void addHotelLineItems(HotelLineItem  hli) {
		hotels.add(hli);
	}
	
	/**
	 * 得到酒店
	 * @param
	 * @return 返回酒店
	 */
	public int getHotel() {
		return hotels.size();
	}
	
	/**
	 * 得到符合条件的酒店
	 * @param
	 * @return 返回酒店个数
	 */
	public int messageLook(String location) {
		int num = 0;
		for(int i=0;i<hotels.size();i++) {
			if(hotels.get(i).location().equals(location)) {
				num++;
			}
		}
		return num;
	}

	/**
	 * 维护酒店信息
	 * @param h Hotel型，新的酒店数据
	 * @return 返回酒店更新结果
	 */
	public ResultMessage messageMaintain(Hotel h) {
		return ResultMessage.Exist;
	}
	
	/**
	 * 搜索酒店
	 * @param name String型，酒店名称
	 * @return 返回酒店数量
	 */
	public int messageSearch(String name) {
		int num = 0;
		for(int i=0;i<hotels.size();i++) {
			if(hotels.get(i).name().contains(name)) {
				num++;
			}
		}
		return num;
	}

	/**
	 * 按价格给酒店排序
	 * @return 返回排序结果
	 */
	public ResultMessage priceSort() {
		return ResultMessage.Exist;
	}
	
	/**
	 * 按评分给酒店排序
	 * @return 返回排序结果
	 */
	public ResultMessage scoreSort() {
		return ResultMessage.Exist;
	}
	
	/**
	 * 按星级给酒店排序
	 * @return 返回排序结果
	 */
	public ResultMessage starSort() {
		return ResultMessage.Exist;
	}

	/**
	 * 给酒店评价
	 * @param comment String型，评论内容
	 * @return 返回评价结果
	 */
	public ResultMessage setComment(String comment) {
		return ResultMessage.Exist;
	}
	
	/**
	 * 给酒店评分
	 * @param score int型，评分
	 * @return 返回评分结果
	 */
	public ResultMessage setScore(int score) {
		return ResultMessage.Exist;
	}
	
}
