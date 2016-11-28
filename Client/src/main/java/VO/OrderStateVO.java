package VO;

import java.util.Calendar;
import java.util.Vector;

import PO.OrderPO;

public class OrderStateVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userID;
    public String hotelID;
	public String orderNumber;
	public int orderState;
	public Calendar expectedCheckIn;
	public Calendar expectedCheckOut;
	public Calendar latest;//最晚执行时间
	public Calendar cancel;//取消时间
	public Calendar generationTime;//操作时间（生成...）
    public OrderPO po;
	public OrderStateVO(OrderPO po){
		userID=po.getUserID();
		hotelID=po.getHotelID();
		orderNumber=po.getOrderNumber();
		orderState=po.getOrderState();
		this.expectedCheckIn=po.getExpectedCheckIn();
		this.expectedCheckOut=po.getExpectedCheckOut();
		this.latest=po.getLatest();
		this.cancel=po.getCancel();
		this.generationTime=po.getgenerationTime();
		this.po=po;
	}
	public void Update(){
		po.setOrderState(orderState);
		po.setExpectedCheckIn(this.expectedCheckIn);
		po.setExpectedCheckOut(this.expectedCheckOut);
		po.setLatest(this.latest);
		po.setcancel(this.cancel);
		po.setgenerationTime(this.generationTime);
	}
}
