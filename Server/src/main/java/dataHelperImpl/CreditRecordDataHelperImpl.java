package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PO.CreditRecordPO;
import dataHelper.CreditRecordDataHelper;

public class CreditRecordDataHelperImpl implements CreditRecordDataHelper{
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
	public void insert(CreditRecordPO po) {
		init();
		finish();
	}

	@Override
	public ArrayList<CreditRecordPO> getAllCredit() {
		ArrayList<CreditRecordPO> list=new ArrayList<CreditRecordPO>();
		init();
		finish();
		return list;
	}

}
