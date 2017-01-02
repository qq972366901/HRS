package hotelWorkerView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uiService.AdminRoomUiService;

/**实现管理客房的界面
 * @author 刘宗侃
 */
public class AdminRoomView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private AdminRoomUiService controller;
	
	private String hotelID;

	private JButton backButton;
	private JButton inputRoomButton;
	private JButton updateRoomButton;
	
	/**
	 * 管理客房界面的构造方法
	 * 
	 * @param controller
	 * @param id
	 */
	public AdminRoomView(AdminRoomUiService controller, String id) {
		this.controller = controller;
		hotelID = id;
		initPanel();
		this.validate();
	}

	/**
	 * 构造管理客房的界面
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
		
		JPanel choosePanel = new JPanel();
		this.add(choosePanel, BorderLayout.CENTER);
		choosePanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		choosePanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		choosePanel.add(panel_2);
		
		JPanel choosePanel_0 = new JPanel();
		choosePanel.add(choosePanel_0);
		choosePanel_0.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_3_1 = new JPanel();
		choosePanel_0.add(panel_3_1);
		
		JPanel choosePanel_1 = new JPanel();
		choosePanel_0.add(choosePanel_1);
		choosePanel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		inputRoomButton = new JButton("录入客房信息");
		choosePanel_1.add(inputRoomButton);
		inputRoomButton.addActionListener(new ActionListener(){
			/**
			 * 进入录入客房信息界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toInputRoomInfoView();
			}
		});
		
		JPanel choosePanel_2 = new JPanel();
		choosePanel_0.add(choosePanel_2);
		
		updateRoomButton = new JButton("更新房间信息");
		choosePanel_2.add(updateRoomButton);
		updateRoomButton.addActionListener(new ActionListener(){
			/**
			 * 进入更新房间信息界面
			 */
			public void actionPerformed(ActionEvent arg0) {
				controller.toUpdateRoomInfoView();
			}
		});
		
		JPanel panel_3_4 = new JPanel();
		choosePanel_0.add(panel_3_4);
		
		JPanel panel_4 = new JPanel();
		choosePanel.add(panel_4);
	}

}

