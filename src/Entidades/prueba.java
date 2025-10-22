
package Entidades;

import java.time.LocalDate;
import Control.*;

public class prueba {
    public static void main(String[] args){
    //CLASES ENTIDADES.....................................................................................
    DiaSpa diaS = new DiaSpa(LocalDate.of(25, 12, 1),1500, true);
    
    Masajista ma1 = new Masajista(0111,"Gloria Rosales",255512,"Facial",true);
    Masajista ma2 = new Masajista(03722,"Mario Gonzales",2321312,"Corporal",true);
    Masajista ma3 = new Masajista(034321,"Gustavo Dominguez",26641234,"Estetico",true);
    Masajista ma4 = new Masajista(02231,"Leandro Gutierrez",1231212,"Relajacion",true);
    
    Cliente c1 = new Cliente("Ian Quimey Pereyra",20, 43330, 2654512,"Alergico  a la crema",true);
    Cliente c2 = new Cliente("Ramiro Elias Moran",23, 410002, 2512313,"Alergico a las piedras",true);
    Cliente c3 = new Cliente("Agustin Rosales Neyra",21, 431230, 26123423,"Alergico al crema",true);
    Cliente c4 = new Cliente("Prueba",99, 0011112, 1231231231,"Alergico a la alergia",true);
    
    Instalacion i1 = new Instalacion("Jacuzzi","Entrar en la pileta y relajarse","Solo recreativo","Para todos",1500,true);
    Instalacion i2 = new Instalacion("Piscina Climatizada","Entrar en la piscina y relajarse","Recreativos","Para mayores de edad",1000,true);
    Instalacion i3 = new Instalacion("Sauna","Entrar en la sala y sentarse","Relajacion","Para mayores de edad",1200, true);
    Instalacion i4 = new Instalacion();
    //CLASES DATAS.....................................................................................
    
    ClientesData clientes = new ClientesData();
    DiaSPAData dia= new DiaSPAData();
    InstalacionesData instalaciones = new InstalacionesData();
    MasajistasData masajistas = new MasajistasData();
    SesionData sesiones = new SesionData();
  
    
    
    //probamos metodos de las clases DATAS(PERSISTENCIA).....................................................................................
    /*clientes.subirCliente(c1);
    
    clientes.borrarCliente(1);
    clientes.darDeAlta(2);
    clientes.darDeBaja(2);
    System.out.println(clientes.buscarCliente(2).getInfo());
    
        System.out.println("CLIENTES ");
    for(Cliente c: clientes.mostrarClientes()){
        System.out.println(c.getInfo());
    }
        System.out.println(".....................................................................");
         
    */
    
    }
    
}
