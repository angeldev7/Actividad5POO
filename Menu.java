package paqueteprincipal;
import java.util.*;
public class Menu {
   Scanner sc=new Scanner(System.in);
   CSVManager csvManager = new CSVManager();
   ArrayList<Producto> inventario=new ArrayList<>();
   
    public void mostrarMenuPrincipal(){
        char opc;
        do{
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Guardar en CSV");
            System.out.println("4. Salir");
            opc=sc.nextLine().charAt(0);
            switch(opc){
                case '1':
                    RegistrarProdcutos();
                    break;
                case '2':
                    ListarProductos();
                    break;
                case '3':
                    csvManager.guardarEnCSV(inventario, "inventario.csv");
                    break;
                case '4':
                    System.out.println("BYE BYE");
                    break;
                default:
                    System.out.println("ERROR: opcion incorrecta");
            }
        }while(opc != '4');

    }
                
    
    public void RegistrarProdcutos(){
            System.out.println("\n--- REGISTRO DE PRODUCTO ---");
        
        // Crear producto con valores temporales
        Producto nuevoProducto = new Producto("", new Categoria("", ""), 0, 0.0);
        
        // Usar setters que manejan la entrada de datos
        nuevoProducto.setNombre(""); // Mensaje definido en el setter de Producto
        nuevoProducto.setCodigo(0);  // Mensaje definido en el setter de Producto
        nuevoProducto.setPrecio(0); // Mensaje definido en el setter de Producto
        
        // Usar setters de Categoria
        Categoria categoria = nuevoProducto.getCategoria();
        categoria.setId("");     // Mensaje definido en el setter de Categoria
        categoria.setNombreCategoria(""); // Mensaje definido en el setter de Categoria
        
        inventario.add(nuevoProducto);
        System.out.println("\n Producto registrado exitosamente");
    }
    public void ListarProductos(){
    if(inventario.isEmpty()){
        System.out.println("No existen productos registrados");
        return;
    }
        System.out.println("Lista de productos");
        inventario.forEach(Producto:: MostrarResumen);
    }
}
