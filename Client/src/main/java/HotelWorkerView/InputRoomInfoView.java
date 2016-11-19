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

import uiService.InputRoomInfoUiService;

public class InputRoomInfoView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private InputRoomInfoUiService controller;
	
	private JTextField roomTypeTextField;
	private JTextField roomNumberTextField;
	private JTextField roomPriceTextField;
	
	private JButton backButton;
	private JButton submitButton;
	
	public InputRoomInfoView(InputRoomInfoUiService controller) {
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
		
		JPanel inputPanel = new JPanel();
		this.add(inputPanel, BorderLayout.CENTER);
		inputPanel.setLayout(new GridLayout(9, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		inputPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		inputPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_2_1 = new JPanel();
		panel_2.add(panel_2_1);
		
		JLabel roomTypeLabel = new JLabel("客房类型：");
		roomTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(roomTypeLabel);
		
		roomTypeTextField = new JTextField();
		panel_2.add(roomTypeTextField);
		roomTypeTextField.setColumns(20);
		
		JPanel panel_1_2 = new JPanel();
		panel_2.add(panel_1_2);
		
		JPanel panel_3 = new JPanel();
		inputPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		inputPanel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_4_1 = new JPanel();
		panel_4.add(panel_4_1);
		
		JLabel roomNumberLabel = new JLabel("客房数量：");
		roomNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(roomNumberLabel);
		
		roomNumberTextField = new JTextField();
		panel_4.add(roomNumberTextField);
		roomNumberTextField.setColumns(3);
		
		JPanel panel_4_2 = new JPanel();
		panel_4.add(panel_4_2);
		
		JPanel panel_5 = new JPanel();
		inputPanel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		inputPanel.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_6_1 = new JPanel();
		panel_6.add(panel_6_1);
		
		JLabel roomPriceLabel = new JLabel("客房原始价格：");
		roomPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(roomPriceLabel);
		
		roomPriceTextField = new JTextField();
		panel_6.add(roomPriceTextField);
		roomPriceTextField.setColumns(5);
		
		JPanel panel_6_2 = new JPanel();
		panel_6.add(panel_6_2);
		
		JPanel panel_7 = new JPanel();
		inputPanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		inputPanel.add(panel_8);
		
		submitButton = new JButton("提交");
		panel_8.add(submitButton);
		submitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				//系统更新酒店拥有的房间信息
			}
			
		});
		
		JPanel panel_9 = new JPanel();
		inputPanel.add(panel_9);
	}

}
