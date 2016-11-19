package HistroyHotelView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import InformationView.InformationViewControllerService;
import LoginView.main;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import HotelorderlistView.HotelorderlistView;
import HotelorderlistView.HotelorderlistViewControllerImpl;
import HotelorderlistView.HotelorderlistViewControllerService;

import javax.swing.JList;


public class HistroyHotelView extends JPanel {
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
		setLayout(null);
        this.controller=controller;
        id=controller.getUserID();
        init_exit();
        
        init_hotelname();
	}
	public void init_exit(){
		panel = new JPanel();
		panel.setBounds(784, 46, 174, 81);
		add(panel);
		panel.setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		back.setFont(new Font("ו", Font.PLAIN, 30));
		back.setBounds(10, 5, 150, 60);
		panel.add(back);
		
		
	}
	public void exit(){
		customerMainViewControllerService con =  new customerMainViewControllerImpl(id);
		customerMainView vie = new customerMainView(con);
		con.setView(vie);
		main.change(this,vie);
	}
	public void init_hotelname(){
		panel_1 = new JPanel();
		panel_1.setBounds(76, 124, 834, 517);
		add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
		label.setFont(new Font("ו", Font.PLAIN, 30));
		label.setBounds(23, 73, 155, 73);
		panel_1.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(188, 55, 616, 415);
		panel_1.add(scrollPane);
		
        name=new Vector<String>();
        name.addAll(controller.getHotelName(id));
		list = new JList<String>(name);
		list.setFont(new Font("ו", Font.PLAIN, 30));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
				if(e.getClickCount()==2){
					System.out.println(list.getSelectedValue());
					controller.intoOrderList(list.getSelectedValue());
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
	}
	public void intoOrderList(String HotelID,String UserID){
		HotelorderlistViewControllerService con =  new HotelorderlistViewControllerImpl(HotelID,UserID);
		HotelorderlistView vie = new HotelorderlistView(con);
		con.setView(vie);
		main.change(this,vie);
	}
}
