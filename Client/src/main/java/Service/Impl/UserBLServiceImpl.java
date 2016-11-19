package Service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import VO.CreditRecordVO;
import VO.UserVO;
import common.ResultMessage;
import common.UserType;
import userBLService.UserBLService;

public class UserBLServiceImpl implements UserBLService{
	public List<CreditRecordVO> showCreditRecord(String userID) {
		return null;
	}
	@Override
	public ResultMessage findByID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long showCredit(String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage updateCredit(UserVO vo, long credit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateLevel(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateCreditRecord(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage register(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage maintainPeersonalInfo(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditRecordVO showCreditRecord(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage topUp(long money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage payment(long money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return UserType.Customer;
	}

	@Override
	public ResultMessage logout(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserVO findByAccount(String acc) {
		// TODO Auto-generated method stub
		return null;
	}

}
