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
import java.util.List;

import PO.HotelPO;
import PO.PromotionPO;
import PO.UserPO;
import common.UserType;
import dataHelper.PromotionDataHelper;

public class PromotionDataHelperImpl implements PromotionDataHelper{
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
	public void insert(PromotionPO po) {
		// TODO Auto-generated method stub
		init();
		String sql;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date1= sdf.format(po.getPromotionBegintime().getTime());
		String date2= sdf.format(po.getPromotionEndtime().getTime());
		if(po.getPromotionNumber()!=null){
		sql="insert into [Promotion] values('"+po.getPromotionNumber()+"','"+po.getPromotionName()+"','"+date1+"','"+date2+"','"+po.getApplyCity()+"','"+po.getHotelBussinesscircle()+"','"+po.getUserShipgrade()+"')";
		}
		else if(po.getHotelID()!=null){
		sql="insert into [Promotion] values('"+po.getHotelID()+"','"+po.getPromotionName()+"','"+date1+"','"+date2+"','"+po.getPromotionDiscount()+"','"+po.getBirthdayDiscount()+"','"+po.getRoomDiscount()+"','"+po.getEnterpriseDiscount()+"')";
		}
		else{
		long[] credit=po.getCreditOfLevel();
		double[] discount=po.getDiscountOfLevel();
		sql="insert into [MemberLevelSystem] values('"+credit[0]+"','"+credit[1]+"','"+credit[2]+"','"+credit[3]+"','"+credit[4]+"','"+discount[0]+"','"+discount[1]+"','"+discount[2]+"','"+discount[3]+"','"+discount[4]+"')";	
		}
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
	public void delete(PromotionPO po) {
		// TODO Auto-generated method stub
		init();
		String sql="delete from [Promotion] where promotionNumber='"+po.getPromotionNumber()+"'";
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
	public void update(PromotionPO po) {
		// TODO Auto-generated method stub
		init();
		long[] credit= po.getCreditOfLevel();
		double[] discount = po.getDiscountOfLevel();
		String sql="update [MemberLevelSystem] set creditOfLevel1='"+credit[0]+"',creditOfLevel2='"+credit[1]+"',creditOfLevel3='"+credit[2]+"',creditOfLevel4='"+credit[3]+"',creditOfLevel5='"+credit[4]+"',discountOfLevel1='"+discount[0]+"',discountOfLevel2='"+discount[1]+"',discountOfLevel3='"+discount[2]+"',discountOfLevel4='"+discount[3]+"',discountOfLevel5='"+discount[4]+"'";
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
	public PromotionPO find(String id) {
		// TODO Auto-generated method stub
		PromotionPO po = null;
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Promotion] where promotionNumber='"+id+"'");
			String number= rs.getString("promotionNumber");
			String name = rs.getString("promotionName");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String begintime1 = rs.getString("promotionBegintime");
			Date begintime2 = null;
			try {
				begintime2 = sdf.parse(begintime1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar begintime= Calendar. getInstance();
			begintime.setTime(begintime2);
			String endtime1 = rs.getString("promotionEndtime");
			Date endtime2 = null;
			try {
				endtime2 = sdf.parse(endtime1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar endtime= Calendar. getInstance();
			endtime.setTime(endtime2);
			String city = rs.getString("applycity");
			String circle = rs.getString("applybussinesscircle");
			int grade = rs.getInt("applyuserShipgrade");
			po = new PromotionPO(number,name,begintime,endtime,city,circle,grade);
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("读取失败");
			e.printStackTrace();
		}
		finish();
		return po;
	}

	@Override
	public List<PromotionPO> getAllWebPromotion() {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list=new ArrayList<PromotionPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Promotion]");
			while(rs.next()){
				if(rs.getString("promotionNumber")!=null){
				String number=rs.getString("promotionNumber");
				String name=rs.getString("promotionName");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String begintime1 = rs.getString("promotionBegintime");
				Date begintime2 = null;
				try {
					begintime2 = sdf.parse(begintime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar begintime= Calendar. getInstance();
				begintime.setTime(begintime2);
				String endtime1 = rs.getString("promotionEndtime");
				Date endtime2 = null;
				try {
					endtime2 = sdf.parse(endtime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar endtime= Calendar. getInstance();
				endtime.setTime(endtime2);
				String city=rs.getString("applycity");
				String circle=rs.getString("applybussinesscircle");
				int grade=rs.getInt("userShipgrade");
				PromotionPO po=new PromotionPO(number,name,begintime,endtime,city,circle,grade);
				list.add(po);
				}
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
	public List<PromotionPO> getAllHotelPromotion() {
		ArrayList<PromotionPO> list=new ArrayList<PromotionPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Promotion]");
			while(rs.next()){
				if(rs.getString("hotelID")!=null){
				String hotelid=rs.getString("hotelID");
				String name=rs.getString("promotionName");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String begintime1 = rs.getString("promotionBegintime");
				Date begintime2 = null;
				try {
					begintime2 = sdf.parse(begintime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar begintime= Calendar. getInstance();
				begintime.setTime(begintime2);
				String endtime1 = rs.getString("promotionEndtime");
				Date endtime2 = null;
				try {
					endtime2 = sdf.parse(endtime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar endtime= Calendar. getInstance();
				endtime.setTime(endtime2);
				double discount=rs.getDouble("Discount");
				double birthdaydiscount=rs.getDouble("birthdayDiscount");
				double roomdiscount=rs.getDouble("roomDiscount");
				double enterprisediscount=rs.getDouble("enterpriseDiscount");
				PromotionPO po=new PromotionPO(hotelid,name,begintime,endtime,discount,birthdaydiscount,roomdiscount,enterprisediscount);
				list.add(po);
				}
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
	public PromotionPO getSystemMemberGrade() {
		// TODO Auto-generated method stub
		PromotionPO po = null;
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [MemberLevelSystem]");
			long[] credit=new long[5];
			double[] discount=new double[5];
			int i=0;
			while(rs.next()){
				credit[i]=rs.getLong("credit");
				discount[i]=rs.getDouble("discount");
				i++;
			}
			po=new PromotionPO(credit,discount);
				rs.close();
				st.close();
			}catch(SQLException e) {
				System.out.println("读取失败");
				e.printStackTrace();
	}
			finish();
			return po;
	}
}
