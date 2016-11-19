package TestRoom;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.RoomLineItem;
import List.RoomList;
import Mock.MockRoom;
import Object.Room;

public class MessageAddTester {

	@Test
	public void testMessageAdd() {

		MockRoom room1 = new MockRoom("303", "已执行", "大床房", 1, 200);
		MockRoom room2 = new MockRoom("304", "未执行", "标准间", 2, 300);
		
		RoomList roomList = new RoomList();
		
		RoomLineItem roomLineItem1 = new RoomLineItem(room1);
		RoomLineItem roomLineItem2 = new RoomLineItem(room2);
		
		roomList.addRoomLineItems(roomLineItem1);
		roomList.addRoomLineItems(roomLineItem2);
		
		Room room = new Room();
		room.addRoomList(roomList);
		
		assertEquals(3, room.messageAdd("305", "异常", "三人间", 3, 400));
	
	}

}
