
package Entidades;

import java.time.LocalDate;
import Control.*;
import Entidades.*;
public class prueba {
    public static void main(String[] args){
    //CLASES ENTIDADES.....................................................................................
    DiaSpa diaS = new DiaSpa(LocalDate.of(25, 12, 1),1500, true);
    Masajista ma1 = new Masajista(0111,"Gloria Rosales",255512,"Masaje con piedras",true);
    Cliente c1 = new Cliente("Pepe Artesano",20, 43330, 25544123,"Alergico",true);
    
    
    //CLASES DATAS.....................................................................................
    ClientesData clientes = new ClientesData();
    
   
    //probamos metodos de las clases DATAS(PERSISTENCIA):
    /*clientes.subirCliente(c1);
    clientes.borrarCliente(1);
    */
        System.out.println("CLIENTES ");
    for(Cliente c: clientes.mostrarClientes()){
        System.out.println(c.getInfo());
    }
        System.out.println(".....................................................................");
    }
}
