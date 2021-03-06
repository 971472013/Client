package vo;

import other.RoomType;
import other.User;
import other.UserType;

import java.util.ArrayList;

/**
 * 存储Hotel信息的VO类
 * @author CROFF
 * @version 2016-12-4
 */
public class HotelVO extends User {

	private String name;	//酒店名称
	private String address;	//酒店地址
	private int level;	//酒店星级
	private String city;	//酒店所在城市名
	private String district;	//酒店所属商圈
	private double score;	//酒店评分
	private String service;	//酒店设施服务
	private String introduction;	//酒店简介
	private String managerName;	//酒店管理人员的姓名
	private String managerTel;	//酒店管理人员的联系方式
	
	private double lowestPrice;	//酒店当天客房最低价
	private ArrayList<RoomType> roomTypeList;	//酒店当天可订房型列表
	private ArrayList<Integer> roomNumberList;	//酒店当天对应房型可订数量
	
	/**
	 * 空构造方法
	 */
	public HotelVO() {
		super.setUserType(UserType.Hotel);
	}
	
	/**
	 * 有参数的构造方法
	 * @param userID 酒店ID
	 * @param password 酒店登陆的密码
	 * @param name 酒店名称
	 * @param address 酒店地址
	 * @param district 酒店所属商圈
	 * @param city 酒店所在城市名
	 * @param level 酒店星级
	 * @param score 酒店评分
	 * @param service 酒店设施服务
	 * @param introduction 酒店简介
	 * @param managerName 酒店工作人员姓名
	 * @param managerTel 酒店工作人员联系方式
	 */
	public HotelVO(String userID, String password, String name, String address,
				   String district, String city, int level, double score, String service,
				   String introduction, String managerName, String managerTel) {
		super(userID, password, UserType.Hotel);
		this.name = name;
		this.address = address;
		this.district = district;
		this.city = city;
		this.level = level;
		this.score = score;
		this.service = service;
		this.introduction = introduction;
		this.managerName = managerName;
		this.managerTel = managerTel;
		super.setUserType(UserType.Hotel);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String getManagerTel() {
		return managerTel;
	}
	
	public void setManagerTel(String managerTel) {
		this.managerTel = managerTel;
	}
	
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public double getLowestPrice() {
		return lowestPrice;
	}
	
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	
	public ArrayList<RoomType> getRoomTypeList() {
		return roomTypeList;
	}
	
	public void setRoomTypeList(ArrayList<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}
	
	public ArrayList<Integer> getRoomNumberList() {
		return roomNumberList;
	}
	
	public void setRoomNumberList(ArrayList<Integer> roomNumberList) {
		this.roomNumberList = roomNumberList;
	}
}