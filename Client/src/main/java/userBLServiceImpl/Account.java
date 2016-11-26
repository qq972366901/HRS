package userBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import PO.UserPO;
import VO.LogVO;
import VO.UserVO;
import common.UserType;
import dataService.DataFactoryService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 负责对于账户的操作
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public class Account{
	private static Account account;
	private DataFactoryService df;
	private HashMap<String,CustomerAccountInfo> customer;
	private HashMap<String,HotelWorkerAccountInfo> hotelworker;
	private HashMap<String,WebPromotionWorkerAccountInfo> webpromotionworker;
	private HashMap<String,WebManagementWorkerAccountInfo> webmanagementworker;
	private Account(){
		//这些只是暂时是初始化，customer的数据从Customer类中取
		customer=new HashMap<String,CustomerAccountInfo>();
		List<UserVO> customerlist=Customer.getUserInstance().getAllCustomer();
		for(int i=0;i<customerlist.size();i++){
			String userID=customerlist.get(i).id;
			customer.put(userID, new CustomerAccountInfo(customerlist.get(i),Log.getLogInstance().getPassword(userID)));
		}
		hotelworker=new HashMap<String,HotelWorkerAccountInfo>();
		webpromotionworker=new HashMap<String,WebPromotionWorkerAccountInfo>();
		webmanagementworker=new HashMap<String,WebManagementWorkerAccountInfo>();
		df=RemoteHelper.getInstance().getDataFactoryService();
	}
	public static Account getInstance(){
		if(account==null){
			account=new Account();
		}
		return account;
	}
	/**
	 * 获取持有此账号的客户的信息
	 * @param account String型，界面层传来的账户编号
	 * @return 返回持有此账号的用户信息
	 * @see VO.UserVO
	 */
	public AccountInfo getUser(UserType type,String account){
		if(type.equals(UserType.Customer)){
			return customer.get(account);
		}
		else if(type.equals(UserType.Hotelworker)){
			return hotelworker.get(account);
		}
		else if(type.equals(UserType.WebPromotionWorker)){
			return webpromotionworker.get(account);
		}
		else{
			return webmanagementworker.get(account);
		}
	}
	/**
	 * 更新账户信息
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void update(UserVO vo,String password) throws RemoteException{
		Log.getLogInstance().revisepassword(vo.id, password);
		if(customer.get(vo.id)!=null){
			CustomerAccountInfo info=new CustomerAccountInfo(vo,password);
			customer.put(vo.id, info);
			Customer.getUserInstance().updateUserInfo(vo,password);
		}
		else if(hotelworker.get(vo.id)!=null){
			HotelWorkerAccountInfo info=new HotelWorkerAccountInfo(vo,password);
			hotelworker.put(vo.id, info);
		}
		else if(webpromotionworker.get(vo.id)!=null){
			WebPromotionWorkerAccountInfo info=new WebPromotionWorkerAccountInfo(vo,password);
			webpromotionworker.put(vo.id, info);
		}
		else if(webmanagementworker.get(vo.id)!=null){
			WebManagementWorkerAccountInfo info=new WebManagementWorkerAccountInfo(vo,password);
			webmanagementworker.put(vo.id, info);
		}
		else{
		}
	}
	/**
	 * 删除某个账户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void delete(String id) throws RemoteException{
		if(customer.get(id)!=null){
			customer.remove(id);
			Customer.getUserInstance().deleteCustomer(id);
		}
		else if(hotelworker.get(id)!=null){
			hotelworker.remove(id);
		}
		else if(webpromotionworker.get(id)!=null){
			webpromotionworker.remove(id);
		}
		else if(webmanagementworker.get(id)!=null){
			webmanagementworker.remove(id);
		}
		else{
		}
		Log.getLogInstance().delete(id);
	}
	/**
	 * 增加一个账户
	 * @param vo UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void add(UserVO vo,String password) throws RemoteException{
		if(vo.type.equals(UserType.Customer)&&customer.get(vo.id)==null){
			CustomerAccountInfo info=new CustomerAccountInfo(vo,password);
			customer.put(vo.id, info);
			Customer.getUserInstance().create(vo,password);
		}
		else if(vo.type.equals(UserType.Hotelworker)&&hotelworker.get(vo.id)==null){
			HotelWorkerAccountInfo info=new HotelWorkerAccountInfo(vo,password);
			hotelworker.put(vo.id, info);
		}
		else if(vo.type.equals(UserType.WebPromotionWorker)&&webpromotionworker.get(vo.id)==null){
			WebPromotionWorkerAccountInfo info=new WebPromotionWorkerAccountInfo(vo,password);
			webpromotionworker.put(vo.id, info);
		}
		else if(vo.type.equals(UserType.WebManagementWorker)&&webmanagementworker.get(vo.id)==null){
			WebManagementWorkerAccountInfo info=new WebManagementWorkerAccountInfo(vo,password);
			webmanagementworker.put(vo.id, info);
		}
		else{
			
		}
		Log.getLogInstance().add(vo.id, new LogVO(password,vo.id,true));
	}
	/**
	 * 判断账户是否存在
	 * @param id
	 * @return
	 */
	public boolean judgeAccount(String id) {
		// TODO Auto-generated method stub
		if(customer.containsKey(id)||hotelworker.containsKey(id)||webpromotionworker.containsKey(id)||webmanagementworker.containsKey(id)){
			return true;
		}
		else{
			return false;
		}
	}
}
