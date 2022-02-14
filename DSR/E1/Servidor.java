import java.rmi.*;

public class Servidor {

    public Servidor(){
        try {
            System.setProperty(
                "java.rmi.server.codebase", 
                "192.168.100.9"
            );

            InterfaceRemota objetoRemoto = new ObjetoRemoto();
            Naming.rebind("//192.168.100.9/ObjetoRemoto", objetoRemoto);
            System.out.println("Iniciando server...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    } 

     public static void main(String[] args) {
        new Servidor();

    }
}

