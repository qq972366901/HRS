package Mock;
public class MockUser{
	private static final long serialVersionUID = 1L;
	private String username;
	private String useraccount;
	private String contactway;
	private int level;
	private String type;
	private String birthday;
	private String enterprise;
	/**
	 * 构造客户数据实体
	 * @param un String型，逻辑层传来的客户名称
	 * @param ua String型，逻辑层传来的客户账号
	 * @param co String型，逻辑层传来的客户联系方式
	 * @param l int型，逻辑层传来的客户会员等级
	 * @param t String型，逻辑层传来的客户种类
	 * @param b String型，逻辑层传来的客户生日
	 * @param e String型，逻辑层传来的客户所在企业
	 * @return 
	 * @throws
	 * @see
	 */
	public MockUser(String un,String ua,String co,int l,String t,String b,String e){
		username=un;
		useraccount=ua;
		contactway=co;
		level=l;
		type=t;
		birthday=b;
		enterprise=e;
	}
	public MockUser(int l){
		level=l;
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
	 * 获取客户种类
	 * @param
	 * @return 返回客户种类
	 * @throws
	 * @see
	 */
	public String getType(){
		return type;
	}
	/**
	 * 设置客户种类
	 * @param t String 型，逻辑层传来的客户种类
	 * @return
	 * @throws
	 * @see
	 */
	public void setType(String t){
		type=t;
	}
	/**
	 * 获取客户生日
	 * @param
	 * @return 返回客户生日
	 * @throws
	 * @see
	 */
	public String getBirthday(){
		return birthday;
	}
	/**
	 * 设置客户生日
	 * @param b String型，逻辑层传来的客户生日
	 * @return 
	 * @throws
	 * @see
	 */
	public void setBirthday(String b){
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
