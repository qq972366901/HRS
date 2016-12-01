package userBLServiceImpl;

import java.util.Calendar;

import PO.UserPO;
import common.UserType;

/**
 * 账户信息，提供给Account类维护和使用
 * @author LZ
 *
 */
public class AccountInfo {
	public String username;
	public String userpassword;
	public String useraccount;
	public String contactway;
	public String membertype;
	public UserType type;
	public Calendar birthday;
	public String enterprise;
	public long credit=-1;
	public int level=-1;
	public AccountInfo(UserPO po){
		username=po.getName();
		userpassword = po.getPassword();
		useraccount=po.getAccount();
		contactway=po.getContact();
		type=po.getType();
		membertype=po.getMemberType();
		birthday=po.getBirthday();
		enterprise=po.getEnterprise();
	}
	public AccountInfo(String name,String password,String id,String contact,String member,UserType t,Calendar birth,String enter,long c,int l){
		username=name;
		userpassword = password;
		useraccount=id;
		contactway=contact;
		type=t;
		membertype=member;
		birthday=birth;
		enterprise=enter;
		credit=c;
		level=l;
	}
}
