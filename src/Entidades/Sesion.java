
package Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Sesion {
    private int codSesion =-1;
    private LocalDateTime fechaIn;
    private LocalDateTime fechaFin;
    private int tratamiento;
    private int masajista;
    private int instalacion ;
    private int diaS;
    private boolean estado;
    
    public Sesion(LocalDateTime fechaIn, LocalDateTime fechaFin, int tratamiento,int masajista ,int instalacion,int diaS, boolean estado){
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

    public LocalDateTime getFechaIn() {
        return fechaIn;
    }
        public void setFechaIn(LocalDateTime fechaIn) {
            this.fechaIn = fechaIn;
        }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
        public void setFechaFin(LocalDateTime fechaFin) {
            this.fechaFin = fechaFin;
        }

    public int getTratamiento() {
        return tratamiento;
    }
        public void setTratamiento(int tratamiento) {
            this.tratamiento = tratamiento;
        }
        
    public int getDiaS() {
        return diaS;
    }
        public void setDiaS(int diaS) {
            this.diaS = diaS;
        }

    public boolean isEstado() {
        return estado;
    }
        public void setEstado(boolean estado) {
            this.estado = estado;
        }

    public int getMasajista() {
        return masajista;
    }

    public void setMasajista(int masajista) {
        this.masajista = masajista;
    }

    public int getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(int instalacion) {
        this.instalacion = instalacion;
    }
        
    public String mostrarInfo(){
    return'['+"CodSe: "+ codSesion+", fechaInicio:"+ fechaIn+", fechaFin:"+ fechaFin+", tratamiento:"+ tratamiento+", Masajista: "+ masajista+", Instalacion:"+ instalacion+", Dia_de_Spa: "+diaS+", Estado"+ estado;
    }
    
}
