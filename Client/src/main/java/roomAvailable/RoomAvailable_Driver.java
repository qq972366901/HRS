package roomAvailable;
import java.util.ArrayList;

import Object.Room;
import VO.*;
import common.*;
import roomBLService.RoomBLService;
public class RoomAvailable_Driver {
	 public void drive(RoomBLService roomBLService){
		 ArrayList<RoomVO> result1=roomBLService.getRoom();
			if(result1 ==new ArrayList<RoomVO>()) System.out.println("getRoom success");
			long result2=roomBLService.getPrice("12");
			if(result2 ==200) System.out.println("getPrice success");
	 }
}
