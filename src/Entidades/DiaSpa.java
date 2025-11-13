
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DiaSpa {
   private int codPack = -1;
   private LocalDate fecha;
   private String prefencias;
   private Cliente cliente;
   private int monto;
   private boolean estado;
   
   public DiaSpa(LocalDate fecha, String preferencias, Cliente cliente, int monto, boolean estado){
       this.fecha = fecha;
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

    public LocalDate getFecha() {
        return fecha;
    }
        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

    public String getPrefencias() {
        return prefencias;
    }

    public void setPrefencias(String prefencias) {
        this.prefencias = prefencias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
    return'['+"CodPack: "+ codPack+", Cliente:"+cliente.getNombreC()+", Fecha: "+ fecha+", Monto: "+ monto+", Estado: "+ estado+']';
    }
}
