package HotelWorkerView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uiService.UpdateRoomInfoUiService;

public class UpdateRoomInfoView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private UpdateRoomInfoUiService controller;
	
	private JTextField userNameTextField;
	private JTextField roomNumberTextField;
	private JTextField checkinTimeTextField;
	private JTextField expectedCheckoutTimeTextField;
	private JTextField checkoutTimeTextField;
	
	private JButton backButton;
	private JButton submitButton;
	
	public UpdateRoomInfoView(UpdateRoomInfoUiService controller) {
		this.controller = controller;
		initPanel();
		this.validate();
	}

	private void initPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel backPanel = new JPanel();
		this.add(backPanel, BorderLayout.NORTH);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("返回");
		backPanel.add(backButton, BorderLayout.EAST);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.toAdminRoomView();
			}
		});
		
		JPanel updatePanel = new JPanel();
		this.add(updatePanel, BorderLayout.CENTER);
		updatePanel.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		updatePanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		updatePanel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_2_1 = new JPanel();
		panel_2.add(panel_2_1);
		
		JLabel userNameLabel = new JLabel("入住人姓名：");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(userNameLabel);
		
		userNameTextField = new JTextField();
		panel_2.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JPanel panel_2_2 = new JPanel();
		panel_2.add(panel_2_2);
		
		JPanel panel_3 = new JPanel();
		updatePanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		updatePanel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_4_1 = new JPanel();
		panel_4.add(panel_4_1);
		
		JLabel roomNumberLabel = new JLabel("房间号：");
		roomNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(roomNumberLabel);
		
		roomNumberTextField = new JTextField();
		panel_4.add(roomNumberTextField);
		roomNumberTextField.setColumns(10);
		
		JPanel panel_4_2 = new JPanel();
		panel_4.add(panel_4_2);
		
		JPanel panel_5 = new JPanel();
		updatePanel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		updatePanel.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_6_1 = new JPanel();
		panel_6.add(panel_6_1);
		
		JLabel checkinTimeLabel = new JLabel("入住时间");
		checkinTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(checkinTimeLabel);
		
		checkinTimeTextField = new JTextField();
		panel_6.add(checkinTimeTextField);
		checkinTimeTextField.setColumns(10);
		
		JPanel panel_6_2 = new JPanel();
		panel_6.add(panel_6_2);
		
		JPanel panel_7 = new JPanel();
		updatePanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		updatePanel.add(panel_8);
		panel_8.setLayout(new GridLayout(1,4, 0, 0));
		
		JPanel panel_8_1 = new JPanel();
		panel_8.add(panel_8_1);
		
		JLabel expectedCheckoutTimeLabel = new JLabel("预计退房时间：");
		expectedCheckoutTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(expectedCheckoutTimeLabel);
		
		expectedCheckoutTimeTextField = new JTextField();
		panel_8.add(expectedCheckoutTimeTextField);
		expectedCheckoutTimeTextField.setColumns(10);
		
		JPanel panel_8_2 = new JPanel();
		panel_8.add(panel_8_2);
		
		JPanel panel_9 = new JPanel();
		updatePanel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		updatePanel.add(panel_10);
		panel_10.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_10_1 = new JPanel();
		panel_10.add(panel_10_1);
		
		JLabel checkoutTimeLabel = new JLabel("退房时间：");
		checkoutTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(checkoutTimeLabel);
		
		checkoutTimeTextField = new JTextField();
		panel_10.add(checkoutTimeTextField);
		checkoutTimeTextField.setColumns(10);
		
		JPanel panel_10_2 = new JPanel();
		panel_10.add(panel_10_2);
		
		JPanel panel_11 = new JPanel();
		updatePanel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		updatePanel.add(panel_12);
		
		submitButton = new JButton("提交");
		panel_12.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//系统更新房间入住信息
			}
		});
		
		JPanel panel_13 = new JPanel();
		updatePanel.add(panel_13);
	}

}
