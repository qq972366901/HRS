package hotelData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.HotelPO;

public class HotelDataServiceMySqlImpl_Stub implements Serializable,dataService.HotelDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public HotelPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		HotelPO po=new HotelPO("汤山镇泉韵路8号","南京","江宁",5,"xxx","xxx","xxx","xxx",4.5);
		return po;
	}

	@Override
	public void insert(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!");
	}

	@Override
	public void delete(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Succeed!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish Succeed!");
	}

	@Override
	public HotelPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		HotelPO po=new HotelPO("汤山镇泉韵路8号","南京","江宁",5,"xxx","xxx","xxx","xxx",4.5);
		return po;
	}

	@Override
	public ArrayList<HotelPO> findByDistrict(String district) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		ArrayList<HotelPO> a=new ArrayList<HotelPO>();
		HotelPO po=new HotelPO("汤山镇泉韵路8号","南京","江宁",5,"xxx","xxx","xxx","xxx",4.5);
		a.add(po);
		return a;
	}

	@Override
	public ArrayList<HotelPO> findByStar(int star) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		ArrayList<HotelPO> a=new ArrayList<HotelPO>();
		HotelPO po=new HotelPO("汤山镇泉韵路8号","南京","江宁",5,"xxx","xxx","xxx","xxx",4.5);
		a.add(po);
		return a;
	}

	@Override
	public ArrayList<HotelPO> findByScore(double sco) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		ArrayList<HotelPO> a=new ArrayList<HotelPO>();
		HotelPO po=new HotelPO("汤山镇泉韵路8号","南京","江宁",5,"xxx","xxx","xxx","xxx",4.5);
		a.add(po);
		return a;
	}

	@Override
	public List<HotelPO> getHistoryHotelByUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPO> getAllHotel() {
		// TODO Auto-generated method stub
		return null;
	}

}
