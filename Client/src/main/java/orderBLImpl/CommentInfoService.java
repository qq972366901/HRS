package orderBLImpl;

import po.OrderPO;

public interface CommentInfoService {
	public void update();
	public void setComment(String str);
	public void setscore(int sc);
	public OrderPO getPO();
}
