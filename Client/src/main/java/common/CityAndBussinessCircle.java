package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
/**
 *为酒店预订系统添加初始的城市和商圈
 */
public class CityAndBussinessCircle implements Serializable{
	private static final long serialVersionUID = 1L;
	private HashMap<String,Vector<String>> cityandbussinesscircle;
	List<String> list;
	Vector<String> list1;
	Vector<String> list2;
	Vector<String> list3;
	Vector<String> list4;
	Vector<String> list5;
	Vector<String> list6;
	Vector<String> list7;
	Vector<String> list8;
	public CityAndBussinessCircle(){
		list=new ArrayList<String>();
		list.add("南京");
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		list.add("杭州");	
		list.add("成都");
		list.add("重庆");
		list1=new Vector<String>();
		list1.add("水游城");
		list1.add("新街口");
		list1.add("中央商场");
		list1.add("德基广场");
		list1.add("苏宁环球");
		list2=new Vector<String>();
		list2.add("西单商业街");
		list2.add("国贸");
		list2.add("王府井商业街");
		list2.add("东四时尚街区");
		list2.add("燕莎商业街区");
		list3=new Vector<String>();
		list3.add("徐家汇商圈");
		list3.add("虹桥商圈");
		list3.add("陆家嘴商圈");
		list3.add("淮海路商圈");
		list3.add("南京东路商圈");
		list4=new Vector<String>();
		list4.add("中华广场");
		list4.add("美居中心");
		list4.add("世贸新天地");
		list4.add("时代广场");
		list4.add("广西百货");
		list5=new Vector<String>();
		list5.add("东门商圈");
		list5.add("华强北商圈");
		list5.add("福田中心区商圈");
		list5.add("宝安商圈");
		list5.add("龙岗商圈");
		list6=new Vector<String>();
		list6.add("湖滨商圈");
		list6.add("吴山商圈");
		list6.add("下沙商圈");
		list6.add("城西商圈");
		list6.add("城战商圈");
		list7=new Vector<String>();
		list7.add("天府新城");
		list7.add("金沙太阳城");
		list7.add("沙湾-犀浦商圈");
		list7.add("红牌楼商圈");
		list7.add("锦华路商圈");
		list8=new Vector<String>();
		list8.add("解放碑");
		list8.add("观音桥");
		list8.add("沙坪坝商圈");
		list8.add("杨家坪商圈");
		list8.add("南坪商圈");
	}
	public List<String> getCity(){
		return list;
	}
	public Vector<String> getCircle(String city){
		cityandbussinesscircle=new HashMap<String,Vector<String>>();
		cityandbussinesscircle.put(list.get(0),list1);
		cityandbussinesscircle.put(list.get(1),list2);
		cityandbussinesscircle.put(list.get(2),list3);
		cityandbussinesscircle.put(list.get(3),list4);
		cityandbussinesscircle.put(list.get(4),list5);
		cityandbussinesscircle.put(list.get(5),list6);
		cityandbussinesscircle.put(list.get(6),list7);
		cityandbussinesscircle.put(list.get(7),list8);
		for(String CITY : list){
			if(CITY.equals(city)){
				return 	cityandbussinesscircle.get(CITY);
			}
		}
		return null;
	}
}
