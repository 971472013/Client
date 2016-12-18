package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by apple on 2016/11/29.
 */
public interface OrderDataAbstractFactory extends Remote {
    
    public OrderDataService getOrderData(String userID) throws RemoteException;
}
