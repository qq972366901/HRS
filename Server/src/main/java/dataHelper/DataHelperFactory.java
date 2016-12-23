package dataHelper;
/**
 * 工厂模式提供DataHelper
 * @author LZ
 *
 */
public interface DataHelperFactory {
	public CreditDataHelper getCreditDataHelper();
	public CreditRecordDataHelper getCreditRecordDataHelper();
	public HotelDataHelper getHotelDataHelper();
	public OrderDataHelper getOrderDataHelper();
	public PromotionDataHelper getPromotionDataHelper();
	public RoomDataHelper getRoomDataHelper();
	public UserDataHelper getUserDataHelper();
}
