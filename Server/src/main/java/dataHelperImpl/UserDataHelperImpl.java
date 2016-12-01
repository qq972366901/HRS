package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PO.UserPO;
import dataHelper.UserDataHelper;

public class UserDataHelperImpl implements UserDataHelper{
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
	@Override
	public void insert(UserPO po) {
		init();
		finish();
	}

	@Override
	public void update(UserPO po) {
		init();
		finish();
	}

	@Override
	public ArrayList<UserPO> getAllUser() {
		ArrayList<UserPO> list=new ArrayList<UserPO>();
		init();
		finish();
		return list;
	}
	@Override
	public void delete(UserPO po) {
		init();
		finish();
	}

}
