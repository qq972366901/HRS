package HistroyHotelView;

import java.util.List;

public interface HistroyHotelViewControllerService {

	public void exit();
    public void setView(HistroyHotelView view);
    public List<String> getHotelName(String id);
    public String getUserID();
    public void intoOrderList(String HotelName);
}
