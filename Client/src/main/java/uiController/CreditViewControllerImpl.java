package uiController;

import java.util.List;

import Service.Impl.UserBLServiceImpl;
import UserView.CreditView;
import VO.CreditRecordVO;
import VO.OrderVO;
import uiService.CreditViewControllerService;
import userBLImpl.Credit;
import userBLService.UserBLService;

public class CreditViewControllerImpl implements CreditViewControllerService {
	private CreditView view;
	private String id;
	private UserBLService user;
	public CreditViewControllerImpl(String id){
		this.id=id;
		user=new UserBLServiceImpl();
		
	}
	public void setView(CreditView view) {
		// TODO Auto-generated method stub
        this.view=view;
	}
	@Override
	public long getcredit(String id) {
		return user.showCredit(id);//c.showCredit(id);		
	}
	public void exit() {
		view.exit();		
	}
	@Override
	public String getUserID() {
		return id;
	}
	@Override
	public List<CreditRecordVO> getCreditRecord(String id) {
		return user.showCreditRecord(id);
	}
}
