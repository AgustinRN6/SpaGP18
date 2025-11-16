
package Control;

import Entidades.Masajista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Utilitario {

    private Connection con = null;
    
    public Utilitario() {
        this.con = Conexion.getConexion();
    }
    
    //Para limpiar todas las tablas
    public void limpiarTodasLasTablas() {
        
        try{
            PreparedStatement ps = con.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM sesion");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM dia_de_spa");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM instalacion");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM masajista");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM tratamiento");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM cliente");
            ps.executeUpdate();
            ps = con.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");
            ps.executeUpdate();
            
            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se pudo realizar el update correspondiente!");

            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, "Error update: "+error.getMessage());
        }
        
    }
    
    
    
    //Se utilizará para comparar dos valores numericos
    public static boolean compararValores(int busqueda, int buscado) {

        String busquedaS = Integer.toString(busqueda);
        String buscadoS = Integer.toString(buscado);
        int contador = 0;
        if (busqueda < 0) {
            return true;
        } else {
            try {

                for (int i = 0; i < busquedaS.length(); i++) {

                    if (buscadoS.charAt(i) == busquedaS.charAt(i)) {
                        contador++;
                    }
                }

                if (contador == busquedaS.length()) {

                    return true;

                } else {

                    return false;

                }

            } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
                return false;
            }

        }

    }

    //Se utilizará para comparar dos valores de texto
    public static boolean compararValores(String busqueda, String buscado) {

        String busquedaS = busqueda;
        String buscadoS = buscado;
        int contador = 0;

        try {

            for (int i = 0; i < busquedaS.length(); i++) {

                if (buscadoS.charAt(i) == busquedaS.charAt(i) || Character.toUpperCase(busquedaS.charAt(i)) == buscadoS.charAt(i)) {
                    contador++;
                }
            }

            if (contador == busquedaS.length()) {

                return true;

            } else {

                return false;

            }

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            return false;
        }

    }
    
    //Limpia la tabla
    public static void limpiarTabla(DefaultTableModel modeloTabla) {

        int f = modeloTabla.getRowCount() - 1; //total de filas (-1 para recorrer for)
        for (int i = f; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }
    
    //Se crea un string en base al estado del objeto, para mostrarlo en la tabla
    public static String estadoParaTabla(boolean estado) {

        if (estado) {
            return "activo";
        } else {
            return "inactivo";
        }
    }
    
    public static Date deLDaD(LocalDate ld) {
        
        Date d = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        return d;
        
    }
    
}
