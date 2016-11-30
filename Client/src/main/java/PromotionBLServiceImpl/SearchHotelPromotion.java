package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import PO.PromotionPO;
import VO.HotelPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class SearchHotelPromotion {
	private DataFactoryService df;
	private PromotionDataService pds;
	
	private List<HotelPromotionVO> voList;
	
	private static SearchHotelPromotion searchHotelPromotion;
	
	private SearchHotelPromotion() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
			List<PromotionPO> poList = pds.getAllHotelPromotion();
			for(PromotionPO po : poList) {
				HotelPromotionVO tempvo = new HotelPromotionVO(po);
				voList.add(tempvo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static SearchHotelPromotion getSearchHotelPromotionInstance() {
		if(searchHotelPromotion== null) {
			searchHotelPromotion = new SearchHotelPromotion();
		}
		return searchHotelPromotion;
	}
	
	public HotelPromotionVO getHotelPromotion(String hotelid,Calendar time) {
		HotelPromotionVO  hpvo=new HotelPromotionVO();
		for(HotelPromotionVO vo : voList) {
		if(searchHotelPromotion.judgeHotel(vo,hotelid) &&searchHotelPromotion.judgeTime(vo,time)) {				
			    hpvo=vo;
				break;
			}
		}
		return hpvo;
	}
	
	private boolean judgeHotel(HotelPromotionVO vo, String hotelid) {
		boolean outcome = false;
		if(vo.hotelID == hotelid) {
			outcome = true;
		}
		return outcome;
	}
	private boolean judgeTime(HotelPromotionVO vo,Calendar time) {
		boolean outcome = false;
	if(time.compareTo(vo.promotionBegintime)>=0&&time.compareTo(vo.promotionEndtime)<=0) {
			outcome = true;
		}
		return outcome;
		
	}

	
	
}
