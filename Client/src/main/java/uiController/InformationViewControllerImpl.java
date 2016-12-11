package uiController;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import UserView.InformationView;
import VO.UserVO;
import uiService.InformationViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class InformationViewControllerImpl implements InformationViewControllerService{
    private InformationView view;
    private UserBLService user;
    private String UserID;
    private UserVO vo;
    String key;
    public InformationViewControllerImpl(String id){
		key="";
    	try {
			user=new UserBLServiceController();			
			key=Log.getLogInstance().getSKey(id);
    	    UserID=id;
    	    vo=user.findByID(id);
    	    } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		String username=DES.decryptDES(vo.username, key);
		data.add(username);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");		
		data.add(sdf.format(vo.birthday.getTime()));
		String contactway=DES.decryptDES(vo.contactway, key);
		data.add(contactway);
		if(vo.enterprise.equals(null)){
			data.add("无");
		}
		else{
			data.add(vo.enterprise);
		}	
		data.add(vo.membertype);
		data.add(""+user.showLevel(UserID));
		data.add(""+user.showCredit(UserID));
		return data;
	}
}
