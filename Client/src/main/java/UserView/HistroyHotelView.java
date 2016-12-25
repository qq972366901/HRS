package UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.HotelDetailUiController;
import uiController.CustomerMainViewController;
import uiService.HistroyHotelViewControllerService;
import uiService.HotelDetailUiService;
import uiService.CustomerMainViewService;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;

/**
 * 历史酒店界面的Panel
 * @author 刘宇翔
 *
 */
public class HistroyHotelView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HistroyHotelViewControllerService controller;
	private JPanel panel;
    private JButton back;
    private JPanel panel_1;
    private JLabel label;
    private JList<String> list;
    private String id;
    private Vector<String> name;
	/**
	 * Create the panel.
	 */
	public HistroyHotelView(HistroyHotelViewControllerService controller) {
		this.controller=controller;
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        panel_1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel_1);
        id=controller.getUserID();
        init_exit();
        
        init_hotelname();
	}
	/**
	 * 退出按钮的初始化
	 */
	public void init_exit(){
		
		back = new JButton("\u8FD4\u56DE");
		/**
		 * 返回按钮的监听
		 */
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		panel.add(back);
		
		
	}
	/**
	 * 退出界面的跳转
	 */
	public void exit(){
		CustomerMainViewService con =  new CustomerMainViewController(id);
		CustomerMainView vie = new CustomerMainView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 表单和主Panel的初始化
	 */
	public void init_hotelname(){	
		label = new JLabel("所有历史酒店",JLabel.CENTER);
        panel_1.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
        
		scrollPane.setPreferredSize(new Dimension(600,400));
        name=new Vector<String>();
        name.addAll(controller.getHotelName(id));
		list = new JList<String>(name);
		DefaultListCellRenderer renderer=new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        renderer.setBackground(Color.gray);
        list.setCellRenderer(renderer);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/**
		 * 表单项的鼠标监听
		 */
		list.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
				if(e.getClickCount()==2){
					controller.intoOrderList(list.getSelectedIndex());
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
		scrollPane.setViewportView(list);
		add(scrollPane);
	}
	/**
	 * 酒店详情界面的跳转
	 */
	public void intoOrderList(String HotelID,String UserID){
		HotelDetailUiService con =  new HotelDetailUiController(HotelID,UserID);
		HotelDetailView vie = new HotelDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
