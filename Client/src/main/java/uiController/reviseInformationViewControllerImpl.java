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
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class reviseInformationViewControllerImpl implements reviseInformationViewControllerService {
	private reviseInformationView view;
	private UserBLService user;
	private String UserID;
	private String key;
	public reviseInformationViewControllerImpl(String id){
		try {
			user=new UserBLServiceController();
			key=Log.getLogInstance().getSKey(id);
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
		for(int i=0;i<vector.size();i++){
			if(!vector.get(i).equals("")){
				switch(i){
				case 0:vo.username=DES.encryptDES(vector.get(i), key);break;
				case 1:SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
				       Calendar cal=Calendar.getInstance();
				       try {
						cal.setTime(sdf.parse(vector.get(i)));
						vo.birthday=cal;
					} catch (ParseException e) {
						e.printStackTrace();
					}
				       break;
				case 2:vo.contactway=DES.encryptDES(vector.get(i),key);
				       break;
				case 3:vo.enterprise=vector.get(i);
				       break;
				}
			}
		}
		user.update(vo);
		view.exit();
	}
	@Override
	public String getUserID() {
		return UserID;
	}
}
