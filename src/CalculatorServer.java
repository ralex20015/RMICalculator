import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Registry rmi = LocateRegistry.createRegistry(1005);

            rmi.rebind("Calculadora", (Remote) new RMICalculator());
            System.out.println("Servidor Activo");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Servidor No Activo");
        }
    }
}
