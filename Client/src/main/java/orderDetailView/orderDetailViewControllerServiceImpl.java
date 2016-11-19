package orderDetailView;

import CommentView.CommentView;
import Service.Impl.OrderBLServiceImpl;
import orderBLService.OrderBLService;

public class orderDetailViewControllerServiceImpl implements orderDetailViewControllerService {
	  private orderDetailView view;
	    private String UserID;
	    private String OrderID;
	    private OrderBLService order;
	    public orderDetailViewControllerServiceImpl(String UserID,String OrderID){
	    	this.UserID=UserID;
	    	this.OrderID=OrderID;
	    	order=new OrderBLServiceImpl(OrderID);
	    }
		@Override
		public void setView(orderDetailView view) {
			// TODO Auto-generated method stub
			this.view=view;
		}

		@Override
		public void exit() {
			// TODO Auto-generated method stub
			view.exit();
		}
		@Override
		public String getUserID() {
			// TODO Auto-generated method stub
			return UserID;
		}
		@Override
		public boolean judgeScore(String input) {
			if(input.equals("")){
				return false;
			}
			char[] digit=input.toCharArray();
			boolean flag=true;
			for(char a:digit){
				if(!Character.isDigit(a)){
					flag=false;
					break;
				}
			}
			int temp;
			if(flag){
				temp=Integer.parseInt(input);
				if(temp>=0&&temp<=100){
					flag=true;
				}
				else{
					flag=false;
				}
			}
			return flag;
		}
		@Override
		public boolean judgeComment(String comment) {
			int cout=0;
			for(char a:comment.toCharArray()){
				if(a!=' '){
					cout++;
				}
			}
			if(cout>=5){
				return true;
			}
			else{
				return false;	
			}
		}
		@Override
		public void comment(String score, String comment) {
			//order.comment(comment, order);
			System.out.println(score+ " "+comment);
			view.exit();
		}
}
