package uiController;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import HotelWorkerView.ProcessOrderView;
import UserView.LogView;
import WebPromotionView.CreditManagementView;
import WebPromotionView.MemberLevelSystemView;
import WebPromotionView.WebPromotionStrategyView;
import WebPromotionView.WebPromotionUserView;
import common.UserType;
import runner.ClientRunner;
import uiService.CreditManagementUiService;
import uiService.LoginViewControllerService;
import uiService.MemberLevelSystemUiService;
import uiService.ProcessOrderUiService;
import uiService.WebPromotionStrategyUiService;
import uiService.webPromotionUserUiService;

/**
 * 负责实现酒店管理系统的网站营销人员界面的控制器
 * @author 刘宗侃
 * @version 1.0
 * @see uiService.webPromotionUserUiService
 * @see javax.swing.JFrame
 * @see java.awt.event.WindowAdapter;
 * @see java.awt.event.WindowEvent;
 * 
 */

public class webPromotionUserUiController implements webPromotionUserUiService {
	private WebPromotionUserView view;
	@Override
	public void toWebPromotionStrategyView() {
		WebPromotionStrategyUiService controller;
		try {
			controller = new WebPromotionStrategyUiController();
			WebPromotionStrategyView view=new WebPromotionStrategyView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void toCreditManagementView() {
		CreditManagementUiService controller=new CreditManagementUiController();
		CreditManagementView view=new CreditManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void toMemberLevelSystemView() {
		MemberLevelSystemUiService controller=new MemberLevelSystemUiController();
		MemberLevelSystemView view=new MemberLevelSystemView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void toLogView() {
		LoginViewControllerService controller =  new LoginViewControllerImpl();
    	LogView view = new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void setView(WebPromotionUserView view) {
		this.view=view;
	}

	@Override
	public void toProcessOrderOrderView() {
		JFrame hotelFrame = new JFrame();
		hotelFrame.setSize(600, 80);
		hotelFrame.setLocation(400, 400);
		
		JPanel hotelPanel = new JPanel();
		hotelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel hotelLabel= new JLabel("输入酒店账号：");
		JTextField hotelField = new JTextField(10);
		JButton hotelButton = new JButton("确定");
		hotelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String acc = hotelField.getText();
				ProcessOrderUiService controller;
				try {
					controller = new ProcessOrderUiController(acc,UserType.WebPromotionWorker);
					ProcessOrderView view=new ProcessOrderView(controller);
					view.enableCancel();
					controller.setView(view);
					ClientRunner.change(view);
					hotelFrame.dispose();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		JButton cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//关闭窗口
				hotelFrame.dispose();
				
			}
		});
		JPanel toHotelPanel = new JPanel();
		toHotelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		toHotelPanel.add(hotelLabel);
		toHotelPanel.add(hotelField);
		toHotelPanel.add(hotelButton);
		toHotelPanel.add(cancelButton);
		
		hotelFrame.getContentPane().add(toHotelPanel);
		hotelFrame.setVisible(true);

	}

}

