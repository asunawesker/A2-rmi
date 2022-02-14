import java.rmi.*;

public interface InterfaceRemota extends Remote{
    public double cuotaMensual(double capital, double interes, double plazo) throws RemoteException;
}
