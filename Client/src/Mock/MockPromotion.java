package Mock;

import java.util.Calendar;

import VO.PromotionVO;

public class MockPromotion extends PromotionVO{
		   private static final long serialVersionUID=1L;
		   /**
			 * 构造营销策略数据实体
			 * @param promotionnumber String型，逻辑层传来的营销策略编号
			 * @param promotionname String型，逻辑层传来的营销策略名称
			 * @param promotionstate int型，逻辑层传来的营销策略状态
			 * @param begintime Calendar型，逻辑层传来的开始时间
			 * @param endtime Calendar型，逻辑层传来的结束时间
			 * @param applyusertype String型，逻辑层传来的适用用户类型
			 * @param applybcircle String型，逻辑层传来的适用商圈
			 * @param applyusershipgrade int型，逻辑层传来的适用用户等级
			 * @param mininum int型，逻辑层传来的最少房间数
			 * @param promotiondiscount double型，逻辑侧传来的折扣
			 * @param usertype String型，数据层传来的用户类型
			 * @param usershipgrade int型，数据层传来的用户等级
			 * @param roomnum int型，数据层传来订购房间数
			 * @param birthday Calendar型，数据层传来的生日
			 *
			 * @return
			 * @throws
			 * @see
			 */
		   public MockPromotion(String promotionnumber,String promotionname,int promotionstate,Calendar promotionbegintime,Calendar promotionendtime,String applyusertype,String applybcircle,int applyusershipgrade,int mininum, double promotiondiscount,String usertype,int usershipgrade,int roomnum,Calendar birthday) {
				 promotionNumber=promotionnumber;
				 promotionName=promotionname;
				 promotionState=promotionstate;
				 promotionBegintime=promotionbegintime;
				 promotionEndtime=promotionendtime;
				 applyuserType=applyusertype;
				 applybusinesscircle=applybcircle;
				 applyuserShipgrade=applyusershipgrade;
				 miniNum=mininum;
				 promotionDiscount=promotiondiscount;
				 userType=usertype;
				 userShipgrade=usershipgrade;
				 roomNum=roomnum;
				 Birthday=birthday;
				}
			/**
			 * 构造会员等级制度
			 * @param a int[]型，逻辑层传来的每个等级的信用值
			 * @param b int[]型。逻辑层传来的每个等级的折扣
			 * @return 
			 * @return
			 * @throws
			 * @see
			 */
			public void PromotionPO(int a[],double b[]){
				for(int i=0;i<a.length;i++){
					creditOfLevel[i]=a[i];
				}
				for(int i=0;i<b.length;i++){
					discountOfLevel[i]=b[i];
				}
			}
			/**
			 * 获取每个等级的信用值
			 * @param
			 * @return 返回每个等级的信用值
			 * @throws
			 * @see
			 */
			 public int[] getCreditOfLevel(){
				 return creditOfLevel;
			 }
			 /**
				 * 设置策略每个等级信用值
				 * @param a int[]型，逻辑层传来的每个等级的信用值
				 * @return 
				 * @throws
				 * @see
				 */
			 public void setCreditOfLevel(int[] a){
				 for(int i=0;i<a.length;i++){
					creditOfLevel[i]=a[i];
				}
			 }
			 /**
				 * 获取每个等级的折扣
				 * @param
				 * @return 返回每个等级的折扣
				 * @throws
				 * @see
				 */
			 public double[] getDiscountOfLevel(){
				 return discountOfLevel;
			 }
			 /**
				 * 设置策略每个等级折扣
				 * @param b int[]型。逻辑层传来的每个等级的折扣
				 * @return
				 * @throws
				 * @see
				 */
			 public void setDiscountOfLevel(double[] b){
				 for(int i=0;i<b.length;i++){
						discountOfLevel[i]=b[i];
					}
			 }
			 /**
				 * 获取策略编号
				 * @param
				 * @return 返回策略编号
				 * @throws
				 * @see
				 */
			 public String getPromotionNumber(){
			     return promotionNumber;
			 }
			 /**
				 * 设置策略编号
				 * @param number String型，逻辑层传来的策略编号
				 * @return
				 * @throws
				 * @see
				 */
			 public void setPromotionNumber(String number){
			     promotionNumber=number;
			 }
			 /**
				 * 获取策略名称
				 * @param
				 * @return 返回策略名称
				 * @throws
				 * @see
				 */
			 public String getPromotionName(){
			     return promotionName;
			 }
			 /**
				 * 设置策略名称
				 * @param name String型，逻辑层传来的策略名称
				 * @return
				 * @throws
				 * @see
				 */
			 public void setPromotionName(String name){
			     promotionName=name;
			 }
			 /**
				 * 获取策略状态
				 * @param
				 * @return 返回策略状态
				 * @throws
				 * @see
				 */
			 public int getPromotionState(){
			     return promotionState;
			 }
			 /**
				 * 设置策略状态
				 * @param state int型，逻辑层传来的策略状态
				 * @return
				 * @throws
				 * @see
				 */
			 public void setPromotionState(int state){
			     promotionState=state;
			 }
			 /**
				 * 获取策略开始时间
				 * @param
				 * @return 返回策略开始时间
				 * @throws
				 * @see
				 */
			 public Calendar getPromotionBegintime(){
			     return promotionBegintime;
			 }
			 /**
				 * 设置策略开始时间
				 * @param begintime Time型，逻辑层传来的开始时间
				 * @return
				 * @throws
				 * @see
				 */
			 public void setPromotionBegintime(Calendar begintime){
			     promotionBegintime=begintime;
			 }
			 /**
				 * 获取策略结束时间
				 * @param
				 * @return 返回策略结束时间
				 * @throws
				 * @see
				 */
			 public Calendar getPromotionEndtime(){
			     return promotionEndtime;
			 }
			 /**
				 * 设置策略结束时间
				 * @param endtime Time型，逻辑层传来的结束时间
				 * @return
				 * @throws
				 * @see
				 */
			 public void setPromotionEndtime(Calendar endtime){
			     promotionEndtime=endtime;
			 }
			 /**
				 * 获取客户适用类型
				 * @param
				 * @return 返回客户适用类型
				 * @throws
				 * @see
				 */   
			 public String getUserType(){
			     return applyuserType;
			 }
			 /**
				 * 设置客户适用种类
				 * @param type String 型，逻辑层传来的客户适用种类
				 * @return
				 * @throws
				 * @see
				 */
			 public void setUserType(String type){
			    applyuserType=type;
			 }
			 /**
				 * 获取适用商圈
				 * @param 
				 * @return 返回适用商圈
				 * @throws
				 * @see
				 */
			 public String getHotelBussinesscircle(){
			    return applybusinesscircle;
			 }
			 /**
				 * 设置适用商圈
				 * @param circle String型，逻辑层传来的适用商圈
				 * @return
				 * @throws
				 * @see
				 */
			 public void setHotelBussinesscircle(String circle){
				 applybusinesscircle=circle;
			 }
			 /**
				 * 获取客户适用等级
				 * @param
				 * @return 返回客户适用等级
				 * @throws
				 * @see
				 */
			 public int getUserShipgrade(){
			     return applyuserShipgrade;
			 }
			 /**
				 * 设置客户适用等级
				 * @param grade int型，逻辑层传来的客户适用等级
				 * @return
				 * @throws
				 * @see
				 */
			 public void setUserShipgrade(int grade){
			     applyuserShipgrade=grade;
			 }
			 /**
				 * 获取最低订购数量
				 * @param
				 * @return 返回最低订购数量
				 * @throws
				 * @see
				 */
			 public int getMiniNum(){
			     return miniNum;
			 }
			 /**
				 * 设置最低订购数量
				 * @param num int型，逻辑层传来的最低订购数量
				 * @return
				 * @throws
				 * @see
				 */
			 public void setMiniNUm(int num){
			     miniNum=num;
			 }
			 /**
				 * 获取策略折扣
				 * @param
				 * @return 返回策略折扣
				 * @throws
				 * @see
				 */
			 public double getPromotionDiscount(){
			     return promotionDiscount;
			 }
			 /**
				 * 设置策略折扣
				 * @param discount double型，逻辑层传来的策略折扣
				 * @return
				 * @throws
				 * @see
				 */
			 public void setPromotionDiscount(double discount){
			     promotionDiscount=discount;
			 }
		}
