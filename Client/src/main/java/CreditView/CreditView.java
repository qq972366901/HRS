package CreditView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import LoginView.main;
import VO.CreditRecordVO;
import VO.OrderVO;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;

import javax.swing.JButton;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreditView extends JPanel {
	private CreditViewControllerService controller;
    
	private JPanel panel;
	private JPanel panel_1;
	private JButton back;
	private JTable table;
	private JLabel label;
	private JLabel totalcredit;
	private JScrollPane scrollPane;
	private String UserID;
	/**
	 * Create the panel.
	 */
	public CreditView(CreditViewControllerService controller) {
		setLayout(null);
		this.controller=controller;
		UserID=controller.getUserID();
		init_exit();
		
		init_table();
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
		back.setFont(new Font("宋体", Font.PLAIN, 30));
		back.setBounds(10, 5, 150, 60);
		panel.add(back);
	}
	public void init_table(){
		panel_1 = new JPanel();
		panel_1.setBounds(78, 100, 842, 539);
		add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("\u4FE1\u7528\u603B\u989D\u5EA6\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		label.setBounds(22, 37, 180, 64);
		panel_1.add(label);
		
		totalcredit = new JLabel("");
		totalcredit.setText(""+controller.getcredit());
		totalcredit.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		totalcredit.setBounds(227, 37, 180, 64);
		panel_1.add(totalcredit);
		
		Vector<CreditRecordVO> Data=new Vector<CreditRecordVO>();
		//Data.addAll(controller.getCreditRecord(UserID));
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
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 111, 822, 404);
		table.setFillsViewportHeight(true);
		panel_1.add(scrollPane);
	}
	public void exit(){
		customerMainViewControllerService con =  new customerMainViewControllerImpl(UserID);
		customerMainView vie = new customerMainView(con);
		con.setView(vie);
		main.change(this,vie);
	}
}
