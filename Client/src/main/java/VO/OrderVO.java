package VO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import PO.*;
import Object.Order;

/**
 * 订单的属性及数据创建与更新
 * @author 刘宇翔
 * @version 1.1
 * @see Object.Order
 */

public class OrderVO extends  Vector<String>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userID;
    public String hotelID;
    public int userLevel;
    public long credit;
	public String orderNumber;
	public int orderState;
	public int orderValue;
	public int numOfPerson;
	public boolean child;
	public String roomType;
	public int roomNumber;
	public Calendar expectedCheckIn;
	public Calendar expectedCheckOut;
	public Calendar latest;//最晚执行时间
	public Calendar cancel;//取消时间
	public Calendar generationTime;//操作时间（生成...）
	public String comment;
	public int score;	
	/**
	 * 构造订单数据实体
	 * @param number int型，房间数量
	 * @param hotelID String型，酒店账号
	 * @param level int型，客户会员等级
	 * @param credit long型，客户信用值
	 * @param Usid String型，客户编号
	 * @param oNum String型，逻辑层传来的订单编号
	 * @param state int型，逻辑层传来的订单状态
	 * @param value int型，逻辑层传来的订单价值
	 * @param pnum int型，逻辑层传来的人数
	 * @param ch boolean型，逻辑层传来的有无儿童
	 * @param rType String型，逻辑层传来的房间类型
	 * @param rNum int型，逻辑层传来的房间数量
	 * @param in Calendar型，逻辑层传来的预订入住时间
	 * @param out Calendar型，逻辑层传来的预订离开时间
	 * @param la Calendar型，逻辑层传来的最晚执行时间
	 * @param can Calendar型，逻辑层传来的取消时间
	 * @param gen Calendar型，逻辑层传来的订单操作时间
	 * @param comm String型，逻辑层传来的订单评价
	 * @param sco int型，逻辑层传来的订单评分
	 * @return
	 * @throws
	 * @see
	 */
    public OrderVO (String hotelID,String userid,String oNum, int state, int value, int pnum,boolean ch,String rType, int rNum, Calendar in, Calendar out,Calendar la,Calendar cal,Calendar gen, String comm, int sco) {
    	this.hotelID=hotelID;
    	userID=userid;
    	userLevel=0;
    	credit=0;
    	orderNumber = oNum;
		orderState = state;
		orderValue = value;
		numOfPerson=pnum;
		child=ch;
		roomType = rType;
		roomNumber = rNum;
		expectedCheckIn = in;
		expectedCheckOut = out;
		latest=la;
		comment = comm;
		score = sco;
        cancel=cal;
        generationTime=gen;
	}
    public void addscore(){
    	if(score>=0){
    	this.add(String.valueOf(score));
    	}
    	else{
    		this.add("");
    	}
    }
    public void addcancel(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    	this.add(sdf.format(this.cancel));
    }
    public void addcomment(){
    	this.add(comment);
    }
    public void addlatest(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    	this.add(sdf.format(this.latest));
    }
    public void addgeenerationTim(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    	this.add(sdf.format(generationTime));
    }
    public void addexpectedCheckIn(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    	this.add(sdf.format(expectedCheckIn));
    }
    public void addexpectedCheckOut(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    	this.add(sdf.format(expectedCheckOut));
    }
    public void addroomType(){
    	this.add(roomType);
    }
    public void addroomNumber(){
    	this.add(String.valueOf(roomNumber));
    }
    public void addnumOfPerson(){
    	this.add(String.valueOf(numOfPerson));
    }
    public void addchild(){
    	this.add(String.valueOf(child));
    }
    public void adduserID(){
    	this.add(userID);
    }
    public void addhotelID(){
    	this.add(hotelID);
    }
    public void addorderNumber(){
    	this.add(orderNumber);
    }
    public void addorderState(){
    	this.add(String.valueOf(orderState));
    }
    public void addorderValue(){
    	this.add(String.valueOf(orderValue));
    }
    public OrderVO (OrderPO po){
    	userID=po.getUserID();
    	userLevel=0;
    	credit=0;
    	hotelID=po.getHotelID();
		orderNumber=po.getOrderNumber();
		orderState=po.getOrderState();
		orderValue=po.getOrderValue();
		numOfPerson=po.getNumOfPerson();
		child=po.getChild();
		roomType=po.getRoomType();
		roomNumber=po.getRoomNumber();
		expectedCheckIn=po.getExpectedCheckIn();
		expectedCheckOut=po.getExpectedCheckOut();
		latest=po.getLatest();
		cancel=po.getCancel();
		generationTime=po.getgenerationTime();
		comment=po.getComment();
		score=po.getScore();	
    }
    public OrderVO (CreditPO po1,OrderPO po){
    	userID=po.getUserID();
    	userLevel=po1.getLevel();
    	credit=po1.getCredit();
    	hotelID=po.getHotelID();
		orderNumber=po.getOrderNumber();
		orderState=po.getOrderState();
		orderValue=po.getOrderValue();
		numOfPerson=po.getNumOfPerson();
		child=po.getChild();
		roomType=po.getRoomType();
		roomNumber=po.getRoomNumber();
		expectedCheckIn=po.getExpectedCheckIn();
		expectedCheckOut=po.getExpectedCheckOut();
		latest=po.getLatest();
		cancel=po.getCancel();
		generationTime=po.getgenerationTime();
		comment=po.getComment();
		score=po.getScore();	
    }
   
    public OrderVO(){}
	/**
     * 更新订单信息
     * 
     * @param ord Order型，一个用来更新数据的订单对象
     * @return 
     * @see Object.Order
     */
	public void update(OrderVO vo) {
		hotelID=vo.hotelID;
		userID=vo.userID;
		orderNumber=vo.orderNumber;
		orderState=vo.orderState;
		orderValue=vo.orderValue;
		numOfPerson=vo.numOfPerson;
		child=vo.child;
		roomType=vo.roomType;
		roomNumber=vo.roomNumber;
		expectedCheckIn=vo.expectedCheckIn;
		expectedCheckOut=vo.expectedCheckOut;
		latest=vo.latest;
		cancel=vo.cancel;
		generationTime=vo.generationTime;
		comment=vo.comment;
		score=vo.score;	
	}
	
	/**
     * 创建订单对象
     * 
     * @return 一个新下的订单
     * @see Object.Order
     */
	public Order makeOrder() {		
		return new Order();
	}
	
}
