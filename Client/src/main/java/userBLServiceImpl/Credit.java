package userBLServiceImpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dataService.CreditDataService;
import dataService.DataFactoryService;
import po.CreditPO;
import promotionMemberGrade.PromotionMemberGradeController;
import rmi.RemoteHelper;
import vo.CreditRecordVO;
import vo.CreditVO;
import vo.MemberLevelSystemVO;
/**
 * 负责对于信用值的操作
 * @author LZ
 * @version 1.0
 * @see vo.CreditRecordVO
 */
public class Credit {
	private HashMap<String,CreditVO> map;
	private PromotionInfo pi;
	DataFactoryService df;
	CreditDataService cd;
	public Credit() throws RemoteException{
		df=RemoteHelper.getInstance().getDataFactoryService();
		cd=(CreditDataService) df.getDataService("Credit");
		map=new HashMap<String,CreditVO>();
		init();
	}
	private void init() throws RemoteException{
		ArrayList<CreditPO> list=cd.getAllCredit();
		for(int i=0;i<list.size();i++){
			CreditVO vo=new CreditVO(list.get(i));
			map.put(vo.customerID,vo);
		}
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
		if(map.containsKey(vo.account)){
			map.get(vo.account).credit=vo.currentcredit;
			updateLevel(vo.account,vo.currentcredit);//更新等级
			CreditPO po=new CreditPO(vo.account,vo.currentcredit,map.get(vo.account).level);
			cd.update(po);
			CreditRecord cr=new CreditRecord();
			cr.add(vo.account, vo);//更新信用记录
		}
	}
	/**
	 * 更新用户等级
	 * @param UserVO型，界面层传来的VO对象
	 * @throws RemoteException
	 * @see vo.UserVO
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
			CreditPO po=new CreditPO(id,credit,map.get(id).level);
			cd.update(po);
		}
	}
	/**
	 * 更新所有客户的会员等级
	 */
	public boolean updateAllLevel() {
		for (Map.Entry<String,CreditVO> entry : map.entrySet()) {
            try {
				updateLevel(entry.getValue().customerID,entry.getValue().credit);
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
        }
		return true;
	}
	/**
	 * 添加一个CreditVO
	 * @param cvo
	 */
	public void add(CreditVO cvo) {
		if(!map.containsKey(cvo.customerID)){
			try {
				map.put(cvo.customerID, cvo);
				CreditPO po=new CreditPO(cvo.customerID,cvo.credit,cvo.level);
				cd.insert(po);
			} catch (RemoteException e) {
				System.out.println("添加Credit失败");
				e.printStackTrace();
			}
		}
	}
}
