package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import VO.OrderVO;
import uiService.HotelBrowseUiService;
import uiService.HotelSearchUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;


public class HotelBrowseView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
	private JButton button1,button2;
	private JTable table,table1;
	private DefaultTableModel model,model1;
	private HotelBrowseUiService controller;
	private String hotelid=controller.getHotelID();

	public HotelBrowseView(HotelBrowseUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));;
		initButton();
		initTable();
		this.validate();
	}

	private void initButton() {
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel.add(button1);
		this.add(panel);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try {
					controller.toHotelSearchView(controller.getUserID());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JPanel panel1= new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		label1=new JLabel("酒店名称："+controller. findByHotelID(hotelid).hotelName);
		panel1.add(label1);
		this.add(panel1);
		JPanel panel2= new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		label2=new JLabel("酒店星级："+controller. findByHotelID(hotelid).hotelStar);
		panel2.add(label2);
		this.add(panel2);
		JPanel panel11= new JPanel();
		panel11.setLayout(new FlowLayout(FlowLayout.LEFT));
		label11=new JLabel("酒店评分："+controller. findByHotelID(hotelid).score);
		panel11.add(label11);
		this.add(panel11);
		JPanel panel12= new JPanel();		
		panel12.setLayout(new FlowLayout(FlowLayout.LEFT));
		List<String> typelist=controller.getRoomType(hotelid);		
		label12=new JLabel("客房类型："+typelist.get(0)+" "+typelist.get(1)+" "+typelist.get(2)+" "+typelist.get(3)+" "+typelist.get(4));
		panel12.add(label12);
		this.add(panel12);
		JPanel panel3= new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		label3=new JLabel("所属城市："+controller. findByHotelID(hotelid).hotelCity);
		panel3.add(label3);
		this.add(panel3);
		JPanel panel4= new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		label4=new JLabel("所属商圈："+controller. findByHotelID(hotelid).hotelDistrict);
		panel4.add(label4);
		this.add(panel4);
		JPanel panel13= new JPanel();
		panel13.setLayout(new FlowLayout(FlowLayout.LEFT));
		label10=new JLabel("所在地址："+controller. findByHotelID(hotelid).hotelAddress);
		panel13.add(label10);
		this.add(panel13);
		JPanel panel5= new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		label5=new JLabel("设施服务："+controller. findByHotelID(hotelid).hotelService);
		panel5.add(label5);
		this.add(panel5);
		JPanel panel6= new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		label6=new JLabel("酒店简介："+controller. findByHotelID(hotelid).hotelProfile);
		panel6.add(label6);
		this.add(panel6);
		JPanel panel7= new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
		String key="";
		try {
			key=Log.getLogInstance().getSKey(hotelid);
		} catch (RemoteException e1) {
			System.out.println("获取密钥失败");
			e1.printStackTrace();
		}
		String str=null;
		if(key!=null){
		str=DES.decryptDES(controller. findByHotelID(hotelid).hotelPhone, key);
		}
		label7=new JLabel("酒店联系方式："+str);
		panel7.add(label7);
		this.add(panel7);
		JPanel panel8= new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.LEFT));
		label8=new JLabel("酒店营销策略："+controller.getHotelPromotionByHotelID(hotelid).promotionName);
		panel8.add(label8);
		this.add(panel8);
		JPanel panel9= new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.LEFT));
		label9=new JLabel("酒店各类型房间价格："+typelist.get(0)+" "+controller.getRoomPrice(hotelid,typelist.get(0))+" "+typelist.get(1)+" "+controller.getRoomPrice(hotelid,typelist.get(1))+" "+typelist.get(2)+" "+controller.getRoomPrice(hotelid,typelist.get(2))+" "+typelist.get(3)+" "+controller.getRoomPrice(hotelid,typelist.get(3))+" "+typelist.get(4)+" "+controller.getRoomPrice(hotelid,typelist.get(0)));
		panel9.add(label9);
		this.add(panel9);
		
		
	}
	private void initTable() {
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label1=new JLabel("历史订单：");
		panel1.add(label1);
		this.add(panel1);
        JScrollPane scrollPane1 = new JScrollPane();  
		Vector<String> vColumns1 = new Vector<String>();
		vColumns1.add("订单号");
		vColumns1.add("订单状态");
		vColumns1.add("入住时间");
		vColumns1.add("退房时间");
		vColumns1.add("房间类型");
		vColumns1.add("房间数量");
		vColumns1.add("价值");
		vColumns1.add("评分");
		List<OrderVO> ordervolist=controller.findByHotelIDAndUserID(controller.getUserID(),hotelid);
		Vector<Vector<Object>> data1=new Vector<Vector<Object>>();
		for(OrderVO vo : ordervolist){
			Vector<Object> inf=new Vector<Object>();
			inf.add(vo.orderNumber);
			String state="";
			if(vo.orderState==1){
				state="已执行订单";
			}
			else if(vo.orderState==2){
				state="未执行订单";
			}
            else if(vo.orderState==3){
				state="异常订单";
			}
            else if(vo.orderState==4){
	            state="撤销订单";
            }
			inf.add(state);
			inf.add(vo.expectedCheckIn);
			inf.add(vo.expectedCheckOut);
			inf.add(vo.roomType);
			inf.add(vo.roomNumber);
			inf.add(vo.orderValue);
			inf.add(vo.score);
			data1.add(inf);
		}
		model1= new DefaultTableModel(data1, vColumns1);
		table1 = new JTable(model1){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane1.getViewport().add(table1);
		table1.setFillsViewportHeight(true);
		this.add(scrollPane1);
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label=new JLabel("客户评价：");
		panel.add(label);
		this.add(panel);
        JScrollPane scrollPane = new JScrollPane();
        
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("客户账号");
		vColumns.add("客户评价");
		vColumns.add("客户评分");
		List<OrderVO> orderlist=controller.getFinishedOrders(hotelid);
		Vector<Vector<Object>> data=new Vector<Vector<Object>>();
		for(OrderVO vo : orderlist){
			Vector<Object> inf=new Vector<Object>();
			inf.add(vo.userID);
			inf.add(vo.comment);
			inf.add(vo.score);
			data.add(inf);
		}
		model= new DefaultTableModel(data, vColumns);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
		JPanel panel10= new JPanel();
		panel10.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("下订单");
		panel10.add(button2);
		this.add(panel10);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try {
					controller.toOrderBuildView(controller.getUserID(),hotelid);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}

