package runner;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmi.RemoteHelper;
/**
 * 服务端初始化
 * @author LZ&刘宗侃
 *
 */
public class ServerRunner implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public ServerRunner(){
		initFrame();
	}

	public static void main(String[] args){
		
		new ServerRunner();
	}
	
	private void initFrame() {
		JFrame frame = new JFrame("服务器");
		contentPane = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel startPanel = new JPanel();
		buttonPanel.add(startPanel);
		
		JButton startButton = new JButton("启动");
		startPanel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoteHelper();
			}
		});
		
		JPanel panel_0 = new JPanel();
		buttonPanel.add(panel_0);
		
		JPanel endPanel = new JPanel();
		buttonPanel.add(endPanel);
		
		JButton endButton = new JButton("关闭");
		endPanel.add(endButton);
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		frame.setVisible(true);
	}
	
}
