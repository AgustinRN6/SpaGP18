
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Sesion {
    private int codSesion;
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private Tratamiento tratamiento;
    private List<Instalacion>instalaciones = new ArrayList();
    private DiaSpa diaS;
    private boolean estado;
    
    public Sesion(int codSesion, LocalDate fechaIn, LocalDate fechaFin, Tratamiento tratamiento, DiaSpa diaS, boolean estado){
        this.codSesion = codSesion;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.tratamiento = tratamiento;
        this.diaS = diaS;
        this.estado = estado;
    }
    
    public Sesion(){
    
    }

    public int getCodSesion() {
        return codSesion;
    }
        public void setCodSesion(int codSesion) {
            this.codSesion = codSesion;
        }

    public LocalDate getFechaIn() {
        return fechaIn;
    }
        public void setFechaIn(LocalDate fechaIn) {
            this.fechaIn = fechaIn;
        }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
        public void setFechaFin(LocalDate fechaFin) {
            this.fechaFin = fechaFin;
        }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }
        public void setTratamiento(Tratamiento tratamiento) {
            this.tratamiento = tratamiento;
        }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }
        public void setInstalaciones(List<Instalacion> instalaciones) {
            this.instalaciones = instalaciones;
        }

    public DiaSpa getDiaS() {
        return diaS;
    }
        public void setDiaS(DiaSpa diaS) {
            this.diaS = diaS;
        }

    public boolean isEstado() {
        return estado;
    }
        public void setEstado(boolean estado) {
            this.estado = estado;
        }
    public String mostrarInfo(){
    return'['+"CodSe: "+ codSesion+", fechaInicio:"+ fechaIn+", fechaFin:"+ fechaFin+", tratamiento:"+ tratamiento+", Instalaciones:"+ instalaciones+", Dia_de_Spa: "+diaS+", Estado"+ estado;
    }
    
}
