package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import VO.OrderVO;
import runner.ClientRunner;
import uiController.customerMainViewControllerImpl;
import uiService.HotelorderlistViewControllerService;
import uiService.customerMainViewControllerService;
import javax.swing.BoxLayout;

public class HotelorderlistView extends JPanel {
	private HotelorderlistViewControllerService controller;
    
	private JPanel panel;
	private JPanel panel_1;
	private JButton back;
	private JTable table;
	private JLabel label;
	private JLabel hotelname;
	private JScrollPane scrollPane;
	private String UserID;
	/**
	 * Create the panel.
	 */
	public HotelorderlistView(HotelorderlistViewControllerService controller) {
		this.controller=controller;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        panel_1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel_1);
		init_exit();
		UserID=controller.getUserID();
		init_table();
	}
	public void init_exit(){
		
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		panel.add(back);
	}
	public void init_table(){
		
		label = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
		
		hotelname = new JLabel("");
		hotelname.setText("");
		panel_1.add(label);
		panel_1.add(hotelname);
		Vector<OrderVO> Data=new Vector<OrderVO>();
		//Data.addAll(controller.getOrderList());
		Vector<String> Columns=new Vector<String>();
		Columns.add("订单号");
		Columns.add("订单状态");
		Columns.add("客户名称");
		Columns.add("客户联系方式");
		Columns.add("入住人数");
		Columns.add("价值");
		Columns.add("房间详情");
		Columns.add("房间数量");
		Columns.add("入住时间");
		Columns.add("最晚执行时间");
		table = new JTable(Data,Columns){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1000,500));
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);
		table.setFillsViewportHeight(true);
		add(scrollPane);
	}
	public void exit(){
		customerMainViewControllerService con =  new customerMainViewControllerImpl(UserID);
		customerMainView vie = new customerMainView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
