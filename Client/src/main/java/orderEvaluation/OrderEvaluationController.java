package orderEvaluation;
import VO.OrderVO;
import orderBLService.OrderBLService_realize;
public class OrderEvaluationController extends OrderBLService_realize{
	public OrderEvaluationController(int hotelId) {
		super(hotelId);
		// TODO Auto-generated constructor stub
	}


	/**
     * 更新订单信息并显示评价
     * 
     * @param comment String型，客户评价
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void comment(String comment,OrderVO order) {
	}
	
	
	/**
     * 根据输入的ID查找订单并显示
     * 
     * @param ID String型，订单号
     * @return OrderVO，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public OrderVO findByID(String ID) {
		OrderVO ov=new OrderVO();
		return ov;
	}
}
