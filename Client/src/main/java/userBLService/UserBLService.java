package userBLService;
import java.rmi.RemoteException;
import java.util.List;

import VO.*;
import common.*;
/**
 * 负责实现用户管理界面所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * @see presentation.User
 */
public interface UserBLService {
/**
 * 根据客户ID查找客户信息并返回
 * @param  in MessageInput型，界面输入的客户ID
 * @return 返回ResultMessage的所有枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage findByID(String userID);
/**
 * 更新客户信息
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage update(UserVO vo);
/**
 * 新增客户信息
 * @param in MessageInput型，界面输入的新增信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage add(UserVO vo);
/**
 * 删除客户信息
 * @param in MessageInput型，界面选择删除的信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage delete(UserVO vo);
/**
 * 显示信用值
 * @param in MessageInput型，界面输入用户ID
 * @return String型，返回客户的信用值
 * @see bussinesslogic.User
 */
	public long showCredit(String userID);
/**
 * 通过充值更新信用值
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage updateCredit(UserVO vo,long credit);
/**
 * 更新会员等级
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage updateLevel(UserVO vo);
/**
 * 根据信用记录更新信用值
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage updateCreditRecord(UserVO vo);
/**
 * 客户注册
 * @param in MessageInput型，界面输入的注册信息
 * @return 返回ResultMessage的所有枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage register(UserVO vo);
/**
 * 维护客户信息
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage maintainPeersonalInfo(UserVO vo);
/**
 * 信用记录显示
 * @param in MessageInput型，界面选择的信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public CreditRecordVO showCreditRecord(UserVO vo);
/**
 * 订单支付成功后的信用更新
 * @param in MessageInput型，界面输入的支付信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage topUp(long money);
/**
 * 订单未支付完成
 * @param in MessageInput型，界面输入的支付信息
 * @return 返回ResultMessage的所有枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage payment(long money);
/**
 * 客户登录
 * @param in MessageInput型，界面输入的更新信息
 * @return 返回UserType的所有枚举值
 * @see bussinesslogic.User
 */
	public UserType login(String ID, String password)throws RemoteException;
/**
 * 客户登出
 * @param in MessageInput型，界面选择的信息
 * @return 返回ResultMessage的一个枚举值
 * @see bussinesslogic.User
 */
	public ResultMessage logout(String ID);

	
    public UserVO findByAccount(String acc);

	public List<CreditRecordVO> showCreditRecord(String userID) ;

}
