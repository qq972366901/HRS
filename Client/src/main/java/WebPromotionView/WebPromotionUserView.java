package webPromotionView;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import uiService.webPromotionUserUiService;
/**
 * 网站营销人员主界面
 * @author LZ
 *
 */
public class WebPromotionUserView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private webPromotionUserUiService controller;
	private JButton proStrategy;
	private JButton abnormalOrder;
	private JButton creditManage;
	private JButton memberLevel;
	private JButton exit;
	public WebPromotionUserView(webPromotionUserUiService controller){
		this.controller=controller;
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		initButton();
		this.validate();
	}
	//初始化按钮
	private void initButton(){
		proStrategy=new JButton("制定营销策略");
		proStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toWebPromotionStrategyView();
			}
		});
		abnormalOrder=new JButton("处理异常申诉");
		abnormalOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toProcessOrderOrderView();
			}
		});
		creditManage=new JButton("管理信用值");
		creditManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toCreditManagementView();
			}
		});
		memberLevel=new JButton("制定会员等级");
		memberLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toMemberLevelSystemView();
			}
		});
		exit=new JButton("退出");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toLogView();
			}
		});
		JPanel panel = new JPanel();	
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		panel.add(toolBar);
	    toolBar.setLayout(new GridLayout(1,5));
	    toolBar.add(proStrategy);
	    toolBar.add(abnormalOrder);
	    toolBar.add(creditManage);
	    toolBar.add(memberLevel);
	    toolBar.add(exit);
		this.add(panel);
	}
}
