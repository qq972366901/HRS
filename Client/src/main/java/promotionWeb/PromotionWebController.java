package promotionWeb;
import VO.PromotionVO;
import common.ResultMessage;
public class PromotionWebController{
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyweb (PromotionVO vo ) {
		return ResultMessage.Exist;
	} 

	
	/**
     * 标记会员等级标准
     * 
     * @param vo PromotionVO型，界面输入的会员等级标注
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage memberlevelmade(PromotionVO vo) {
		return ResultMessage.Exist;
	}

}
