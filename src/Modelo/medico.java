
package Modelo;

public class medico {
    private int id_medico;
    private int dni_medico;
    private String nombre_medico;
    private String apellidos_medico;
    private String especialidad;

    public medico() {
    }

    public medico(int id_medico, int dni_medico, String nombre_medico, String apellidos_medico, String especialidad) {
        this.id_medico = id_medico;
        this.dni_medico = dni_medico;
        this.nombre_medico = nombre_medico;
        this.apellidos_medico = apellidos_medico;
        this.especialidad = especialidad;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getDni_medico() {
        return dni_medico;
    }

    public void setDni_medico(int dni_medico) {
        this.dni_medico = dni_medico;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getApellidos_medico() {
        return apellidos_medico;
    }

    public void setApellidos_medico(String apellidos_medico) {
        this.apellidos_medico = apellidos_medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    

    
}
