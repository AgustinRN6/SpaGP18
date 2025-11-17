package Entidades;

import java.time.LocalTime;


//Se utilizará para manejar la tabla de seleccion de instalaciones
public class diaSpaInstalacion {
    
    Instalacion instalacion;
    LocalTime horario;
    boolean disponible;

    public diaSpaInstalacion(Instalacion instalacion, LocalTime horario, boolean disponible) {
        this.instalacion = instalacion;
        this.horario = horario;
        this.disponible = disponible;
    }

    public diaSpaInstalacion() {
    }
    
    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
}
