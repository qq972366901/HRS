package PO;

import java.io.Serializable;
import java.util.Calendar;

import common.UserType;
/**
 * 客户的数据实体
 * @author LZ
 * @version 1.0
 * @see
 */
public class UserPO extends PO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	String userpassword;
	private String useraccount;
	private String contactway;
	private int level;
	private String membertype;
	private UserType type;
	private Calendar birthday;
	private String enterprise;
	/**
	 * 构造客户数据实体
	 * @param un String型，逻辑层传来的客户名称
	 * @param ua String型，逻辑层传来的客户账号
	 * @param co String型，逻辑层传来的客户联系方式
	 * @param l int型，逻辑层传来的客户会员等级
	 * @param mt String型，逻辑层传来的客户会员种类
	 * @param t int型，逻辑层传来的用户种类
	 * @param b String型，逻辑层传来的客户生日
	 * @param e String型，逻辑层传来的客户所在企业
	 * @return 
	 * @throws
	 * @see
	 */
	public UserPO(String un,String password,String ua,String co,int l,String mt,UserType t,Calendar b,String e){
		username=un;
		userpassword = password;
		useraccount=ua;
		contactway=co;
		level=l;
		type=t;
		membertype=mt;
		birthday=b;
		enterprise=e;
	}
	/**
	 * 获取客户名称
	 * @param
	 * @return 返回客户名称
	 * @throws
	 * @see
	 */
	public String getName(){
		return username;
	}
	/**
	 * 设置客户名称
	 * @param un String型，逻辑层传来的客户名称
	 * @return
	 * @throws
	 * @see
	 */
	public void setName(String un){
		username=un;
	}
	/**
	 * 获取密码
	 * @return
	 */
	public String getPassword(){
		return userpassword;
	}
	/**
	 * 设置密码
	 * @param password
	 */
	public void setPassword(String password){
		userpassword=password;
	}
	/**
	 * 获取客户账号
	 * @param
	 * @retur 返回客户账号
	 * @throws
	 * @see
	 */
	public String getAccount(){
		return useraccount;
	}
	/**
	 * 设置客户账号
	 * @param ua String型，逻辑层传来的客户账号
	 * @return
	 * @throws
	 * @see
	 */
	public void setAccount(String ua){
		useraccount=ua;
	}
	/**
	 * 获取客户联系方式
	 * @param
	 * @return 返回客户联系方式
	 * @throws
	 * @see
	 */
	public String getContact(){
		return contactway;
	}
	/**
	 * 设置客户联系方式
	 * @param co String型，逻辑层传来的客户联系方式
	 * @return 
	 * @throws
	 * @see
	 */
	public void setContact(String co){
		contactway=co;
	}
	/**
	 * 获取客户会员等级
	 * @param
	 * @return 返回客户会员等级
	 * @throws
	 * @see
	 */
	public int getLevel(){
		return level;
	}
	/**
	 * 设置客户会员等级
	 * @param l int型，逻辑层传来的客户会员等级
	 * @return 
	 * @throws
	 * @see
	 */
	public void setLevel(int l){
		level=l;
	}
	/**
	 * 获取客户会员种类
	 * @param
	 * @return 返回客户会员种类
	 * @throws
	 * @see
	 */
	public String getMemberType(){
		return membertype;
	}
	/**
	 * 设置客户会员种类
	 * @param t String 型，逻辑层传来的客户会员种类
	 * @return
	 * @throws
	 * @see
	 */
	public void setMemberType(String t){
		membertype=t;
	}
	/**
	 * 获取用户种类
	 * @param
	 * @return 返回用户种类
	 * @throws
	 * @see
	 */
	public UserType getType(){
		return type;
	}
	/**
	 * 设置用户种类
	 * @param t String 型，逻辑层传来的用户种类
	 * @return
	 * @throws
	 * @see
	 */
	public void setType(UserType t){
		type=t;
	}
	/**
	 * 获取客户生日
	 * @param
	 * @return 返回客户生日
	 * @throws
	 * @see
	 */
	public Calendar getBirthday(){
		return birthday;
	}
	/**
	 * 设置客户生日
	 * @param b String型，逻辑层传来的客户生日
	 * @return 
	 * @throws
	 * @see
	 */
	public void setBirthday(Calendar b){
		birthday=b;
	}
	/**
	 * 获取客户所在企业
	 * @param
	 * @return 返回企业名称
	 * @throws
	 * @see
	 */
	public String getEnterprise(){
		return enterprise;
	}
	/**
	 * 设置客户所在企业名称
	 * @param e String型，逻辑层传来的客户所在企业名称
	 * @return
	 * @throws
	 * @see
	 */
	public void setEnterprise(String e){
		enterprise=e;
	}

	
}
