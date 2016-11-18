package WebPromotionView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTable strategyTable;
	private DefaultTableModel strategyListModel;
	private JPanel addPanel;
	private JFrame addFrame;
	public WebPromotionStrategyView(WebPromotionStrategyUiService controller) {
		// TODO Auto-generated constructor stub
		this.controller=controller;
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
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("策略编号");
		vColumns.add("策略名称");
		vColumns.add("开始时间");
		vColumns.add("结束时间");
		vColumns.add("适用城市");
		vColumns.add("商圈范围");
		vColumns.add("适用等级");
		vColumns.add("折扣");
		Vector<PromotionVO> vData = new Vector<PromotionVO>();
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
		// TODO Auto-generated method stub
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
		JComboBox<String> citylist=new JComboBox<String>();
		p4.add(city);
		p4.add(citylist);
		addPanel.add(p4);
		JPanel p5=new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel circle=new JLabel("商圈范围：");
		JComboBox<String> circlelist=new JComboBox<String>();
		p5.add(circle);
		p5.add(circlelist);
		addPanel.add(p5);
		JPanel p6=new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel level=new JLabel("适用等级：");
		JComboBox<Integer> levellist=new JComboBox<Integer>();
		p6.add(level);
		p6.add(levellist);
		addPanel.add(p6);
		JPanel p7=new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel discount=new JLabel("折扣：");
		JComboBox<Double> discountlist=new JComboBox<Double>();
		p7.add(discount);
		p7.add(discountlist);
		addPanel.add(p7);
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton contin=new JButton("继续");
		JButton confir=new JButton("确定");
		p8.add(contin);
		p8.add(confir);
		addPanel.add(p8);
		addFrame.getContentPane().add(addPanel);
		addFrame.setVisible(true);
	}
	public void delButtonClicked() {
		// TODO Auto-generated method stub
		int index = strategyTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择策略！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		final int rowIndex = index;
		final int strategyNo =Integer.valueOf((String)strategyTable.getValueAt(index, 0));
		if(controller.deleteStrategy(strategyNo)){
			strategyListModel.removeRow(rowIndex);
		}
	}
}
