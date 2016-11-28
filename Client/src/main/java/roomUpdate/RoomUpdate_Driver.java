package roomUpdate;
import java.util.ArrayList;

import VO.*;
import common.*;
import roomBLService.RoomBLService;
public class RoomUpdate_Driver {
	 public void drive(RoomBLService roomBLService){
		 ResultMessage result1=roomBLService.messageupdate(null);
			if(result1 ==ResultMessage.Exist) System.out.println("messageupdate success");
			RoomVO result2=roomBLService.messageadd(new OrderVO());
			if(result2 ==new RoomVO()) System.out.println("messageadd success");
			ArrayList<RoomVO> result3=roomBLService.getRoom();
			if(result3 ==new ArrayList<RoomVO>()) System.out.println("getRoom success");
	 }
}
