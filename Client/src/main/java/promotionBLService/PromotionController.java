package promotionBLService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import PromotionBLServiceImpl.GetMemberLevelSystem;
import VO.MemberLevelSystemVO;
import VO.WebPromotionVO;
import promotionHotel.PromotionHotelController;
import promotionMemberGrade.PromotionMemberGradeController;
import promotionWeb.PromotionWebController;

/**
 * Promotion模块的实现
 * @author LW
 *
 */
public class PromotionController implements PromotionBLService {
		private PromotionHotelController promotionHotelController;
		private PromotionWebController promotionWebController;
		private PromotionMemberGradeController promotionMemberGradeController;
		/**
		 * 初始化
		 * @throws RemoteException 
		 */
		public PromotionController() throws RemoteException{
			this.promotionHotelController=new PromotionHotelController();
			this.promotionWebController=new PromotionWebController();
			this.promotionMemberGradeController=new PromotionMemberGradeController();
		}
	  /**
     * 添加一种新的酒店营销策略，并公布
     * 
     * @param vo HotelPromotionVO型，界面输入的营销策略
     * @return
     * @see bussinesslogic.Promotion
     */
	public void madebyhotel (String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount){
		promotionHotelController.madebyhotel (hotelid,promotionname,promotionbegintime,promotionendtime,promotiondiscount,birthdaydiscount,roomdiscount,enterprisediscount);
	}

	/**
	 * 得到在下订单时客户能获得的酒店营销策略折扣
     */
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime){
		return promotionHotelController.getHotelPromotionDiscount(hotelid,userID,roomNumber,orderbuildtime);
	}
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo WebPromotionVO型，界面输入的营销策略
     * @see bussinesslogic.Promotion
     */
	public void madebyweb(String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,String applycity,String applybussinesscircle,int applymembergrade){
		promotionWebController.madebyweb(promotionnumber,promotionname,promotionbegintime,promotionendtime,applycity,applybussinesscircle,applymembergrade);
	}
	/**
     * 得到所有的网站营销策略
     */
	public Vector<Vector<String>> getAllWebPromotion(){
		return promotionWebController.getAllWebPromotion();
	}
	/**
	 * 通过策略ID查找策略
     */
	public WebPromotionVO getWebPromotionByPromotionNumber(String promotionnumber){
		return promotionWebController.getWebPromotionByPromotionNumber(promotionnumber);
	}
	/**
	 * 得到在下订单时客户能获得的网站营销策略折扣
	 * @throws  
     */
	public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime){
		try {
			return promotionWebController.getWebPromotionDiscount(userID,city,bussinesscircle,orderbuildtime);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 根据策略编号删除策略
     */
	public boolean deleteWebPromotion(String promotionnumber){
		return promotionWebController.deleteWebPromotion(promotionnumber);
	}
	/**
     * 添加一种新的会员等级制度
     * 
     * @param vo long[]和double[]型，界面输入数据
     * @see bussinesslogic.Promotion
     */
	public void addMemberLevelSystem(long credit[],double discount[]){
		promotionMemberGradeController.addMemberLevelSystem(credit,discount);
	}
	/**
     * 更新的会员等级制度
     * 
     * @param vo long[]和double[]型，界面输入数据
     * @see bussinesslogic.Promotion
     */
	public void updateMemberLevelSystem(long credit[],double discount[]){
		promotionMemberGradeController.updateMemberLevelSystem(credit,discount);
	}
	/**
     * 得到会员等级制度
     * 
     * @param
     * @see bussinesslogic.Promotion
     */
	public MemberLevelSystemVO getMemberLevelSystem(){
		return promotionMemberGradeController.getMemberLevelSystem();		
	}
	/**
     *根据等级获取折扣
     * 
     * @param
     * @see bussinesslogic.Promotion
     */
	public double getDiscountOfLevel(int grade){
		return promotionMemberGradeController.getDiscountOfLevel(grade);
	}
}
