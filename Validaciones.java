package paqueteprincipal;
import java.util.*;
public class Validaciones {
    Scanner sc=new Scanner(System.in);
    
    public String ValidacionString(String mensaje){
    while(true){
        System.out.println(mensaje);
        String input=sc.nextLine().trim();
        if(!input.isEmpty()){
            return input;
        }
        System.out.println("ERROR: campo vacio, ingrese de nuevo");      
    }
    }
    public double ValidacionDoublePositivo(String mensaje){
        while(true){
            try{
                System.out.println(mensaje);
                double valor= Double.parseDouble(sc.nextLine());
                if(valor>0){
                return valor;}
                System.out.println("ERROR: debe ser mayor que 0");
            }
            catch(NumberFormatException e){
                System.out.println("ERROR: Ingrese solo numeros");
            }
        }
    }
        public int ValidacionIntPositivo(String mensaje){
        while(true){
            try{
                System.out.println(mensaje);
                int valor= Integer.parseInt(sc.nextLine());
                if(valor>0){
                return valor;}
                System.out.println("ERROR: debe ser mayor que 0");
            }
            catch(NumberFormatException e){
                System.out.println("ERROR: Ingrese solo numeros");
            }
        }
    }
}
