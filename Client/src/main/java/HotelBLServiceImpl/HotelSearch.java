package HotelBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.HotelPO;
import RoomBLServiceImpl.RoomAllOfHotel;
import VO.HotelVO;
import VO.RoomVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import rmi.RemoteHelper;
/**
 * 负责酒店查找功能的具体实现
 * @author 刘宗侃
 */
public class HotelSearch {

	private DataFactoryService df;
	private HotelDataService hds;
	
	private List<HotelVO> hvoList = new ArrayList<HotelVO>();
	private List<String> hotelidList = new ArrayList<String>();
	
	private static HotelSearch hotelSearch;
	
	/**
	 * 构造类，得到所有酒店的列表
	 */
	private HotelSearch() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
			List<HotelPO> hpoList = hds.getAllHotel();
			for(HotelPO hpo : hpoList) {
				HotelVO tempvo = new HotelVO(hpo);
				hvoList.add(tempvo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
     * 查找符合客户选择条件的酒店列表
     * 
     * @return 返回HotelSearch对象
     */
	public static HotelSearch getHotelSearchInstance() {
		if(hotelSearch == null) {
			hotelSearch = new HotelSearch();
		}
		return hotelSearch;
	}
	
	/**
     * 查找符合客户选择条件的酒店列表
     * 
     * @param city String型，酒店城市，若未选择，值为null
     * @param businessCircle String型，商圈，若未选择，值为null
     * @param roomType String型，房型，若未选择，值为null
     * @param roomNumber int型，房间数量，若未选择，值为-1
     * @param priceLow int型，房间最低价格，若未选择，值为-1
     * @param priceHigh int型，房间最高价格，若未选择，值为-1
     * @param hotelStar int型，酒店星级，若未选择，值为-1
     * @param scoreLow int型，搜索选择的最低评分，若未选择，值为-1
     * @param scoreHigh int型，搜索选择的最高评分，若未选择，值为-1
     * @param everBooked String型，选择搜索的范围：全部，预定过，未预定过，若未选择，值为null
     * @param userid String型，客户的id
     * @param name String型，酒店名称，若未选择，值为null
     * 
     * @return 返回符合条件的酒店ID列表
     */
	public List<String> getHotelIDList(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int star, int scoreLow, int scoreHigh,
			String everBooked,String userid, String name) {
		for(HotelVO hvo : hvoList) {
			if(hotelSearch.judgeCity(hvo, city) && hotelSearch.judgeBusinessCircle(hvo, businessCircle)
					&& hotelSearch.judgeRoom(hvo, roomType, roomNumber, priceLow, priceHigh) && 
					hotelSearch.judgeStar(hvo, star) && hotelSearch.judgeScore(hvo, scoreLow, scoreHigh)
					&& hotelSearch.judgeEverBooked(hvo, everBooked, userid) && hotelSearch.judgeName(hvo, name)) {
				
				hotelidList.add(hvo.hotelAccount);
				
			}
		}
		
		return hotelidList;
	}
	
	private boolean judgeCity(HotelVO vo, String city) {
		boolean outcome = false;
		if(city.length() < 1 || city == null) {
			return true;
		}
		if(vo.hotelCity.equals(city)) {
			outcome = true;
		}
		return outcome;
	}
	private boolean judgeBusinessCircle(HotelVO vo, String businessCircle) {
		boolean outcome = false;
		if(businessCircle.length() < 1 || businessCircle == null) {
			return true;
		}
		if(vo.hotelDistrict.equals(businessCircle)) {
			outcome = true;
		}
		return outcome;
		
	}
	private boolean judgeRoom(HotelVO vo, String rType, int roomNumber,
			int priceLow, int priceHigh) {
		boolean outcome = false;
		int num = roomNumber;
		RoomAllOfHotel roomAllOfHotel = RoomAllOfHotel.getRoomAllOfHotelInstance(vo.hotelAccount);
		List<RoomVO> listtemp = roomAllOfHotel.getAllRooms();
		if(rType != null) {
			for(RoomVO rvo : listtemp) {
				if(rvo.roomStatue.equals("空闲") && rvo.roomType.equals(rType)
						&& rvo.roomPrice <= priceHigh && 
						rvo.roomPrice >= priceLow) {
					if(roomNumber == -1) {
						outcome = true;
						break;
					} else {
						num--;
					}
				}
				if(num <= 0 && roomNumber != -1) {
					outcome = true;
					break;
				}
			}
		} else {
			for(RoomVO rvo : listtemp) {
				if(rvo.roomStatue.equals("空闲") && rvo.roomPrice <= priceHigh && 
						rvo.roomPrice >= priceLow) {
					if(roomNumber == -1) {
						outcome = true;
						break;
					} else {
						num--;
					}
				}
				if(num <= 0 && roomNumber != -1) {
					outcome = true;
					break;
				}
			}
		}
		return outcome;
	}
	private boolean judgeStar(HotelVO vo, int star) {
		boolean outcome = false;
		if(star == -1) {
			return true;
		}
		if(vo.hotelStar >= star) {
			outcome = true;
		}
		return outcome;
	}
	private boolean judgeScore(HotelVO vo, int scoreLow, int scoreHigh) {
		boolean outcome = false;
		if(scoreLow == -1 && scoreHigh == -1) {
			return true;
		} else if(scoreLow == -1 && scoreHigh != -1) {
			if(vo.score <= scoreHigh) {
				outcome = true;
			}
		} else if(scoreLow != -1 && scoreHigh == -1) {
			if(vo.score >= scoreLow) {
				outcome = true;
			}
		} else {
			if(vo.score >= scoreLow && vo.score <= scoreHigh) {
				outcome = true;
			}
		}
		return outcome;
	}
	private boolean judgeEverBooked(HotelVO vo, String everBooked, String userid) {
		boolean outcome = false;
		if(everBooked.equals("全部") || everBooked.length() < 1 || everBooked == null) {
			return true;
		}
		HotelInfoListByUser hotelInfoListByUser = HotelInfoListByUser.getHotelInfoListByUserInstance(userid);
		List<HotelVO> listtemp = hotelInfoListByUser.getHistoryHotel();
		if(everBooked.equals("预定过")) {
			for(HotelVO tempvo : listtemp) {
				if(tempvo.hotelAccount.equals(vo.hotelAccount)) {
					outcome = true;
					break;
				}
			}
		} else if(everBooked.equals("未预定过")) {
			boolean contain = false;
			for(HotelVO tempvo : listtemp) {
				if(tempvo.hotelAccount.equals(vo.hotelAccount)) {
					contain = true;
					break;
				}
			}
			if(!contain) {
				outcome = true;
			}
		}
		return outcome;
	}
	private boolean judgeName(HotelVO vo,String name) {
		if(name.length() < 1 || name == null) {
			return true;
		}
		if(vo.hotelName.contains(name)) {
			return true;
		}
		return false;
	}
	
	
}
