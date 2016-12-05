package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class CityAndBussinessCircle implements Serializable{
	private static final long serialVersionUID = 1L;
	private HashMap<String,Vector<String>> cityandbussinesscircle;
	List<String> list=new ArrayList<String>(){{
		add("南京");
		add("北京");
		add("上海");
		add("广州");
		add("深圳");
		add("杭州");	
		add("成都");
		add("重庆");
	}};
	Vector<String> list1=new Vector<String>(){{
		add("水游城");
		add("新街口");
		add("中央商场");
		add("德基广场");
		add("苏宁环球");
	}};
	Vector<String> list2=new Vector<String>(){{
		add("西单商业街");
		add("国贸");
		add("王府井商业街");
		add("东四时尚街区");
		add("燕莎商业街区");
	}};
	Vector<String> list3=new Vector<String>(){{
		add("徐家汇商圈");
		add("虹桥商圈");
		add("陆家嘴商圈");
		add("淮海路商圈");
		add("南京东路商圈");
	}};
	
	Vector<String> list4=new Vector<String>(){{
		add("中华广场");
		add("美居中心");
		add("世贸新天地");
		add("时代广场");
		add("广西百货");
	}};
	Vector<String> list5=new Vector<String>(){{
		add("东门商圈");
		add("华强北商圈");
		add("福田中心区商圈");
		add("宝安商圈");
		add("龙岗商圈");
	}};
	Vector<String> list6=new Vector<String>(){{
		add("湖滨商圈");
		add("吴山商圈");
		add("下沙商圈");
		add("城西商圈");
		add("城战商圈");
	}};
	Vector<String> list7=new Vector<String>(){{
		add("天府新城");
		add("金沙太阳城");
		add("沙湾-犀浦商圈");
		add("红牌楼商圈");
		add("锦华路商圈");
	}};
	Vector<String> list8=new Vector<String>(){{
		add("解放碑");
		add("观音桥");
		add("沙坪坝商圈");
		add("杨家坪商圈");
		add("南坪商圈");
	}};
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
