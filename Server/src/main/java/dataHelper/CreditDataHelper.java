package dataHelper;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface CreditDataHelper extends Remote{
	public ArrayList<String> get()throws RemoteException;
}
