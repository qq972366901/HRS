package rmi;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
		DataRemoteObject dataRemoteObject;
		try {
			dataRemoteObject = new DataRemoteObject();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/DataRemoteObject",dataRemoteObject);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
