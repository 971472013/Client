package bl.dataservice;

import po.RoomPO;

public interface RoomData {

	public RoomPO getRoom(String ID) ;
	public boolean updateRoom(RoomPO room);
	public boolean addRoom(RoomPO room);
	public boolean deleteRoom(String roomNUM);
	
}
