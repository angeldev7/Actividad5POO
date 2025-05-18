package paqueteprincipal;
import java.util.*;
import paqueteprincipal.Excepciones.*;
public class Validaciones {
    Scanner sc = new Scanner(System.in);
    public String ValidacionString(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new CampoVacioException("ERROR: campo vacio, ingrese de nuevo");
                }
                return input;
            } catch (CampoVacioException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public double ValidacionDoublePositivo(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                String entrada = sc.nextLine();
                double valor;
                try {
                    valor = Double.parseDouble(entrada);
                } catch (NumberFormatException e) {
                    throw new FormatoIncorrectoException("ERROR: Ingrese solo numeros"+ e.getMessage());
                }
                if (valor <= 0) {
                    throw new ValorNegativoException("ERROR: debe ser mayor que 0");
                }
                return valor;
            } catch (FormatoIncorrectoException | ValorNegativoException e) {
                System.out.println(e.getMessage());
            }
        }
    }   
    public int ValidacionIntPositivo(String mensaje) {
    while (true) {
        try {
            System.out.println(mensaje);
            String entrada = sc.nextLine();
            int valor = Integer.parseInt(entrada);
            if (valor <= 0) {
                throw new IllegalArgumentException("ERROR: debe ser mayor que 0");
            }
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Ingrese solo numeros"+e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }  
    }

    public void validarCodigoDuplicado(int codigo, ArrayList<Producto> inventario) throws DatosDuplicadosException {
        for (Producto p : inventario) {
            if (p.getCodigo() == codigo) {
                throw new DatosDuplicadosException("ERROR: Código duplicado, ya existe un producto con ese código.");
            }
        }
    }
}
