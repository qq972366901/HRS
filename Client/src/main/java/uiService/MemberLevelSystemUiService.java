package uiService;

import VO.PromotionVO;

import WebPromotionView.MemberLevelSystemView;

public interface MemberLevelSystemUiService {

	public void setView(MemberLevelSystemView view);

	public void toWebPromotionUserView();

	public void updateMemberLevelSystem(PromotionVO vo);

	public void addMemberLevelSystem(PromotionVO vo);

	public PromotionVO getMemberLevelSystem();

}
