package uiService;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import UserView.AddHotelView;
import VO.UserVO;
/**
 * 添加酒店界面接口的实现接口
 * @author 刘伟
 *
 */
public interface AddHotelUiService {
	/**
	 * 设置一个AddHotelView的panel
	 * @param view
	 */
	public void setView(AddHotelView view);
	 /**
     * 网站管理人员界面跳转
     */
	public void toWebAdminUserView(String id) throws RemoteException;
	 /**
     * 用户管理界面跳转
     */
	public void toUserManagementView(String id) throws RemoteException;
	 /**
     * 保存酒店信息
     */
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore);
	 /**
     * 从上一界面获取用户ID
     */
	public String getUserID();
	 /**
     * 获取所有的城市
     */
	public List<String> getCity();
	 /**
     * 获取某一城市的商圈
     */
	public Vector<String> getCircle(String city);
	 /**
     * 保存会员的注册信息
     */
	public void register(UserVO vo,String password);
	 /**
     * 保存会员的ID，加密后的ID和密钥
     */
	public boolean addLog(String id,String k,String secretid);
}
