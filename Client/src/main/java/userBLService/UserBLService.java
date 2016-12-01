package userBLService;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import VO.*;
import common.*;
/**
 * 负责实现用户管理界面所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * @see Customer.User
 */
public interface UserBLService {
/**
 * 根据客户ID查找客户信息并返回
 * @param  userID String型，界面输入的客户ID
 * @return 返回UserVO
 * @see Customer.User
 */
	public UserVO findByID(String userID);
/**
 * 更新客户信息
 * @param vo UserVO型，界面输入的更新信息
 * @param passwordo String型，用户的密码
 * @see Customer.User
 */
	public void update(UserVO vo);
/**
 * 新增客户信息
 * @param vo UserVO型，界面输入的新增信息
 * @param passwordo String型，用户的密码
 * @return 返回布尔值表示成功与否
 * @see Customer.User
 */
	public boolean add(UserVO vo,String password);
/**
 * 删除客户信息
 * @param id String型，界面选择的用户
 * @see Customer.User
 */
	public void delete(String id);
/**
 * 显示信用值
 * @param userID String型，界面输入用户ID
 * @return long型，返回客户的信用值
 * @see Customer.User
 */
	public long showCredit(String userID);
/**
 * 更新会员等级
 * @param id String型，界面输入的用户账号
 * @param credit long型，界面传入的信用值
 * @see Customer.User
 */
	public void updateLevel(String id,long credit);
/**
 * 根据信用记录更新信用值
 * @param vo CreditRecordVO型，界面传入的CreditRecordVO
 * @see Customer.User
 */
	public void updateCreditRecord(CreditRecordVO vo);
/**
 * 客户注册
 * @param vo UserVO型，界面传入的VO对象
 * @param password String型，界面传入的客户密码
 * @see Customer.User
 */
	public void register(UserVO vo,String password);
/**
 * 信用记录显示
 * @param id String型，界面传入的客户账号
 * @return 返回信用记录列表
 * @see Customer.User
 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String id);
/**
 * 客户登录
 * @param ID String型，界面输入的用户账号
 * @param password型，界面输入的用户账号
 * @see Customer.User
 */
	public boolean login(String ID, String password);
/**
 * 客户登出
 * @param ID String型，界面输入的客户ID
 * @see Customer.User
 */
	public void logout(String ID);
    /**
     * 判断用户账号是否存在
     * @param ID
     * @return
     */
    public boolean judge(String account);
    /**
     * 修改密码
     * @param userID
     * @param newpassword
     */
	public void revisepassword(String userID, String password);
	/**
	 * 检查密码是否正确
	 * @param userID
	 * @param password
	 * @return 
	 */
	public boolean checkoldPassword(String userID, String password);
	/**
	 * 根据对应等级获得折扣
	 * @param level
	 * @return
	 */
	public Double getDiscount(int level);
	/**
	 * 更新所有客户的会员等级
	 */
	public void updateAllLevel();
}
