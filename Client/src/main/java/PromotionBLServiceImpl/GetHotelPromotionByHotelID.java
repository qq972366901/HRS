package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.PromotionPO;
import VO.HotelPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class GetHotelPromotionByHotelID {
	private DataFactoryService df;
	private PromotionDataService pds;
	private List<HotelPromotionVO> voList;
	private static GetHotelPromotionByHotelID getHotelPromotionByHotelID;
	private GetHotelPromotionByHotelID() {
		voList=new ArrayList<HotelPromotionVO>();
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
	
	public static GetHotelPromotionByHotelID getHotelPromotionByHotelIDInstance() {
		if(getHotelPromotionByHotelID== null) {
			getHotelPromotionByHotelID= new GetHotelPromotionByHotelID();
		}
		return getHotelPromotionByHotelID;
	}
	public HotelPromotionVO getHotelPromotionByHotelID(String hotelid) {
		HotelPromotionVO  hpvo=new HotelPromotionVO();
		for(HotelPromotionVO vo : voList) {
		if(getHotelPromotionByHotelID.judgeHotelID(vo,hotelid)) {				
			    hpvo=vo;
				break;
			}
		}
		return hpvo;
	}
	private boolean judgeHotelID(HotelPromotionVO vo,String hotelid) {
		boolean outcome = false;
		if(vo.hotelID==hotelid) {
			outcome = true;
		}
		return outcome;
	}
}
