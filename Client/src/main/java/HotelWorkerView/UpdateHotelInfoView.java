package HotelWorkerView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uiService.UpdateHotelInfoUiService;


public class UpdateHotelInfoView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private UpdateHotelInfoUiService controller;
	
	private JButton backButton;
	private JButton submitButton;
	
	public UpdateHotelInfoView(UpdateHotelInfoUiService controller) {
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
				controller.toHotelMainView();
			}
		});
		
		JPanel updatePanel = new JPanel();
		this.add(updatePanel, BorderLayout.CENTER);
		updatePanel.setLayout(new GridLayout(15, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		updatePanel.add(panel_1);
		
		JPanel hotelNamePanel = new JPanel();
		updatePanel.add(hotelNamePanel);
		hotelNamePanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel1 = new JPanel();
		hotelNamePanel.add(panel1);
		panel1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelNameLabel = new JLabel("酒店名称");
		panel1.add(hotelNameLabel);
		hotelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea hotelNameTextArea = new JTextArea();
		panel1.add(hotelNameTextArea);
		
		JPanel panel_2 = new JPanel();
		updatePanel.add(panel_2);
		
		JPanel hotelLocationPanel = new JPanel();
		updatePanel.add(hotelLocationPanel);
		hotelLocationPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel2 = new JPanel();
		hotelLocationPanel.add(panel2);
		panel2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelLocationLabel = new JLabel("酒店地址");
		panel2.add(hotelLocationLabel);
		hotelLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea hotelLocationTextArea = new JTextArea();
		panel2.add(hotelLocationTextArea);
		
		JPanel panel_3 = new JPanel();
		updatePanel.add(panel_3);
		
		JPanel hotelServicePanel = new JPanel();
		updatePanel.add(hotelServicePanel);
		hotelServicePanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel5 = new JPanel();
		hotelServicePanel.add(panel5);
		panel5.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelServiceLabel = new JLabel("设施服务");
		panel5.add(hotelServiceLabel);
		hotelServiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea hotelServiceTextArea = new JTextArea();
		panel5.add(hotelServiceTextArea);
		
		JPanel panel_4 = new JPanel();
		updatePanel.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel hotelAreaPanel = new JPanel();
		updatePanel.add(hotelAreaPanel);
		hotelAreaPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel3 = new JPanel();
		hotelAreaPanel.add(panel3);
		panel3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelAreaLabel = new JLabel("所属商圈");
		panel3.add(hotelAreaLabel);
		hotelAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea hotelAreaTextArea = new JTextArea();
		panel3.add(hotelAreaTextArea);
		
		JPanel panel_5 = new JPanel();
		updatePanel.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel hotelIntroducePanel = new JPanel();
		updatePanel.add(hotelIntroducePanel);
		hotelIntroducePanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel4 = new JPanel();
		hotelIntroducePanel.add(panel4);
		panel4.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelIntroduceLabel = new JLabel("酒店简介");
		panel4.add(hotelIntroduceLabel);
		hotelIntroduceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea hotelIntroduceTextArea = new JTextArea();
		panel4.add(hotelIntroduceTextArea);
		
		JPanel panel_6 = new JPanel();
		updatePanel.add(panel_6);
		
		JPanel hotelStarPanel = new JPanel();
		updatePanel.add(hotelStarPanel);
		hotelStarPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel6 = new JPanel();
		hotelStarPanel.add(panel6);
		panel6.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelStarLabel = new JLabel("星级");
		panel6.add(hotelStarLabel);
		hotelStarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox<Integer> starComboBox = new JComboBox<Integer>();
		panel6.add(starComboBox);
		starComboBox.addItem(1);
		starComboBox.addItem(2);
		starComboBox.addItem(3);
		starComboBox.addItem(4);
		starComboBox.addItem(5);
		
		JPanel panel_7 = new JPanel();
		updatePanel.add(panel_7);
		
		JPanel submitPanel = new JPanel();
		updatePanel.add(submitPanel);
		
		submitButton = new JButton("提交");
		submitPanel.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//系统更新酒店信息
			}
			
		});
		
		JPanel panel_8 = new JPanel();
		updatePanel.add(panel_8);
	}
	
}
