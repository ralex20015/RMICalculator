import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operations extends Remote {
    void borrar(String nameOfWindow) throws RemoteException;
    int sendNumberToServer(double number,String whoSendTheNumber) throws RemoteException;
    void setOperation(String operation, String nameOfTheWindowThatWantTheOperation) throws RemoteException;
    double getResult(String nameOfTheWindowThatWantTheResult) throws RemoteException;
    void registerWindow(MyWindow window) throws RemoteException;
}
