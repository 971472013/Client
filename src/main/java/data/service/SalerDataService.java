package data.service;

import po.SalerPO;

public interface SalerDataService {
	public boolean addSaler(SalerPO saler);
	public boolean deleteSaler(String salerID);
	public boolean updateSaler(SalerPO saler);
	public SalerPO getSaler(String ID);
	public String getAvailableID();   //得到可用的新增ID
	public void close();   //关闭输入流
}
