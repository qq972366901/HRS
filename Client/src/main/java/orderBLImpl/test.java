package orderBLImpl;

import java.rmi.RemoteException;

public class test {
    OrderState info;
    public static void main(String[] args) throws RemoteException{
    	new test();
    }
    public test() throws RemoteException{
    	info=new OrderState("110");
    	init();
    }
    public void init() throws RemoteException{
    	info.cancel();
    }
}
