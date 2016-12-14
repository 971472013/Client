package bl.implementation;

import data.service.HotelDataService;
import bl.service.HotelBLService;
import data.stub.HotelDataStub;
import other.OrderStatus;
import other.RoomType;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 97147 on 2016/11/18.
 * Hotel模块的bl实现类
 * @author CROFF
 * @version 2016-12-7
 */
public class Hotel implements HotelBLService {
	
	private String hotelID;
	private HotelVO hotelVO;

	public Order order;
	public Room room;
	public Promotion promotion;
	
	private HotelDataService hotelDataService;
	
	/**
	 * 新增酒店时调用这个构造方法，自动分配可用ID
	 */
	public Hotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
//		hotelDataService = RemoteHelper.getInstance().getHotelDataService();
		hotelDataService = new HotelDataStub();
		hotelVO.setUserID(hotelDataService.getAvailableHotelID());
		hotelID = hotelVO.getUserID();
		hotelDataService.addHotel(hotelVOtoPO(hotelVO));
	}
	
	/**
	 * 一般酒店的构造方法，提供酒店ID
	 * @param hotelID 酒店ID
	 */
	public Hotel(String hotelID) {
		this.hotelID = hotelID;
//		hotelDataService = RemoteHelper.getInstance().getHotelDataService();
		hotelDataService = new HotelDataStub();
		updateDateFromFile();
	}
	
	/**
	 * 获取酒店名称
	 * @return 酒店名称
	 */
	@Override
	public String getHotelName() {
		updateDateFromFile();
		return hotelVO.getName();
	}
	
	/**
	 * 获取酒店地址
	 * @return 酒店地址
	 */
	@Override
	public String getHotelAddress() {
		updateDateFromFile();
		return hotelVO.getAddress();
	}
	
	/**
	 * 获取酒店所在城市
	 * @return 酒店所在城市
	 */
	@Override
	public String getCity() {
		updateDateFromFile();
		return hotelVO.getCity();
	}
	
	/**
	 * 获取酒店星级
	 * @return 酒店星级
	 */
	@Override
	public int getHotelLevel() {
		updateDateFromFile();
		return hotelVO.getLevel();
	}
	
	/**
	 * 获取酒店所属商圈
	 * @return 酒店所属商圈
	 */
	@Override
	public String getDistrict() {
		updateDateFromFile();
		return hotelVO.getDistrict();
	}
	
	/**
	 * 获取酒店评分
	 * @return 酒店评分
	 */
	@Override
	public double getHotelScore() {
		updateDateFromFile();
		return hotelVO.getScore();
	}
	
	/**
	 * 获取酒店设施服务
	 * @return 酒店设施服务
	 */
	@Override
	public String getHotelService() {
		updateDateFromFile();
		return hotelVO.getService();
	}
	
	/**
	 * 获取酒店简介
	 * @return 酒店简介
	 */
	@Override
	public String getHotelIntroduction() {
		updateDateFromFile();
		return hotelVO.getIntroduction();
	}
	
	/**
	 * 获取酒店工作人员名称
	 * @return 酒店工作人员名称
	 */
	@Override
	public String getHotelManagerName() {
		updateDateFromFile();
		return hotelVO.getManagerName();
	}
	
	/**
	 * 获取酒店工作人员的联系方式
	 * @return 酒店工作人员联系方式
	 */
	@Override
	public String getHotelManagerTel() {
		updateDateFromFile();
		return hotelVO.getManagerTel();
	}
	
	/**
	 * 设置酒店信息
	 * @param hotelInformation 酒店信息
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setHotelInformation(HotelVO hotelInformation) {
		this.hotelVO = hotelInformation;
		updateDateToFile();
		return true;
	}
	
	/**
	 * 获取酒店信息
	 * @return 酒店信息
	 */
	@Override
	public HotelVO getHotelInformation() {
		updateDateFromFile();
		return hotelVO;
	}
	
	/**
	 * 办理入住手续
	 * @param orderID 相关订单ID
	 * @param roomID 使用的客房号
	 * @return 办理成功则返回true，否则返回false
	 */
	@Override
	public boolean checkin(String orderID, String roomID) {
		order.updateDataFromFile();
		OrderVO orderVO = order.getOrderInformation(orderID);
		if(orderVO==null) {
			return false;
		}
		orderVO.setOrderStatus(OrderStatus.Executed);
		orderVO.setActualCheckinTime(new Date());
		int index = order.getOrderIndex(orderID);
		order.getOrderList().set(index, orderVO);
		
		return room.checkin(new Date(), roomID);
	}
	
	/**
	 * 办理离店手续
	 * @param orderID 相关订单ID
	 * @param roomID 使用的客房号
	 * @return 办理成功则返回true，否则返回false
	 */
	@Override
	public boolean checkout(String orderID, String roomID) {
		order = new Order(hotelID);
		OrderVO orderVO = order.getOrderInformation(orderID);
		if(orderVO==null || orderVO.getActualCheckinTime()==null) {
			return false;
		}
		orderVO.setActualCheckoutTime(new Date());
		int index = order.getOrderIndex(orderID);
		order.getOrderList().set(index, orderVO);
		
		return room.checkout(new Date(), roomID);
	}
	
	/**
	 * 预订单间客房
	 * @param date 日期
	 * @param roomName 客房名称
	 * @return 预订成功则返回true，否则返回false
	 */
	public boolean reserveSingleRoom(Date date, String roomName) {
		ArrayList<RoomVO> roomList = room.getDailyRoomList(date);
		RoomVO roomVO;
		for(int i=0; i<roomList.size(); i++) {
			roomVO = roomList.get(i);
			if(roomVO.getRoomName().equals(roomName) && roomVO.isReserved()==false) {
				String roomID = roomVO.getRoomNumber();
				return room.reserveSingleRoom(date, roomID);
			}
		}
		return false;
	}
	
	/**
	 * 办理延迟入住
	 * @param orderID 相关订单ID
	 * @return 办理成功则返回true，否则返回false
	 */
	@Override
	public boolean delay(String orderID, String roomID) {
		order = new Order(hotelID);
		OrderVO orderVO = order.getOrderInformation(orderID);
		if(orderVO==null) {
			return false;
		}
		order.cancelAbnormalOrder(orderID, orderVO.getPrice());
		
		RoomVO roomVO = room.getRoomInformation(new Date(), roomID);
		roomVO.setAvailable(false);
		return true;
	}
	
	/**
	 * 通过给定日期获取当天酒店的信息
	 * @param date 日期
	 */
	public void updateDailyInformation(Date date) {
		ArrayList<RoomType> roomTypeList = new ArrayList<RoomType>();
		ArrayList<Integer> roomNumberList = new ArrayList<Integer>();
		
		ArrayList<RoomVO> dailyRoomList = room.getDailyRoomList(date);
		double lowestPrice = Double.MAX_VALUE;
		RoomVO roomVO;
		double price;
		for(int i=0; i<dailyRoomList.size(); i++) {
			roomVO = dailyRoomList.get(i);
			price = roomVO.getPrice();
			if(price < lowestPrice) {
				lowestPrice = price;
			}
			
			RoomType roomType = roomVO.getRoomType();
			if(roomTypeList.contains(roomType)) {
				int index = roomTypeList.indexOf(roomType);
				roomNumberList.set(index, roomNumberList.get(index)+1);
			} else {
				roomTypeList.add(roomType);
			}
		}
		
		hotelVO.setLowestPrice(lowestPrice);
		hotelVO.setRoomTypeList(roomTypeList);
		hotelVO.setRoomNumberList(roomNumberList);
	}
	
	/**
	 * 从Data层更新数据
	 */
	public boolean updateDateFromFile() {
		if(hotelDataService.getHotelByID(hotelID)==null) {
			return false;
		}
		hotelVO = hotelPOtoVO(hotelDataService.getHotelByID(hotelID));
		room = new Room(hotelID);
		promotion = new Promotion(hotelID);
		return true;
	}
	
	/**
	 * 将数据更新到Data层
	 */
	public boolean updateDateToFile() {
		HotelPO hotelPO = hotelVOtoPO(hotelVO);
		return hotelDataService.updateHotel(hotelPO);
	}
	
	/**
	 * hotel的PO转换成VO
	 * @param hotelPO PO
	 * @return VO
	 */
	public static HotelVO hotelPOtoVO(HotelPO hotelPO) {
		String hotelID = hotelPO.getUserID();
		String password = hotelPO.getPassword();
		String name = hotelPO.getName();
		String address = hotelPO.getAddress();
		String district = hotelPO.getDistrict();
		String city = hotelPO.getCity();
		int level = hotelPO.getLevel();
		double score = hotelPO.getScore();
		String service = hotelPO.getService();
		String introduction = hotelPO.getIntroduction();
		String managerName = hotelPO.getManagerName();
		String managerTel = hotelPO.getManagerTel();
		HotelVO hotelVO = new HotelVO(hotelID, password, name, address, district,
				city, level, score, service, introduction, managerName, managerTel);
		return hotelVO;
	}
	
	/**
	 * hotel的VO转换成PO
	 * @param hotelVO VO
	 * @return PO
	 */
	public static HotelPO hotelVOtoPO(HotelVO hotelVO) {
		String hotelID = hotelVO.getUserID();
		String password = hotelVO.getPassword();
		String name = hotelVO.getName();
		String address = hotelVO.getAddress();
		String district = hotelVO.getDistrict();
		String city = hotelVO.getCity();
		int level = hotelVO.getLevel();
		double score = hotelVO.getScore();
		String service = hotelVO.getService();
		String introduction = hotelVO.getIntroduction();
		String managerName = hotelVO.getManagerName();
		String managerTel = hotelVO.getManagerTel();
		ArrayList<String> enterpriseList = new ArrayList<String>();
		HotelPO hotelPO = new HotelPO(hotelID, password, name, address, district, city,
				level, score, service, introduction, managerName, managerTel, enterpriseList);
		return hotelPO;
	}
	
	/**
	 * 删除当前酒店
	 * @return 删除成功则返回true，否则返回false
	 */
	public boolean deleteHotel() {
		return hotelDataService.deleteHotel(hotelID);
	}
	
	/**
	 * 更新酒店工作人员信息
	 * @param managerName 酒店工作人员名称
	 * @param managerTel 酒店工作人员联系方式
	 * @return 更新成功则返回true，否则返回false
	 */
	public boolean updateHotelManagerInformation(String managerName, String managerTel) {
		hotelVO.setManagerName(managerName);
		hotelVO.setManagerTel(managerTel);
		updateDateToFile();
		return true;
	}
}