package Modelo;

public class usuario {

    private int id_usua;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String cargo;

    public usuario() {
    }

    public usuario(int id_usua, String usuario, String contraseña, String nombre, String cargo) {
        this.id_usua = id_usua;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getId_usua() {
        return id_usua;
    }

    public void setId_usua(int id_usua) {
        this.id_usua = id_usua;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
