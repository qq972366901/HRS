package uiService;

import java.util.List;

import UserView.CommentView;
/**
 * 负责实现评论界面的初始界面
 * @author 刘宇翔
 *
 */
public interface CommentViewService {
       /**
        * 设置一个panel
        * @param view
        */
       public void setView(CommentView view);
       /**
        * 实现返回按钮
        */
       public void exit();
       /**
        * 获得用户id
        * @return String 用户id
        */
       public String getUserID();
       /**
        * 判断评分是否合法
        * @param input 输入的评分
        * @return  boolean，true为合法
        */
       public boolean judgeScore(String input);
       /**
        * 判断评论是否合法
        * @param comment 输入的评论
        * @return  boolean，true为合法
        */
       public boolean judgeComment(String comment);
       /**
        * 更新订单的评论
        * @param score 客户的评分
        * @param comment 客户的评论
        */
       public void comment(String score,String comment);
       /**
        * 获得订单的详细
        * @return 订单的详细信息
        */
       public  List<String> getDetail();
       /**
        * 更新酒店的评分
        * @param hotelid 酒店的id
        * @param score 客户的评分
        */
       public void changeHotelScore(String hotelid, int score);
       /**
        * 获得酒店的id
        * @return 酒店的id
        */
       public String getHotelID();
}
