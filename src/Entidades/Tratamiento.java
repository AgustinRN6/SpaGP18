
package Entidades;

import java.util.Date;


public class Tratamiento {
   private int codTrat;
   private String nombre;
   private Date duracion;
   private int costo;
   private boolean estado;
   private String tipo;
   
   public Tratamiento(int codTrat, String nombre, Date duracion, int costo, boolean estado, String tipo){
       this.codTrat = codTrat;
       this.nombre = nombre;
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

    public Date getDuracion() {
        return duracion;
    }
        public void setDuracion(Date duracion) {
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
   
    public String mostrarInfo(){
    return'['+"CodTratamiento:"+ codTrat+", Nombre: "+ nombre+", Duracion: "+ duracion+", Costo: "+ costo+", Estado: "+estado+", Tipo: "+tipo+']';
    }
   
}
