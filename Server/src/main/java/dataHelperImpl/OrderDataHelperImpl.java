package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import PO.OrderPO;
import dataHelper.OrderDataHelper;

public class OrderDataHelperImpl implements OrderDataHelper{
	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	private Connection dbConn;
	private void init() {
		driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=HRS";
		userName="sa";
		userPwd="123456";
		try{
			 Class.forName(driverName);
			 dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			 System.out.println("连接数据库成功");
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.print("连接失败");
		 }
	}
	private void finish(){
		if(dbConn!=null){
			try {
				dbConn.close();
				System.out.print("关闭成功");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.print("关闭失败");
			}
		}
	}
	@Override
	public void insert(OrderPO po) {
		init();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String in = sdf.format(po.getExpectedCheckIn().getTime());
		String out = sdf.format(po.getExpectedCheckOut().getTime());
		String late = sdf.format(po.getLatest().getTime());
		String cancel = sdf.format(po.getCancel().getTime());
		String gen = sdf.format(po.getgenerationTime().getTime());
		String sql="insert into [Order] values('"+po.getUserID()+"','"+po.getHotelID()+"','"+po.getOrderNumber()+"','"+po.getOrderState()+"','"+po.getOrderValue()+"','"+po.getNumOfPerson()+"','"+po.getChild()+"','"+po.getRoomType()+"','"+po.getRoomNumber()+"','"+in+"','"+out+"','"+late+"','"+cancel+"','"+gen+"','"+po.getComment()+"','"+po.getScore()+"')";
		try {
			Statement st=dbConn.createStatement();
			int res=st.executeUpdate(sql);
			if(res==1){
				System.out.println("插入成功");
			}
			else{
				System.out.println("插入失败");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("插入失败");
			e.printStackTrace();
		}
		finish();
	}

	@Override
	public void update(OrderPO po) {
		init();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String in = sdf.format(po.getExpectedCheckIn().getTime());
		String out = sdf.format(po.getExpectedCheckOut().getTime());
		String late = sdf.format(po.getLatest().getTime());
		String cancel = sdf.format(po.getCancel().getTime());
		String gen = sdf.format(po.getgenerationTime().getTime());
		String sql="update [Order] set UserID = '"+po.getUserID()+"',HotelID = '"+po.getHotelID()+"',orderState = '"+po.getOrderState()+"',orderValue = '"+po.getOrderValue()+"',numOfPerson = '"+po.getNumOfPerson()+"',child = '"+po.getChild()+"',roomType = '"+po.getRoomType()+"',roomNumber = '"+po.getRoomNumber()+"',expectedCheckIn = '"+in+"',expectedCheckOut = '"+out+"',latest = '"+late+"',cancel = '"+cancel+"',generationTime = '"+gen+"',comment = '"+po.getComment()+"',score = '"+po.getScore()+"'where orderNumber = '"+po.getOrderNumber()+"'";
		try {
			Statement st=dbConn.createStatement();
			int res=st.executeUpdate(sql);
			if(res==1){
				System.out.println("更新成功");
			}
			else{
				System.out.println("更新失败");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("更新失败");
			e.printStackTrace();
		}
		finish();
	}

	@Override
	public ArrayList<OrderPO> getAllUser() {
		ArrayList<OrderPO> list=new ArrayList<OrderPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Order]");
			while(rs.next()){
				String userid=rs.getString("UserID");
				String hotelid=rs.getString("HotelID");
				String number=rs.getString("orderNumber");
				int orderstate=rs.getInt("orderState");
				int value=rs.getInt("orderValue");
				int person=rs.getInt("numOfPerson");
				boolean child=rs.getBoolean("child");
				String type=rs.getString("roomType");
				int roomnums=rs.getInt("roomNumber");
				Calendar in=trans(rs.getString("expectedCheckIn"));
				Calendar out=trans(rs.getString("expectedCheckOut"));
				Calendar late=trans(rs.getString("latest"));
				Calendar cancel=trans(rs.getString("cancel"));
				Calendar gen=trans(rs.getString("generationTime"));
				String comment=rs.getString("comment");
				int score=rs.getInt("score");
				OrderPO po=new OrderPO(userid,hotelid,number,orderstate,value,person,child,type,roomnums,in,out,late,cancel,gen,comment,score);
				list.add(po);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("读取失败");
			e.printStackTrace();
		}
		finish();
		return list;
	}
	@Override
	public void delete(OrderPO po) {
		init();
		String sql="delete from [Order] where orderNumber='"+po.getOrderNumber()+"'";
		try {
			Statement st=dbConn.createStatement();
			int res=st.executeUpdate(sql);
			if(res==1){
				System.out.println("删除成功");
			}
			else{
				System.out.println("删除失败");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}
		finish();
	}
	private Calendar trans(String date){
		if(date==null){
			return null;
		}
		else{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return cal;
		}
	}
}
