package Modelo;

import java.sql.Date;
import java.sql.Time;

public class horario {
    private int id_dispo;
    private String nom_doctor;
    private String especialidad;
    private Date fecha_dispo;
    private Time hora_dispo;

    public horario() {
    }

    public horario(int id_dispo, String nom_doctor, String especialidad, Date fecha_dispo, Time hora_dispo) {
        this.id_dispo = id_dispo;
        this.nom_doctor = nom_doctor;
        this.especialidad = especialidad;
        this.fecha_dispo = fecha_dispo;
        this.hora_dispo = hora_dispo;
    }

    public int getId_dispo() {
        return id_dispo;
    }

    public void setId_dispo(int id_dispo) {
        this.id_dispo = id_dispo;
    }

    public String getNom_doctor() {
        return nom_doctor;
    }

    public void setNom_doctor(String nom_doctor) {
        this.nom_doctor = nom_doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFecha_dispo() {
        return fecha_dispo;
    }

    public void setFecha_dispo(Date fecha_dispo) {
        this.fecha_dispo = fecha_dispo;
    }

    public Time getHora_dispo() {
        return hora_dispo;
    }

    public void setHora_dispo(Time hora_dispo) {
        this.hora_dispo = hora_dispo;
    }
    
    
}
