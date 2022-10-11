
package Modelo;

import java.sql.Date;
import java.sql.Time;


public class cita {
    private int id_cita;
    private int dni_paciente;
    private String nombre_paciente;
    private String apellido_paterno;
    private String apellido_materno;
    private String genero_paciente;
    private int edad_paciente;
    private Date fecha_nacimiento;
    private Date fecha_cita;
    private Time hora_cita;
    private int telefono_paciente;
    private String correo_paciente;
    private String seguro_paciente;
    private String nombre_doctor;
    private String especialidad;
    private String descripcion_cita;
    private String fecha_regis;
    private String usuario;

    public cita() {
    }

    public cita(int id_cita, int dni_paciente, String nombre_paciente, String apellido_paterno, String apellido_materno, String genero_paciente, int edad_paciente, Date fecha_nacimiento, Date fecha_cita, Time hora_cita, int telefono_paciente, String correo_paciente, String seguro_paciente, String nombre_doctor, String especialidad, String descripcion_cita, String fecha_regis, String usuario) {
        this.id_cita = id_cita;
        this.dni_paciente = dni_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.genero_paciente = genero_paciente;
        this.edad_paciente = edad_paciente;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.telefono_paciente = telefono_paciente;
        this.correo_paciente = correo_paciente;
        this.seguro_paciente = seguro_paciente;
        this.nombre_doctor = nombre_doctor;
        this.especialidad = especialidad;
        this.descripcion_cita = descripcion_cita;
        this.fecha_regis = fecha_regis;
        this.usuario = usuario;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getDni_paciente() {
        return dni_paciente;
    }

    public void setDni_paciente(int dni_paciente) {
        this.dni_paciente = dni_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getGenero_paciente() {
        return genero_paciente;
    }

    public void setGenero_paciente(String genero_paciente) {
        this.genero_paciente = genero_paciente;
    }

    public int getEdad_paciente() {
        return edad_paciente;
    }

    public void setEdad_paciente(int edad_paciente) {
        this.edad_paciente = edad_paciente;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public Time getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(Time hora_cita) {
        this.hora_cita = hora_cita;
    }

    public int getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(int telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public String getSeguro_paciente() {
        return seguro_paciente;
    }

    public void setSeguro_paciente(String seguro_paciente) {
        this.seguro_paciente = seguro_paciente;
    }

    public String getNombre_doctor() {
        return nombre_doctor;
    }

    public void setNombre_doctor(String nombre_doctor) {
        this.nombre_doctor = nombre_doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion_cita() {
        return descripcion_cita;
    }

    public void setDescripcion_cita(String descripcion_cita) {
        this.descripcion_cita = descripcion_cita;
    }

    public String getFecha_regis() {
        return fecha_regis;
    }

    public void setFecha_regis(String fecha_regis) {
        this.fecha_regis = fecha_regis;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    
    
}
