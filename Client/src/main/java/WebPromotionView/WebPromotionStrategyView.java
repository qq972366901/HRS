package WebPromotionView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import VO.PromotionVO;
import VO.WebPromotionVO;
import uiService.WebPromotionStrategyUiService;

public class WebPromotionStrategyView  extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WebPromotionStrategyUiService controller;
	private JButton back;
	private JButton add;
	private JButton del;
	Vector<String> vColumns;
	private JTable strategyTable;
	private DefaultTableModel strategyListModel;
	private JPanel addPanel;
	private JFrame addFrame;
	JComboBox<String> citylist;
	JComboBox<String> circlelist;
	Vector<Vector<String> > vData;
	private Vector<PromotionVO> promotionArray;
	public WebPromotionStrategyView(WebPromotionStrategyUiService controller) {
		this.controller=controller;
		this.promotionArray=new Vector<PromotionVO>();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		initStrategyList();
		this.validate();
	}
	private void initButton(){
		back=new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toWebPromotionUserView();
			}
		});
		add=new JButton("增加策略");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addButtonClicked();
			}
		});
		del=new JButton("删除策略");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.delButtonClicked();
			}
		});
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(back);
		this.add(panel);
		JPanel processPanel = new JPanel();
		processPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		processPanel.add(add);
		processPanel.add(del);
		this.add(processPanel);
	}
	private void initStrategyList(){
		JScrollPane scrollPane = new JScrollPane();
		vColumns = new Vector<String>();
		vColumns.add("策略编号");
		vColumns.add("策略名称");
		vColumns.add("开始时间");
		vColumns.add("结束时间");
		vColumns.add("适用城市");
		vColumns.add("商圈范围");
		vColumns.add("适用等级");
		vColumns.add("折扣");
		vData = new Vector<Vector<String> >();
		vData.addAll(controller.getAllWebPromotion());
		strategyListModel=new DefaultTableModel(vData, vColumns);
		strategyTable = new JTable(strategyListModel){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		strategyTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(strategyTable);
		strategyTable.setFillsViewportHeight(true);
		this.add(scrollPane);
	}
	public void addButtonClicked() {
		addFrame = new JFrame("增加策略");
		addFrame.setSize(1000, 700);
		addFrame.setLocation(10, 10);	
		addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel,BoxLayout.Y_AXIS));
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel name=new JLabel("策略名称：");
		JTextField nametext=new JTextField(10);
		p1.add(name);
		p1.add(nametext);
		addPanel.add(p1);
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel begin=new JLabel("开始时间：");
		JTextField begintext=new JTextField(10);
		p2.add(begin);
		p2.add(begintext);
		addPanel.add(p2);
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel end=new JLabel("结束时间：");
		JTextField endtext=new JTextField(10);
		p3.add(end);
		p3.add(endtext);
		addPanel.add(p3);
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel city=new JLabel("适用城市：");
		citylist=new JComboBox<String>();
		List<String> list=controller.addCity();
		for(int i=0;i<list.size();i++){
			citylist.addItem(list.get(i));
		}
		citylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String city=(String) citylist.getSelectedItem();
				controller.addCircle(city);
			}
		});
		p4.add(city);
		p4.add(citylist);
		addPanel.add(p4);
		JPanel p5=new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel circle=new JLabel("商圈范围：");
		circlelist=new JComboBox<String>();
		p5.add(circle);
		p5.add(circlelist);
		addPanel.add(p5);
		JPanel p6=new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel level=new JLabel("适用等级：");
		JComboBox<Integer> levellist=new JComboBox<Integer>();
		for(int i=1;i<=5;i++){
			levellist.addItem(i);
		}
		p6.add(level);
		p6.add(levellist);
		addPanel.add(p6);
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton contin=new JButton("继续");
		contin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean beginIsValid=timeIsValid(begintext.getText());
				boolean endIsValid=timeIsValid(endtext.getText());
				if(beginIsValid&&endIsValid){
					String id=UUID.randomUUID().toString().substring(0, 8);
					String name=nametext.getText();
					Calendar c1=Calendar.getInstance();
					Calendar c2=Calendar.getInstance();
					Date d1 = null;
					Date d2 = null;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					try {
						d1 = sdf.parse(begintext.getText());
						d2 = sdf.parse(endtext.getText());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					c1.setTime(d1);
					c2.setTime(d2);
					String city=(String) citylist.getSelectedItem();
					String circle=(String) circlelist.getSelectedItem();
					Integer level=(Integer) levellist.getSelectedItem();
					WebPromotionVO vo=new WebPromotionVO(id,name,c1,c2,city,circle,level);
					promotionArray.add(vo);
					nametext.setText("");
					begintext.setText("");
					endtext.setText("");
				}
				nametext.setText("");
				begintext.setText("");
				endtext.setText("");
				citylist.setSelectedIndex(0);
				circlelist.setSelectedIndex(0);
				levellist.setSelectedIndex(0);
			}
		});
		JButton confir=new JButton("确定");
		confir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean beginIsValid=timeIsValid(begintext.getText());
				boolean endIsValid=timeIsValid(endtext.getText());
				if(beginIsValid&&endIsValid){
					String id=UUID.randomUUID().toString().substring(0, 8);
					String name=nametext.getText();
					Calendar c1=Calendar.getInstance();
					Calendar c2=Calendar.getInstance();
					Date d1 = null;
					Date d2 = null;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					try {
						d1 = sdf.parse(begintext.getText());
						d2 = sdf.parse(endtext.getText());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					c1.setTime(d1);
					c2.setTime(d2);
					String city=(String) citylist.getSelectedItem();
					String circle=(String) circlelist.getSelectedItem();
					Integer level=(Integer) levellist.getSelectedItem();
					WebPromotionVO vo=new WebPromotionVO(id,name,c1,c2,city,circle,level);
					promotionArray.add(vo);
				for(int i=0;i<promotionArray.size();i++){
					controller.addWebPromotion(promotionArray.get(i));
				}
				promotionArray.clear();
				controller.updateListModel();
				addFrame.dispose();
			}
			}});
		p8.add(contin);
		p8.add(confir);
		addPanel.add(p8);
		addFrame.getContentPane().add(addPanel);
		addFrame.setVisible(true);
	}
	public void updateListModel() {
		vData.clear();
		((DefaultTableModel) strategyTable.getModel()).getDataVector().clear();
		((DefaultTableModel) strategyTable.getModel()).fireTableDataChanged();
		for(Vector<String> v:controller.getAllWebPromotion()){
			strategyListModel.addRow(v);
		}
		strategyTable.updateUI(); 
	}
	private boolean timeIsValid(String time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date = sdf.parse(time);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "请按格式（yyyy/MM/dd HH:mm:ss）填写时间！","", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public void delButtonClicked() {
		int index = strategyTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择策略！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		final int rowIndex = index;
		final String strategyNo =(String) strategyTable.getValueAt(index, 0);
		if(controller.deleteStrategy(strategyNo)){
			strategyListModel.removeRow(rowIndex);
		}
	}
	public void addCircle(Vector<String> circles) {
		circlelist.removeAllItems();
		for(int i=0;i<circles.size();i++){
			circlelist.addItem(circles.get(i));
		}
	}
}
