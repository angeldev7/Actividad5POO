
package paqueteprincipal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVManager {
 public void guardarEnCSV(ArrayList<Producto> inventario, String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            boolean existeArchivo = archivo.exists();
            
            FileWriter writer = new FileWriter(archivo, true); // Modo append
            
            // Escribir encabezado solo si el archivo es nuevo
            if (!existeArchivo) {
                writer.append("Codigo,Nombre,Precio,ID_Categoria,Categoria\n");
            }
            
            // Escribir datos
            for (Producto producto : inventario) {
                writer.append(String.valueOf(producto.getCodigo())).append(",");
                writer.append(escapeCSV(producto.getNombre())).append(",");
                writer.append(String.valueOf(producto.getPrecio())).append(",");
                writer.append(escapeCSV(producto.getCategoria().getId())).append(",");
                writer.append(escapeCSV(producto.getCategoria().getNombreCategoria()));
                writer.append("\n");
            }
            
            writer.close();
            System.out.println("\nDatos guardados exitosamente en: " + nombreArchivo);
            
        } catch (IOException e) {
            System.out.println("\nError al guardar el archivo: " + e.getMessage());
        }
    }
    
    private String escapeCSV(String input) {
        if (input.contains(",") || input.contains("\"") || input.contains("\n")) {
            return "\"" + input.replace("\"", "\"\"") + "\"";
        }
        return input;
    }
}
