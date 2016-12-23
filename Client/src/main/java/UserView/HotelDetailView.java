package UserView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import VO.HotelVO;
import VO.OrderVO;
import runner.ClientRunner;
import uiController.HistroyHotelViewControllerImpl;
import uiController.OrderBuildUiController;
import uiController.orderDetailViewControllerServiceImpl;
import uiService.HistroyHotelViewControllerService;
import uiService.HotelDetailUiService;
import uiService.OrderBuildUiService;
import uiService.orderDetailViewControllerService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HotelDetailView extends JPanel{
	private HotelDetailUiService controller;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel10;
	private JButton back;
	private String UserID;
	private String HotelID;
	private static final long serialVersionUID = 1L;
	private JLabel hotelName;
	private JLabel hotelCity;
	private JLabel hotelCirc;
	private JLabel hotelScore;
	private JLabel hotelStar;
	private JLabel hotelTel;
	private JLabel hotelService;
	private JLabel hotelAddress;
	private JLabel hotelIntroduce;
	private JLabel hotelin;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	private Box box1,box2,box3,box4;
	public HotelDetailView(HotelDetailUiService controller) {
		this.controller=controller;
		UserID=controller.getUserID();
		HotelID=controller.getHotelID();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel4=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel5=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel10=new JPanel(new FlowLayout(FlowLayout.CENTER));
		add(panel);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createHorizontalBox();
		box4.add(Box.createHorizontalStrut(200));
		box3.add(box1);
		box3.add(box4);
		box3.add(box2);
		panel1.add(box3);
		add(panel1);
		HotelVO vo=controller.findByhotelID(HotelID);
		hotelName = new JLabel("酒店名称       ："+vo.hotelName);
		box1.add(hotelName);
		box1.add(Box.createVerticalStrut(30));
		hotelCity = new JLabel("酒店所在城市   ："+vo.hotelCity);
		box2.add(hotelCity);
		box2.add(Box.createVerticalStrut(30));
		hotelCirc = new JLabel("酒店所在商圈   ："+vo.hotelDistrict);
		box1.add(hotelCirc);
		box1.add(Box.createVerticalStrut(30));
		DecimalFormat    df   = new DecimalFormat("######0.00"); 
		hotelScore = new JLabel("酒店评分       ："+df.format(vo.score)+"     ");
		box2.add(hotelScore);
		box2.add(Box.createVerticalStrut(30));
		
		hotelStar = new JLabel("酒店星级       ："+vo.hotelStar+"        ");
		box1.add(hotelStar);
		box1.add(Box.createVerticalStrut(30));
		String key="";
		try {
			Log log=new Log();
			key=log.getSKey(HotelID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hotelTel = new JLabel("酒店联系方式   ："+DES.decryptDES(vo.hotelPhone,key),Label.LEFT);
		box2.add(hotelTel);
		box2.add(Box.createVerticalStrut(30));
		
		hotelService = new JLabel("酒店服务       ："+vo.hotelService);
		box1.add(hotelService);
		box1.add(Box.createVerticalStrut(30));
		
		hotelAddress = new JLabel("酒店地址       ："+vo.hotelAddress);
		box2.add(hotelAddress);
		box2.add(Box.createVerticalStrut(30));
		
		hotelIntroduce = new JLabel("酒店介绍       ：");
		panel5.add(hotelIntroduce);
		
		hotelin = new JLabel(vo.hotelProfile);
		panel5.add(hotelin);
	    add(panel5);
		hotelin.setPreferredSize(new Dimension(450, 30));
		
		init_OrderList();
		
		add(panel10);
		
		btnNewButton = new JButton("生成订单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       buildOrder();
			}
		});
		panel10.add(btnNewButton);
		init_exit();
		init_information();
	}
    public void init_OrderList(){
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
					try {
						showDetail(id);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		scrollPane.setPreferredSize(new Dimension(500,300));
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);
		table.setFillsViewportHeight(true);
		add(scrollPane);
    }
	/**
	 * 
	 */
	public void init_exit(){
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		panel.add(back);
	}
	public void init_information(){
		
	}
	public void exit(){
		HistroyHotelViewControllerService con =  new HistroyHotelViewControllerImpl(UserID);
		HistroyHotelView vie = new HistroyHotelView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
    public void buildOrder(){	
		try {
			OrderBuildUiService controller= new OrderBuildUiController(UserID,HotelID,2);
			OrderBuildView view=new OrderBuildView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void showDetail(String id) throws RemoteException{
		orderDetailViewControllerService con =  new orderDetailViewControllerServiceImpl(UserID,id,HotelID,2);
		orderDetailView vie = new orderDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
