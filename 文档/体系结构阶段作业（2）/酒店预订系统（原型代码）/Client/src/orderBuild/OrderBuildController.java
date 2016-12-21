package orderBuild;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.Hotel;
import Object.RoomType;
import Object.Time;
import VO.HotelVO;
import VO.OrderVO;
import VO.UserVO;
import common.ResultMessage;
import common.UserType;
import orderBLService.OrderBLService_realize;
public class OrderBuildController extends OrderBLService_realize{
	/**
     * 生成一个订单对象
     * 
     * @param currentTime Time型，当前时间
     * @param in Time型，入住时间
     * @param out Time型，离开时间
     * @param ddl Time型，预计离开时间
     * @param roomType RoomType型，房间类型
     * @param num int型，房间号
     * @param numOfPerson int型，住店人数
     * @param hasChild Boolean型，是否有小孩
     * @see bussinesslogic.Order
     */
	public void makeOrder(Time currentTime,
			Time in,Time out,Time ddl,
			RoomType roomType,int num,
			int numOfPerson,
			boolean haveChild ) {
	}
	
	
	
	/**
     * 判断订单是否生成
     * 
     * @param userID String型，客户编号
     * @return 若已生成则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean whetherMake(String uerID) {
		return false;
	}
	/**
     * 计算订单价值并显示
     * 
     * @param vo OrderVO型，订单的值对象
     * @param userID String型，客户编号
     * @return long，订单的价值
     * @see bussinesslogic.Order
     */
	public long getPrice(OrderVO vo,String userID) {
		return 200;
	}
	
	
	/**
     * 计算订单价值并显示
     * 
     * @param vo OrderVO型，订单的值对象
     * @return ResultMessage的一个枚举值
     * @see bussinesslogic.Order
     */
	public ResultMessage payment(OrderVO vo) {
		return ResultMessage.Exist;
	}
}
