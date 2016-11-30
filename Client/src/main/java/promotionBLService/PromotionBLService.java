package promotionBLService;
import java.util.*;

import PromotionBLServiceImpl.GetMemberLevelSystem;
import VO.*;

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
     * @param vo HotelPromotionVO型，界面输入的营销策略
     * @return
     * @see bussinesslogic.Promotion
     */
	public void madebyhotel (String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount);

	/**
	 * 得到在下订单时客户能获得的酒店营销策略折扣
     */
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime);
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo WebPromotionVO型，界面输入的营销策略
     * @see bussinesslogic.Promotion
     */
	public void madebyweb(String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,String applycity,String applybussinesscircle,int applymembergrade);
	/**
     * 得到所有的网站营销策略
     */
	public Vector<Vector<String>> getAllWebPromotion();
	/**
	 * 通过策略ID查找策略
     */
	public WebPromotionVO getWebPromotionByPromotionNumber(String promotionnumber);
	/**
	 * 得到在下订单时客户能获得的网站营销策略折扣
     */
	public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime);
	/**
	 * 根据策略编号删除策略
     */
	public boolean deleteWebPromotion(String promotionnumber);
	/**
     * 添加一种新的会员等级制度
     * 
     * @param vo long[]和double[]型，界面输入数据
     * @see bussinesslogic.Promotion
     */
	public void addMemberLevelSystem(long credit[],double discount[]);
	/**
     * 更新的会员等级制度
     * 
     * @param vo long[]和double[]型，界面输入数据
     * @see bussinesslogic.Promotion
     */
	public void updateMemberLevelSystem(long credit[],double discount[]);
	/**
     * 得到会员等级制度
     * 
     * @param
     * @see bussinesslogic.Promotion
     */
	public MemberLevelSystemVO getMemberLevelSystem();
	/**
     *根据等级获取折扣
     * 
     * @param
     * @see bussinesslogic.Promotion
     */
	public double getDiscountOfLevel(int grade);
}
