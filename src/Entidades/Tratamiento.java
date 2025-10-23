
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
   
   public Tratamiento( String nombre,String detalle, LocalTime duracion, int costo, boolean estado, String tipo){
       this.nombre = nombre;
       this.detalle = detalle;
       this.duracion = duracion;
       this.costo = costo;
       this.estado = estado;
       this.tipo = tipo;
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

    public boolean isEstado() {
        return estado;
    }
        public void setEstado(boolean estado) {
            this.estado = estado;
        }

    public String getTipo() {
        return tipo;
    }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
   
    public String mostrarInfo(){
    return'['+"CodTratamiento:"+ codTrat+", Nombre: "+ nombre+", Detalle: "+detalle+", Duracion: "+ duracion+", Costo: "+ costo+", Estado: "+estado+", Tipo: "+tipo+']';
    }
   
}
