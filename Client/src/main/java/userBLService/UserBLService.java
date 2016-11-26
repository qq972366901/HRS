package userBLService;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JLabel;

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
 * @param  in MessageInput型，界面输入的客户ID
 * @return 返回ResultMessage的所有枚举值
 * @see Customer.User
 */
	public UserVO findByID(String userID);
/**
 * 更新客户信息
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see Customer.User
 */
	public void update(UserVO vo,String password);
/**
 * 新增客户信息
 * @param in MessageInput型，界面输入的新增信息
 * @return 返回ResultMessage的一个枚举值
 * @see Customer.User
 */
	public boolean add(UserVO vo,String password);
/**
 * 删除客户信息
 * @param in MessageInput型，界面选择删除的信息
 * @return 返回ResultMessage的一个枚举值
 * @see Customer.User
 */
	public void delete(String id);
/**
 * 显示信用值
 * @param in MessageInput型，界面输入用户ID
 * @return String型，返回客户的信用值
 * @see Customer.User
 */
	public long showCredit(String userID);
/**
 * 通过充值更新信用值
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see Customer.User
 */
	public void updateCredit(String id,long val);
/**
 * 更新会员等级
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see Customer.User
 */
	public void updateLevel(String id,long credit);
/**
 * 根据信用记录更新信用值
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see Customer.User
 */
	public ResultMessage updateCreditRecord(UserVO vo);
/**
 * 客户注册
 * @param in MessageInput型，界面输入的注册信息
 * @return 返回ResultMessage的所有枚举值
 * @see Customer.User
 */
	public void register(UserVO vo,String password);
/**
 * 信用记录显示
 * @param in MessageInput型，界面选择的信息
 * @return 返回信用记录列表
 * @see Customer.User
 */
	public List<CreditRecordVO> showCreditRecord(String userID);
/**
 * 客户登录
 * @param in MessageInput型，界面输入的更新信息
 * @see Customer.User
 */
	public boolean login(String ID, String password)throws RemoteException;
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
}
