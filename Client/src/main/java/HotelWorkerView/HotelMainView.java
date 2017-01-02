package hotelWorkerView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uiService.HotelMainUiService;

/**
 * 酒店工作人员的主界面
 * @author 刘宗侃
 */
public class HotelMainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private HotelMainUiService controller;
	
	private String hotelID;
	
	private JButton backButton;
	private JButton updateHotelInfoButton;
	private JButton adminRoomButton;
	private JButton browseOrderButton;
	private JButton makeHotelPromotionButton;

	/**
	 * 酒店工作人员主界面的构造方法
	 * @param controller
	 * @param hotelid
	 */
	public HotelMainView(HotelMainUiService controller, String hotelid) {
		this.controller = controller;
		this.hotelID = hotelid;
		initPanel();
		this.validate();
	}
	
	/**
	 * 构造酒店工作人员主界面
	 * 
	 */
	private void initPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		this.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("返回");
		backButton.addActionListener(new ActionListener(){
			/**
			 * 返回至登录界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toLogView();
			}
		});
		panel.add(backButton, BorderLayout.EAST);
		
		JPanel choosePanel = new JPanel();
		this.add(choosePanel);
		choosePanel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel updateInfoPanel = new JPanel();
		choosePanel.add(updateInfoPanel);
		updateInfoPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		updateInfoPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		updateInfoPanel.add(panel_4);
		
		updateHotelInfoButton = new JButton("维护酒店基本信息");
		panel_4.add(updateHotelInfoButton);
		updateHotelInfoButton.addActionListener(new ActionListener(){
			/**
			 * 进入维护酒店基本信息界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toUpdateHotelInfoView();
			}
		});
		
		JPanel panel_5 = new JPanel();
		updateInfoPanel.add(panel_5);
		
		JPanel adminRoomPanel = new JPanel();
		choosePanel.add(adminRoomPanel);
		adminRoomPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		adminRoomPanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		adminRoomPanel.add(panel_7);
		
		adminRoomButton = new JButton("管理客房信息");
		panel_7.add(adminRoomButton);
		adminRoomButton.addActionListener(new ActionListener(){
			/**
			 * 进入管理客房信息界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toAdminRoomView();
			}
		});
		
		JPanel panel_8 = new JPanel();
		adminRoomPanel.add(panel_8);
		
		JPanel scanOrderPanel = new JPanel();
		choosePanel.add(scanOrderPanel);
		scanOrderPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		scanOrderPanel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		scanOrderPanel.add(panel_10);
		
		browseOrderButton = new JButton("浏览订单");
		panel_10.add(browseOrderButton);
		browseOrderButton.addActionListener(new ActionListener(){
			/**
			 * 进入浏览订单界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toProcessOrderOrderView();
			}
		});
		
		JPanel panel_11 = new JPanel();
		scanOrderPanel.add(panel_11);
		
		JPanel makePromoPanel = new JPanel();
		choosePanel.add(makePromoPanel);
		makePromoPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_12 = new JPanel();
		makePromoPanel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		makePromoPanel.add(panel_13);
		
		makeHotelPromotionButton = new JButton("制定营销策略");
		panel_13.add(makeHotelPromotionButton);
		makeHotelPromotionButton.addActionListener(new ActionListener(){
			/**
			 * 进入制定营销策略界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toMakeHotelPromotionView();
			}
		});
		
		JPanel panel_14 = new JPanel();
		makePromoPanel.add(panel_14);
		
		JPanel panel_2 = new JPanel();
		this.add(panel_2);
	}

}
