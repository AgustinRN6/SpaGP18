
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DiaSPAData {
    private Connection con = null;
    
    
    public DiaSPAData(){
        this.con = Conexion.getConexion();
    }
    
    //INSERT
    public void crearDiaSpa(DiaSpa d) {
        
        String query = "INSERT INTO dia_de_spa(fechaHora, preferencias, estado, monto, cliente) VALUES (?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setTimestamp(1, Timestamp.valueOf(d.getFechayH()));
            ps.setString(2, d.getPrefencias());
            ps.setBoolean(3, d.isEstado());
            ps.setInt(4, d.getMonto());
            ps.setInt(5, d.getCliente());
            
            if (ps.executeUpdate() > 0) {
                
                JOptionPane.showMessageDialog(null, "Se ha creado el día de spa con éxito!");
                
            }
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                
                d.setCodPack(rs.getInt(1));
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo crearse el dia de spa " + ex.getMessage());
        }
                
    }
    
    
    
    
}
