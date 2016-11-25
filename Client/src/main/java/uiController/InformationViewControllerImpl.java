package uiController;

import Service.Impl.UserBLServiceImpl;
import UserView.InformationView;
import VO.UserVO;
import uiService.InformationViewControllerService;
import userBLService.UserBLService;

public class InformationViewControllerImpl implements InformationViewControllerService{
    private InformationView view;
    private UserBLService user;
    private String UserID;
    private UserVO vo;
    public InformationViewControllerImpl(String id){
    	user=new UserBLServiceImpl();
    	UserID=id;
    	vo=new UserVO();
    }
    public void setView(InformationView view){
    	this.view=view;
    }
	@Override
	public void exit() {
		view.exit();
	}
	@Override
	public void getname() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getbirth() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gettel() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getenterprise() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getemail() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getlevel() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gettype() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getcredit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reviseinformation() {
		// TODO Auto-generated method stub
		view.reviseinformation();
	}
	@Override
	public void revisepassword() {
		// TODO Auto-generated method stub
		view.revisepassword();
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return UserID;
	}
}
