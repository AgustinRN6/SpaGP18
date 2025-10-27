
package Entidades;

import java.time.LocalDateTime;
import Control.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class prueba {
    public static void main(String[] args){
    //CLASES ENTIDADES.....................................................................................
    DiaSpa diaS1 = new DiaSpa(LocalDateTime.now(),"facial",6, 1500, true);
    DiaSpa diaS2 = new DiaSpa(LocalDateTime.now(),"Corporal",7, 1500, true);
    DiaSpa diaS3 = new DiaSpa(LocalDateTime.now(),"Estetico",8, 1500, true);
    DiaSpa diaS4 = new DiaSpa(LocalDateTime.now(),"Prueba",9, 1500, true);
    
    Masajista ma1 = new Masajista(1111,"Gloria Rosales",255512,"Facial",true);
    Masajista ma2 = new Masajista(3333,"Mario Gonzales",2321312,"Corporal",true);
    Masajista ma3 = new Masajista(4444,"Gustavo Dominguez",26641234,"Estetico",true);
    Masajista ma4 = new Masajista(2232,"Leandro Gutierrez",1231212,"Relajacion",true);
    Masajista ma5 = new Masajista(9999,"Prueba",99999,"Prueba",true);
    
    Cliente c1 = new Cliente("Ian Quimey Pereyra",20, 43330, 2654512,"Alergico  a la crema",true);
    Cliente c2 = new Cliente("Ramiro Elias Moran",23, 410002, 2512313,"Alergico a las piedras",true);
    Cliente c3 = new Cliente("Agustin Rosales Neyra",21, 431230, 26123423,"Alergico al crema",true);
    Cliente c4 = new Cliente("Prueba",99, 0011112, 1231231231,"Alergico a la alergia",true);
    
    
    Instalacion i1 = new Instalacion("Jacuzzi","Entrar en la pileta y relajarse","Solo recreativo","Para todos",1500,true);
    Instalacion i2 = new Instalacion("Piscina Climatizada","Entrar en la piscina y relajarse","Recreativos","Para mayores de edad",1000,true);
    Instalacion i3 = new Instalacion("Sauna","Entrar en la sala y sentarse","Relajacion","Para mayores de edad",1200, true);
    Instalacion i4 = new Instalacion("Zona de Relax ","Espacio tranquilo con sillones","Relajacion","Para todas las edades",1800, true);
    Instalacion i5 = new Instalacion("Sala de Infusiones ","Un area donde se ofrecen bebidas relajantes","Relajacion","Para todas las edades",2000, true);
    Instalacion i6 = new Instalacion("Prueba","Prueba","Prueba","Prueba",2000,true);
    
    
    Tratamiento t1 = new Tratamiento("Tratamiento Facial","Facial basico: exfoliacion y limpieza",LocalTime.of(2, 0, 0),10000,true,"facial");
    Tratamiento t2 = new Tratamiento("Tratamiento Corporal","Hidroterapia: Sesiones en saunas o jacuzzis",LocalTime.of(1, 0, 0),15000,true,"corporal");
    Tratamiento t3 = new Tratamiento("Masaje Especializado","Especialiado: incluye aromaterapia",LocalTime.of(2, 30, 0),10000,true,"especializado");
    Tratamiento t4 = new Tratamiento("Masaje Corporal","Sueco: Terapia de relajacion cuerpo completo",LocalTime.of(2, 0, 0),20000,true,"Corporal");
    Tratamiento t5 = new Tratamiento("Prueba","Prueba",LocalTime.of(1, 0, 0),100000,true,"Prueba");
    
    Sesion s1 = new Sesion(LocalDateTime.of(2025, 9, 9, 5, 0), LocalDateTime.of(2025, 9, 9, 8, 0),1,1111,1,1,true);
    Sesion s2 = new Sesion(LocalDateTime.of(2025, 9, 9, 5, 0), LocalDateTime.of(2025, 9, 9, 8, 0),1,1111,1,1,true);
    Sesion s3 = new Sesion(LocalDateTime.of(2025, 9, 9, 5, 0), LocalDateTime.of(2025, 9, 9, 8, 0),1,1,1111,1,true);
    Sesion s4 = new Sesion(LocalDateTime.of(2025, 9, 9, 5, 0), LocalDateTime.of(2025, 9, 9, 8, 0),1,1,1111,1,true);
    Sesion s5 = new Sesion(LocalDateTime.of(2025, 9, 9, 5, 0), LocalDateTime.of(2025, 9, 9, 8, 0),2,4444,6,3,true);

    //CLASES DATAS.....................................................................................
    ClientesData clientes = new ClientesData();
    DiaSPAData dia= new DiaSPAData();
    InstalacionesData instalaciones = new InstalacionesData();
    MasajistasData masajistas = new MasajistasData();
    SesionData sesiones = new SesionData();
    TratamientosData tratamientos = new TratamientosData();
    //probamos metodos de las clases DATAS(PERSISTENCIA).....................................................................................
    
    //INSERT INTO
    
    
    /*
    dia.crearDiaSpa(diaS1);
    dia.crearDiaSpa(diaS2);
    dia.crearDiaSpa(diaS3);
    dia.crearDiaSpa(diaS4);
    
    clientes.subirCliente(c1);
    clientes.subirCliente(c2);
    clientes.subirCliente(c3);
    clientes.subirCliente(c4);
    
    masajistas.agregarMasajista(ma1);
    masajistas.agregarMasajista(ma2);
    masajistas.agregarMasajista(ma3);
    masajistas.agregarMasajista(ma4);
    masajistas.agregarMasajista(ma5);
    
    instalaciones.cargarInstalacion(i1);
    instalaciones.cargarInstalacion(i2);
    instalaciones.cargarInstalacion(i3);
    instalaciones.cargarInstalacion(i4);
    instalaciones.cargarInstalacion(i5);
    
    
    tratamientos.cargarTratamiento(t1);
    tratamientos.cargarTratamiento(t2);
    tratamientos.cargarTratamiento(t3);
    tratamientos.cargarTratamiento(t4);
    tratamientos.cargarTratamiento(t5);
    */

    //UPDATE
    /*
    Sesion s = sesiones.mostrarSesion(3);
    Tratamiento t = tratamientos.buscarTratamiento(5);
    Masajista m = masajistas.buscarMasajista(999999);
    Instalacion i = instalaciones.buscarInstalacion(1);
    Cliente c = clientes.buscarCliente(4);
  
    Masajista ma6 = new Masajista(5555,"Cambio",12222222,"cambio",true);
    int id2 = m.getMatricula();
    ma6.setMatricula(id2);
    Cliente c5 = new Cliente("Cambio",99,111111,2222222,"cambio",true);
    int id4 = c.getCodCli();
    c1.setCodCli(id4);
    Instalacion i5 = new Instalacion("Cambio","Cambio","Cambio","Cambio",2000,true);
    int id3 = i.getCodIns();
    i1.setCodIns(id3);
    Tratamiento t6 = new Tratamiento("Cambio","Cambio",LocalTime.of(1, 0, 0),100000,true,"Cambio");
    int id1 = t.getCodTrat();
    t5.setCodTrat(id1);
    
    
    clientes.modificarCliente(c1);
    tratamientos.actualizarTratamiento(t5);
    instalaciones.modificarInstalacion(i1);
    masajistas.actualizarMasajista(ma6);
    sesiones.actualizarSesion(s);
    */

    
    //SELECT * FROM tabla WHERE tabla.keyprimary = ? ;
        
        /*
        System.out.println(clientes.buscarCliente(4).getInfo());
        System.out.println(masajistas.buscarMasajistaPorEspecialidad("facial").mostrarInfo());
        System.out.println(masajistas.buscarMasajista(1111).mostrarInfo());
        System.out.println(instalaciones.buscarInstalacion(1).mostrarInfo());
        System.out.println(tratamientos.buscarTratamiento(1).mostrarInfo());
        System.out.println(sesiones.mostrarSesion(1).mostrarInfo());
        */
        
        
    //SELECT * FROM tabla
    /*
        System.out.println("CLIENTES ");
    for(Cliente c: clientes.mostrarClientes()){
        System.out.println(c.getInfo());
    }
        System.out.println(".....................................................................");
        
        System.out.println("MASAJISTAS ");
    for(Masajista m: masajistas.mostrarMasajistas()){
        System.out.println(m.mostrarInfo());
    }
        System.out.println(".....................................................................");
    
        System.out.println("INSTALACIONES ");
    for(Instalacion i : instalaciones.mostrarInstalaciones()){
        System.out.println(i.mostrarInfo());
    }
        System.out.println(".....................................................................");
    
        System.out.println("MASAJISTAS ESPECIALIDAD: FACIAL");
    for(Masajista m: masajistas.mostrarPorEspecialidad("facial")){
        System.out.println(m.mostrarInfo());
    }
        System.out.println(".....................................................................");
    
        System.out.println("TRATAMIENTOS");
    for(Tratamiento t: tratamientos.mostrarTratamientos()){
        System.out.println(t.mostrarInfo());
    }
        System.out.println(".....................................................................");
    
        System.out.println("DiasSpa");
    for(DiaSpa d: dia.cargarTodosDiaSpa()){
        System.out.println(d.mostrarInfo());
    }
        System.out.println(".....................................................................");
        
        System.out.println("Sesiones");
    for(Sesion s: sesiones.mostrarTodasSesiones()){
        System.out.println(s.mostrarInfo());
    }
        System.out.println(".....................................................................");
    */

    }
    
}
