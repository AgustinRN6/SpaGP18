
package Entidades;


public class Instalacion {
    private int codIns = -1;
    private String nombre;
    private String detallesUso;
    private String usos;
    private String apto;
    private int precio30M;
    private boolean estado;
    
    public Instalacion(String nombre, String detallesUso,String usos, String apto, int precio30M, boolean estado){
        this.nombre = nombre;
        this.detallesUso = detallesUso;
        this.usos= usos;
        this.apto = apto;
        this.precio30M = precio30M;
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
       
    public boolean getEstado(){
        return estado;
    }
        public void setEstado(boolean estado){
            this.estado = estado;
        }

    public String getUsos() {
        return usos;
    }

    public void setUsos(String usos) {
        this.usos = usos;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }
    
    public String mostrarInfo(){
        return'['+"CodigoIns: "+codIns+", NombreIns: "+nombre+", Detalles de uso:"+detallesUso+",Usos: "+usos+", Apto: "+ apto+", Precio por 30 min: "+precio30M+", Estado: "+ estado+']';
    }
}
