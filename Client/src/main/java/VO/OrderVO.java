package VO;
import java.sql.Time;
import java.util.Date;
import PO.*;
import Object.Order;

/**
 * 订单的属性及数据创建与更新
 * @author 刘宇翔
 * @version 1.1
 * @see Object.Order
 */

public class OrderVO extends VO {
    public String userID;
    public int userLevel;
    public long credit;
    public String hotelID;
	public String orderNumber;
	public int orderState;
	public int orderValue;
	public int numOfPerson;
	public boolean child;
	public String roomType;
	public int roomNumber;
	public Date expectedCheckIn;
	public Date expectedCheckOut;
	public Date latest;//最晚执行时间
	public Date cancel;//取消时间
	public Date generationTime;//操作时间（生成...）
	public String comment;
	public int score;	
    public OrderVO (String hotelID,int level,long credit,String userid,String oNum, int state, int value, int pnum,boolean ch,String rType, int rNum, Date in, Date out,Date la,Date cal,Date gen, String comm, int sco) {
		this.hotelID=hotelID;
		userLevel=level;
		this.credit=credit;
    	userID=userid;
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
    	this.add(String.valueOf(score));
    }
    public void addcancel(){
    	this.add(String.valueOf(cancel));
    }
    public void addcomment(){
    	this.add(comment);
    }
    public void addlatest(){
    	this.add(String.valueOf(latest));
    }
    public void addgeenerationTim(){
    	this.add(String.valueOf(generationTime));
    }
    public void addexpectedCheckIn(){
    	this.add(String.valueOf(expectedCheckIn));
    }
    public void addexpectedCheckOut(){
    	this.add(String.valueOf(expectedCheckOut));
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
    public void adduserLevel(){
    	this.add(String.valueOf(userLevel));
    }
    public void addcredit(){
    	this.add(String.valueOf(credit));
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
    public OrderVO (HotelPO po1,OrderPO po){
    	hotelID=po1.gethotelName();
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
    public OrderVO (UserPO po1,OrderPO po){
    	userLevel=po1.getLevel();
    	userID=po1.getAccount();
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
    public OrderVO (CreditRecordPO po1,OrderPO po){
    	credit=po1.getCurrentcredit();
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
