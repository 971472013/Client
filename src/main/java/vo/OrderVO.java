package vo;

import other.OrderStatus;

import java.util.ArrayList;
import java.util.Date;

/**
 * 存储Order信息的VO类
 * @author CROFF
 * @version 2016-12-1
 */
public class OrderVO {
	
	private String memberID;	//订单相关客户
	private String hotelID;	//订单相关酒店
	private String orderID;	//订单编号
	private OrderStatus orderStatus;	//订单状态
	private Date createTime;	//订单创建时间
	private Date checkinTime; 	//预计入住时间
	private Date actualCheckinTime;	//实际入住时间
	private Date latestCheckinTime;	//最晚入住时间
	private Date checkoutTime;	//预计退房时间
	private Date actualCheckoutTime;	//实际退房时间
	private int numberOfRoom;	//订单中客房数量
	private String roomName;	//订单中客房名称
	private int numberOfClient;	//预计入住人数
	private boolean haveKids;	//有无儿童
	private double score;	//订单评分
	private String evaluation;	//订单评价
	private double recover;	//撤销异常时返回的信用比例，若无则为0
	private String promotionID;	//使用的促销策略ID
	private double price;	//订单价值
	private Date cancelTime;	//订单撤销时间
	
	private MemberVO memberVO;	//客户信息
	private HotelVO hotelVO;	//酒店信息
	private ArrayList<RoomVO> roomList = new ArrayList<>();
	
	/**
	 * 空构造方法
	 */
	public OrderVO() {
		
	}
	
	/**
	 * 客户创建订单的构造方法
	 * @param memberID 订单相关客户
	 * @param hotelID 订单相关酒店
	 * @param checkinTime 预计入住时间
	 * @param latestCheckinTime 最晚入住时间
	 * @param checkoutTime 预计退房时间
	 * @param numberOfRoom 订单中客房名称高
	 * @param roomName 订单中客房数量
	 * @param numberOfClient 预计入住人数
	 * @param haveKids 有无儿童
	 * @param promotionID 使用的促销策略ID
	 * @param price 订单价值
	 */
	public OrderVO(String memberID, String hotelID, Date checkinTime, Date checkoutTime,
				   Date latestCheckinTime, String roomName, int numberOfRoom, int numberOfClient,
				   boolean haveKids, String promotionID, double price) {
		this.memberID = memberID;
		this.hotelID = hotelID;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.latestCheckinTime = latestCheckinTime;
		this.roomName = roomName;
		this.numberOfRoom = numberOfRoom;
		this.numberOfClient = numberOfClient;
		this.haveKids = haveKids;
		this.promotionID = promotionID;
		this.price = price;
		this.orderStatus = OrderStatus.Unexecuted;
		this.createTime = new Date();
	}
	
	/**
	 * 带参数的构造方法
	 * @param memberID 订单相关客户
	 * @param hotelID 订单相关酒店
	 * @param orderID 订单编号
	 * @param orderStatus 订单状态
	 * @param createTime 订单创建时间
	 * @param checkinTime 预计入住时间
	 * @param actualCheckinTime 实际入住时间
	 * @param latestCheckinTime 最晚入住时间
	 * @param checkoutTime 预计退房时间
	 * @param actualCheckoutTime 实际退房时间
	 * @param numberOfRoom 订单中客房名称高
	 * @param roomName 订单中客房数量
	 * @param numberOfClient 预计入住人数
	 * @param haveKids 有无儿童
	 * @param score 订单评分
	 * @param evaluation 订单评价
	 * @param recover 撤销异常时返回的信用比例，若无则为0
	 * @param promotionID 使用的促销策略ID
	 * @param price 订单价值
	 * @param cancelTime 订单撤销时间
	 */
	public OrderVO(String memberID, String hotelID, String orderID,
				   OrderStatus orderStatus, Date createTime, Date checkinTime,
				   Date actualCheckinTime, Date latestCheckinTime, Date checkoutTime,
				   Date actualCheckoutTime, int numberOfRoom, String roomName,
				   int numberOfClient, boolean haveKids, double score,
				   String evaluation, double recover, String promotionID,
				   double price, Date cancelTime) {
		this.memberID = memberID;
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.orderStatus = orderStatus;
		this.createTime = createTime;
		this.checkinTime = checkinTime;
		this.actualCheckinTime = actualCheckinTime;
		this.latestCheckinTime = latestCheckinTime;
		this.checkoutTime = checkoutTime;
		this.actualCheckoutTime = actualCheckoutTime;
		this.numberOfRoom = numberOfRoom;
		this.roomName = roomName;
		this.numberOfClient = numberOfClient;
		this.haveKids = haveKids;
		this.score = score;
		this.evaluation = evaluation;
		this.recover = recover;
		this.promotionID = promotionID;
		this.price = price;
		this.cancelTime = cancelTime;
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCheckinTime() {
		return checkinTime;
	}
	
	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}
	
	public Date getActualCheckinTime() {
		return actualCheckinTime;
	}
	
	public void setActualCheckinTime(Date actualCheckinTime) {
		this.actualCheckinTime = actualCheckinTime;
	}
	
	public Date getLatestCheckinTime() {
		return latestCheckinTime;
	}
	
	public void setLatestCheckinTime(Date latestCheckinTime) {
		this.latestCheckinTime = latestCheckinTime;
	}
	
	public Date getCheckoutTime() {
		return checkoutTime;
	}
	
	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
	public Date getActualCheckoutTime() {
		return actualCheckoutTime;
	}
	
	public void setActualCheckoutTime(Date actualCheckoutTime) {
		this.actualCheckoutTime = actualCheckoutTime;
	}
	
	public int getNumberOfClient() {
		return numberOfClient;
	}
	
	public void setNumberOfClient(int numberOfClient) {
		this.numberOfClient = numberOfClient;
	}
	
	public boolean getHaveKids() {
		return haveKids;
	}
	
	public void setHaveKids(boolean haveKids) {
		this.haveKids = haveKids;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getEvaluation() {
		return evaluation;
	}
	
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	public double getRecover() {
		return recover;
	}
	
	public void setRecover(double recover) {
		this.recover = recover;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getNumberOfRoom() {
		return numberOfRoom;
	}
	
	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getPromotionID() {
		return promotionID;
	}
	
	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}
	
	public Date getCancelTime() {
		return cancelTime;
	}
	
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	
	public MemberVO getMemberVO() {
		return memberVO;
	}
	
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	public HotelVO getHotelVO() {
		return hotelVO;
	}
	
	public void setHotelVO(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
	}
	
	public ArrayList<RoomVO> getRoomList() {
		return roomList;
	}
	
	public void setRoomList(ArrayList<RoomVO> roomList) {
		this.roomList = roomList;
	}
}
