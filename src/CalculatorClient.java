import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1005);
            Operations operations = (Operations)registry.lookup("Calculadora");
            String nameOfTheWindow = JOptionPane.showInputDialog("Ingrese el nombre de la calculadora");
            new MyWindow(operations,nameOfTheWindow);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}