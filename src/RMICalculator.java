import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMICalculator extends UnicastRemoteObject implements Operations {

    public ArrayList<MyWindow> windows;
    double num1 = 0, num2 = 0;
    private String[] operations;

    public RMICalculator() throws RemoteException {
        windows = new ArrayList<>();
        operations = new String[2];
    }

    @Override
    public void borrar(String nameOfWindow) throws RemoteException {
        if (windows.get(0).getNameOfTheWindow().equals(nameOfWindow)) {
            this.num1 = 0;
        } else if (windows.get(1).getNameOfTheWindow().equals(nameOfWindow)) {
            this.num2 =0;
        }
    }

    @Override
    public int sendNumberToServer(double number, String nameOfWindow) throws RemoteException {
        if (windows.get(0).getNameOfTheWindow().equals(nameOfWindow)) {
            this.num1 = number;
        } else if (windows.get(1).getNameOfTheWindow().equals(nameOfWindow)) {
            this.num2 = number;
        }
        return 0;
    }

    @Override
    public void setOperation(String operation, String nameOfWindow) throws RemoteException {
        if (windows.get(0).getNameOfTheWindow().equals(nameOfWindow)) {
            operations[0] = operation;
        } else if (windows.get(1).getNameOfTheWindow().equals(nameOfWindow)) {
            operations[1] = operation;
        }
    }

    @Override
    public double getResult(String nameOfTheWindowThatWantTheResult) throws RemoteException {
        for (int i = 0; i < windows.size(); i++) {
            if (windows.get(i).getNameOfTheWindow().equals(nameOfTheWindowThatWantTheResult)) {
                if (operations[i] == null) {
                    return 0;
                } else if (operations[i].equals("s")) {
                    return num1 + num2;
                } else if (operations[i].equals("r")) {
                    return num1 - num2;
                } else if (operations[i].equals("p")) {
                    return num1 * num2;
                } else if (operations[i].equals("d")) {
                    return num1 / num2;
                } else if (operations[i].equals("m")) {
                    return num1 % num2;
                } else if (operations[i].equals("c")) {
                    return (int) Math.pow(num1, num2);
                }
            }
        }
        return 0;
    }

    @Override
    public void registerWindow(MyWindow window) {
        this.windows.add(window);
    }
}
