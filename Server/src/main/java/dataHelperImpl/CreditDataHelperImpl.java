package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import PO.CreditPO;
import dataHelper.CreditDataHelper;

public class CreditDataHelperImpl implements CreditDataHelper{
	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	private Connection dbConn;

	@Override
	public void insert(CreditPO po) {
		init();
		String sql="insert into [Credit] values('"+po.getAccount()+"','"+po.getCredit()+"','"+po.getLevel()+"')";
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
	public void delete(CreditPO po) {
		init();
		String sql="delete from [Credit] where userID='"+po.getAccount()+"'";
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
	@Override
	public void update(CreditPO po) {
		init();
		String id=po.getAccount();
		long credit=po.getCredit();
		int level=po.getLevel();
		String sql="update [Credit] set credit='"+credit+"',level='"+level+"' where userID='"+id+"'";
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
			 System.out.println("连接失败");
		 }
	}
	private void finish(){
		if(dbConn!=null){
			try {
				dbConn.close();
				System.out.println("关闭成功");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭失败");
			}
		}
	}
	@Override
	public ArrayList<CreditPO> getAllCredit() {
		ArrayList<CreditPO> list=new ArrayList<CreditPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Credit]");
			while(rs.next()){
				String id=rs.getString("userID");
				long credit=rs.getLong("credit");
				int level=rs.getShort("level");
				CreditPO po=new CreditPO(id,credit,level);
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
}
