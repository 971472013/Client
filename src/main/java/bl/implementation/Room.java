package bl.implementation;

import data.service.RoomDataService;
import bl.service.RoomBLService;
import other.RoomType;
import po.RoomPO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Room模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Room implements RoomBLService {
	
	private String hotelID;
	
	private RoomDataService roomDataService;
	
	/**
	 * 构造方法
	 * @param hotelID 酒店ID
	 */
	public Room(String hotelID) {
		this.hotelID = hotelID;
	}
	
	/**
	 * 根据客房号码获取房间信息
	 * @param roomNumber 客房号码
	 * @return 房间信息
	 */
	@Override
	public RoomVO getRoomInformation(String roomNumber){
		RoomPO roomPO = roomDataService.getSingleRoom(roomNumber, hotelID);
		RoomVO roomVO = roomPOtoVO(roomPO);
		return roomVO;
	}
	
	
	/**
	 * 添加新客房
	 * @param roomVO 新客房信息
	 * @return 添加成功则返回true，否则返回false
	 */
	@Override
	public boolean addRoom(RoomVO roomVO) {
		RoomPO roomPO = roomVOtoPO(roomVO);
		return roomDataService.addSingleRoom(roomPO, hotelID);
	}
	
	/**
	 * 删除客房
	 * @param roomNumber 客房号码
	 * @return 删除成功则返回true，否则返回false
	 */
	@Override
	public boolean deleteRoom(String roomNumber) {
		return roomDataService.deleteSingleRoom(roomNumber, hotelID);
	}
	
	/**
	 * 更新客房信息
	 * @param roomVO 客房信息
	 * @return 更新成功则返回true，否则返回false
	 */
	@Override
	public boolean updateRoom(RoomVO roomVO) {
		RoomPO roomPO = roomVOtoPO(roomVO);
		return roomDataService.updateSingleRoom(roomPO, hotelID);
	}
	
	/**
	 * room从PO到VO的转换
	 * @param roomPO PO
	 * @return VO
	 */
	public RoomVO roomPOtoVO(RoomPO roomPO) {
		boolean reserved = roomPO.isReserved();
		boolean available = roomPO.isAvailable();
		String roomNumber = roomPO.getRoomNumber();
		String roomName = roomPO.getRoomName();
		RoomType roomType = roomPO.getRoomType();
		double price = roomPO.getPrice();
		String hotelID = roomPO.getHotelID();
		RoomVO roomVO = new RoomVO(reserved, available, roomNumber, roomName, roomType, price, hotelID);
		return roomVO;
	}
	
	/**
	 * room从VO到PO的转换
	 * @param roomVO VO
	 * @return PO
	 */
	public RoomPO roomVOtoPO(RoomVO roomVO) {
		boolean reserved = roomVO.isReserved();
		boolean available = roomVO.isAvailable();
		String roomNumber = roomVO.getRoomNumber();
		String roomName = roomVO.getRoomName();
		RoomType roomType = roomVO.getRoomType();
		double price = roomVO.getPrice();
		String hotelID = roomVO.getHotelID();
		RoomPO roomPO = new RoomPO(reserved, available, roomNumber, roomName, roomType, price, hotelID);
		return roomPO;
	}
}

