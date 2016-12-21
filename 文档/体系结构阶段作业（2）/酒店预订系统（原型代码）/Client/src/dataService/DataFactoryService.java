package dataService;
/**
 * 职责是定义提供数据接口的接口
 * @author LZ
 * @version 1.0
 * @see
 */
public interface DataFactoryService {
	/**
	 * 定义提供客户数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getUserData();
	/**
	 * 定义提供信用记录数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getCreditRecordData();
	/**
	 * 定义提供促销策略数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getPromotionData();
	/**
	 * 定义提供订单数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getOrderData();
	/**
	 * 定义提供酒店数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getHotelData();
	/**
	 * 定义提供房间数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getRoomData();
}
