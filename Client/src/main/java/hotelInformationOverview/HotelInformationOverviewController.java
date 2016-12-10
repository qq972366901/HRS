package hotelInformationOverview;

import HotelBLServiceImpl.HotelInfo;
import VO.HotelVO;
public class HotelInformationOverviewController{
	
	/**
     * 根据酒店帐号返回酒店详细信息
     * 
     * @param hotelID String型，酒店帐号
     * @return 返回此酒店的详细信息
     */
	public HotelVO findByHotelID(String hotelID) {
		HotelInfo hotelInfo = new HotelInfo(hotelID);
		return hotelInfo.getHotelVO();
	}
	/**
     * 酒店信息浏览得到酒店平均评分
     * 
     * @param hotelid String型，酒店帐号
     * @return 返回此酒店的平均评分
     */
	public double getHotelScore(String hotelid) {
		HotelInfo hotelInfo = new HotelInfo(hotelid);
		return hotelInfo.getHotelScore();
	}
	
	
	
	
	//---------------------------------------
//	HotelBLService hotel = new HotelBLServiceController();
//	RoomBLService room = new RoomBLServiceController();
//	/**
//     * 酒店列表按照星级从高到低排序
//     * 
//     * @param hotelIDList List<String>型，酒店帐号列表
//     * @return 返回按照星级从高到低排序后的酒店列表
//     */
//	private List<String> starSortHigh(List<String> hotelIDList) {
//		List<HotelVO> temp = new ArrayList<HotelVO>();
//		for(int i=0;i<hotelIDList.size();i++) {
//			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
//			temp.add(vo);
//		}
//		for(int i=0;i<temp.size();i++) {
//			for(int j=i;j<temp.size();j++) {
//				if(temp.get(j).hotelStar > temp.get(i).hotelStar) {
//					HotelVO hvo = temp.get(i);
//					temp.set(i, temp.get(j));
//					temp.set(j, hvo);
//				}
//			}
//		}
//		List<String> outcome = new ArrayList<String>();
//		for(int i=0;i<temp.size();i++) {
//			outcome.add(temp.get(i).hotelAccount);
//		}
//		return outcome;
//	}
//	/**
//     * 酒店列表按照星级从低到高排序
//     * 
//     * @param hotelIDList List<String>型，酒店帐号列表
//     * @return 返回按照星级从低到高排序后的酒店列表
//     */
//	private List<String> starSortLow(List<String> hotelIDList) {
//		List<HotelVO> temp = new ArrayList<HotelVO>();
//		for(int i=0;i<hotelIDList.size();i++) {
//			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
//			temp.add(vo);
//		}
//		for(int i=0;i<temp.size();i++) {
//			for(int j=i;j<temp.size();j++) {
//				if(temp.get(j).hotelStar < temp.get(i).hotelStar) {
//					HotelVO hvo = temp.get(i);
//					temp.set(i, temp.get(j));
//					temp.set(j, hvo);
//				}
//			}
//		}
//		List<String> outcome = new ArrayList<String>();
//		for(int i=0;i<temp.size();i++) {
//			outcome.add(temp.get(i).hotelAccount);
//		}
//		return outcome;
//	}
//	/**
//     * 酒店列表按照评分从高到低排序
//     * 
//     * @param hotelIDList List<String>型，酒店帐号列表
//     * @return 返回按照评分从高到低排序后的酒店列表
//     */
//	private List<String> scoreSort(List<String> hotelIDList) {
//		List<HotelVO> temp = new ArrayList<HotelVO>();
//		for(int i=0;i<hotelIDList.size();i++) {
//			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
//			temp.add(vo);
//		}
//		for(int i=0;i<temp.size();i++) {
//			for(int j=i;j<temp.size();j++) {
//				if(temp.get(j).score > temp.get(i).score) {
//					HotelVO hvo = temp.get(i);
//					temp.set(i, temp.get(j));
//					temp.set(j, hvo);
//				}
//			}
//		}
//		List<String> outcome = new ArrayList<String>();
//		for(int i=0;i<temp.size();i++) {
//			outcome.add(temp.get(i).hotelAccount);
//		}
//		return outcome;
//	}
//	/**
//     * 酒店列表按照房间最低价格从高到低排序
//     * 
//     * @param hotelIDList List<String>型，酒店帐号列表
//     * @return 返回按照房间最低价格从高到低排序后的酒店列表
//     */
//	private List<String> priceSortHigh(List<String> hotelIDList) {
//		for(int i=0;i<hotelIDList.size();i++) {
//			for(int j=i;j<hotelIDList.size();j++) {
//				if(room.getRoomLowestPrice(hotelIDList.get(i)) < room.getRoomLowestPrice(hotelIDList.get(j))) {
//					String s = hotelIDList.get(i);
//					hotelIDList.set(i, hotelIDList.get(j));
//					hotelIDList.set(j, s);
//				}
//			}
//		}
//		return hotelIDList;
//	}
//	/**
//     * 酒店列表按照房间最低价格从低到高排序
//     * 
//     * @param hotelIDList List<String>型，酒店帐号列表
//     * @return 返回按照房间最低价格从低到高排序后的酒店列表
//     */
//	private List<String> priceSortLow(List<String> hotelIDList) {
//		for(int i=0;i<hotelIDList.size();i++) {
//			for(int j=i;j<hotelIDList.size();j++) {
//				if(room.getRoomLowestPrice(hotelIDList.get(i)) > room.getRoomLowestPrice(hotelIDList.get(j))) {
//					String s = hotelIDList.get(i);
//					hotelIDList.set(i, hotelIDList.get(j));
//					hotelIDList.set(j, s);
//				}
//			}
//		}
//		return hotelIDList;
//	}

}


















