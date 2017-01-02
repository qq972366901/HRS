package orderBLImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.DataFactoryService;
import dataService.OrderDataService;
import po.OrderPO;
import rmi.RemoteHelper;
/**
 * 订单的评价实现类
 * @author Administrator
 *
 */
public class Comment {
	private DataFactoryService DataFactory;
    private OrderDataService orderData;
    private CommentInfoService info;
    public Comment() {   
 	   try {
 		  DataFactory=RemoteHelper.getInstance().getDataFactoryService();
		  orderData= (OrderDataService) DataFactory.getDataService("Order");
	} catch (RemoteException e) {
		e.printStackTrace();
	}
 	   
    }
	
	/**
     * 更新客户评论
     * 
     * @param String comment,客户的评论
     * @param int score,客户的评分
     * @param String OrderID，订单的id
	 * @ 
     * @see bussinesslogic.Order
     */
	public void updatecomment(String comment,int score,String orderID) {
		try {
			OrderPO po = orderData.find(orderID);
			info=new CommentInfo(po);
			info.setComment(comment);
			info.setscore(score);
			info.update();
			orderData.update(info.getPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取酒店的所有客户评论和评分
	 * 
	 * @param String HotelID ,酒店的ID
	 * @return List<CommentVO> 一个评价的列表;
	 * @ 
	 */
	public List<CommentInfo> getHotelComment(String HotelID) {
		List<OrderPO> orderlist;
		try {
			orderlist = orderData.findByHotelID(HotelID, 0);
			List<CommentInfo> commentlist=new ArrayList<CommentInfo>();
			for(OrderPO order:orderlist){
				if(order.getComment()!=null){
					commentlist.add(new CommentInfo(order));
				}
			}
			return commentlist;
		} catch (RemoteException e) {		
			e.printStackTrace();
			return null;
		}	
	}
}
