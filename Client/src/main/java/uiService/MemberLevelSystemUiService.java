package uiService;

import VO.MemberLevelSystemVO;
import WebPromotionView.MemberLevelSystemView;
/**
 * 制定会员等级系统控制器接口
 * @author LZ
 *
 */
public interface MemberLevelSystemUiService {
/**
 * 设置界面
 * @param view MemberLevelSystemView型，界面层传入的panel
 */
	public void setView(MemberLevelSystemView view);
/**
 * 跳转到网站营销人员主界面
 */
	public void toWebPromotionUserView();
/**
 * 更新会员等级系统
 * @param vo MemberLevelSystemVO型，界面层传来的VO对象
 */
	public void updateMemberLevelSystem(MemberLevelSystemVO vo);
/**
 * 增加会员等级系统
 * @param vo MemberLevelSystemVO型，界面层传来的VO对象
 */
	public void addMemberLevelSystem(MemberLevelSystemVO vo);
/**
 * 获取会员等级系统
 * @return 返回会员等级系统
 */
	public MemberLevelSystemVO getMemberLevelSystem();
	/**
	 * 由于会员等级系统的更新，需要更新所有客户的会员等级
	 * @return 返回操作是否成功
	 */
	public boolean updateAllLevel();

}
