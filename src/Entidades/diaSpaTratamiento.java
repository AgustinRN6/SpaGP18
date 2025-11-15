
package Entidades;

import java.time.LocalTime;

public class diaSpaTratamiento {
    
   private int codTrat;
   private String nombre;
   private String detalle;
   private LocalTime duracion;
   private int costo;
   private String Masajista;
   private LocalTime Inicio;
   private LocalTime fin;

    public diaSpaTratamiento(int codTrat, String nombre, String detalle, LocalTime duracion, int costo, String Masajista, LocalTime Inicio, LocalTime fin) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.duracion = duracion;
        this.costo = costo;
        this.Masajista = Masajista;
        this.Inicio = Inicio;
        this.fin = fin;
    }

    public diaSpaTratamiento() {
    }
    
    

    public int getCodTrat() {
        return codTrat;
    }

    public void setCodTrat(int codTrat) {
        this.codTrat = codTrat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getMasajista() {
        return Masajista;
    }

    public void setMasajista(String Masajista) {
        this.Masajista = Masajista;
    }

    public LocalTime getInicio() {
        return Inicio;
    }

    public void setInicio(LocalTime Inicio) {
        this.Inicio = Inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
    
    
   
   
    
}
