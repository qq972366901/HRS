package orderBLImpl;

import java.util.Calendar;

import po.OrderPO;

public interface OrderStateInfoService {
	public void Update();
	public void setOrderState(int i);
	public void setIn(Calendar time);
	public void setOut(Calendar time);
	public void setLatest(Calendar time);
	public void setCancel(Calendar time);
	public void setGen(Calendar time);
	public OrderPO getPO();
	public Calendar getLatest();
}
