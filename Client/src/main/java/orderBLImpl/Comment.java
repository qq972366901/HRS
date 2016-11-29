package orderBLImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import PO.OrderPO;
import VO.CommentVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import dataService.OrderDataService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 订单的评价实现类
 * @author Administrator
 *
 */
public class Comment {
	private DataFactoryService DataFactory;
    private OrderDataService orderData;
    private HotelDataService hotelData;
    private UserDataService userData;
    
    public Comment() {   
 	   try {
 		  DataFactory=RemoteHelper.getInstance().getDataFactoryService();
		orderData= (OrderDataService) DataFactory.getDataService("Order");
		//userData= (UserDataService) DataFactory.getDataService("User");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	   
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
		try {
			System.out.println("update!");
			
			orderData= (OrderDataService) DataFactory.getDataService("Order");
			OrderPO po = orderData.find(orderID);
			System.out.println(po.getOrderNumber()+"         "+po.getScore() + "            "+po.getComment());
			CommentVO vo=new CommentVO(po);
			vo.comment=comment;
			vo.score=score;
			vo.update();
			orderData.update(po);
			OrderPO po1=orderData.find(orderID);
			System.out.println(po1.getOrderNumber()+"         "+po1.getScore()+ "            "+po1.getComment());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
	public List<CommentVO> getHotelComment(String HotelID) {
		List<OrderPO> orderlist;
		try {
			orderlist = orderData.findByType(HotelID);
			List<CommentVO> commentlist=new ArrayList<CommentVO>();
			for(OrderPO order:orderlist){
				commentlist.add(new CommentVO(order));
			}
			return commentlist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return null;
		}	
	}
}
