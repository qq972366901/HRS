package userBLService;
import java.util.HashMap;
import VO.*;
import common.UserType;
import userBLServiceImpl.AccountInfo;
/**
 * 负责实现用户管理界面所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * @see Customer.User
 */
public interface UserBLService {
	/**
	 * 根据用户账号和类型获取客户账户信息，供网站管理人员查看
	 * @param type UserType型，用户类型
	 * @param account String型，用户账号
	 * @return 返回用户账号信息
	 */
	public AccountInfo getUser(UserType type,String account);
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
	 * 判断账号是否存在
	 * @param account String型，逻辑层传入的用户账号
	 * @return 返回布尔值表示是否存在此账号
	 * @throws  
	 */
    public boolean judge(String account);
    /**
     * 修改密码
     * @param userID String型，界面层传入的用户账号
     * @param password String 型，界面层传入的用户密码
     */
	public void revisepassword(String userID, String password);
	/**
	 * 检查密码是否正确
	 * @param userID String型，界面层传入的用户账号
     * @param password String 型，界面层传入的用户密码
     * @return 返回布尔值表示密码是否正确
	 */
	public boolean checkoldPassword(String userID, String password);
	/**
	 * 获取对应等级的折扣
	 * @param level int 型，界面层传入的会员等级
	 * return 返回此等级对应的折扣
	 */
	public Double getDiscount(int level);
	/**
	 * 更新所有客户的会员等级
	 */
	public void updateAllLevel();
	/**
	 * 显示信用等级
	 * @param id String 型，界面层传入的客户账户
	 * @return 返回此账号的信用等级
	 */
	public int showLevel(String id);
}
