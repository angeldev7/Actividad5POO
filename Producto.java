package paqueteprincipal;
public class Producto {
    Validaciones entrada= new Validaciones();
    private String nombre;
    private Categoria categoria;
    private int codigo;
    private double precio;

    public Producto(String nombre, Categoria categoria, int codigo, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.codigo = codigo;
        this.precio = precio;
    }
//getter
    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }
//setter
public void setCodigo(int codigo) {
    this.codigo = codigo;
}
public void setPrecio(double precio) {
    this.precio = precio;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}

        public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void MostrarResumen(){
        System.out.println("\n Producto:");
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Precio: "+ getPrecio());
        System.out.println("Categoria: "+ categoria.getNombreCategoria());
        System.out.println("ID categoria: " + categoria.getId());
    }  
}
