
package Entidades;

import java.time.LocalTime;
import java.util.Date;

public class Tratamiento {
   private int codTrat = -1;
   private String nombre;
   private String detalle;
   private LocalTime duracion;
   private int costo;
   private boolean estado;
   private String tipo;
   private Masajista masajista;
   
   public Tratamiento( String nombre,String detalle, LocalTime duracion, int costo, boolean estado,String tipo,Masajista masajista){
       this.nombre = nombre;
       this.detalle = detalle;
       this.duracion = duracion;
       this.costo = costo;
       this.estado = estado;
       this.tipo = tipo;
       this.masajista = masajista;
   }
   
   public Tratamiento(){
   
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

        
    public String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public boolean isEstado() {
        return estado;
    }
        public void setEstado(boolean estado) {
            this.estado = estado;
        }

    public Masajista getMasajista(){
        return this.masajista;
    }
    public void setMasajista(Masajista masajista){
        this.masajista = masajista;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
   
    public String mostrarInfo(){
    return'['+"CodTratamiento:"+ codTrat+", Nombre: "+ nombre+", Detalle: "+detalle+", Duracion: "+ duracion+", Costo: "+ costo+", Estado: "+estado+",Tipo: "+ tipo+",Masajista: "+masajista.getNombreCompleto()+']';
    }
   
}
