package Mock;

import java.sql.Time;
import java.util.Calendar;

import Object.Order;
import VO.OrderVO;
/**
 * MockOrder
 * @author 刘宇翔
 * @version 1.0
 * @see
 */
public class MockOrder extends OrderVO{
		private static final long serialVersionUID = 1L;
		/**
		 * 构造订单数据实体
		 * @param oNum String型，逻辑层传来的订单编号
		 * @param userID String型，逻辑层传来的用户标号
		 * @param hotelID String型，逻辑层传来的酒店id
		 * @param state int型，逻辑层传来的订单状态
		 * @param value int型，逻辑层传来的订单价值
		 * @param pnum int型，逻辑层传来的人数
		 * @param ch boolean型，逻辑层传来的有无儿童
		 * @param rType String型，逻辑层传来的房间类型
		 * @param rNum int型，逻辑层传来的订购数量
		 * @param in Calendar型，逻辑层传来的预订入住时间
		 * @param out Calendar型，逻辑层传来的预订离开时间
		 * @param la Calendar型，逻辑层传来的最晚执行时间
		 * @param can Calendar型，逻辑层传来的取消时间
		 * @param gen Calendar型，逻辑层传来的操作时间
		 * @param comm String型，逻辑层传来的订单评价
		 * @param sco int型，逻辑层传来的订单评分
		 * @return
		 * @throws
		 * @see
		 */
		public MockOrder (String hotelID,String userid,String oNum, int state, int value, int pnum,boolean ch,String rType, int rNum, Calendar in, Calendar out,Calendar la ,Calendar can,Calendar gen,String comm, int sco) {
			userID=userid;
			this.hotelID=hotelID;
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
			cancel=can;
			generationTime=gen;
			comment = comm;
			score = sco;

		}
		/**
		 * 构造订单数据实体
		 * @param oNum String型，逻辑层传来的订单编号
		 * @param level int型，逻辑层传来的客户等级
		 * @param credit long型，逻辑层传来的客户信用值
		 * @param userID String型，逻辑层传来的用户标号
		 * @param hotelID String型，逻辑层传来的酒店id
		 * @param state int型，逻辑层传来的订单状态
		 * @param value int型，逻辑层传来的订单价值
		 * @param pnum int型，逻辑层传来的人数
		 * @param ch boolean型，逻辑层传来的有无儿童
		 * @param rType String型，逻辑层传来的房间类型
		 * @param rNum int型，逻辑层传来的订购数量
		 * @param in Calendar型，逻辑层传来的预订入住时间
		 * @param out Calendar型，逻辑层传来的预订离开时间
		 * @param la Calendar型，逻辑层传来的最晚执行时间
		 * @param can Calendar型，逻辑层传来的取消时间
		 * @param gen Calendar型，逻辑层传来的操作时间
		 * @param comm String型，逻辑层传来的订单评价
		 * @param sco int型，逻辑层传来的订单评分
		 * @return
		 * @throws
		 * @see
		 */
		public MockOrder (String hotelID,int level,long credit,String userid,String oNum, int state, int value, int pnum,boolean ch,String rType, int rNum, Calendar in, Calendar out,Calendar la ,Calendar can,Calendar gen,String comm, int sco) {
			userID=userid;
			this.userLevel=level;
			this.credit=credit;
			this.hotelID=hotelID;
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
			cancel=can;
			generationTime=gen;
			comment = comm;
			score = sco;

		}
		/**
		 * 获取订单编号
		 * @param
		 * @return 返回订单编号
		 * @throws
		 * @see
		 */
		public String getOrderNumber() {
			return orderNumber;
		}
		/**
		 * 获取订单状态
		 * @param
		 * @return 返回订单状态
		 * @throws
		 * @see
		 */
		public int getOrderState() {
			return orderState;
		}
		/**
		 * 获取订单价值
		 * @param
		 * @return 返回订单价值
		 * @throws
		 * @see
		 */
		public int getOrderValue() {
			return orderValue;
		}
		/**
		 * 获取人数
		 * @param
		 * @return 返回人数
		 * @throws
		 * @see
		 */
		public int getNumOfPerson(){
			return numOfPerson;
		}
		/**
		 * 获取有无儿童
		 * @param
		 * @return 返回有无儿童
		 * @throws
		 * @see
		 */
		public boolean getChild(){
			return child;
		}
		/**
		 * 获取房间类型
		 * @param
		 * @return 返回房间类型
		 * @throws
		 * @see
		 */
		public String getRoomType() {
			return roomType;
		}
		/**
		 * 获取订购数量
		 * @param
		 * @return 返回订购数量
		 * @throws
		 * @see
		 */
		public int getRoomNumber() {
			return roomNumber;
		}
		/**
		 * 获取预订入住时间
		 * @param
		 * @return 返回预订入住时间
		 * @throws
		 * @see
		 */
		public Calendar getExpectedCheckIn() {
			return expectedCheckIn;
		}
		/**
		 * 获取预订离开时间
		 * @param
		 * @return 返回预订离开时间
		 * @throws
		 * @see
		 */
		public Calendar getExpectedCheckOut() {
			return expectedCheckOut;
		}
		/**
		 * 获取最晚执行时间
		 * @param
		 * @return 返回最晚执行时间
		 * @throws
		 * @see
		 */
		public Calendar getLatest(){
			return latest;
		}
		/**
		 * 获取订单评价
		 * @param
		 * @return 返回订单评价
		 * @throws
		 * @see
		 */
		public String getComment() {
			return comment;
		}
		/**
		 * 获取订单评分
		 * @param
		 * @return 返回订单评分
		 * @throws
		 * @see
		 */
		public int getScore() {
			return score;
		}
		/**
		 * 设置订单编号
		 * @param oNum String型，逻辑层传来的订单编号
		 * @return
		 * @throws
		 * @see
		 */
		public void setOrderNumber(String oNum) {
			orderNumber = oNum;

		}
		/**
		 * 设置订单状态
		 * @param state int型，逻辑层传来的订单状态
		 * @return
		 * @throws
		 * @see
		 */
		public void setOrderState(int state) {
			orderState = state;
		}

		/**
		 * 设置订单价值
		 * @param value int型，逻辑层传来的订单价值
		 * @return
		 * @throws
		 * @see
		 */
		public void setOrderValue(int value) {
			orderValue = value;
		}
		/**
		 * 设置人数
		 * @param pnum int型，逻辑层传来的人数
		 * @return
		 * @throws
		 * @see
		 */
		public void setNumOfPerson(int num){
			numOfPerson=num;
		}
		/**
		 * 设置有无儿童
		 * @param ch boolean型，逻辑层传来的有无儿童
		 * @return
		 * @throws
		 * @see
		 */
		public void setChild(boolean ch){
			child=ch;
		}
		/**
		 * 设置房间类型
		 * @param rType String型，逻辑层传来的房间类型
		 * @return
		 * @throws
		 * @see
		 */
		public void setRoomType(String rType) {
			roomType = rType;
		}
		/**
		 * 设置订购数量
		 * @param rNum int型，逻辑层传来的订购数量
		 * @return
		 * @throws
		 * @see
		 */
		public void setRoomNumber(int rNum) {
			roomNumber = rNum;
		}
		/**
		 * 设置预订入住时间
		 * @param in Time型，逻辑层传来的预订入住时间
		 * @return
		 * @throws
		 * @see
		 */
		public void setExpectedCheckIn(Calendar in) {
			expectedCheckIn = in;
		}
		/**
		 * 设置最晚执行时间
		 * @param la Time型，逻辑层传来的最晚执行时间
		 * @return
		 * @throws
		 * @see
		 */
		public void setLatest(Calendar la){
			latest=la;
		}
		/**
		 * 设置预订入住时间
		 * @param out Time型，逻辑层传来的预订离开时间
		 * @return
		 * @throws
		 * @see
		 */
		public void setExpectedCheckOut(Calendar out) {
			expectedCheckOut = out;
		}
		/**
		 * 设置订单评价
		 * @param comm String型，逻辑层传来的订单评价
		 * @return
		 * @throws
		 * @see
		 */
		public void setComment(String comm) {
			comment = comm;
		}
		/**
		 * 设置订单评分
		 * @param sco int型，逻辑层传来的订单评分
		 * @return
		 * @throws
		 * @see
		 */
		public void setScore(int sco) {
			score = sco;
		}
		/**
		 * 获取取消时间
		 * @param
		 * @return 返回取消时间
		 * @throws
		 * @see
		 */
		public Calendar getCancel() {
			return cancel;
		}
		/**
		 * 获取操作时间
		 * @param
		 * @return 返回操作时间
		 * @throws
		 * @see
		 */
		public Calendar getgenerationTime() {
			return generationTime;
		}
		/**
		 * 设置取消时间
		 * @param can Calendar型，逻辑层传来的取消时间
		 * @return
		 * @throws
		 * @see
		 */
		public void setcancel(Calendar can) {
			cancel = can;
		}
		/**
		 * 设置操作时间
		 * @param gen Calendar型，逻辑层传来的操作时间
		 * @return
		 * @throws
		 * @see
		 */
		public void setgenerationTime(Calendar gen) {
			generationTime = gen;
		}
		/**
		 * 获取客户信用值
		 * @param
		 * @return 返回客户信用值
		 * @throws
		 * @see
		 */
		public long getcredit() {
			return credit;
		}
		/**
		 * 获取客户等级
		 * @param
		 * @return 返回客户等级
		 * @throws
		 * @see
		 */
		public int getlevel() {
			return userLevel;
		}
		/**
		 * 设置客户信用值
		 * @param can long型，逻辑层传来的信用值总额
		 * @return
		 * @throws
		 * @see
		 */
		public void setcredit(long can) {
			credit = can;
		}
		/**
		 * 设置客户登记
		 * @param gen long型，逻辑层传来的客户等级
		 * @return
		 * @throws
		 * @see
		 */
		public void setlevel(int gen) {
			userLevel = gen;
		}
}
