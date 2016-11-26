package common;

public enum Operate {
	/**
	 * Done 订单从未执行变为已执行，将会执行为客户增加相应订单价值的信用值
	 * Abnormal 订单超时未执行，为客户扣除相应订单价值的信用值
	 * Cancel 根据撤销时间与订单最晚执行时间的差距，如果小于6小时扣除客户相应订单价值一半的信用值
	 * Recharge 根据客户充值的金额为客户增加信用值
	 * Delayed 酒店人员将订单从异常重新设置为已执行状态，并为客户增加订单价值的信用值
	 * Appeal 网站人员对于申诉成功的异常订单为客户恢复其价值一半的信用值
	 */
     Done,Abnormal,Cancel,Recharge,Delayed,Appeal
}
