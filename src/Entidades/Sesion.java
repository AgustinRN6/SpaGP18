
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Sesion {
    private int codSesion =-1;
    private LocalDate fechaIn;
    private LocalDate fechaFin;
    private Tratamiento tratamiento;
    private Masajista masajista;
    private Instalacion instalacion ;
    private DiaSpa diaS;
    private boolean estado;
    
    public Sesion(LocalDate fechaIn, LocalDate fechaFin, Tratamiento tratamiento,Masajista masajista ,Instalacion instalacion,DiaSpa diaS, boolean estado){
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.tratamiento = tratamiento;
        this.masajista = masajista;
        this.instalacion = instalacion;
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

    public Masajista getMasajista() {
        return masajista;
    }

    public void setMasajista(Masajista masajista) {
        this.masajista = masajista;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }
        
    public String mostrarInfo(){
    return'['+"CodSe: "+ codSesion+", fechaInicio:"+ fechaIn+", fechaFin:"+ fechaFin+", tratamiento:"+ tratamiento+", Masajista: "+ masajista+", Instalacion:"+ instalacion+", Dia_de_Spa: "+diaS+", Estado"+ estado;
    }
    
}
