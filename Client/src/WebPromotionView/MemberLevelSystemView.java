package WebPromotionView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uiService.MemberLevelSystemUiService;

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
	JComboBox<Double> dis1;
	JComboBox<Double> dis2;
	JComboBox<Double> dis3;
	JComboBox<Double> dis4;
	JComboBox<Double> dis5;
	public MemberLevelSystemView(MemberLevelSystemUiService controller) {
		// TODO Auto-generated constructor stub
		this.controller=controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
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
		p7.add(level5);
		p7.add(l5);
		p7.add(d5);
		p7.add(dis5);
		this.add(p7);
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		confir=new JButton("确定");
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
}
