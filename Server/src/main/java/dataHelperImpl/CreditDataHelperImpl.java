package dataHelperImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataHelper.CreditDataHelper;

public class CreditDataHelperImpl implements Serializable, CreditDataHelper{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<String> get() throws RemoteException{
		ArrayList<String> list=new ArrayList<String>();
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=db_Student";
		 String userName="liu";
		 String userPwd="naigo961226";
		 try{
			 Class.forName(driverName);
			 Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			 ResultSet rs=dbConn.createStatement().executeQuery("SELECT TOP 1000 [UserID],[UserName],[PassWord],[Email],[Role] FROM [db_Student].[dbo].[tb_User]");
			 while(rs.next()){
				 list.add(rs.getString("UserName"));
				 list.add(rs.getString("PassWord"));
			 }
			 System.out.println("连接数据库成功");
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.print("连接失败");
		 }
		return list;
	}

}
