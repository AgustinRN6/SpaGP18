
package Entidades;


public class Cliente {
    private int codCli =-1;
    private String nombreC;
    private int edad;
    private int dni;
    private int telefono;
    private boolean estado;
    
    public Cliente(String nombreC, int edad, int dni, int telefono , boolean estado){
        this.nombreC = nombreC;
        this.edad = edad;
        this.dni = dni;
        this.telefono = telefono;
        this.estado = estado;
    }
    public Cliente(){
    
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getInfo(){
        return'['+"Cod: "+ codCli+", Nombre completo: "+ nombreC+", Edad: "+edad+", dni: "+ dni+", Numero de telefono:"+ telefono+", estado: "+ estado;
    }
}
