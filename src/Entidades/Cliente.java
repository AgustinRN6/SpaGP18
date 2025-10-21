
package Entidades;


public class Cliente {
    private int codCli;
    private String nombreC;
    private int edad;
    private String afecciones;
    private int dni;
    private long telefono;
    private boolean estado;
    
    public Cliente(int codCli, String nombreC, int edad, String afecciones, int dni, long telefono, boolean estado){
        this.codCli = codCli;
        this.nombreC = nombreC;
        this.edad = edad;
        this.afecciones = afecciones;
        this.dni = dni;
        this.telefono = telefono;
        this.estado = estado;
    }
    public Cliente(){
    
    }
    
}
