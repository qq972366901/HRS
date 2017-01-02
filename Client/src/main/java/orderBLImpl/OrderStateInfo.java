package orderBLImpl;

import java.util.Calendar;

import po.OrderPO;

public class OrderStateInfo implements OrderStateInfoService{
	/**
	 * 
	 */
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
	public OrderStateInfo(OrderPO po){
		userID=po.getUserID();
		hotelID=po.getHotelID();
		orderNumber=po.getOrderNumber();
		orderState=po.getOrderState();
		this.expectedCheckIn=po.getExpectedCheckIn();
		this.expectedCheckOut=po.getExpectedCheckOut();
		this.latest=po.getLatest();
		this.cancel=po.getCancel();
		this.generationTime=po.getgenerationTime();
		this.po=new OrderPO(po.getUserID(),po.getHotelID(),po.getOrderNumber(),po.getOrderState(),po.getOrderValue(),po.getNumOfPerson(),po.getChild(),po.getRoomType(),po.getRoomNumber(),po.getExpectedCheckIn()
				,po.getExpectedCheckOut(),po.getLatest(),po.getCancel(),po.getgenerationTime(),po.getComment(),po.getScore());
	}
	public void Update(){
		po.setOrderState(orderState);
		po.setExpectedCheckIn(this.expectedCheckIn);
		po.setExpectedCheckOut(this.expectedCheckOut);
		po.setLatest(this.latest);
		po.setcancel(this.cancel);
		po.setgenerationTime(this.generationTime);
	}
	public void setOrderState(int i){
		orderState=i;
	}
	public void setIn(Calendar time){
		expectedCheckIn=time;
	}
	public void setOut(Calendar time){
		expectedCheckOut=time;
	}
	public void setLatest(Calendar time){
		latest=time;
	}
	public void setCancel(Calendar time){
		cancel=time;
	}
	public void setGen(Calendar time){
		generationTime=time;
	}
	public OrderPO getPO(){
		return po;
	}
	public Calendar getLatest(){
		return latest;
	}
}
