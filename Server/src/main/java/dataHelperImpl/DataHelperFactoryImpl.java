package dataHelperImpl;

import dataHelper.CreditDataHelper;
import dataHelper.CreditRecordDataHelper;
import dataHelper.DataHelperFactory;
import dataHelper.HotelDataHelper;
import dataHelper.OrderDataHelper;
import dataHelper.PromotionDataHelper;
import dataHelper.RoomDataHelper;
import dataHelper.UserDataHelper;

public class DataHelperFactoryImpl implements DataHelperFactory{

	@Override
	public CreditDataHelper getCreditDataHelper() {
		CreditDataHelper helper=new CreditDataHelperImpl();
		return helper;
	}

	@Override
	public CreditRecordDataHelper getCreditRecordDataHelper() {
		CreditRecordDataHelper helper=new CreditRecordDataHelperImpl();
		return helper;
	}

	@Override
	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper helper=new HotelDataHelperImpl();
		return helper;
	}

	@Override
	public OrderDataHelper getOrderDataHelper() {
		OrderDataHelper helper=new OrderDataHelperImpl();
		return helper;
	}

	@Override
	public PromotionDataHelper getPromotionDataHelper() {
		PromotionDataHelper helper=new PromotionDataHelperImpl();
		return helper;
	}

	@Override
	public RoomDataHelper getRoomDataHelper() {
		RoomDataHelper helper=new RoomDataHelperImpl();
		return helper;
	}

	@Override
	public UserDataHelper getUserDataHelper() {
		UserDataHelper helper=new UserDataHelperImpl();
		return helper;
	}

}
