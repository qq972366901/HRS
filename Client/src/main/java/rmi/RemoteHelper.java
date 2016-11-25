package rmi;

import java.io.Serializable;
import java.rmi.Remote;

import dataService.DataFactoryService;


public class RemoteHelper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Remote remote;
	private static RemoteHelper remoteHelper = null;
	public static RemoteHelper getInstance(){
		if(remoteHelper == null){
			remoteHelper=new RemoteHelper();
		}
		return remoteHelper;
	}
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	public DataFactoryService getDataFactoryService(){
		return (DataFactoryService) remote;
	}
}
