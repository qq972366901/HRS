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
import PO.CreditRecordPO;
import common.Operate;
import dataHelper.CreditRecordDataHelper;

public class CreditRecordDataHelperImpl implements CreditRecordDataHelper{
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
	@Override
	public void insert(CreditRecordPO po) {
		init();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date= sdf.format(po.getTime().getTime());
		String sql="insert into [CreditRecord] values('"+po.getID()+"','"+po.getUserID()+"',null,'"+date+"','"+ActionToString(po.getAction())+"','"+po.getCreditchange()+"','"+po.getCurrentcredit()+"')";
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
	public ArrayList<CreditRecordPO> getAllCredit() {
		ArrayList<CreditRecordPO> list=new ArrayList<CreditRecordPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [CreditRecord]");
			while(rs.next()){
				String userID=rs.getString("userID");
				String crid=rs.getString("recordID");
				String str=rs.getString("time");
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date =sdf.parse(str);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				String act=rs.getString("action");
				Operate action=getAction(act);
				long creditchange=rs.getLong("creditchange");
				long currentcredit=rs.getLong("currentcredit");
				CreditRecordPO po=new CreditRecordPO(userID,crid,calendar,action,creditchange,currentcredit);
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
	private Operate getAction(String act){
		if(act.equals("Done")){
			return Operate.Done;
		}
		else if(act.equals("Cancel")){
			return Operate.Cancel;
		}
		else if(act.equals("Appeal")){
			return Operate.Appeal;
		}
		else if(act.equals("Delayed")){
			return Operate.Delayed;
		}
		else if(act.equals("Recharge")){
			return Operate.Recharge;
		}
		else{
			return Operate.Abnormal;
		}
	}
	private String ActionToString(Operate act){
		if(act.equals(Operate.Appeal)){
			return "Appeal";
		}
		else if(act.equals(Operate.Recharge)){
			return "Recharge";
		}
		else if(act.equals(Operate.Done)){
			return "Done";
		}
		else if(act.equals(Operate.Delayed)){
			return "Delayed";
		}
		else if(act.equals(Operate.Cancel)){
			return "Cancel";
		}
		else{
			return "Abnormal";
		}
	}
}
