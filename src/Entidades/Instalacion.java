
package Entidades;


public class Instalacion {
    private int codIns;
    private String nombre;
    private String detallesUso;
    private int precio30M;
    private Sesion sesion;
    private boolean estado;
    
    public Instalacion(int codIns, String nombre, String detallesUso, int precio30M, Sesion sesion, boolean estado){
        this.codIns = codIns;
        this.nombre = nombre;
        this.detallesUso = detallesUso;
        this.precio30M = precio30M;
        this.sesion = sesion;
        this.estado = estado;
    }
    public Instalacion(){
    
    }

    public int getCodIns() {
        return codIns;
    }
        public void setCodIns(int codIns) {
            this.codIns = codIns;
        }

    public String getNombre() {
        return nombre;
    }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    public String getDetallesUso() {
        return detallesUso;
    }
        public void setDetallesUso(String detallesUso) {
            this.detallesUso = detallesUso;
        }

    public int getPrecio30M() {
        return precio30M;
    }
        public void setPrecio30M(int precio30M) {
            this.precio30M = precio30M;
        }

    public Sesion getSesion() {
        return sesion;
    }
        public void setSesion(Sesion sesion) {
            this.sesion = sesion;
        }
        
    public boolean getEstado(){
        return estado;
    }
        public void setEstado(boolean estado){
            this.estado = estado;
        }
    
    public String mostrarInfo(){
        return'['+"CodigoIns: "+codIns+", NombreIns: "+nombre+", Detalles de uso:"+detallesUso+", Precio por 30 min: "+precio30M+", Sesion asiganada: "+sesion+", Estado: "+ estado+']';
    }
}
