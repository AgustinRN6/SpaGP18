
package Entidades;


public class Consultorio {
    private int nroConsultorio = -1;
    private int usos;
    private String  equipamiento;
    private String apto;
    
    public Consultorio(int usos, String equipamiento, String apto){
        this.usos = usos;
        this.equipamiento = equipamiento;
        this.apto = apto;
    }
    public Consultorio(){
    
    }

    public int getNroConsultorio() {
        return nroConsultorio;
    }

    public void setNroConsultorio(int nroConsultorio) {
        this.nroConsultorio = nroConsultorio;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }
    
    public String getInfo(){
        return '['+"nroC: "+nroConsultorio+", Usos: "+ usos+", Equipamiento: "+ equipamiento+", Apto: "+ apto+']';
    }


}
