package reviseInformationView;

import java.util.Vector;

import Service.Impl.UserBLServiceImpl;
import VO.UserVO;
import userBLService.UserBLService;

public class reviseInformationViewControllerImpl implements reviseInformationViewControllerService {
	private reviseInformationView view;
	private UserBLService user;
	private String UserID;
	public reviseInformationViewControllerImpl(String id){
		user=new UserBLServiceImpl();
		UserID=id;
	}
	@Override
	public void setView(reviseInformationView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		view.exit();
	}

	@Override
	public void updateinformation(Vector<String> vector) {
		// TODO Auto-generated method stub
		//user.update((UserVO) vector);
		view.exit();
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return UserID;
	}

}
