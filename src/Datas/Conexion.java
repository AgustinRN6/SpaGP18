
package Datas;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection con = null;
    

private Conexion(){
    try{
        Class.forName("org.mariadb.jdbc.Driver");
    }catch(java.lang.ClassNotFoundException error){
        JOptionPane.showMessageDialog(null, "Clase no encontrada!!!!");
    }
}
public static Connection getConexion(){
    Conexion conexion = null;
    
    if(con == null){
        
        conexion = new Conexion();
        
        try{ 
            
            con =DriverManager.getConnection("jdbc:mariadb://localhost/gp18_spa_relax", "root", "");
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos!!!");
        }
    }
    return con;
}
    
}
