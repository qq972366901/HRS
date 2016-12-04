package dataHelper;

import java.util.ArrayList;
import java.util.List;

import PO.PromotionPO;

public interface PromotionDataHelper {

	void insert(PromotionPO po);

	void delete(PromotionPO po);

	void update(PromotionPO po);
	
	void finish();
	
	void init();
	
	void find(String id);

	List<PromotionPO> getAllWebPromotion();

	List<PromotionPO> getAllHotelPromotion();

	PromotionPO getSystemMemberGrade();

}
