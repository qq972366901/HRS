package promotionHotel;
import VO.PromotionVO;
import common.ResultMessage;
import promotionBLService.PromotionBLService_realize;
public class PromotionHotelController extends PromotionBLService_realize {
	  /**
     * 添加一种新的酒店营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyhotel (PromotionVO vo) {
		return ResultMessage.Exist;
	}

}
