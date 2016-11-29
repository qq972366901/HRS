package dataHelperImpl;

import java.io.Serializable;

import dataHelper.CreditDataHelper;
import dataHelper.CreditRecordDataHelper;
import dataHelper.DataHelperFactory;

public class DataHelperFactoryImpl implements DataHelperFactory,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CreditDataHelper getCreditDataHelper() {
		CreditDataHelper helper=new CreditDataHelperImpl();
		return helper;
	}

	@Override
	public CreditRecordDataHelper getCreditRecordDataHelper() {
		// TODO Auto-generated method stub
		return null;
	}

}
