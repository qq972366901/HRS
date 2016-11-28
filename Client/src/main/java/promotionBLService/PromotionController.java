package promotionBLService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import Object.Promotion;
import VO.MemberLevelSystemVO;
import VO.PromotionVO;
import common.ResultMessage;

public class PromotionController implements PromotionBLService {
	/**
     * 添加一种新的酒店营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyhotel (PromotionVO vo){
		return ResultMessage.Exist;
	}
	
	
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public void madebyweb (PromotionVO vo ){

	}

	
	/**
     * 标记会员等级标准
     * 
     * @param vo PromotionVO型，界面输入的会员等级标注
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage memberlevelmade(PromotionVO vo){
		return ResultMessage.Exist;
	}
	
	/**
     * 取消一个订单
     * 
     * @param promotion Promotion型，需要取消的订单
     * @return 取消成功则返回true，否则返回true
     * @see bussinesslogic.Promotion
     */
	public boolean cancel(Promotion promotion){
		return true;
	}
	
	
	/**
     * 显示所有能用的营销策略
     * 
     * @param userID String型，客户的ID
     * @return ArrayList<PromotionVO>，一个营销策略值对象的列表
     * @see bussinesslogic.Promotion
     */
	public Vector<PromotionVO> getPromotion(String userID){
		return new Vector<PromotionVO>();
	}


	@Override
	public Vector<Vector<String> > getAllWebPromotion() {
		//只是为了在界面上显示而已
		Vector<Vector<String>> promotionlist=new Vector<Vector<String>>();
		Calendar time1=Calendar.getInstance();
		time1.set(2016,11,11);
		Calendar time2=Calendar.getInstance();
		time2.set(2016,11,11);
		PromotionVO vo1=new PromotionVO("xx","xx",time1,time2,"xx","xx",5,4.5);
		PromotionVO vo2=new PromotionVO("xx","xx",time1,time2,"xx","xx",5,4.5);
		promotionlist.add(vo1.getPromotion());
		promotionlist.add(vo2.getPromotion());
		return promotionlist;
	}


	@Override
	public boolean deleteStrategy(String strategyNo) {
		return true;
	}


	@Override
	public void updateMemberLevelSystem(MemberLevelSystemVO vo) {	
	}


	@Override
	public void addMemberLevelSystem(MemberLevelSystemVO vo) {	
	}


	@Override
	public MemberLevelSystemVO getMemberLevelSystem() {
		return new MemberLevelSystemVO(1,2,3,4,5,9.5,8.5,7.5,6.5,5.5);
	}


	@Override
	public Vector<String> getCity() {
		Vector<String> cities=new Vector<String>();
		cities.add("北京");
		cities.add("上海");
		cities.add("南京");//暂时这么写，需要调用逻辑层方法
		return cities;
	}

	@Override
	public Vector<String> getCircle(String city) {
		Vector<String> circles=new Vector<String>();
		if(city.equals("北京")){
			circles.addElement("北1");
			circles.addElement("北2");
			circles.addElement("北3");
		}
		else if(city.equals("上海")){
			circles.addElement("上1");
			circles.addElement("上2");
			circles.addElement("上3");
		}
		else if(city.equals("南京")){
			circles.addElement("南1");
			circles.addElement("南2");
			circles.addElement("南3");
		}
		return circles;
	}
}
