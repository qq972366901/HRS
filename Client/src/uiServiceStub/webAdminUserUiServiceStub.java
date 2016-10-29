package uiServiceStub;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import uiService.webAdminUserUiService;

/**
 * 负责实现酒店管理系统的网站管理人员的界面的控制器
 * @author 刘宗侃
 * @version 1.0
 * @see uiService.webAdminUserUiService
 * @see javax.swing.JFrame
 * @see java.awt.event.WindowAdapter;
 * @see java.awt.event.WindowEvent;
 * 
 */
public class webAdminUserUiServiceStub extends JFrame implements webAdminUserUiService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 网站管理人员的初始界面
     * 
     * @param 
     * @return 
     */
	public void init() {
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

