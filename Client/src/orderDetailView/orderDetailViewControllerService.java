package orderDetailView;

import CommentView.CommentView;

public interface orderDetailViewControllerService {
	 public void setView(orderDetailView view);
     public void exit();
     public String getUserID();
     public boolean judgeScore(String input);
     public boolean judgeComment(String comment);
     public void comment(String score,String comment);
}
