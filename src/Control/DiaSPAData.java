
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    
    //DELETE
    public void borrarDiaSpa(int eliminar) {
        
        String query = "DELETE FROM dia_de_spa WHERE codPack = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(0, eliminar);
            
            if (ps.executeUpdate() > 0) {
                
                JOptionPane.showMessageDialog(null, "El dia de spa ha sido eliminado!");
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo eliminarse el dia de spa " + ex.getMessage());
        }
        
    }
    
    //UPDATE
    public void actualizarDiaSpa(DiaSpa d) {
        
        String query = "UPDATE dia_de_spa SET fechaHora= ? ,preferencias= ? ,monto= ? ,cliente= ? WHERE codPack = ?";
        
        try {

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, Timestamp.valueOf(d.getFechayH()));
            ps.setString(2, d.getPrefencias());
            ps.setInt(3, d.getMonto());
            ps.setInt(4, d.getCliente());
            ps.setInt(5, d.getCodPack());

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha actualizado el día de spa con éxito!");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo actualizarse el dia de spa " + ex.getMessage());
        }
        
    }
    
    //SELECT 1
    public DiaSpa cargarDiaSpa(int cargar) {
        
        DiaSpa diaSpa = new DiaSpa();
        
        String query = "SELECT * FROM dia_de_spa WHERE codPack = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(0, cargar);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                diaSpa.setCodPack(rs.getInt("codPack"));
                diaSpa.setFechayH(rs.getTimestamp("FechaHora").toLocalDateTime());
                diaSpa.setPrefencias(rs.getString("preferencias"));
                diaSpa.setEstado(rs.getBoolean("estado"));
                diaSpa.setMonto(rs.getInt("monto"));
                diaSpa.setCliente(rs.getInt("cliente"));
            }
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo cargarse el dia de spa " + ex.getMessage());
        }
        return diaSpa;
        
    }
        
    //SELECT TODOS
    public List<DiaSpa> cargarTodosDiaSpa() {
        
        List<DiaSpa> cargarTodos = new ArrayList();
        
        String query = "SELECT * FROM dia_de_spa";
        
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                DiaSpa diaSpa = new DiaSpa();

                diaSpa.setCodPack(rs.getInt("codPack"));
                diaSpa.setFechayH(rs.getTimestamp("FechaHora").toLocalDateTime());
                diaSpa.setPrefencias(rs.getString("preferencias"));
                diaSpa.setEstado(rs.getBoolean("estado"));
                diaSpa.setMonto(rs.getInt("monto"));
                diaSpa.setCliente(rs.getInt("cliente"));
                
                cargarTodos.add(diaSpa);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo cargarse todos los dias de spa " + ex.getMessage());
        }
        
        
        return cargarTodos;
        
    }
    
    //UPDATE alta lógica
    public void altaLogicaDiaSpa(DiaSpa alta) {
        
        String query = "UPDATE dia_de_spa SET estado= 1 WHERE codPack = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, alta.getCodPack());

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha dado de alta el día de spa con éxito!");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo darse de alta el dia de spa " + ex.getMessage());
        }
        
    }
    
    //UPDATE baja lógica
    public void bajaLogicaDiaSpa(DiaSpa baja) {

        String query = "UPDATE dia_de_spa SET estado= 0 WHERE codPack = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, baja.getCodPack());

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha dado de baja el día de spa con éxito!");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo darse de baja el dia de spa " + ex.getMessage());
        }

    }
    
    
    
    
}
