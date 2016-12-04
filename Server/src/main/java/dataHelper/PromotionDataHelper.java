package dataHelper;

import java.util.List;

import PO.PromotionPO;

public interface PromotionDataHelper {
	/**
	 * 在数据库中增加一个po记录
	 * @param po PromotionPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.Promotion
	 */
	public void insert(PromotionPO po);
	/**
	 * 在数据库中删除一个po
	 * @param po PromotionPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.Promotion
	 */
	public void delete(PromotionPO po);
	/**
	 *在数据库中更新一个po
	 * @param po PromotionPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.Promotion
	 */
	public void update(PromotionPO po);
	/**
	 * 按策略ID进行查找返回相应的PromotionPO结果
	 * 
	 * @param id String型，界面输入的策略id
	 * @return 返回对应的PromotionPO
	 */	
	public PromotionPO find(String id);
	/**
	 * 获取所有的网站策略
	 * 
	 * @return 返回对应的PromotionPO列表
	 */	
	public List<PromotionPO> getAllWebPromotion();
	/**
	 * 获取所有的酒店策略
	 * 
	 * @return 返回对应的PromotionPO列表
	 */	
	public List<PromotionPO> getAllHotelPromotion();
	/**
	 *获取会员等级系统
	 * 
	 * @return 返回对应的PromotionPO
	 */	
	public PromotionPO getSystemMemberGrade();

}
