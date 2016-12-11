package HotelWorkerView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uiService.UpdateHotelInfoUiService;
import common.CityAndBussinessCircle;

/**
 * 维护酒店基本信息的界面
 * @author 刘宗侃
 */
public class UpdateHotelInfoView extends JPanel {

	private static final long serialVersionUID = 1L;
	private String hotelID;
	
	private UpdateHotelInfoUiService controller;
	
	private JTextArea hotelNameTextArea;
	private JTextArea hotelLocationTextArea;
	private JTextArea hotelServiceTextArea;
	private JTextArea hotelIntroduceTextArea;
	private String hotelCity;
	private String hotelArea;
	private int hotelStar = -1;
	private JTextArea hotelPhoneTextArea;
	
	private JButton backButton;
	private JButton submitButton;
	
	private JComboBox<String> hotelAreaJComboBox = new JComboBox<String>();
	
	CityAndBussinessCircle cityAndCircle = new CityAndBussinessCircle();
	
	public UpdateHotelInfoView(UpdateHotelInfoUiService controller,String id) {
		this.hotelID = id;
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
		updatePanel.setLayout(new GridLayout(17, 1, 0, 0));
		
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
		
		hotelNameTextArea = new JTextArea();
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
		
		hotelLocationTextArea = new JTextArea();
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
		
		hotelServiceTextArea = new JTextArea();
		panel5.add(hotelServiceTextArea);
		
		JPanel panel_4 = new JPanel();
		updatePanel.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel hotelCityPanel = new JPanel();
		updatePanel.add(hotelCityPanel);
		hotelCityPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelCityLabel = new JLabel("所在城市");
		hotelCityPanel.add(hotelCityLabel);
		hotelCityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox<String> hotelCityComboBox = new JComboBox<String>();
		hotelCityPanel.add(hotelCityComboBox);
		hotelCityComboBox.addItem("请选择城市");
		List<String> cities = cityAndCircle.getCity();
		for(int i=0;i<cities.size();i++) {
			hotelCityComboBox.addItem(cities.get(i));
		}
		hotelCityComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	hotelCity = hotelCityComboBox.getSelectedItem().toString();
                	Vector<String> circles = cityAndCircle.getCircle(hotelCity);
                	String[] circleArray = new String[circles.size()];
                	for(int i=0;i<circles.size();i++) {
                		circleArray[i] = circles.get(i);
                	}
                	hotelArea = circleArray[0];
                	ComboBoxModel<String> model = new DefaultComboBoxModel<String>(circleArray);
                	hotelAreaJComboBox.setModel(model);
                }
            }
        });
		
		JPanel panel_8 = new JPanel();
		updatePanel.add(panel_8);
		
		JPanel hotelAreaPanel = new JPanel();
		updatePanel.add(hotelAreaPanel);
		hotelAreaPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel3 = new JPanel();
		hotelAreaPanel.add(panel3);
		panel3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelAreaLabel = new JLabel("所属商圈");
		panel3.add(hotelAreaLabel);
		hotelAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel3.add(hotelAreaJComboBox);
		hotelAreaJComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	hotelArea = hotelAreaJComboBox.getSelectedItem().toString();
                }
            }
        });
		
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
		
		hotelIntroduceTextArea = new JTextArea();
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
		starComboBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	hotelStar = Integer.parseInt(starComboBox.getSelectedItem().toString());
                }
            }
        });
		
		JPanel panel_17 = new JPanel();
		updatePanel.add(panel_17);
		
		JPanel hotelPhonePanel = new JPanel();
		updatePanel.add(hotelPhonePanel);
		hotelPhonePanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel17 = new JPanel();
		hotelPhonePanel.add(panel17);
		panel17.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel hotelPhoneLabel = new JLabel("酒店联系电话");
		panel17.add(hotelPhoneLabel);
		hotelPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		hotelPhoneTextArea = new JTextArea();
		panel17.add(hotelPhoneTextArea);
		
		JPanel submitPanel = new JPanel();
		updatePanel.add(submitPanel);

		submitButton = new JButton("提交");
		submitPanel.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//系统更新酒店信息
				String hotelName = hotelNameTextArea.getText();
				String hotelLocation = hotelLocationTextArea.getText();
				String hotelService = hotelServiceTextArea.getText();
				String hotelIntroduce = hotelIntroduceTextArea.getText();
				String hotelPhone = hotelPhoneTextArea.getText();
				if(hotelName.length() < 1 || hotelLocation.length() < 1 || hotelService.length() < 1
				  || hotelCity.length() < 1 || hotelArea.length() < 1 || hotelIntroduce.length() < 1 || hotelStar == -1
				  || hotelPhone.length() < 1 ) {
					JOptionPane.showMessageDialog(null, "请填写完整信息！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				controller.updateHotelInfo(hotelName, hotelLocation, hotelService, hotelCity, hotelArea, hotelIntroduce, hotelStar, hotelPhone);
			}
			
		});

	}
	
}
