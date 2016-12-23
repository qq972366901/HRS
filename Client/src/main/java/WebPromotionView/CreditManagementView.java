package WebPromotionView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import VO.CreditRecordVO;
import common.Operate;
import uiService.CreditManagementUiService;
import userBLServiceImpl.Customer;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;
/**
 * 信用管理界面
 * @author LZ
 *
 */
public class CreditManagementView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CreditManagementUiService controller;
	private JButton back;
	private JButton confir;
	private JButton cancel;
	private JLabel account;
	private JLabel val;
	private JTextField accountText;
	private JTextField valText;
	public CreditManagementView(CreditManagementUiService controller) {
		this.controller=controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		init();
		this.validate();
	}
	private void init(){
		back=new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toWebPromotionUserView();
			}
		});
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p1.add(back);
		this.add(p1);
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		account=new JLabel("客户账号：");
		accountText=new JTextField(10);
		p2.add(account);
		p2.add(accountText);
		this.add(p2);
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		val=new JLabel("充值额度：");
		valText=new JTextField(10);
		p3.add(val);
		p3.add(valText);
		this.add(p3);
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		confir=new JButton("确定");
		confir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long time=100;
				String key="";
				try {
					Log log=new Log();
					key=log.getKey(accountText.getText());
				} catch (RemoteException e1) {
					System.out.println("获取密钥失败");
					e1.printStackTrace();
				}
				if(key!=null){
					String acc=DES.encryptDES(accountText.getText(), key);
					long value=Long.valueOf(valText.getText());
					try {
						Customer c=new Customer();
						if(c.hasCustomer(acc)){
							long currentcredit=controller.getCurrencredit(acc);
							currentcredit+=value*time; 
							Date now = new Date(); 
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(now);
							CreditRecordVO vo=new CreditRecordVO(null,acc,calendar,"",Operate.Recharge,value*time,currentcredit);
							controller.updateCredit(vo);
							JOptionPane.showMessageDialog(null, "操作成功！","", JOptionPane.YES_OPTION);
						}
						else{
							JOptionPane.showMessageDialog(null, "不存在此客户！","", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (RemoteException e) {
						System.out.println("判断客户是否存在失败");
						e.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "不存在此客户！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		cancel=new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountText.setText("");
				valText.setText("");
			}
		});
		p4.add(confir);
		p4.add(cancel);
		this.add(p4);
	}
}
