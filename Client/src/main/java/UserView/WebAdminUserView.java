package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


import uiService.WebAdminUserUiService;



public class WebAdminUserView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2,button3;
	private WebAdminUserUiService controller;
	public WebAdminUserView(WebAdminUserUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
	}
	private void initButton(){
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("退出");
		p1.add(button1);
		this.add(p1);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toLogView();
			}
		});
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("用户管理");
		p2.add(button2);
		this.add(p2);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toUserManagementView();
			}
		});
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		button3=new JButton("添加酒店");
		p3.add(button3);
		this.add(p3);
		button3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toAddHotelView();
			}
		});
	}
}
