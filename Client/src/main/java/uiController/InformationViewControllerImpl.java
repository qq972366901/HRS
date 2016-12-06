package uiController;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import UserView.InformationView;
import VO.CreditVO;
import VO.UserVO;
import uiService.InformationViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class InformationViewControllerImpl implements InformationViewControllerService{
    private InformationView view;
    private UserBLService user;
    private String UserID;
    private UserVO vo;
    private CreditVO vo1;
    public InformationViewControllerImpl(String id){
    	try {
			user=new UserBLServiceController();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	UserID=id;
    	vo=user.findByID(id);
    }
    public void setView(InformationView view){
    	this.view=view;
    }
	@Override
	public void exit() {
		view.exit();
	}
	@Override
	public void reviseinformation() {
		view.reviseinformation();
	}
	@Override
	public void revisepassword() {
		view.revisepassword();
	}
	@Override
	public String getUserID() {
		return UserID;
	}
	@Override
	public Vector<String> getInformation(String UserID) {
		Vector<String> data=new Vector<String>();
		data.add(vo.username);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");		
		data.add(sdf.format(vo.birthday.getTime()));
		data.add(vo.contactway);
		data.add(vo.enterprise);
		data.add(vo.membertype);
		data.add(""+user.showLevel(UserID));
		data.add(""+user.showCredit(UserID));
		return data;
	}
}
