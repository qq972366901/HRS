package hotelWorkerView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uiService.MakeHotelPromotionUiService;
/**
 * 制定酒店营销策略的界面
 * @author 刘宗侃
 */
public class MakeHotelPromotionView extends JPanel {

	private static final long serialVersionUID = 1L;
	String hotelID;
	
	private MakeHotelPromotionUiService controller;
	
	private JTextField promotionNameTextField;
	private JTextField startTimeTextField;
	private JTextField endTimeTextField;
	private JTextField discountTextField;
	private JTextField birthdayDiscountTextField;
	private JTextField threeRoomsDiscountTextField;
	private JTextField businessDiscountTextField;
	
	JButton backButton;
	JButton submitButton;
	
	/**
	 * 制定营销策略界面的构造方法
	 * @param controller
	 * @param id
	 */
	public MakeHotelPromotionView(MakeHotelPromotionUiService controller,String id) {
		this.hotelID = id;
		this.controller = controller;
		initPanel();
		this.validate();
	}

	/**
	 * 构造制定营销策略界面
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
			 * 返回酒店工作人员主界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toHotelMainView();
			}
		});
		
		JPanel hotelPromotionPanel = new JPanel();
		this.add(hotelPromotionPanel, BorderLayout.CENTER);
		hotelPromotionPanel.setLayout(new GridLayout(16, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		hotelPromotionPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel_1.add(panel_1_1);
		
		JLabel promotionNameLabel = new JLabel("营销策略名称：");
		promotionNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(promotionNameLabel);
		
		promotionNameTextField = new JTextField();
		panel_1.add(promotionNameTextField);
		promotionNameTextField.setColumns(10);
		
		JPanel panel_1_2 = new JPanel();
		panel_1.add(panel_1_2);
		
		JPanel panel_2 = new JPanel();
		hotelPromotionPanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		hotelPromotionPanel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_3.add(panel_3_1);
		
		JLabel startTimeLabel = new JLabel("活动开始时间(yyyy/MM/dd)：");
		startTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(startTimeLabel);
		
		startTimeTextField = new JTextField();
		panel_3.add(startTimeTextField);
		startTimeTextField.setColumns(10);
		
		JPanel panel_3_2 = new JPanel();
		panel_3.add(panel_3_2);
		
		JPanel panel_4 = new JPanel();
		hotelPromotionPanel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		hotelPromotionPanel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_5_1 = new JPanel();
		panel_5.add(panel_5_1);
		
		JLabel endTimeLabel = new JLabel("活动结束时间(yyyy/MM/dd)：");
		endTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(endTimeLabel);
		
		endTimeTextField = new JTextField();
		panel_5.add(endTimeTextField);
		endTimeTextField.setColumns(10);
		
		JPanel panel_5_2 = new JPanel();
		panel_5.add(panel_5_2);
		
		JPanel panel_6 = new JPanel();
		hotelPromotionPanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		hotelPromotionPanel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_7_1 = new JPanel();
		panel_7.add(panel_7_1);
		
		JLabel discountLabel = new JLabel("活动折扣(0.5~10)：");
		discountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(discountLabel);
		
		discountTextField = new JTextField();
		panel_7.add(discountTextField);
		discountTextField.setColumns(10);
		
		JPanel panel_7_2 = new JPanel();
		panel_7.add(panel_7_2);
		
		JPanel panel_8 = new JPanel();
		hotelPromotionPanel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		hotelPromotionPanel.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_9_1 = new JPanel();
		panel_9.add(panel_9_1);
		
		JLabel birthdayDiscountLabel = new JLabel("客户生日优惠折扣(0.5~10)：");
		birthdayDiscountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(birthdayDiscountLabel);
		
		birthdayDiscountTextField = new JTextField();
		panel_9.add(birthdayDiscountTextField);
		birthdayDiscountTextField.setColumns(10);
		
		JPanel panel_9_2 = new JPanel();
		panel_9.add(panel_9_2);
		
		JPanel panel_10 = new JPanel();
		hotelPromotionPanel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		hotelPromotionPanel.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_11_1 = new JPanel();
		panel_11.add(panel_11_1);
		
		JLabel threeRoomsDiscountLabel = new JLabel("客户订房满三间折扣(0.5~10)：");
		threeRoomsDiscountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(threeRoomsDiscountLabel);
		
		threeRoomsDiscountTextField = new JTextField();
		panel_11.add(threeRoomsDiscountTextField);
		threeRoomsDiscountTextField.setColumns(10);
		
		JPanel panel_11_2 = new JPanel();
		panel_11.add(panel_11_2);
		
		JPanel panel_12 = new JPanel();
		hotelPromotionPanel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		hotelPromotionPanel.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_13_1 = new JPanel();
		panel_13.add(panel_13_1);
		
		JLabel businessDiscountLabel = new JLabel("企业合作客户折扣(0.5~10)：");
		businessDiscountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(businessDiscountLabel);
		
		businessDiscountTextField = new JTextField();
		panel_13.add(businessDiscountTextField);
		businessDiscountTextField.setColumns(10);
		
		JPanel panel_13_2 = new JPanel();
		panel_13.add(panel_13_2);
		
		JPanel panel_14 = new JPanel();
		hotelPromotionPanel.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		hotelPromotionPanel.add(panel_15);
		
		submitButton = new JButton("确定");
		panel_15.add(submitButton);
		submitButton.addActionListener(new ActionListener(){
			/**
			 * 提交酒店营销策略的信息
			 */
			public void actionPerformed(ActionEvent arg0) {
				//系统添加酒店营销策略
				String name = promotionNameTextField.getText();
				if(name.length()<1) {
					JOptionPane.showMessageDialog(null, "请填写营销策略名称！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String beginTimeString = startTimeTextField.getText();
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
				Date date1 = null;
				try {
					date1 = sdf.parse(beginTimeString);
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "请以yyyy/MM/dd格式填写时间","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Calendar calendar1 = Calendar.getInstance();
				calendar1.setTime(date1);
				String endTimeString = endTimeTextField.getText();
				Date date2 = null;
				try {
					date2 = sdf.parse(endTimeString);
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "请以yyyy/MM/dd格式填写时间","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(date2);
				if(!date1.before(date2)) {
					JOptionPane.showMessageDialog(null, "请填写正确的时间先后顺序！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				double discount;
				double birthdayDiscount;
				double threeRoomsDiscount;
				double businessLogicDiscount;
				try {
					discount = Double.parseDouble(discountTextField.getText());
					birthdayDiscount = Double.parseDouble(birthdayDiscountTextField.getText());
					threeRoomsDiscount = Double.parseDouble(threeRoomsDiscountTextField.getText());
					businessLogicDiscount = Double.parseDouble(businessDiscountTextField.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "请填写正确的折扣！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(discount < 0.5 || discount > 10 || birthdayDiscount < 0.5 || birthdayDiscount > 10 ||
					threeRoomsDiscount < 0.5 || threeRoomsDiscount > 10 || businessLogicDiscount < 0.5 || businessLogicDiscount > 10) {
					JOptionPane.showMessageDialog(null, "折扣在0.5到10之间！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				controller.makeHotelPromotion(hotelID, name, calendar1, calendar2, discount, birthdayDiscount, threeRoomsDiscount, businessLogicDiscount);
				JOptionPane.showMessageDialog(null, "已录入酒店营销策略！");
			}
			
		});
		
		JPanel panel_16 = new JPanel();
		hotelPromotionPanel.add(panel_16);
	}

}
