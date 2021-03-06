package bl.service;

import other.UserType;
import vo.MemberVO;

/**
 * login模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-28
 */
public interface LoginBLService {

	public boolean checkNetwork();	//判断网络情况
	public boolean existUserID(String userID);	//登录时判断用户名是否存在
	public boolean validPassword(String password);	//注册时判断密码是否可以使用
	/* 密码格式要求：1.长度最少为10位  2.只能是数字或字母或数字和字母的组合 */
	public boolean login(String userID, String password);	//登陆
	public boolean register(MemberVO memberVO);	//注册
	public UserType getUserType(String userID);	//登录时获得用户类型（客户、酒店工作人员、网站营销人员、网站管理人员）
}
