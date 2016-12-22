package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import PO.RoomPO;
import dataHelper.RoomDataHelper;

public class RoomDataHelperImpl implements RoomDataHelper{

	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	private Connection dbConn;
	
	private void init() {
		driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=HRS";
		userName="lyx";
		userPwd="liuyx970202";
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

	public void insert(RoomPO po) {
		init();
		String sql="insert into [Room] values('"+po.getHotelId()+"','"+po.getroomId()+"','"+po.getroomStatue()+"','"+po.getroomType()+"','"+po.getroomPrice()+"')";
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
	
	public void update(RoomPO po) {
		init();
		String hotelid = po.getHotelId();
		String rid = po.getroomId();
		String rState = po.getroomStatue();
		String rType = po.getroomType();
		int rPrice = po.getroomPrice();
		String sql="update [Room] set roomStatue='"+rState+"',roomType='"+rType+"',roomPrice='"+rPrice+"' where hotelID='"+hotelid+"' and roomID='"+rid+"'";
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

	public List<RoomPO> getAllRooms(String hotelid) {
		List<RoomPO> list = new ArrayList<RoomPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Room] where hotelID='"+hotelid+"'");
			while(rs.next()){
				String hid = rs.getString("hotelID");
				String roomid=rs.getString("roomID");
				String rStatue = rs.getString("roomStatue");
				String rType = rs.getString("roomType");
				int rPrice = rs.getInt("roomPrice");
				RoomPO po=new RoomPO(hid, roomid, rStatue, rType, rPrice);
				list.add(po);
			}
			System.out.println("得到所有房间");
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("读取失败");
			e.printStackTrace();
		}
		finish();
		return list;
	}

}
