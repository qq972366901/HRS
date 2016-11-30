package promotionWeb;
import java.util.Calendar;
import java.util.List;

import PromotionBLServiceImpl.AddWebPromotion;
import PromotionBLServiceImpl.DeleteWebPromotion;
import PromotionBLServiceImpl.GetMemberLevelSystem;
import PromotionBLServiceImpl.SearchWebPromotion;
import VO.MemberLevelSystemVO;
import VO.WebPromotionVO;
import userBLServiceImpl.Credit;
public class PromotionWebController{
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo WebPromotionVO型，界面输入的营销策略
     * @see bussinesslogic.Promotion
     */
	public void madebyweb(String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,String applycity,String applybussinesscircle,int applymembergrade) {
        AddWebPromotion.getAddWebPromotionInstance().addWebPromotion(promotionnumber,promotionname,promotionbegintime,promotionendtime,applycity,applybussinesscircle,applymembergrade);
	} 
	/**
     * 得到所有的网站营销策略
     */
	public List<WebPromotionVO> getAllWebPromotion() {
		return  SearchWebPromotion.getSearchWebPromotionInstance().getAllWebPromotion();
	}
	/**
	 * 通过策略ID查找策略
     */
	public WebPromotionVO getWebPromotionByPromotionNumber(String promotionnumber) {
		return SearchWebPromotion.getSearchWebPromotionInstance().getWebPromotionByPromotionNumber(promotionnumber);
		
	}
	/**
	 * 得到在下订单时客户能获得的网站营销策略折扣
     */
	public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime) {
		long creditvalue=Credit.getInstance().showCredit(userID);
		MemberLevelSystemVO vo2=GetMemberLevelSystem.getMemberLevelSystemInstance().getMemberLevelSystem();
		long credit[]=vo2.creditOfLevel;
		int grade;
		if(creditvalue<credit[0]){
				grade=0;
			}
		else if(creditvalue>=credit[0]&&creditvalue<credit[1]){
			    grade=1;
		}
		else if(creditvalue>=credit[1]&&creditvalue<credit[2]){
		        grade=2;
	    }
		else if(creditvalue>=credit[2]&&creditvalue<credit[3]){
		        grade=3;
	    }
		else if(creditvalue>=credit[3]&&creditvalue<credit[4]){
		        grade=4;
	    }
		else{
		        grade=5;
		}
		WebPromotionVO vo3=SearchWebPromotion.getSearchWebPromotionInstance().getWebPromotion(orderbuildtime,city,bussinesscircle,grade);
		double discount[]=vo2.discountOfLevel;
		if(vo3==null){
			return 1;
		}
		else{
			return discount[grade-1];
		}
	}
	/**
	 * 根据策略编号删除策略
	 * @return 
     */
	public boolean deleteWebPromotion(String promotionnumber){
		return DeleteWebPromotion.getDeleteWebPromotionInstance().deleteWebPromotion(promotionnumber);
		
	}
}
