package uiController;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import uiService.CreditViewService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.Log;
import userView.CreditView;
import vo.CreditRecordVO;
/**
 * 信用查看的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class CreditViewController implements CreditViewService {
	private CreditView view;
	private String id;
	private UserBLService user;
	String key;
	public CreditViewController(String id){
		
		try {
			user=new UserBLServiceController();
			Log log=new Log();
			key=log.getSKey(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id=id;
	}
	public void setView(CreditView view) {
        this.view=view;
	}
	@Override
	public long getcredit(String id) {
		return user.showCredit(id);
	}
	public void exit() {
		view.exit();		
	}
	@Override
	public String getUserID() {
		return id;
	}
	@Override
	public Vector<Vector<String>> getCreditRecord(String id) {
		Vector<Vector<String>> volist=new Vector<Vector<String>>();
		Iterator<Map.Entry<String, CreditRecordVO>> it=user.showCreditRecord(id).entrySet().iterator();
		while(it.hasNext()){
			CreditRecordVO vo=it.next().getValue();
			volist.add(vo.getVector());
		}
		return volist;
	}
}
