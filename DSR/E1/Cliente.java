import java.rmi.*;
import java.text.*;
import java.util.Scanner;

public class Cliente {

    public Cliente(){

        Scanner entrada; 
        String repetir;
        double capital;
        double interes;
        double plazo;
        int opcion;
        DecimalFormat df;

        try {
            InterfaceRemota objetoRemoto = (InterfaceRemota)Naming.lookup("//192.168.100.9/ObjetoRemoto");

            entrada = new Scanner(System.in);
            df = new DecimalFormat("#.##");
            
            System.out.println("Ingrese el capital (peso mexicano): ");
            capital = entrada.nextDouble();
            
            System.out.println("Ingrese el interés (porcentaje): ");
            interes = entrada.nextDouble();         

            if(
                (capital<0.00 || capital<10000.00) ||
                (interes<6.00 || interes>9.00)                  
            ){
                System.out.println("El calculo no se puede realizar, no cumple las condiciones adecuadas");
            } else{
                System.out.println("\nElige el plazo\n1. 3 años\n2. 5 años\n3. 7 años");
                opcion = entrada.nextInt();

                switch(opcion){
                    case 1:   
                        plazo = 3.0;    
                        System.out.println("\nCapital: $"+capital+"\nInterés: "+interes+"% \nPlazo: "+plazo+" años");              
                        System.out.println("Cuota capital: " + df.format(objetoRemoto.cuotaMensual(capital, interes, 3.0)) + " pesos" );
                        break;
                    case 2:
                        plazo = 5.0;
                        System.out.println("\nCapital: $"+capital+"\nInterés: "+interes+"% \nPlazo: "+plazo+" años");    
                        System.out.println("Cuota capital: " + df.format(objetoRemoto.cuotaMensual(capital, interes, 5.0)) + " pesos" );
                        break;
                    case 3:
                        plazo = 7.0; 
                        System.out.println("\nCapital: $"+capital+"\nInterés: "+interes+"% \nPlazo: "+plazo+" años");   
                        System.out.println("Cuota capital: " + df.format(objetoRemoto.cuotaMensual(capital, interes, 7.0)) + " pesos" );
                        break;
                    default:
                        System.out.println("\nOpción no permitida");
                }                
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public static void  main(String[] args){
        new Cliente();
    }
}
    

