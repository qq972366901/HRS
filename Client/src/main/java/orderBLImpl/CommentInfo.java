package orderBLImpl;

import po.OrderPO;

public class CommentInfo implements CommentInfoService{
	public String comment;
	public int score;
	public String UserID;
	public String OrderID;
	public String HotelID;
	public OrderPO po;
	public CommentInfo(String UserID,String OrderID,String HotelID,String comment,int score){
		this.comment=comment;
		this.score=score;
		this.UserID=UserID;
		this.OrderID=OrderID;
		this.HotelID=HotelID;
	}
	public CommentInfo(OrderPO order){
		this.comment=order.getComment();
		this.score=order.getScore();
		this.UserID=order.getUserID();
		this.OrderID=order.getOrderNumber();
		this.HotelID=order.getHotelID();
		po=new OrderPO(order.getUserID(),order.getHotelID(),order.getOrderNumber(),order.getOrderState(),order.getOrderValue(),order.getNumOfPerson(),order.getChild(),order.getRoomType(),order.getRoomNumber(),order.getExpectedCheckIn()
				,order.getExpectedCheckOut(),order.getLatest(),order.getCancel(),order.getgenerationTime(),order.getComment(),order.getScore());
	}
	public void update(){
		po.setComment(comment);
		po.setScore(score);
	}
	public void setComment(String str){
		comment = str;
	}
	public void setscore(int sc){
		score=sc;
	}
	public OrderPO getPO(){
		return po;
	}
}
