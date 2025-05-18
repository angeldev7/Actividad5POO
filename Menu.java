package paqueteprincipal;
import java.util.*;

public class Menu {
   Scanner sc=new Scanner(System.in);
   CSVManager csvManager = new CSVManager();
   ArrayList<Producto> inventario=new ArrayList<>();
   Validaciones validaciones = new Validaciones();  
    public void mostrarMenuPrincipal(){
        inventario = csvManager.cargarDesdeCSV("inventario.csv");
        char opc;
        do{
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Guardar en CSV");
            System.out.println("4. Salir");
            opc=sc.nextLine().trim().charAt(0);
            switch(opc){
                case '1':
                    // Registrar producto  
                  RegistrarProdcutos();  
                 break;
                case '2':
                    // Cargar productos desde CSV al inventario
                    ListarProductos();
                    break;
                case '3':
                    // Guardar inventario en CSV
                    csvManager.guardarEnCSV(inventario, "inventario.csv");
                    break;
                case '4':
                    // Salir
                    System.out.println("BYE BYE");
                    break;
                default: 
                    System.out.println("ERROR: Opcion no valida");
                    break;
            }
        }while(opc != '4');
            // Guardar automáticamente al salir
    csvManager.guardarEnCSV(inventario, "inventario.csv"); 

    }
                
public void RegistrarProdcutos() {
    try {
        System.out.println("\n--- REGISTRO DE PRODUCTO ---");
        
        // 1. Validar nombre
        String nombre = validaciones.ValidacionString("Ingrese nombre: ");
        
        // 2. Validar código único
        int codigo = validaciones.ValidacionIntPositivo("Ingrese codigo: ");
        if (csvManager.existeCodigoEnCSV(codigo, "inventario.csv")) {
            throw new Excepciones.DatosDuplicadosException("Codigo ya existe en CSV");
        }
        validaciones.validarCodigoDuplicado(codigo, inventario);
        
        // 3. Validar precio
        double precio = validaciones.ValidacionDoublePositivo("Ingrese precio: ");
        
        // 4. Validar categoría
        String idCategoria = validaciones.ValidacionString("ID categoria: ");
        String nombreCategoria = validaciones.ValidacionString("Nombre categoria: ");
        
        // Crear objeto Producto
        Producto nuevo = new Producto(
            nombre,
            new Categoria(idCategoria, nombreCategoria),
            codigo,
            precio
        );
        inventario.add(nuevo);
        System.out.println("\n Producto registrado");
        
    } catch (Excepciones.DatosDuplicadosException e) {
        System.out.println(e.getMessage());
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

public void ListarProductos() {
    ArrayList<Producto> productosCSV = csvManager.cargarDesdeCSV("inventario.csv");
    
    if (productosCSV.isEmpty()) {
        System.out.println("\nNo hay productos en el archivo CSV");
        return;
    }
    
    System.out.println("\n--- PRODUCTOS DESDE CSV ---");
    productosCSV.forEach(producto -> {
        System.out.println("\nCodigo: " + producto.getCodigo());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Categoria: " + producto.getCategoria().getNombreCategoria());
        System.out.println("ID Categoria: " + producto.getCategoria().getId());
 
    });
}
}
