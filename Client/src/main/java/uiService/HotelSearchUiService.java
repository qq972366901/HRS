package uiService;

import java.util.ArrayList;
import java.util.List;

import Object.Hotel;
import UserView.HotelSearchView;
import VO.HotelVO;
import common.MessageInput;
import common.ResultMessage;

public interface HotelSearchUiService {
	public void setView(HotelSearchView view);
	public void toUserView(String id);
	public void toHotelBrowseView(String id);
	public void toOrderBuildView(String id);
	public List<HotelVO> getHistoryHotel(String userID);
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid);
	public ResultMessage messagelook(HotelVO hvo);
	public ArrayList<HotelVO> messagesearch(MessageInput in);
	public  ArrayList<HotelVO> historylook(String  id);
	public HotelVO pricesort(ArrayList<Hotel>  ah);
	public HotelVO starsort(ArrayList<Hotel>  ah);
	public HotelVO scoresort(ArrayList<Hotel>  ah);
}
