
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DiaSPAData {
    private Connection con = null;
    
    
    public DiaSPAData(){
        this.con = Conexion.getConexion();
    }
    
    
}
