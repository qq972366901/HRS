package uiService;

import java.util.List;

import UserView.HistroyHotelView;

public interface HistroyHotelViewControllerService {

	public void exit();
    public void setView(HistroyHotelView view);
    public List<String> getHotelName(String id);
    public String getUserID();
    public void intoOrderList(int i);
}
