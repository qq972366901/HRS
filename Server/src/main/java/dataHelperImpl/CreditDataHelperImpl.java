package dataHelperImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PO.CreditPO;
import dataHelper.CreditDataHelper;

public class CreditDataHelperImpl implements Serializable, CreditDataHelper{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	private Connection dbConn;

	@Override
	public void insert(CreditPO po) {
		init();
		finish();
	}
	@Override
	public void delete(CreditPO po) {
		init();
		finish();
	}
	@Override
	public void update(CreditPO po) {
		init();
		finish();	
	}
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
	public ArrayList<CreditPO> getAllCredit() {
		ArrayList<CreditPO> list=new ArrayList<CreditPO>();
		init();
		finish();
		return list;
	}
}
