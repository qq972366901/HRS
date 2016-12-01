package uiController;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import UserView.reviseInformationView;
import VO.UserVO;
import uiService.reviseInformationViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class reviseInformationViewControllerImpl implements reviseInformationViewControllerService {
	private reviseInformationView view;
	private UserBLService user;
	private String UserID;
	public reviseInformationViewControllerImpl(String id){
		try {
			user=new UserBLServiceController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserID=id;
	}
	@Override
	public void setView(reviseInformationView view) {
		this.view=view;
	}

	@Override
	public void exit() {
		view.exit();
	}

	@Override
	public void updateinformation(Vector<String> vector) {
	    UserVO vo=user.findByID(UserID);
		//user.update(vo,);
		for(int i=0;i<vector.size();i++){
			if(!vector.get(i).equals("")){
				switch(i){
				case 0:vo.username=vector.get(i);break;
				case 1:SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
				       Calendar cal=Calendar.getInstance();
				       try {
						cal.setTime(sdf.parse(vector.get(i)));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				       break;
				case 2:vo.contactway=vector.get(i);
				case 3:vo.enterprise=vector.get(i);
				}
			}
		}
		view.exit();
	}
	@Override
	public String getUserID() {
		return UserID;
	}
}
