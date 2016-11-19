package HotelWorkerView;

import javax.swing.JPanel;

import uiService.BrowseOrderUiService;

public class BrowseOrderView extends JPanel {

	private static final long serialVersionUID = 1L;

	private BrowseOrderUiService controller;
	
	public BrowseOrderView(BrowseOrderUiService controller) {
		this.controller = controller;
		initPanel();
		this.validate();
	}

	private void initPanel() {
		
	}
	
}
