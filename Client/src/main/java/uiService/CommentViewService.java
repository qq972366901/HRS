package uiService;

import java.util.List;

import UserView.CommentView;

public interface CommentViewService {
       public void setView(CommentView view);
       public void exit();
       public String getUserID();
       public boolean judgeScore(String input);
       public boolean judgeComment(String comment);
       public void comment(String score,String comment);
       public  List<String> getDetail();
}
