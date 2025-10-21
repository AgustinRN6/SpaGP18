
package Entidades;

public class Masajista {
    private int matricula;
    private String nombreApellido;
    private long numeroT;
    private String especialidad;
    private boolean estado;
    
    public Masajista(int matricula, String nombreApellido, long numeroT, String especialidad, boolean estado){
        this.matricula = matricula;
        this.nombreApellido = nombreApellido;
        this.numeroT = numeroT;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    public Masajista(){
        
    }

    public int getMatricula() {
        return matricula;
    }
        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }

    public String getNombreCompleto() {
        return nombreApellido;
    }
        public void setNombreCompleto(String nombreApellido) {
            this.nombreApellido = nombreApellido;
        }
        
    public long getNumeroT() {
        return numeroT;
    }
        public void setNumeroT(long numeroT) {
            this.numeroT = numeroT;
        }

    public String getEspecialidad() {
        return especialidad;
    }
        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

    public boolean isEstado() {
        return estado;
    }
        public void setEstado(boolean estado) {
            this.estado = estado;
        }
    
    public String mostrarInfo(){
    return'['+"Matricula: "+matricula+", Nombre y apellido: "+ nombreApellido +", Especialidad: "+ especialidad+", Numero Tel:"+ numeroT+", Estado:"+ estado +']';
    }
    
}
