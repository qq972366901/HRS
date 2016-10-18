package runner;

import rmi.RemoteHelper;

public class ServerRunner {
	public ServerRunner() {
		new RemoteHelper();
		System.out.println("BFServer is ready");
	}
	
	public static void main(String[] args) {
		new ServerRunner();
	}
}
