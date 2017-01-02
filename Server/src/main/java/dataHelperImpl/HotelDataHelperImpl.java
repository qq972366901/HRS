package dataHelperImpl;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataHelper.HotelDataHelper;
import po.HotelPO;

/**
 * 数据库对酒店表的操作的实现
 * @author 刘宗侃
 *
 */
public class HotelDataHelperImpl implements HotelDataHelper{

	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	private Connection dbConn;
	/**
	 * 连接数据库
	 */
	private void init() {
		driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=HRS";
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
	/**
	 * 关闭数据库的连接
	 */
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
	/**
	 * 按酒店ID进行查找返回相应的HotelPO结果
	 * 
	 * @param id String型，界面输入的酒店id
	 * @return 返回对应的HotelPO
	 */
	public HotelPO find(String id) throws RemoteException {
		HotelPO po = null;
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Hotel] where hotelAccount='"+id+"'");
			String hAddress = rs.getString("hotelAddress");
			String hCity = rs.getString("hotelCity");
			String hDistrict = rs.getString("hotelDistrict");
			int hStar = rs.getInt("hotelStar");
			String hProfile = rs.getString("hotelProfile");
			String hService = rs.getString("hotelService");
			String hName = rs.getString("hotelName");
			String hAccount = rs.getString("hotelAccount");
			double sco = (double)rs.getFloat("score");
			String phone = rs.getString("hotelPhone");
			po = new HotelPO(hAddress, hCity, hDistrict, hStar,hProfile, hService, hName, hAccount, sco, phone);
			System.out.println("获得酒店");
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("读取失败");
			e.printStackTrace();
		}
		finish();
		return po;
	}
	/**
	 * 在数据库中查找一个用户的历史酒店
	 * 
	 * @param userid String型，用户ID
	 * @return 此用户的历史酒店列表
	 */
	public List<HotelPO> getHistoryHotelByUser(String userid) throws RemoteException {
		List<HotelPO> list = new ArrayList<HotelPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Hotel] where [Hotel].hotelAccount in (select HotelID from [Order] where [Order].UserID='"+userid+"')");
			while(rs.next()){
				String hAddress = rs.getString("hotelAddress");
				String hCity = rs.getString("hotelCity");
				String hDistrict = rs.getString("hotelDistrict");
				int hStar = rs.getInt("hotelStar");
				String hProfile = rs.getString("hotelProfile");
				String hService = rs.getString("hotelService");
				String hName = rs.getString("hotelName");
				String hAccount = rs.getString("hotelAccount");
				double sco = (double)rs.getFloat("score");
				String phone = rs.getString("hotelPhone");
				HotelPO po = new HotelPO(hAddress, hCity, hDistrict, hStar,hProfile, hService, hName, hAccount, sco, phone);
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
	/**
	 * 得到所有酒店
	 * 
	 * @return 返回所有酒店的列表
	 */
	public List<HotelPO> getAllHotel() throws RemoteException {
		List<HotelPO> list = new ArrayList<HotelPO>();
		init();
		try {
			Statement st=dbConn.createStatement();
			ResultSet rs=st.executeQuery("select * from [Hotel]");
			while(rs.next()){
				String hAddress = rs.getString("hotelAddress");
				String hCity = rs.getString("hotelCity");
				String hDistrict = rs.getString("hotelDistrict");
				int hStar = rs.getInt("hotelStar");
				String hProfile = rs.getString("hotelProfile");
				String hService = rs.getString("hotelService");
				String hName = rs.getString("hotelName");
				String hAccount = rs.getString("hotelAccount");
				double sco = (double)rs.getFloat("score");
				String phone = rs.getString("hotelPhone");
				HotelPO po = new HotelPO(hAddress, hCity, hDistrict, hStar,hProfile, hService, hName, hAccount, sco, phone);
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
	/**
	 * 在数据库中增加一个po记录
	 * 
	 * @param po HotelPO型，新增的酒店
	 * @return
	 */
	public void insert(HotelPO po) throws RemoteException {
		init();
		String sql="insert into [Hotel] values('"+po.gethotelAddress()+"','"+po.gethotelCity()+"','"+po.gethotelDistrict()+"','"+po.gethotelStar()+"','"+po.gethotelProfile()+"','"+po.gethotelService()+"','"+po.gethotelName()+"','"+po.gethotelAccount()+"','"+po.getScore()+"','"+po.getHotelPhone()+"')";
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
	/**
	 * 在数据库中删除一个po
	 * 
	 * @param po HotelPO型，删除的酒店
	 * @return
	 */
	public void delete(HotelPO po) throws RemoteException {
		init();
		String sql="delete from [Hotel] where hotelAccount='"+po.gethotelAccount()+"'";
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
	/**
	 * 在数据库中更新一个po
	 * 
	 * @param po HotelPO型，更新的酒店
	 * @return
	 */
	public void update(HotelPO po) throws RemoteException {
		init();
		String hAddress = po.gethotelAddress();
		String hCity = po.gethotelCity();
		String hDistrict = po.gethotelDistrict();
		int hStar = po.gethotelStar();
		String hProfile = po.gethotelProfile();
		String hService = po.gethotelService();
		String hName = po.gethotelName();
		String hAccount = po.gethotelAccount();
		double sco = po.getScore();
		String phone = po.getHotelPhone();
		String sql="update [Hotel] set hotelAddress='"+hAddress+"',hotelCity='"+hCity+"',hotelDistrict='"+hDistrict+"',hotelStar='"+hStar+"',hotelProfile='"+hProfile+"',hotelService='"+hService+"',hotelName='"+hName+"',score='"+sco+"',hotelPhone='"+phone+"' where hotelAccount='"+hAccount+"'";
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
	
}
