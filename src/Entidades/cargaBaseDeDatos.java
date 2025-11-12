package Entidades;
import Control.*;

import java.sql.Connection;
import java.time.LocalTime;

public class cargaBaseDeDatos {
    
    public static void main(String[] args) {
                     
        
    /*PRECAUCION , LA SIGUIENTE FUNCION LIMPIA TODAS LAS TABLAS DE LA BASE DE DATOS USARLA CON PRECAUCIÓN */
     
    /*
        Utilitario update = new Utilitario();
        update.limpiarTodasLasTablas();
    */    

        /*
        Se realizará la carga de toda la información del TP, tratamientos e instalaciones 
        */
        
        /*
Instalaciones de agua  
• Jacuzzi o hidromasaje: Bañeras con chorros de agua a presión para relajar los músculos y aliviar la tensión. 
• Piscina climatizada: Piscinas con agua a temperatura agradable, a veces equipadas con camas de burbujas. 
• Baño turco o Sauna: Habitaciones con vapor de agua caliente que ayudan a purificar y limpiar la piel en profundidad. 
• Duchas de sensaciones: Combina diferentes temperaturas, presiones y aromas para estimular los sentidos. 
• Pediluvio: Baño de pies que generalmente combina agua fría y caliente para mejorar la circulación de las piernas. 
• Circuito de hidroterapia: Secuencia de 3 bañeras de agua con diferentes temperaturas para estimular la circulación.  
Áreas de relajación 
• Zona de relax: Espacio tranquilo con tumbonas o sillones para descansar antes y después de los tratamientos. 
• Sala de té o infusiones: Un área donde se ofrecen bebidas relajantes para complementar la experiencia.
        */
    
    /**/
        
    Instalacion i1 = new Instalacion("Jacuzzi","Bañeras con chorros de agua a presión para relajar los músculos y aliviar la tensión.","Solo recreativo","Para todos",1500,true);
    Instalacion i2 = new Instalacion("Piscina Climatizada","Piscinas con agua a temperatura agradable, a veces equipadas con camas de burbujas. ","Recreativos","Para mayores de edad",1000,true);
    Instalacion i3 = new Instalacion("Sauna","Habitaciones con vapor de agua caliente que ayudan a purificar y limpiar la piel en profundidad.","Relajacion","Para mayores de edad",1200, true);
    Instalacion i4 = new Instalacion("Zona de Relax ","Espacio tranquilo con tumbonas o sillones para descansar antes y después de los tratamientos. ","Relajacion","Para todas las edades",1800, true);
    Instalacion i5 = new Instalacion("Sala de Infusiones ","Un área donde se ofrecen bebidas relajantes para complementar la experiencia.","Relajacion","Para todas las edades",2000, true);
    Instalacion i6 = new Instalacion("Maquinas Gym","Sala con todas las máquinas necesarias para los distintos tipos de ejercicios","Ejercitación","Entre 20 a 50 años",3000, true);
    Instalacion i7 = new Instalacion("Baño Turco","Habitaciones con vapor de agua caliente que ayudan a purificar y limpiar la piel en profundidad. Área cerrada","Relajación","todas las edades",5000, true);
    Instalacion i8 = new Instalacion("Ducha","Combina diferentes temperaturas, presiones y aromas para estimular los sentidos. ","Relajación","todas las edades",1000, true);
    Instalacion i9 = new Instalacion("Circuito de hidroterapia","Secuencia de 3 bañeras de agua con diferentes temperaturas para estimular la circulación.  ","Relajación","todas las edades",3000, true);
    Instalacion i10 = new Instalacion("Pediluvio","Baño de pies que generalmente combina agua fría y caliente para mejorar la circulación de las piernas.","Relajación","todas las edades",1500, true);
    
    /**/
    
      /**/
    /*masajistas prefabricados*/
    /**/
    
    Masajista ma1 = new Masajista(1111,"Gloria Rosales",255512,"Facial",true);
    Masajista ma2 = new Masajista(3333,"Mario Gonzales",2321312,"Corporal",true);
    Masajista ma3 = new Masajista(4444,"Gustavo Dominguez",26641234,"Estetico",true);
    Masajista ma4 = new Masajista(2232,"Leandro Gutierrez",1231212,"Relajacion",true);
    Masajista ma5 = new Masajista(9999,"Gustavo Alfange",1231212,"Especializado",true);
    /**/
    /* 
    Masajes 
• Masaje sueco: Terapia de relajación de cuerpo completo con presión ligera a media. 
• Masaje de tejido profundo: Para aliviar tensión muscular crónica y tratar contracturas, con presión más intensa. 
• Masaje con piedras calientes: Utiliza piedras calientes para calmar los músculos y el sistema nervioso. 
• Masajes especializados: Incluyen técnicas como la aromaterapia, masajes para parejas o masajes prenatales.  
Tratamientos faciales 
• Facial básico: Limpieza profunda, exfoliación y mascarilla para refrescar el cutis. 
• Faciales avanzados: Pueden incluir tratamientos antienvejecimiento, microdermoabrasión o hidrafaciales.  
• Microdermoabrasión: Exfolia la capa superficial de la piel usando puntas de diamante o microcristales. 
• Radiofrecuencia: Usa ondas de radio para generar calor en la piel, estimulando la producción de colágeno y elastina. 
• Ultrasonido: Usa ondas sonoras de alta frecuencia para limpiar la piel, penetrar activos o hacer masajes profundos. 
• Luz Pulsada Intensa (IPL): Utilizada para fotodepilación, rejuvenecimiento de la piel y tratamiento de manchas. 
• Vaporizador facial: Produce vapor para abrir los poros y limpiar la piel profundamente. 
Tratamientos corporales 
• Exfoliación corporal: Elimina las células muertas de la piel con el uso de sales o azúcares. 
• Envolturas corporales: Hidratan y desintoxican la piel con ingredientes como algas, barro o chocolate. 
• Hidroterapia: Sesiones en saunas, jacuzzis o baños de vapor.  
• Vacumterapia: Es una succión corporal que mejora la circulación sanguínea y el drenaje linfático. 
    */
    
    /**/
    
    Tratamiento t1 = new Tratamiento("Masaje sueco","Terapia de relajación de cuerpo completo con presión ligera a media.",LocalTime.of(1, 30),2000,true,ma4);
    Tratamiento t2 = new Tratamiento("Masaje de tejido profundo","Para aliviar tensión muscular crónica y tratar contracturas, con presión más intensa.",LocalTime.of(2, 0),2500,true,ma4);
    Tratamiento t3 = new Tratamiento("Masaje con piedras calientes","Utiliza piedras calientes para calmar los músculos y el sistema nervioso.",LocalTime.of(1, 0),1500,true,ma4); 
    Tratamiento t4 = new Tratamiento("Masajes especializados","Incluyen técnicas como la aromaterapia, masajes para parejas o masajes prenatales.",LocalTime.of(2, 30),4000,true,ma5); 
    Tratamiento t5 = new Tratamiento("Facial básico","Limpieza profunda, exfoliación y mascarilla para refrescar el cutis.",LocalTime.of(1, 0),4000,true,ma1);
    Tratamiento t6 = new Tratamiento("Faciales avanzados","Pueden incluir tratamientos antienvejecimiento, microdermoabrasión o hidrafaciales.",LocalTime.of(2, 0),2000,true,ma1);
    Tratamiento t7 = new Tratamiento("Microdermoabrasión","Exfolia la capa superficial de la piel usando puntas de diamante o microcristales.",LocalTime.of(1, 30),2500,true,ma1);
    Tratamiento t8 = new Tratamiento("Radiofrecuencia","Usa ondas de radio para generar calor en la piel, estimulando la producción de colágeno y elastina.",LocalTime.of(0,30),3000,true,ma1);
    Tratamiento t9 = new Tratamiento("Ultrasonido","Usa ondas sonoras de alta frecuencia para limpiar la piel, penetrar activos o hacer masajes profundos.",LocalTime.of(1,0),3500,true,ma1);
    Tratamiento t10 = new Tratamiento("Luz Pulsada Intensa (IPL)","Utilizada para fotodepilación, rejuvenecimiento de la piel y tratamiento de manchas.",LocalTime.of(0,30),4000,true,ma1);
    Tratamiento t11 = new Tratamiento("Vaporizador facial","Produce vapor para abrir los poros y limpiar la piel profundamente.",LocalTime.of(1,0),2000,true,ma4);
    Tratamiento t12 = new Tratamiento("Exfoliación corporal","Elimina las células muertas de la piel con el uso de sales o azúcares.",LocalTime.of(1,30),2500,true,ma4);
    Tratamiento t13 = new Tratamiento("Envolturas corporales","Hidratan y desintoxican la piel con ingredientes como algas, barro o chocolate.",LocalTime.of(2,30),3500,true,ma4);
    Tratamiento t14 = new Tratamiento("Hidroterapia","Sesiones en saunas, jacuzzis o baños de vapor.",LocalTime.of(1,30),2000,true,ma4);
    Tratamiento t15 = new Tratamiento("Vacumterapia","Es una succión corporal que mejora la circulación sanguínea y el drenaje linfático.",LocalTime.of(2,0),3500,true,ma4);
    
    
    /**/
    
    /*
    Clientes prefabricados
    */
    
    /**/
    
    Cliente c1 = new Cliente("Ian Quimey Pereyra",20, 43330, 2654512,true);
    Cliente c2 = new Cliente("Ramiro Elias Moran",23, 410002, 2512313,true);
    Cliente c3 = new Cliente("Agustin Rosales Neyra",21, 431230, 26123423,true);
    Cliente c4 = new Cliente("Prueba",99, 0011112, 1231231231,true);
    

    
    /*DATAS*/
    
    /**/
    
    InstalacionesData instalaciones = new InstalacionesData();
    TratamientosData tratamientos = new TratamientosData();
    ClientesData clientes = new ClientesData();
    MasajistasData masajistas = new MasajistasData();
    
    /**/
    
    /*RELLENAR BASE*/
    
    /*
    
    instalaciones.cargarInstalacion(i1);
    instalaciones.cargarInstalacion(i2);
    instalaciones.cargarInstalacion(i3);
    instalaciones.cargarInstalacion(i4);
    instalaciones.cargarInstalacion(i5);
    instalaciones.cargarInstalacion(i6);
    instalaciones.cargarInstalacion(i7);
    instalaciones.cargarInstalacion(i8);
    instalaciones.cargarInstalacion(i9);
    instalaciones.cargarInstalacion(i10);
    
    tratamientos.cargarTratamiento(t1);
    tratamientos.cargarTratamiento(t2);
    tratamientos.cargarTratamiento(t3);
    tratamientos.cargarTratamiento(t4);
    tratamientos.cargarTratamiento(t5);
    tratamientos.cargarTratamiento(t6);
    tratamientos.cargarTratamiento(t7);
    tratamientos.cargarTratamiento(t8);
    tratamientos.cargarTratamiento(t9);
    tratamientos.cargarTratamiento(t10);
    tratamientos.cargarTratamiento(t11);
    tratamientos.cargarTratamiento(t12);
    tratamientos.cargarTratamiento(t13);
    tratamientos.cargarTratamiento(t14);
    tratamientos.cargarTratamiento(t15);
    
    clientes.subirCliente(c1);
    clientes.subirCliente(c2);
    clientes.subirCliente(c3);
    clientes.subirCliente(c4);
    
    masajistas.agregarMasajista(ma1);
    masajistas.agregarMasajista(ma2);
    masajistas.agregarMasajista(ma3);
    masajistas.agregarMasajista(ma4);
    
    */
    
    
    }
    
}
