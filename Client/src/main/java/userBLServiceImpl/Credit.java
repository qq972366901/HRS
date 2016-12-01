package userBLServiceImpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import PO.CreditPO;
import VO.CreditRecordVO;
import VO.CreditVO;
import VO.MemberLevelSystemVO;
import dataService.CreditDataService;
import dataService.DataFactoryService;
import promotionMemberGrade.PromotionMemberGradeController;
import rmi.RemoteHelper;
/**
 * 负责对于信用值的操作
 * @author LZ
 * @version 1.0
 * @see VO.CreditRecordVO
 */
public class Credit {
	private HashMap<String,CreditVO> map;
	private PromotionInfo pi;
	private static Credit credit;
	DataFactoryService df;
	CreditDataService cd;
	private Credit() throws RemoteException{
		df=RemoteHelper.getInstance().getDataFactoryService();
		cd=(CreditDataService) df.getDataService("Credit");
		map=new HashMap<String,CreditVO>();
		ArrayList<CreditPO> list=cd.getAllCredit();
		for(int i=0;i<list.size();i++){
			CreditVO vo=new CreditVO(list.get(i));
			map.put(vo.customerID,vo);
		}
	}
	public static Credit getInstance() throws RemoteException{
		if(credit==null){
			credit=new Credit();
		}
		return credit;
	}
	/**
	 * 显示信用值
	 * @param id String型，界面层传来的客户ID
	 * @return 返回属于此ID的信用值
	 */
	public long showCredit(String id){
		return map.get(id).credit;
	}
	/**
	 * 显示信用等级
	 * @param id
	 * @return
	 */
	public int showLevel(String id){
		return map.get(id).level;
	}
	/**
	 * 根据信用记录更新信用值
	 * @param vo CreditRecordVO型，界面层传入的VO对象
	 * @throws RemoteException
	 * @throws ParseException 
	 */
	public void updateCredit(CreditRecordVO vo) throws RemoteException, ParseException{
		map.get(vo.account).credit=vo.currentcredit;
		CreditRecord.getInstance().add(vo.account, vo);
	}
	/**
	 * 更新用户等级
	 * @param UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void updateLevel(String id ,long credit) throws RemoteException{
		pi=new PromotionMemberGradeController();
		MemberLevelSystemVO level=pi.getMemberLevelSystem();
		if(map.containsKey(id)){
			if(credit<level.creditOfLevel[0]){
				map.get(id).level=0;
			}
			else if(credit>=level.creditOfLevel[4]){
				map.get(id).level=5;
			}
			else if(level.creditOfLevel[0]<=credit&&credit<level.creditOfLevel[1]){
				map.get(id).level=1;
			}
			else if(level.creditOfLevel[1]<credit&&credit<level.creditOfLevel[2]){
				map.get(id).level=2;
			}
			else if(level.creditOfLevel[2]<=credit&&credit<level.creditOfLevel[3]){
				map.get(id).level=3;
			}
			else{
				map.get(id).level=4;
			}
		}
	}
	/**
	 * 更新所有客户的会员等级
	 */
	public void updateAllLevel() {
		Iterator<String> it=map.keySet().iterator(); 
		while(it.hasNext()){   
		   try {
			updateLevel(it.next(),map.get(it.next()).credit);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		}  
	}
}
