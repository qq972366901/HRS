package orderEvaluation;

import orderBLImpl.Comment;

/**
 * 评价订单
 * 记录客户对于订单的评价和评论，更新到该订单信息中
 * @author Lyx
 * 
 *
 */
public class OrderEvaluationController{
	Comment ct;
	public OrderEvaluationController() {
		ct=new Comment();
	}
	/**
     * 更新客户评论
     * 
     * @param String comment,客户的评论
     * @param int score,客户的评分
     * @param String UserID，客户的id
     * @param String OrderID，订单的id
	 * @ 
     * @see bussinesslogic.Order
     */
	public void updatecomment(String comment,int score,String UserID,String orderID) {
		ct.updatecomment(comment, score, UserID, orderID);
	}
}
