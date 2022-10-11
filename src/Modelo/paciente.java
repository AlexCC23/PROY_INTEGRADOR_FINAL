/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

public class paciente {
    private int id_paciente;
    private int dni_pa;
    private String nombre_pa;
    private String apellidopat_pa;
    private String apellidomat_pa;
    private String genero_pa;
    private int edad_pa;
    private Date fechanac_pa;
    private int telefono_pa;
    private String correo_pa;
    private String seguro_pa;

    public paciente(int id_paciente, int dni_pa, String nombre_pa, String apellidopat_pa, String apellidomat_pa, String genero_pa, int edad_pa, Date fechanac_pa, int telefono_pa, String correo_pa, String seguro_pa) {
        this.id_paciente = id_paciente;
        this.dni_pa = dni_pa;
        this.nombre_pa = nombre_pa;
        this.apellidopat_pa = apellidopat_pa;
        this.apellidomat_pa = apellidomat_pa;
        this.genero_pa = genero_pa;
        this.edad_pa = edad_pa;
        this.fechanac_pa = fechanac_pa;
        this.telefono_pa = telefono_pa;
        this.correo_pa = correo_pa;
        this.seguro_pa = seguro_pa;
    }

    public paciente() {
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getDni_pa() {
        return dni_pa;
    }

    public void setDni_pa(int dni_pa) {
        this.dni_pa = dni_pa;
    }

    public String getNombre_pa() {
        return nombre_pa;
    }

    public void setNombre_pa(String nombre_pa) {
        this.nombre_pa = nombre_pa;
    }

    public String getApellidopat_pa() {
        return apellidopat_pa;
    }

    public void setApellidopat_pa(String apellidopat_pa) {
        this.apellidopat_pa = apellidopat_pa;
    }

    public String getApellidomat_pa() {
        return apellidomat_pa;
    }

    public void setApellidomat_pa(String apellidomat_pa) {
        this.apellidomat_pa = apellidomat_pa;
    }

    public String getGenero_pa() {
        return genero_pa;
    }

    public void setGenero_pa(String genero_pa) {
        this.genero_pa = genero_pa;
    }

    public int getEdad_pa() {
        return edad_pa;
    }

    public void setEdad_pa(int edad_pa) {
        this.edad_pa = edad_pa;
    }

    public Date getFechanac_pa() {
        return fechanac_pa;
    }

    public void setFechanac_pa(Date fechanac_pa) {
        this.fechanac_pa = fechanac_pa;
    }

    public int getTelefono_pa() {
        return telefono_pa;
    }

    public void setTelefono_pa(int telefono_pa) {
        this.telefono_pa = telefono_pa;
    }

    public String getCorreo_pa() {
        return correo_pa;
    }

    public void setCorreo_pa(String correo_pa) {
        this.correo_pa = correo_pa;
    }

    public String getSeguro_pa() {
        return seguro_pa;
    }

    public void setSeguro_pa(String seguro_pa) {
        this.seguro_pa = seguro_pa;
    }

    
    
    
}
