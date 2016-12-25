package orderBLImpl;

import PO.OrderPO;

public interface CommentInfoService {
	public void update();
	public void setComment(String str);
	public void setscore(int sc);
	public OrderPO getPO();
}
