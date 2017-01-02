package promotionMemberGrade;

import promotionBLServiceImpl.AddMemberLevelSystem;
import promotionBLServiceImpl.GetMemberLevelSystem;
import promotionBLServiceImpl.UpdateMemberLevelSystem;
import userBLServiceImpl.PromotionInfo;
import vo.MemberLevelSystemVO;
public class PromotionMemberGradeController implements PromotionInfo{	
	/**
     * 添加一种新的会员等级制度
     * 
     * @param vo long[]和double[]型，界面输入数据
     * @see bussinesslogic.Promotion
     */
	public void addMemberLevelSystem(long credit[],double discount[]){
		AddMemberLevelSystem.getAddMemberLevelSystemInstance().addMemberLevelSystem(credit,discount);
	}
	/**
     * 更新的会员等级制度
     * 
     * @param vo long[]和double[]型，界面输入数据
     * @see bussinesslogic.Promotion
     */
	public void updateMemberLevelSystem(long credit[],double discount[]){
		UpdateMemberLevelSystem.getUpdateMemberLevelSystemInstance().updateMemberLevelSystem(credit,discount);
	}
	/**
     * 得到会员等级制度
     * 
     * @param
     * @see bussinesslogic.Promotion
     */
	public MemberLevelSystemVO getMemberLevelSystem(){
		return GetMemberLevelSystem.getMemberLevelSystemInstance().getMemberLevelSystem();
	}
	/**
     *根据等级获取折扣
     * 
     * @param
     * @see bussinesslogic.Promotion
     */
	public double getDiscountOfLevel(int grade){
		return GetMemberLevelSystem.getMemberLevelSystemInstance().getDiscountOfLevel(grade);
	}
}

