package HotelWorkerView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uiService.UpdateRoomInfoUiService;
/**
 * 更新房间信息的界面
 * @author 刘宗侃
 */
public class UpdateRoomInfoView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String hotelID;
	
	private UpdateRoomInfoUiService controller;
	
	private JTextField roomNumberTextField;
	private JTextField roomTypeTextField;
	
	private JButton backButton;
	private JButton checkinButton;
	private JButton checkoutButton;
	
	public UpdateRoomInfoView(UpdateRoomInfoUiService controller,String id) {
		this.controller = controller;
		this.hotelID = id;
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
		updatePanel.setLayout(new GridLayout(13, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		updatePanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		updatePanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		updatePanel.add(panel_3);
		
		JPanel panel_5 = new JPanel();
		updatePanel.add(panel_5);
		
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
		
		JPanel panel_6 = new JPanel();
		updatePanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		updatePanel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_7_1 = new JPanel();
		panel_7.add(panel_7_1);
		
		JLabel roomTypeLabel = new JLabel("房型：");
		roomTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(roomTypeLabel);
		
		roomTypeTextField = new JTextField();
		panel_7.add(roomTypeTextField);
		roomTypeTextField.setColumns(10);
		
		JPanel panel_7_2 = new JPanel();
		panel_7.add(panel_7_2);

		JPanel panel_8 = new JPanel();
		updatePanel.add(panel_8);
		
		JPanel panel_12 = new JPanel();
		updatePanel.add(panel_12);
		
		panel_12.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_12_1 = new JPanel();
		panel_12.add(panel_12_1);
		JPanel panel_12_2 = new JPanel();
		panel_12.add(panel_12_2);
		JPanel panel_12_3 = new JPanel();
		panel_12.add(panel_12_3);
		JPanel panel_12_4 = new JPanel();
		panel_12.add(panel_12_4);
		
		checkinButton = new JButton("入住");
		panel_12_2.add(checkinButton);
		checkinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//系统更新房间号的房间状态为入住
				String roomNumber = roomNumberTextField.getText();
				if(roomNumber.length() < 1) {
					JOptionPane.showMessageDialog(null, "请填写房间号！","", JOptionPane.ERROR_MESSAGE);
				}
				String roomType = roomTypeTextField.getText();
				if(roomType.length() < 1) {
					JOptionPane.showMessageDialog(null, "请填写房型！","", JOptionPane.ERROR_MESSAGE);
				}
				
				controller.updateRoomInfo(hotelID, roomNumber, roomType,"已入住");
			}
		});
		
		checkoutButton = new JButton("退房");
		panel_12_3.add(checkoutButton);
		checkoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//系统更新房间号的房间状态为空闲
				String roomNumber = roomNumberTextField.getText();
				if(roomNumber.length() < 1) {
					JOptionPane.showMessageDialog(null, "请填写房间号！","", JOptionPane.ERROR_MESSAGE);
				}
				String roomType = roomTypeTextField.getText();
				if(roomType.length() < 1) {
					JOptionPane.showMessageDialog(null, "请填写房型！","", JOptionPane.ERROR_MESSAGE);
				}
				
				controller.updateRoomInfo(hotelID, roomNumber, roomType,"空闲");
			}
		});
		
		JPanel panel_11 = new JPanel();
		updatePanel.add(panel_11);
		
		JPanel panel_13 = new JPanel();
		updatePanel.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		updatePanel.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		updatePanel.add(panel_15);
	}

}
