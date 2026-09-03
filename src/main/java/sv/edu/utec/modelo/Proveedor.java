package sv.edu.utec.modelo;

public class Proveedor {
    private int id;
    private String nombreEmpresa;
    private String telefono;

    //Constructor
    public Proveedor(int id, String nombreEmpresa, String telefono) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
    }

    //Metodos accesores
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "ID: " + id + "| Empresa: " + nombreEmpresa + "| Telefono: " + telefono;
    }
}
