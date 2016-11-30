package promotionMemberGrade;

import PromotionBLServiceImpl.AddMemberLevelSystem;
import PromotionBLServiceImpl.GetMemberLevelSystem;
import PromotionBLServiceImpl.UpdateMemberLevelSystem;
import VO.MemberLevelSystemVO;
public class PromotionMemberGradeController{	
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
		MemberLevelSystemVO vo=GetMemberLevelSystem.getMemberLevelSystemInstance().getMemberLevelSystem();
		double[] discount=vo.discountOfLevel;
		if(grade==0){
			return 1;
		}
		else if(grade==1){
			return discount[1];
		}
		else if(grade==1){
			return discount[2];
		}
		else if(grade==1){
			return discount[3];
		}
		else{
			return discount[4];
		}
	}
}

