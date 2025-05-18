package paqueteprincipal;
public class Categoria {
    Validaciones entrada= new Validaciones();
private String Id,NombreCategoria;
    public Categoria(String Id, String NombreCategoria) {
        this.Id = Id;
        this.NombreCategoria = NombreCategoria;
    }
//getter
    public String getId() {
        return Id;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }
//setter
public void setId(String Id) {
    this.Id = Id;
}
public void setNombreCategoria(String NombreCategoria) {
    this.NombreCategoria = NombreCategoria;
}
}
