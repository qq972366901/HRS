package uiService;

import java.util.List;
import java.util.Vector;

import vo.WebPromotionVO;
import webPromotionView.WebPromotionStrategyView;
/**
 * 制定网站营销策略控制器接口
 * @author LZ
 *
 */
public interface WebPromotionStrategyUiService {
/**
 * 设置界面
 * @param view 界面层传来的panel
 */
	public void setView(WebPromotionStrategyView view);
/**
 * 跳转到网站营销人员主界面
 */
	public void toWebPromotionUserView();
/**
 * 获取所有的网站营销策略
 * @return 返回所有的网站营销策略
 */
	public Vector<Vector<String> > getAllWebPromotion();
/**
 * 处理增加策略响应
 */
	public void addButtonClicked();
/**处理删除策略响应
 * 
 */
	public void delButtonClicked();
/**
 * 删除策略
 * @param strategyNo String型，界面层传来的策略编号
 * @return 返回删除操作是否成功
 */
	public boolean deleteStrategy(String strategyNo);
/**
 * 增加网站营销策略
 * @param vo WebPromotionVO型，界面层传来的VO对象
 */
	public void addWebPromotion(WebPromotionVO vo);
/**
 * 增加商圈
 * @param city String型，商圈名称
 */
	public void addCircle(String city);
/**
 * 获取城市列表
 * @return 返回城市列表
 */
	public List<String> addCity();
/**
 * 更新数据源
 */
	public void updateListModel();
/**
 * 获取某一会员等级的对应折扣
 * @param level  int型，界面层传来的会员等级
 * @return 返回此等级对应的折扣
 */
	public Double getDiscount(int level);

}
