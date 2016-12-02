package bl.stub;

import java.util.ArrayList;
import java.util.Date;

import bl.service.MemberBLService;
import other.MemberType;
import other.OrderAction;
import vo.CreditChangeVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.OrderVO;

public class MemberBLStub implements MemberBLService {
	
	private MemberVO memberVO;
	private double credit = 100;
	
	public MemberBLStub() {
		String memberID = "12345678";
		String password = "12345678910";
		String name = "周杰伦";
		String tel = "12345678910";
		int level = 1;
		double discount = 1;
		MemberType memberType = MemberType.Orinary;
		Date birthday = new Date(96, 11, 11);
		String enterprise = "南京大学有限公司";
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		memberVO = new MemberVO(memberID, password, name, tel, level, discount,
				memberType, birthday, enterprise, orderList, hotelList);
	}
	
	@Override
	public String getName() {
		System.out.println("获取名称成功");
		return memberVO.getName();
	}
	
	@Override
	public String getTel() {
		System.out.println("获取联系方式成功");
		return memberVO.getTel();
	}
	
	@Override
	public double getCredit() {
		System.out.println("获取客户信用成功");
		return credit;
	}
	
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		System.out.println("获取信用变化情况成功");
		ArrayList<CreditChangeVO> creditChangeList = new ArrayList<CreditChangeVO>();
		CreditChangeVO creditChange = new CreditChangeVO(new Date(116, 11, 1), "20161101000000", OrderAction.ExecuteOrder, 100, 100);
		creditChangeList.add(creditChange);
		creditChange = new CreditChangeVO(new Date(116, 11, 2), "20161102000000", OrderAction.ExecuteOrder, 100, 200);
		creditChangeList.add(creditChange);
		return creditChangeList;
	}
	
	@Override
	public int getLevel() {
		System.out.println("获取客户会员等级成功");
		return memberVO.getLevel();
	}
	
	@Override
	public double getDiscount() {
		System.out.println("获取折扣成功");
		return memberVO.getDiscount();
	}
	
	@Override
	public MemberType getMemberType() {
		System.out.println("获取客户类型成功");
		return memberVO.getMemberType();
	}
	
	@Override
	public Date getBirthday() {
		System.out.println("获取生日成功");
		return memberVO.getBirthday();
	}
	
	@Override
	public String getEnterprise() {
		System.out.println("获取合作企业名称成功");
		return memberVO.getEnterprise();
	}
	
	@Override
	public MemberVO getMemberInformation() {
		System.out.println("获取客户信息成功");
		return memberVO;
	}
	
	@Override
	public boolean updateMemberInformation(MemberVO memberVO) {
		System.out.println("更新客户信息成功");
		return true;
	}
	
	@Override
	public boolean newReservation(String hotelID, String roomID) {
		System.out.println("新建预订成功");
		return true;
	}
	
	@Override
	public boolean markHotel(String hotelID) {
		System.out.println("收藏酒店成功");
		return true;
	}
	
	@Override
	public boolean CreateOrder(OrderVO orderVO) {
		System.out.println("创建订单成功");
		return true;
	}
}
