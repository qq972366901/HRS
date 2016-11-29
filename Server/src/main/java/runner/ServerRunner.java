package runner;

import java.io.Serializable;
import java.sql.SQLException;

import rmi.RemoteHelper;

public class ServerRunner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerRunner(){
		new RemoteHelper();
		System.out.println("Server is ready");
	}

	public static void main(String[] args){
		new ServerRunner();
	}
}
