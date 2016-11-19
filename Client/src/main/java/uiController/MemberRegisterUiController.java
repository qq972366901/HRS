package uiController;

import javax.swing.JPanel;

import MemberRegisterView.MemberRegisterView;
import runner.ClientRunner;
import uiService.MemberRegisterUiService;

public class MemberRegisterUiController implements MemberRegisterUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(MemberRegisterView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toLogView(){
		
	}
}
