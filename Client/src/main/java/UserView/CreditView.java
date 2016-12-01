package UserView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import runner.ClientRunner;
import uiController.customerMainViewControllerImpl;
import uiService.CreditViewControllerService;
import uiService.customerMainViewControllerService;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class CreditView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CreditViewControllerService controller;
    
	private JPanel panel;
	private JButton back;
	private JTable table;
	private JLabel label;
	private JLabel totalcredit;
	private JScrollPane scrollPane;
	private String UserID;
	private JPanel panel1;
	/**
	 * Create the panel.
	 */
	public CreditView(CreditViewControllerService controller) {
		this.controller=controller;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel1);
		UserID=controller.getUserID();
		init_exit();
		
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
		
		label = new JLabel("\u4FE1\u7528\u603B\u989D\u5EA6\uFF1A");
		panel1.add(label);
		totalcredit = new JLabel("");
		totalcredit.setText(""+controller.getcredit(UserID));
		panel1.add(totalcredit);
		Vector<Vector<String>> Data=new Vector<Vector<String>>();
		Data.addAll(controller.getCreditRecord(UserID));
		Vector<String> Columns=new Vector<String>();
		Columns.add("时间");
		Columns.add("订单号");
		Columns.add("动作");
		Columns.add("信用变化");
		Columns.add("信用总额");
		table = new JTable(Data,Columns){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		scrollPane = new JScrollPane();
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
