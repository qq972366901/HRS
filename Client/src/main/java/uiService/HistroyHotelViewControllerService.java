package uiService;

import java.util.List;

import userView.HistroyHotelView;
/**
 * 负责实现历史酒店的初始界面
 * @author 刘宇翔
 *
 */
public interface HistroyHotelViewControllerService {
    /**
     * 返回界面的实现
     */
	public void exit();
	/**
	 * 设置一个HistoryHotelView的panel
	 * @param view
	 */
    public void setView(HistroyHotelView view);
    /**
     * 获得所有历史酒店的名字
     * @param id 客户id
     * @return 酒店列表
     */
    public List<String> getHotelName(String id);
    /**
     * 获得客户id
     * @return UserID String
     */
    public String getUserID();
    /**
     * 酒店详情界面的跳转
     * @param i 第i个酒店
     */
    public void intoOrderList(int i);
}
