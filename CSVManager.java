package paqueteprincipal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class CSVManager {

public void guardarEnCSV(ArrayList<Producto> inventario, String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
        writer.println("Codigo,Nombre,Precio,ID_Categoria,Categoria");
        
        for (Producto producto : inventario) {
            writer.println(
                producto.getCodigo() + "," +
                "\"" + producto.getNombre().replace("\"", "\"\"") + "\"," +
                producto.getPrecio() + "," +
                "\"" + producto.getCategoria().getId() + "\"," +
                "\"" + producto.getCategoria().getNombreCategoria() + "\""
            );
        }
        System.out.println("Datos guardados correctamente en: " + nombreArchivo);
    } catch (IOException e) {
        System.out.println("Error crítico al guardar: " + e.getMessage());
    }
}

public ArrayList<Producto> cargarDesdeCSV(String nombreArchivo) {
    ArrayList<Producto> inventario = new ArrayList<>();
    File archivo = new File(nombreArchivo);  
    if (!archivo.exists()) return inventario; 
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        br.readLine(); // Saltar encabezado
        
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            
            if (datos.length == 5) {
                int codigo = Integer.parseInt(datos[0]);
                String nombre = datos[1].replaceAll("^\"|\"$", "");
                double precio = Double.parseDouble(datos[2]);
                String idCat = datos[3].replaceAll("^\"|\"$", "");
                String nombreCat = datos[4].replaceAll("^\"|\"$", "");       
                inventario.add(new Producto(
                    nombre,
                    new Categoria(idCat, nombreCat),
                    codigo,
                    precio
                ));
            }
        }
    } catch (Exception e) {
        System.out.println("Error leyendo archivo: " + e.getMessage());
    }
    return inventario;
}
    
public boolean existeCodigoEnCSV(int codigo, String nombreArchivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        boolean primeraLinea = true;
        while ((linea = br.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false;
                continue; // Saltar encabezado
            }
            String[] datos = linea.split(",");
            if (datos.length > 0 && Integer.parseInt(datos[0]) == codigo) {
                return true;
            }
        }
    } catch (Exception e) {
        // Si el archivo no existe, no hay duplicados
    }
    return false;
}
}
