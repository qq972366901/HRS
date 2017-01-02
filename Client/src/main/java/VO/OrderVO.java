package vo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import po.*;

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
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addscore(){
    	if(score>0){
    	this.add(String.valueOf(score));
    	}
    	else{
    		this.add("");
    	}
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addcancel(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
    	this.add(sdf.format(this.cancel.getTime()));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addcomment(){
    	this.add(comment);
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addlatest(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	this.add(sdf.format(this.latest.getTime()));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addgeenerationTim(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
    	this.add(sdf.format(generationTime.getTime()));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addexpectedCheckIn(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
    	this.add(sdf.format(expectedCheckIn.getTime()));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addexpectedCheckOut(){
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
    	this.add(sdf.format(expectedCheckOut.getTime()));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addroomType(){
    	this.add(roomType);
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void adddetail(){
    	this.add(roomType+":"+roomNumber+"间");
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addUserInfo(String username){
    	this.add(username);
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addroomNumber(){
    	this.add(String.valueOf(roomNumber));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addnumOfPerson(){
    	this.add(String.valueOf(numOfPerson));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addchild(){
    	this.add(String.valueOf(child));
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void adduserID(){
    	this.add(userID);
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addhotelID(){
    	this.add(hotelID);
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addorderNumber(){
    	this.add(orderNumber);
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addorderState(){
    	if(orderState==1){
    		this.add("已执行");
    	}
    	else if(orderState==2){
    		this.add("未执行");
    	}
    	else if(orderState==3){
    		this.add("异常");
    	}
    	else if(orderState==4){
    		this.add("已撤销");
    	}
    }
    /**
     * 为OrderVO这个Vector添加Object
     */
    public void addorderValue(){
    	this.add(String.valueOf(orderValue));
    }
    /**
     * OrderVO的构造函数
     */
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
	 * 得到向量用于在表格中显示
	 * @return
	 */
	public Vector<String> toVector() {
		Vector<String> v=new Vector<String>();
		//待实现
		return v;
	}
}
