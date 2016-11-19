package promotionBLService;
import java.util.*;
import VO.*;
import common.*;
import Object.*;

/**
 * 负责实现营销策略界面所需要的服务接口  
 * @author 刘宇翔
 * @version 1.0
 * @see presentation.Promotion
 */

public interface PromotionBLService {
    /**
     * 添加一种新的酒店营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyhotel (PromotionVO vo);
	
	
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyweb (PromotionVO vo ); 

	
	/**
     * 标记会员等级标准
     * 
     * @param vo PromotionVO型，界面输入的会员等级标注
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage memberlevelmade(PromotionVO vo);

	
	/**
     * 取消一个订单
     * 
     * @param promotion Promotion型，需要取消的订单
     * @return 取消成功则返回true，否则返回true
     * @see bussinesslogic.Promotion
     */
	public boolean cancel(Promotion promotion);
	
	
	/**
     * 显示所有能用的营销策略
     * 
     * @param userID String型，客户的ID
     * @return ArrayList<PromotionVO>，一个营销策略值对象的列表
     * @see bussinesslogic.Promotion
     */
	public ArrayList<PromotionVO> getPromotion(String userID);
	
	public ArrayList<PromotionVO> getAllWebPromotion();


	public boolean deleteStrategy(int strategyNo);


	public void updateMemberLevelSystem(PromotionVO vo);


	public void addMemberLevelSystem(PromotionVO vo);


	public PromotionVO getMemberLevelSystem();
}
