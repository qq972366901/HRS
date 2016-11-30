package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.DataFactoryService;
import datafactory.DataFactoryMySqlImpl;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
		DataFactoryService dataFactory;
		try {
			dataFactory = DataFactoryMySqlImpl.getInstance();
			LocateRegistry.createRegistry(8089);
			Naming.bind("rmi://localhost:8089/DataFactoryService",
					dataFactory);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
