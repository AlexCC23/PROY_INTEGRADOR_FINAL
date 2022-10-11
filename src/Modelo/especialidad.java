
package Modelo;

public class especialidad {
    private int id_especialidad;
    private String nom_espec;

    public especialidad() {
    }

    public especialidad(int id_especialidad, String nom_espec) {
        this.id_especialidad = id_especialidad;
        this.nom_espec = nom_espec;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNom_espec() {
        return nom_espec;
    }

    public void setNom_espec(String nom_espec) {
        this.nom_espec = nom_espec;
    }
    
    
    
}
