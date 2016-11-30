package dataHelper;

public interface DataHelperFactory {
	public CreditDataHelper getCreditDataHelper();
	public CreditRecordDataHelper getCreditRecordDataHelper();
	public HotelDataHelper getHotelDataHelper();
	public OrderDataHelper getOrderDataHelper();
	public PromotionDataHelper getPromotionDataHelper();
	public RoomDataHelper getRoomDataHelper();
	public UserDataHelper getUserDataHelper();
}
