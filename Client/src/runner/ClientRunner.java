package runner;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import HotelWorkerView.HotelMainView;
import WebPromotionView.WebPromotionUserView;
import rmi.RemoteHelper;
import uiController.HotelMainUiController;
import uiController.webPromotionUserUiController;
import uiService.HotelMainUiService;
import uiService.webPromotionUserUiService;

public class ClientRunner implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RemoteHelper remoteHelper;
	private static JFrame mFrame;
	public ClientRunner() throws RemoteException {
		linkToServer();
		initGUI();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:7777/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private void initGUI() throws RemoteException {
		mFrame = new JFrame("HRS");
		mFrame.setSize(1000, 700);
		mFrame.setLocation(10, 10);
		//¥˝≤π≥‰
		
		HotelMainUiService controller=new HotelMainUiController();
		HotelMainView view=new HotelMainView(controller);
		controller.setView(view);
		mFrame.getContentPane().add(view);
		
		mFrame.setVisible(true);
		/*
		DataFactoryService df=RemoteHelper.getInstance().getDataFactoryService();
		HotelDataService dh=(HotelDataService) df.getDataService("Hotel");
		ArrayList<HotelPO> a=new ArrayList<HotelPO>();
		HotelPO po=dh.find("423523");
		a=dh.findByDistrict("œ…¡÷");
		po=dh.findByName("xxx");
		a=dh.findByScore(4);
		a=dh.findByStar(2);
		dh.insert(po);
		dh.update(po);
		dh.delete(po);
		dh.init();
		dh.finish();
		*/
	}
	public static void change(JPanel view){
		mFrame.getContentPane().removeAll();
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
