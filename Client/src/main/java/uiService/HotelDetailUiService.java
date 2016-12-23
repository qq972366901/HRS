package uiService;

import java.util.List;

import UserView.HotelDetailView;
import VO.HotelVO;
import VO.OrderVO;
/**
 * 负责实现酒店详细信息及相关订单的初始界面
 * @author 刘宇翔
 *
 */
public interface HotelDetailUiService {
	  /**
	   * 设置一个HotelDetailView的panel
	   * @param view
	   */
      public void setView(HotelDetailView view);
      /**
       * 根据酒店id获得酒店详情
       * @param hotelID 酒店id
       * @return 酒店详情
       */
      public HotelVO findByhotelID(String hotelID);
      /**
       * 获得酒店id
       * @return 酒店id HotelID
       */
      public String getHotelID();
      /**
       * 获得客户ID
       * @return 客户iD
       */
      public String getUserID();
      /**
       * 返回界面的实现
       */
      public void exit();
      /**
       * 获得酒店下所有该用户的订单
       * @return 订单列表
       */
      public List<OrderVO> getOrderList();
}
