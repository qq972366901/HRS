package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=db_Student";
		userName="liu";
		userPwd="naigo961226";
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
	
	public RoomPO find(String id) {
		init();
		finish();
		return null;
	}

	public void insert(RoomPO po) {
		init();
		finish();
	}

	public void delete(RoomPO po) {
		init();
		finish();
	}

	public void update(RoomPO po) {
		init();
		finish();
	}

	public List<RoomPO> getAllRooms(String hotelid) {
		init();
		finish();
		return null;
	}

}
