package userView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.CommentViewController;
import uiController.CustomerMainViewController;
import uiController.OrderDetailViewController;
import uiService.CommentViewService;
import uiService.OrderViewService;
import vo.OrderVO;
import uiService.CustomerMainViewService;
import uiService.OrderDetailViewService;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.BoxLayout;
/**
 * 订单管理的Panel
 * @author 刘宇翔
 *
 */
public class OrderView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderViewService controller;
	private JPanel panel;
    private JButton back;
    private JComboBox<String> typebox;
	
	private JScrollPane scrollPane;
	
	private DefaultTableModel model;
	private JButton cancelorder ;
	
	private JButton commentorder ;
	private JTable table;
	private String UserID;
	
	private JPanel panel2;
	private JPanel panel3;
	private JPanel k;
	
	/**
	 * Create the panel.
	 */
	public OrderView(OrderViewService controller) {
		this.controller=controller;
		k=this;
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        
        panel2=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel2);
        panel3=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel3);
        UserID=controller.getUserID();
        init_exit();
        
        init_order();
	}
	/**
	 * 返回按钮的初始化
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
	 * 返回的界面跳转
	 */
	public void exit(){
		CustomerMainViewService con =  new CustomerMainViewController(UserID);
		CustomerMainView vie = new CustomerMainView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 初始化订单表项，以及panel主界面
	 */
	public void init_order(){
		
		typebox = new JComboBox<String>();
		typebox.setPreferredSize(new Dimension(100,30));
		Vector<String> type=new Vector<String>();
		type.add("所有类型");
		type.add("未执行订单");
		type.add("已执行订单");
		type.add("异常订单");
		type.add("撤销订单");
		for(String i:type){
			typebox.addItem(i);
		}
		/**
		 * combobox的监听，实现订单表源的更换
		 */
		typebox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent evt) {
                if(evt.getStateChange() == ItemEvent.SELECTED){
					
					String selected=(String)typebox.getSelectedItem();
					
					//更换数据源
					controller.updateList(selected);
                }
			}			
		});
		panel2.add(typebox);
		scrollPane = new JScrollPane();
		
		Vector<OrderVO> Data=new Vector<OrderVO>();
		Data.addAll(controller.getAllOrder());
		Vector<String> Columns=new Vector<String>();
		Columns.add("订单号");
		Columns.add("订单状态");
		Columns.add("价值");
		Columns.add("房间详情");
		Columns.add("预订入住时间");
		Columns.add("最晚入住时间");
		Columns.add("评分");
		model=new DefaultTableModel(Data,Columns);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		/**
		 * 为表单按照预定时间进行排序
		 */
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();  
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
		cancelorder = new JButton("\u64A4\u9500\u8BA2\u5355");
		/**
		 * 撤销按钮的监听
		 */
		cancelorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(k, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int i=JOptionPane.showConfirmDialog(k, "撤销订单可能会扣除您的信用值！\n当前时间如果距离该订单最晚执行时间少于6小时将会扣除您的信用值\n确定要撤销该订单么?","", JOptionPane.YES_NO_OPTION);
				if(i==0){
				   String id=(String)table.getValueAt(index, 0);
				   controller.cancel(id);
				}
			}
		});
		/**
		 * 实现双击表单中某一项实现查看订单详情
		 */
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
		add(scrollPane);
		cancelorder.setEnabled(false);

		
		commentorder = new JButton("\u8BC4\u4EF7\u8BA2\u5355");
		commentorder.setEnabled(false);
		/**
		 * 评价按钮的监听
		 */
		commentorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      controller.comment();
			}
		});
		panel3.add(cancelorder);
		panel3.add(commentorder);
	}
	/**
	 * 替换订单表源
	 */
	public void updateList(Vector<OrderVO> list,String type){
		if(type.equals("未执行订单")){
		    model.setRowCount(0);
		    for(OrderVO vo:list){
		    	model.addRow(vo);
		    }
			cancelorder.setEnabled(true);
			commentorder.setEnabled(false);
		}
		else if(type.equals("已执行订单")){
			model.setRowCount(0);
		    for(OrderVO vo:list){
		    	model.addRow(vo);
		    }
			cancelorder.setEnabled(false);
			commentorder.setEnabled(true);
		}
		else {
			model.setRowCount(0);
		    for(OrderVO vo:list){
		    	model.addRow(vo);
		    }
			cancelorder.setEnabled(false);
			commentorder.setEnabled(false);
		}
	}
	/**
	 * 评论界面的跳转
	 */
	public void comment() throws RemoteException{
		int index = table.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(k, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!table.getValueAt(index, 6).equals("")){
			JOptionPane.showMessageDialog(k, "这个订单已经被评价过了！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String id=(String)table.getValueAt(index, 0);
		CommentViewService con =  new CommentViewController(controller.getUserID(),id);
		CommentView vie = new CommentView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 撤销表单中的某一项
	 */
	public void cancel(){
		model.removeRow(table.getSelectedRow());
	}
	/**
	 * 订单详情界面的跳转
	 */
	public void showDetail(String id,String hotelid) throws RemoteException{
		OrderDetailViewService con =  new OrderDetailViewController(controller.getUserID(),id,hotelid,1);
		OrderDetailView vie = new OrderDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
