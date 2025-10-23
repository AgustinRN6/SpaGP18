
package Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DiaSpa {
   private int codPack = -1;
   private LocalDateTime fechayH;
   private String prefencias;
   private int cliente;
   private List<Sesion> sesiones = new ArrayList();
   private int monto;
   private boolean estado;
   
   public DiaSpa(LocalDateTime fechayH, String preferencias, int cliente, int monto, boolean estado){
       this.fechayH = fechayH;
       this.prefencias = preferencias;
       this.cliente = cliente;
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

    public LocalDateTime getFechayH() {
        return fechayH;
    }
        public void setFechayH(LocalDateTime fechayH) {
            this.fechayH = fechayH;
        }

    public List<Sesion> getSesiones() {
        return sesiones;
    }
        public void setSesiones(List<Sesion> sesiones) {
            this.sesiones = sesiones;
        }

    public String getPrefencias() {
        return prefencias;
    }

    public void setPrefencias(String prefencias) {
        this.prefencias = prefencias;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
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
