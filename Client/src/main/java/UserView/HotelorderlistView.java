package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import VO.OrderVO;
import runner.ClientRunner;
import uiController.HistroyHotelViewControllerImpl;
import uiController.HotelDetailUiController;
import uiController.orderDetailViewControllerServiceImpl;
import uiService.HistroyHotelViewControllerService;
import uiService.HotelDetailUiService;
import uiService.HotelorderlistViewControllerService;
import uiService.orderDetailViewControllerService;

import javax.swing.BoxLayout;

public class HotelorderlistView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HotelorderlistViewControllerService controller;
    
	private JPanel panel;
	private JPanel panel_1;
	private JButton back;
	private JTable table;
	private JLabel label;
	private JLabel hotelname;
	private JScrollPane scrollPane;
	private String UserID;
	private String HotelID;
	private JButton back2;
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
		HotelID=controller.getHotelID();
		init_table();
	}
	public void init_exit(){
		
		back = new JButton("返回酒店详情");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		
		back2 = new JButton("返回酒店列表");
		back2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     controller.exit2();
			}
		});
		panel.add(back2);
		panel.add(back);
	}
	public void init_table(){
		
		label = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
		
		hotelname = new JLabel("");
		hotelname.setText("");
		panel_1.add(label);
		panel_1.add(hotelname);
		Vector<OrderVO> Data=new Vector<OrderVO>();
		Data.addAll(controller.getOrderList());
		Vector<String> Columns=new Vector<String>();
		Columns.add("订单号");
		Columns.add("订单状态");
		Columns.add("入住人数");
		Columns.add("价值");
		Columns.add("房间类型");
		Columns.add("房间数量");
		Columns.add("入住时间");
		Columns.add("离开时间");
		Columns.add("评分");
		table = new JTable(Data,Columns){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2){
					int index = table.getSelectedRow();
					if(index == -1){
						JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String id=(String) table.getValueAt(index, 0);
					controller.showDetail(id);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub		
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1000,500));
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);
		table.setFillsViewportHeight(true);
		add(scrollPane);
	}
	public void exit(){
		HotelDetailUiService con =  new HotelDetailUiController(HotelID,UserID);
		HotelDetailView vie = new HotelDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	public void exit2(){
		HistroyHotelViewControllerService con =  new HistroyHotelViewControllerImpl(UserID);
		HistroyHotelView vie = new HistroyHotelView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	public void showDetail(String id) throws RemoteException{
		orderDetailViewControllerService con =  new orderDetailViewControllerServiceImpl(UserID,id,HotelID,2);
		orderDetailView vie = new orderDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
