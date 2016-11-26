package userRegister;
import VO.UserVO;
import common.ResultMessage;
import userBLService.UserBLService_realize;
public class UserRegisterController extends UserBLService_realize{
	/**
	 * 客户注册
	 * @param in MessageInput型，界面输入的注册信息
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage register(UserVO vo) {
		return ResultMessage.Exist;
	}
}
