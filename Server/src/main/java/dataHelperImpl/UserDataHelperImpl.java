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
import java.util.Date;
import java.util.HashMap;

import PO.UserPO;
import common.UserType;
import dataHelper.UserDataHelper;

public class UserDataHelperImpl implements UserDataHelper{
	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	private Connection dbConn;
	private void init() {
		driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=HRS1";
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
	@Override
	public void insert(UserPO po) {
		init();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(po.getBirthday().getTime());
		String sql="insert into [User] values('"+po.getName()+"','"+po.getPassword()+"','"+po.getAccount()+"','"+po.getContact()+"','"+po.getMemberType()+"','"+typeToString(po.getType())+"','"+date+"','"+po.getEnterprise()+"')";
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
	public void update(UserPO po) {
		init();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(po.getBirthday().getTime());
		String sql="update [User] set username='"+po.getName()+"',userpassword='"+po.getPassword()+"',contactway='"+po.getContact()+"',membertype='"+po.getMemberType()+"',type='"+typeToString(po.getType())+"',birthday='"+date+"',enterprise='"+po.getEnterprise()+"'where useraccount='"+po.getAccount()+"'";
		try {
			System.out.println(sql);
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
	public ArrayList<UserPO> getAllUser() {
		ArrayList<UserPO> list=new ArrayList<UserPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [User]");
			while(rs.next()){
				String name=rs.getString("username");
				String pwd=rs.getString("userpassword");
				String id=rs.getString("useraccount");
				String phone=rs.getString("contactway");
				String membertype=rs.getString("membertype");
				if(membertype==null){
					membertype="";
				}
				UserType type=getType(rs.getString("type"));
				String birthday=rs.getString("birthday");
				Calendar c=Calendar.getInstance();
				if(birthday==null){
					c.set(0, 0, 0);
				}
				else{
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
					Date date =sdf.parse(birthday);
					c.setTime(date);
				}
				String enter=rs.getString("enterprise");
				if(enter==null){
					enter="";
				}
				UserPO po=new UserPO(name,pwd,id,phone,membertype,type,c,enter);
				list.add(po);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("读取失败");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("解析错误");
			e.printStackTrace();
		}
		finish();
		return list;
	}
	@Override
	public void delete(UserPO po) {
		init();
		String sql="delete from [User] where useraccount='"+po.getAccount()+"'";
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
	private UserType getType(String type){
		if(type.equals("Customer")){
			return UserType.Customer;
		}
		else if(type.equals("HotelWorker")){
			return UserType.HotelWorker;
		}
		else if(type.equals("WebPromotionWorker")){
			return UserType.WebPromotionWorker;
		}
		else{
			return UserType.WebManagementWorker;
		}
	}
	private String typeToString(UserType type){
		if(type.equals(UserType.Customer)){
			return "Customer";
		}
		else if(type.equals(UserType.HotelWorker)){
			return "HotelWorker";
		}
		else if(type.equals(UserType.WebPromotionWorker)){
			return "WebPromotionWorker";
		}
		else{
			return "WebManagementWorker";
		}
	}
	@Override
	public HashMap<String, String> getAllKeys() {
		HashMap<String,String> list=new HashMap<String,String>();
		init();
		try {
			Statement st = dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Key]");
			while(rs.next()){
				String id=rs.getString("userid");
				String key=rs.getString("key");
				list.put(id, key);
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
	public void deleteKey(String secretID) {
		init();
		String sql="delete from [Key] where userid='"+secretID+"'";
		try {
			Statement st = dbConn.createStatement();
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
	public void addKey(String id, String k) {
		init();
		String sql="insert into [Key] values('"+id+"','"+k+"')";
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
}
