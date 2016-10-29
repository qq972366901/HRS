package uiServiceStub;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import uiService.MainFrameUiService;

/**
 * 负责实现酒店管理系统的主登录界面的控制器
 * @author 刘宗侃
 * @version 1.0
 * @see uiService.MainFrameUiService
 * @see javax.swing.JFrame
 * @see java.awt.event.WindowAdapter;
 * @see java.awt.event.WindowEvent;
 * 
 */
public class MainFrameUiServiceStub extends JFrame implements MainFrameUiService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 打开程序的主界面
     * 
     * @param args0  程序打开时的参数
     * @return 
     */
	public void init(String[] args0) {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
}

