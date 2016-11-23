package UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.HotelDetailUiController;
import uiController.HotelorderlistViewControllerImpl;
import uiController.customerMainViewControllerImpl;
import uiService.HistroyHotelViewControllerService;
import uiService.HotelDetailUiService;
import uiService.HotelorderlistViewControllerService;
import uiService.customerMainViewControllerService;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;


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
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        panel_1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel_1);
        id=controller.getUserID();
        init_exit();
        
        init_hotelname();
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
	public void exit(){
		customerMainViewControllerService con;
		try {
			con = new customerMainViewControllerImpl(id);
			customerMainView vie = new customerMainView(con);
			con.setView(vie);
			ClientRunner.change(vie);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init_hotelname(){

		
		label = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
        panel_1.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
        
		scrollPane.setPreferredSize(new Dimension(1000,500));
        name=new Vector<String>();
        name.addAll(controller.getHotelName(id));
		list = new JList<String>(name);
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
		add(scrollPane);
	}
	public void intoOrderList(String HotelID,String UserID){
		HotelDetailUiService con =  new HotelDetailUiController(HotelID,UserID);
		HotelDetailView vie = new HotelDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
