package Client;

import java.rmi.RemoteException;

import hotelBLService.*;
import orderBLService.*;
import promotionBLService.*;
import roomBLService.*;
import userBLService.*;
public class Client {
     public static void main(String[] args) throws RemoteException{
    	 HotelBLService hotelController=new HotelController();
    	 HotelBLService_Driver driver1=new HotelBLService_Driver();
    	 OrderBLService orderController=new OrderController();
    	 OrderBLService_Driver driver2=new OrderBLService_Driver();
    	 PromotionBLService promotionController=new PromotionController();
    	 PromotionBLService_Driver driver3=new PromotionBLService_Driver();
    	 RoomBLService roomController=new RoomController();
    	 RoomBLService_Driver driver4=new RoomBLService_Driver();
    	 UserBLService userController=new UserController();
    	 UserBLService_Driver driver5=new UserBLService_Driver();
    	 driver1.drive(hotelController);
    	 driver2.drive(orderController);
    	 driver3.drive(promotionController);
    	 driver4.drive(roomController);
    	 driver5.drive(userController);
     }
}
