package VO;

import java.util.Vector;

import PO.OrderPO;

public class CommentVO{
	public String comment;
	public int score;
	public String UserID;
	public String OrderID;
	public String HotelID;
	public OrderPO po;
	public CommentVO(String UserID,String OrderID,String HotelID,String comment,int score){
		this.comment=comment;
		this.score=score;
		this.UserID=UserID;
		this.OrderID=OrderID;
		this.HotelID=HotelID;
	}
	public CommentVO(OrderPO order){
		this.comment=order.getComment();
		this.score=order.getScore();
		this.UserID=order.getUserID();
		this.OrderID=order.getOrderNumber();
		this.HotelID=order.getHotelID();
		po=order;
	}
	public void update(){
		po.setComment(comment);
		po.setScore(score);
	}
}
