
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DiaSpa {
   private int codPack;
   private LocalDate fechayH;
   private List<Sesion> sesiones = new ArrayList();
   private int monto;
   private boolean estado;
   
   public DiaSpa(int codPack, LocalDate fechayH, int monto, boolean estado){
       this.codPack = codPack;
       this.fechayH = fechayH;
       this.monto = monto;
       this.estado = estado;
   }
   
   public DiaSpa(){
   
   }

    public int getCodPack() {
        return codPack;
    }
        public void setCodPack(int codPack) {
            this.codPack = codPack;
        }

    public LocalDate getFechayH() {
        return fechayH;
    }
        public void setFechayH(LocalDate fechayH) {
            this.fechayH = fechayH;
        }

    public List<Sesion> getSesiones() {
        return sesiones;
    }
        public void setSesiones(List<Sesion> sesiones) {
            this.sesiones = sesiones;
        }

    public int getMonto() {
        return monto;
    }
        public void setMonto(int monto) {
            this.monto = monto;
        }

    public boolean isEstado() {
        return estado;
    }
        public void setEstado(boolean estado) {
            this.estado = estado;
        }
   
    public String mostrarInfo(){
    return'['+"CodPack: "+ codPack+", Fecha y Hora: "+ fechayH+", Sesiones: "+ sesiones+", Monto: "+ monto+", Estado: "+ estado+']';
    }
}
