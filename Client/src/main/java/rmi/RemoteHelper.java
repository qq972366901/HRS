package rmi;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.DataService;


public class RemoteHelper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	public DataFactoryService getDataFactoryService(){
		return (DataFactoryService) remote;
	}
}
