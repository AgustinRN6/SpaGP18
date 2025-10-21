
package Entidades;

public class Masajista {
    private int matricula;
    private String nombre;
    private String apellido;
    private long numeroT;
    private String especialidad;
    private boolean estado;
    
    public Masajista(int matricula, String nombre, String apellido, long numeroT, String especialidad, boolean estado){
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getNombre() {
        return nombre;
    }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    public String getApellido() {
        return apellido;
    }
        public void setApellido(String apellido) {
            this.apellido = apellido;
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
    return'['+"Matricula: "+matricula+", Nombre y apellido: "+ nombre+" "+ apellido+", Especialidad: "+ especialidad+", Numero Tel:"+ numeroT+", Estado:"+ estado +']';
    }
    
}
