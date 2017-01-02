package hotelWorkerView;

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

import uiService.InputRoomInfoUiService;
/**
 * 录入客房信息的界面
 * @author 刘宗侃
 */
public class InputRoomInfoView extends JPanel {

	private static final long serialVersionUID = 1L;
	private String hotelID;
	
	private InputRoomInfoUiService controller;
	
	private JTextField roomTypeTextField;
	private JTextField roomNumberTextField;
	private JTextField roomPriceTextField;
	private JTextField roomNNNTextField;
	
	private JButton backButton;
	private JButton submitButton;
	
	/**
	 * 录入客房信息的构造方法
	 * @param controller
	 * @param id
	 */
	public InputRoomInfoView(InputRoomInfoUiService controller,String id) {
		this.controller = controller;
		this.hotelID = id;
		initPanel();
		this.validate();
	}

	/**
	 * 构造录入客房信息界面
	 */
	private void initPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel backPanel = new JPanel();
		this.add(backPanel, BorderLayout.NORTH);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("返回");
		backPanel.add(backButton, BorderLayout.EAST);
		backButton.addActionListener(new ActionListener(){
			/**
			 * 返回管理客房信息界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toAdminRoomView();
			}
		});
		
		JPanel inputPanel = new JPanel();
		this.add(inputPanel, BorderLayout.CENTER);
		inputPanel.setLayout(new GridLayout(11, 1, 0, 0));
		
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
		
		JPanel panel_10 = new JPanel();
		inputPanel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		inputPanel.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_11_1 = new JPanel();
		panel_11.add(panel_11_1);
		
		JLabel roomNNNLabel = new JLabel("房间号（?-?）：");
		roomNNNLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(roomNNNLabel);
		
		roomNNNTextField = new JTextField();
		panel_11.add(roomNNNTextField);
		roomNNNTextField.setColumns(20);
		
		JPanel panel_11_2 = new JPanel();
		panel_11.add(panel_11_2);
		
		JPanel panel_7 = new JPanel();
		inputPanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		inputPanel.add(panel_8);
		
		submitButton = new JButton("提交");
		panel_8.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			/**
			 * 提交要添加的房间
			 */
			public void actionPerformed(ActionEvent arg0) {
				//系统更新酒店拥有的房间信息
				String roomType = roomTypeTextField.getText();
				if( ! ( roomType.equals("大床房") || roomType.equals("标准双人间") || roomType.equals("三人间") ||  
						roomType.equals("豪华套房") || roomType.equals("总统套房") ) ) {
					JOptionPane.showMessageDialog(null, "请输入正确的房型！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String roomNumString = roomNumberTextField.getText();
				boolean validNum = true;
				for(int i=0;i<roomNumString.length();i++) {
					if(roomNumString.charAt(i) < '0' || roomNumString.charAt(i) > '9') {
						validNum = false;
						break;
					}
				}
				if(!validNum) {
					JOptionPane.showMessageDialog(null, "房间数量为正整数！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int roomNumber = Integer.parseInt(roomNumString);
				String roomPriceString = roomPriceTextField.getText();
				boolean validPrice = true;
				for(int i=0;i<roomPriceString.length();i++) {
					if(roomPriceString.charAt(i) < '0' || roomPriceString.charAt(i) > '9') {
						validPrice = false;
						break;
					}
				}
				if(!validPrice) {
					JOptionPane.showMessageDialog(null, "房间价格只能是正整数!","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int roomPrice = Integer.parseInt(roomPriceString);
				
				String roomNNN = roomNNNTextField.getText();
				if(roomNNN.length() < 3) {
					JOptionPane.showMessageDialog(null, "请输入正确的房间号范围，如301-303","", JOptionPane.ERROR_MESSAGE);
				}
				boolean validNNN = true;
				for(int i=0;i<roomNNN.length();i++) {
					if((roomNNN.charAt(i) < '0' || roomNNN.charAt(i) > '9' ) && (roomNNN.charAt(i) != '-' &&
							roomNNN.charAt(i) != ' ')) {
						validNNN = false;
						break;
					}
				}
				if(!validNNN) {
					JOptionPane.showMessageDialog(null, "请输入正确的房间号!","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int numberOf_sign = 0;
				for(int i=0;i<roomNNN.length();i++) {
					if(roomNNN.charAt(i) == '-') {
						numberOf_sign ++;
					}
				}
				if(numberOf_sign != 1) {
					JOptionPane.showMessageDialog(null, "请输入正确的房间号范围!","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(roomNNN.charAt(roomNNN.length()-1) < '0' || roomNNN.charAt(roomNNN.length()-1) > '9' ) {
					JOptionPane.showMessageDialog(null, "请输入正确的房间号范围!","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				controller.inputRoomInfo(roomType,roomNumber,roomPrice,roomNNN);
				JOptionPane.showMessageDialog(null, "录入成功！");
			}
		});
		
		JPanel panel_9 = new JPanel();
		inputPanel.add(panel_9);
	}

}
