package webPromotionView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uiService.MemberLevelSystemUiService;
import vo.MemberLevelSystemVO;
/**
 * 会员等级制度界面
 * @author LZ
 *
 */
public class MemberLevelSystemView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberLevelSystemUiService controller;
	private JButton back;
	private JButton confir;
	private JButton cancel;
	private JLabel level1;
	private JLabel level2;
	private JLabel level3;
	private JLabel level4;
	private JLabel level5;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;
	private JTextField l4;
	private JTextField l5;
	private JComboBox<Double> dis1;
	private JComboBox<Double> dis2;
	private JComboBox<Double> dis3;
	private JComboBox<Double> dis4;
	private JComboBox<Double> dis5;
	private boolean hasMemberLevelSystem;
	public MemberLevelSystemView(MemberLevelSystemUiService controller) {
		this.controller=controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.hasMemberLevelSystem=false;
		init();
		this.validate();
	}
	private void init(){
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		back=new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toWebPromotionUserView();
			}
		});
		p1.add(back);
		this.add(p1);
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		level1=new JLabel("LEVEL 1：信用值：");
		l1=new JTextField(10);
		JLabel d1=new JLabel("折扣：");
		dis1=new JComboBox<Double>();
		for(double i=0.5;i<10;i+=0.5){
			dis1.addItem(i);
		}
		p3.add(level1);
		p3.add(l1);
		p3.add(d1);
		p3.add(dis1);
		this.add(p3);
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		level2=new JLabel("LEVEL 2：信用值：");
		l2=new JTextField(10);
		JLabel d2=new JLabel("折扣：");
		dis2=new JComboBox<Double>();
		for(double i=0.5;i<10;i+=0.5){
			dis2.addItem(i);
		}
		p4.add(level2);
		p4.add(l2);
		p4.add(d2);
		p4.add(dis2);
		this.add(p4);
		JPanel p5=new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		level3=new JLabel("LEVEL 3：信用值：");
		l3=new JTextField(10);
		JLabel d3=new JLabel("折扣：");
		dis3=new JComboBox<Double>();
		for(double i=0.5;i<10;i+=0.5){
			dis3.addItem(i);
		}
		p5.add(level3);
		p5.add(l3);
		p5.add(d3);
		p5.add(dis3);
		this.add(p5);
		JPanel p6=new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		level4=new JLabel("LEVEL 4：信用值：");
		l4=new JTextField(10);
		JLabel d4=new JLabel("折扣：");
		dis4=new JComboBox<Double>();
		for(double i=0.5;i<10;i+=0.5){
			dis4.addItem(i);
		}
		p6.add(level4);
		p6.add(l4);
		p6.add(d4);
		p6.add(dis4);
		this.add(p6);
		JPanel p7=new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		level5=new JLabel("LEVEL 5：信用值：");
		l5=new JTextField(10);
		JLabel d5=new JLabel("折扣：");
		dis5=new JComboBox<Double>();
		for(double i=0.5;i<10;i+=0.5){
			dis5.addItem(i);
		}
		p7.add(level5);
		p7.add(l5);
		p7.add(d5);
		p7.add(dis5);
		this.add(p7);
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		confir=new JButton("确定");
		//更新或者新建会员等级制度
		confir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long credit1=Long.valueOf(l1.getText());
				long credit2=Long.valueOf(l2.getText());
				long credit3=Long.valueOf(l3.getText());
				long credit4=Long.valueOf(l4.getText());
				long credit5=Long.valueOf(l5.getText());
				long credit[]={credit1,credit2,credit3,credit4,credit5};
				double discount1=(double) dis1.getSelectedItem();
				double discount2=(double) dis2.getSelectedItem();
				double discount3=(double) dis3.getSelectedItem();
				double discount4=(double) dis4.getSelectedItem();
				double discount5=(double) dis5.getSelectedItem();
				double discount[]={discount1,discount2,discount3,discount4,discount5};
				MemberLevelSystemVO vo=new MemberLevelSystemVO(credit,discount);
				if(hasMemberLevelSystem){
					controller.updateMemberLevelSystem(vo);
					if(controller.updateAllLevel()){
						JOptionPane.showMessageDialog(null, "操作成功！","", JOptionPane.YES_OPTION);
					}
				}
				else{
					controller.addMemberLevelSystem(vo);
					if(controller.updateAllLevel()){
						JOptionPane.showMessageDialog(null, "操作成功！","", JOptionPane.YES_OPTION);
					}
				}
			}
		});
		cancel=new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				l1.setText("");
				l2.setText("");
				l3.setText("");
				l4.setText("");
				l5.setText("");
			}
		});
		p8.add(confir);
		p8.add(cancel);
		this.add(p8);
	}
	//显示会员等级系统
	public void showMemberLevelSystem(MemberLevelSystemVO vo){
		if(vo!=null){
			hasMemberLevelSystem=true;
			long credit[]=vo.creditOfLevel;
			double discount[]=vo.discountOfLevel;
			l1.setText(String.valueOf(credit[0]));
			l2.setText(String.valueOf(credit[1]));
			l3.setText(String.valueOf(credit[2]));
			l4.setText(String.valueOf(credit[3]));
			l5.setText(String.valueOf(credit[4]));
			dis1.setSelectedItem(discount[0]);
			dis2.setSelectedItem(discount[1]);
			dis3.setSelectedItem(discount[2]);
			dis4.setSelectedItem(discount[3]);
			dis5.setSelectedItem(discount[4]);
		}
	}
}
