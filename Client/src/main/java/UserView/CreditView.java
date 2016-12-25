package UserView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import runner.ClientRunner;
import uiController.CustomerMainViewController;
import uiService.CreditViewService;
import uiService.CustomerMainViewService;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
/**
 * 信用查看界面的Panel
 * @author 刘宇翔
 *
 */
public class CreditView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CreditViewService controller;
    
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
	public CreditView(CreditViewService controller) {
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
	/**
	 * 初始化退出按钮
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
	 * 初始化表单
	 */
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
		TableModel model = new DefaultTableModel(Data, Columns);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();  
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);
		table.setFillsViewportHeight(true);
		add(scrollPane);
	}
	/**
	 * 退出的跳转实现
	 */
	public void exit(){
		CustomerMainViewService con =  new CustomerMainViewController(UserID);
		CustomerMainView vie = new CustomerMainView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
