package promotionData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import PO.HotelPO;
import PO.PromotionPO;
import PO.UserPO;
import common.UserType;
import dataHelper.DataHelperFactory;
import dataHelper.PromotionDataHelper;
import dataHelper.UserDataHelper;
import dataHelperImpl.DataHelperFactoryImpl;
/**
 * 职责是将逻辑层面发来的请求转发给后台PromotionData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.Promotion
 */
public class PromotionDataServiceMySqlImpl implements Serializable,dataService.PromotionDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataHelperFactory datafactory;
	private HashMap<String,PromotionPO> promotion;
	private HashMap<String,Vector<PromotionPO>> hotelpromotion;
	private PromotionDataHelper helper;
	
	
	private static PromotionDataServiceMySqlImpl promotionDataServiceMySqlImpl;
	private PromotionDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
	}
	public static PromotionDataServiceMySqlImpl getInstance() throws RemoteException{
		if(promotionDataServiceMySqlImpl==null){
			promotionDataServiceMySqlImpl=new PromotionDataServiceMySqlImpl();
		}
		return promotionDataServiceMySqlImpl;
	}
	/**
	 * 按ID进行查找返回相应的PromotionPO结果
	 * @param id String 型，逻辑层传来的策略编号
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public PromotionPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return promotion.get(id);
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po PromotionPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void insert(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po.getPromotionNumber()!=null){
			if(!promotion.containsKey(po.getPromotionNumber())){
				promotion.put(po.getPromotionNumber(), po);
				helper.insert(po);
			}
		}
		else if(po.getHotelID()!=null){
			Vector<PromotionPO> list3=new Vector<PromotionPO>();
			if(hotelpromotion.get(po.getHotelID())!=null){
				for(PromotionPO hotelpo : hotelpromotion.get(po.getHotelID())){
				      list3.add(hotelpo);	
				}
				}
		      list3.add(po);
		 hotelpromotion.put(po.getHotelID(),list3);
		 helper.insert(po);
		}
		else{
			if(!promotion.containsKey("会员等级系统")){
				promotion.put("会员等级系统", po);
				helper.insert(po);
			}
		}
	}
	/**
	 * 在数据库中删除一个po
	 * @param po PromotionPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		if(promotion.containsKey(id)){
			promotion.remove(id);
			helper.delete(id);
		}
		
	}
	/**
	 * 在数据库中跟新一个po
	 * @param po PromotionPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void update(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(promotion.containsKey("会员等级系统")){
			promotion.put("会员等级系统", po);
			helper.update(po);
		}
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		datafactory=new DataHelperFactoryImpl();
		helper=datafactory.getPromotionDataHelper();
		promotion=new HashMap<String,PromotionPO>();
		hotelpromotion=new HashMap<String,Vector<PromotionPO>>();
		List<PromotionPO> list1=new ArrayList<PromotionPO>();
		List<PromotionPO> list2=new ArrayList<PromotionPO>();
		list1=helper.getAllWebPromotion();
		list2=helper.getAllHotelPromotion();
		PromotionPO po=helper.getSystemMemberGrade();
		for(int i=0;i<list1.size();i++){
			promotion.put(list1.get(i).getPromotionNumber(), list1.get(i));
		}
		for(PromotionPO hpo : list2){
			hotelpromotion.put(hpo.getHotelID(),null);
		}
		for(PromotionPO hpo : list2){
			String hotelid=hpo.getHotelID();
			if(hotelpromotion.containsKey(hotelid)){
			Vector<PromotionPO> list3=new Vector<PromotionPO>();
			if(hotelpromotion.get(hotelid)!=null){
			for(PromotionPO hotelpo : hotelpromotion.get(hotelid)){
			      list3.add(hotelpo);	
			}
			}
			list3.add(hpo);
			hotelpromotion.put(hotelid,list3);
			}
		}
		promotion.put("会员等级系统", po);
	}
	/**
	 *得到所有的酒店策略
	 */
    public List<Vector<PromotionPO>> getAllHotelPromotion(){
    	List<Vector<PromotionPO>> list=new ArrayList<Vector<PromotionPO>>();
		for (Map.Entry<String,Vector<PromotionPO>> entry : hotelpromotion.entrySet()) {
				list.add(entry.getValue());
        }
		return list;
    }

	/**
	 *得到所有的网站策略
	 */
	    public List<PromotionPO> getAllWebPromotion(){
	    	List<PromotionPO> list=new ArrayList<PromotionPO>();
			for (Map.Entry<String,PromotionPO> entry : promotion.entrySet()) {
				if(entry.getValue().getPromotionNumber()!=null)
					list.add(entry.getValue());
	        }
			return list;
	    }
/**
 *得到会员等级系统
 */
    public PromotionPO getMemberLevelSystem(){
		return promotion.get("会员等级系统");
    }
}
