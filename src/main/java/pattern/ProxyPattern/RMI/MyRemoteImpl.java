package pattern.ProxyPattern.RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

  protected MyRemoteImpl () throws RemoteException {
  }

      public static void main(String[] args){
            try {
              MyRemoteImpl service = new MyRemoteImpl ();
              Naming.rebind("RemoteHello",service);
            }catch(Exception e){

            }
      }

  @Override public String sayHello () throws RemoteException {
    return "hello world";
  }
}
