package WebAdminView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uiService.AddHotelUiService;


public class AddHotelView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton button1,button2;
	private JLabel label2,label3,label4,label5,label6,label7;
	private JTextField textField2,textField3,textField6,textField7;
	private JComboBox<String> comboBox1;
	private JComboBox<Integer> comboBox2;
	private AddHotelUiService controller;
	public AddHotelView(AddHotelUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
	}
	private void initButton() {
		JPanel panel1= new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel1.add(button1);
		this.add(panel1);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toWebAdminUserView();
			}
		});
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label2 = new JLabel("酒店名称");
		textField2 = new JTextField(10);
		panel2.add(label2);
		panel2.add(textField2);
		this.add(panel2);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label3 = new JLabel("酒店地址");
		textField3 = new JTextField(10);
		panel3.add(label3);
		panel3.add(textField3);
		this.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label4 = new JLabel("所属商圈");
		comboBox1=new JComboBox<String>();
		panel4.add(label4);
		panel4.add(comboBox1);
		this.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		label5 = new JLabel("酒店星级");
		comboBox2=new JComboBox<Integer>();
		comboBox2.addItem(1);
		comboBox2.addItem(2);
		comboBox2.addItem(3);
		comboBox2.addItem(4);
		comboBox2.addItem(5);
		panel5.add(label5);
		panel5.add(comboBox2);
		this.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		label6 = new JLabel("设施服务");
		textField6 = new JTextField(10);
		panel6.add(label6);
		panel6.add(textField6);
		this.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		label7 = new JLabel("酒店简介");
		textField7 = new JTextField(10);
		panel7.add(label7);
		panel7.add(textField7);
		this.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("添加酒店");
		panel8.add(button2);
		this.add(panel8);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new  JFrame();
				frame.setBounds(360,260,300,200);
				frame.setVisible(true);
				JPanel panel= new JPanel();
				panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
				frame.getContentPane().add(panel);
				JPanel panel1= new JPanel();
				panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel label = new JLabel("添加成功！");
				panel1.add(label);
				panel.add(panel1);
				JPanel panel2= new JPanel();
				panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton button = new JButton("确定");
				panel2.add(button);
				panel.add(panel2);
				button.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						controller.toWebAdminUserView();
					}
				});
			}
		});		
	}
}
		
