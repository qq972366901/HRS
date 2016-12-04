package dataHelperImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PO.HotelPO;
import dataHelper.HotelDataHelper;

public class HotelDataHelperImpl implements Serializable, HotelDataHelper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public HotelPO find(String id) throws RemoteException {
		init();
		finish();
		return null;
	}
	public List<HotelPO> getHistoryHotelByUser(String userid) throws RemoteException {
		init();
		finish();
		return null;
	}
	public List<HotelPO> getAllHotel() throws RemoteException {
		init();
		finish();
		List<HotelPO> list=new ArrayList<HotelPO>();
		return list;
	}
	public HotelPO findByName(String name) throws RemoteException {
		init();
		finish();
		return null;
	}
	public ArrayList<HotelPO> findByDistrict(String district) throws RemoteException {
		init();
		finish();
		return null;
	}
	public ArrayList<HotelPO> findByStar(int star) throws RemoteException {
		init();
		finish();
		return null;
	}
	public ArrayList<HotelPO> findByScore(double sco) throws RemoteException {
		init();
		finish();
		return null;
	}
	public void insert(HotelPO po) throws RemoteException {
		init();
		finish();
	}
	public void delete(HotelPO po) throws RemoteException {
		init();
		finish();
	}
	public void update(HotelPO po) throws RemoteException {
		init();
		finish();
	}
	
	
}
