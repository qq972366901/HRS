package uiServiceStub;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import uiService.hotelUserUiService;

/**
 * 负责实现酒店管理系统的酒店工作人员界面的控制器
 * @author 刘宗侃
 * @version 1.0
 * @see uiService.hotelUserUiService
 * @see javax.swing.JFrame
 * @see java.awt.event.WindowAdapter;
 * @see java.awt.event.WindowEvent;
 * 
 */
public class hotelUserUiServiceStub extends JFrame implements hotelUserUiService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 酒店工作人员的初始界面
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

