package rmi;

import data.service.*;
import other.OrderStatus;
import po.OrderPO;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

/**
 * Created by CROFF on 2016/12/10.
 */
public class RemoteHelper {
	
	private Remote remote;
	private boolean connected = false;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
		
	}
	
	public CreditDataService getCreditDataService() {
		return (CreditDataService)remote;
	}
	
	public HotelDataService getHotelDataService() {
		return (HotelDataService)remote;
	}
	
	public ManagerDataService getManagerDataService() {
		return (ManagerDataService)remote;
	}
	
	public MemberDataService getMemberDataService() {
		return (MemberDataService)remote;
	}
	
//	public OrderDataService getOrderDataService() {
//		return (OrderDataService)remote;
//	}
	
	public PromotionDataService getPromotionDataService() {
		return (PromotionDataService)remote;
	}
	
	public RankDataService getRankDataService() {
		return (RankDataService)remote;
	}
	
	public RoomDataService getRoomDataService() {
		return (RoomDataService)remote;
	}
	
	public SalerDataService getSalerDataService() {
		return (SalerDataService)remote;
	}
	
	public SearchDataService getSearchDataService() {
		return (SearchDataService)remote;
	}

	public OrderDataObstractFactory getOrderDataFactory(){
		return (OrderDataObstractFactory)remote;
	}
	
	public boolean connect() {
		try {
			remote = Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			connected = true;
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			connected = false;
			return false;
		} catch (NotBoundException e) {
			e.printStackTrace();
			connected = false;
			return false;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			connected = false;
			return false;
		}
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public static void main(String[] args) {
//		try {
//			System.out.println(InetAddress.getLocalHost().toString());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		System.out.println(remoteHelper.connect());
		OrderDataService test = remoteHelper.getOrderDataFactory().getOrdaerData("00000000");
		OrderPO result = test.getOrder("2016120900000000");
		SimpleDateFormat bartDateFormate = new SimpleDateFormat("MM-dd-yyyy");
		System.out.println("orderID: "+result.getOrderID());
		System.out.println("mamberID: "+result.getMemberID());
		System.out.println("hotelID: "+result.getHotelID());
		System.out.println("orderStatus: "+result.getOrderStatus());
		if(result.getOrderStatus()== OrderStatus.Canceled){
			System.out.println("cancel: "+bartDateFormate.format(result.getCancelTime()));
		}
		System.out.println("roomName: "+result.getRoomName());
		System.out.println("numberOfRoom: "+result.getNumberOfRoom());
		System.out.println("numberOfClient: "+result.getNumberOfClient());
		System.out.println("hasKid: "+result.getHaveKids());
		System.out.println("checkInTime: "+bartDateFormate.format(result.getCheckinTime()));
		System.out.println("checkOutTime: "+bartDateFormate.format(result.getCheckoutTime()));
		System.out.println("latesCheckInTime: "+bartDateFormate.format(result.getLatestCheckinTime()));
		System.out.println("promotionID: "+result.getPromotionID());
		System.out.println("price: "+result.getPrice());
		if(result.getOrderStatus()== OrderStatus.Executed){
			System.out.println("actualCheckInTime: "+bartDateFormate.format(result.getActualCheckinTime()));
			System.out.println("actualCheckOutTime: "+bartDateFormate.format(result.getActualCheckoutTime()));
			System.out.println("score: "+result.getScore());
			System.out.println("evaluation: "+result.getEvaluation());
			System.out.println("recover: "+result.getRecover());
		}
		System.out.println("createTime: "+bartDateFormate.format(result.getCreateTime()));
	}
}