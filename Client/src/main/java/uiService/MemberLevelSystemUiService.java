package uiService;

import VO.MemberLevelSystemVO;
import WebPromotionView.MemberLevelSystemView;

public interface MemberLevelSystemUiService {

	public void setView(MemberLevelSystemView view);

	public void toWebPromotionUserView();

	public void updateMemberLevelSystem(MemberLevelSystemVO vo);

	public void addMemberLevelSystem(MemberLevelSystemVO vo);

	public MemberLevelSystemVO getMemberLevelSystem();

	public boolean updateAllLevel();

}
