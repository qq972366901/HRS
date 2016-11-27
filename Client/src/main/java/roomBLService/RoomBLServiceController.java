package roomBLService;

import java.util.ArrayList;

import VO.OrderVO;
import VO.RoomVO;
import common.MessageInput;
import common.ResultMessage;

public class RoomBLServiceController implements RoomBLService {
	
	
	
	
	
	
	
	
	//-----------------------------------------------------
	/**
     * 修改房间信息
     * 
     * @param in MessageInput型，界面输入的修改信息
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Room
     */
	public ResultMessage messageupdate(MessageInput in){
		return ResultMessage.Exist;
	}
	
	
	
    /**
     * 修改酒店含有的房间信息
     * 
     * @param in MessageInput型，界面输入的修改信息
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Room
     */
	public ResultMessage messageadd(MessageInput  in){
		return ResultMessage.Exist;
	}
	
	
	/**
     * 获得订单上的客户的个人信息和入住退房时间
     * 
     * @param vo OrderVO型，一个OrderVO，订单值对象
     * @return RoomVO返回一个房间值对象
     * @see bussinesslogic.Room
     */
	public RoomVO messageadd(OrderVO  vo){
		return new RoomVO();
	}
	
	
	/**
     * 返回可入住房间
     * 
     * @return ArrayList<RoomVO>,一个房间值对象列表
     * @see bussinesslogic.Room
     */
	public ArrayList<RoomVO> getRoom(){
		return new ArrayList<RoomVO>();
	}
	
	
	/**
     * 返回房间的价格
     * 
     * @param roomType String型，一种房间类型
     * @return 返回一个long数值
     * @see bussinesslogic.Room
     */
	public long getPrice(String roomType){
		return 200;
	}
}
