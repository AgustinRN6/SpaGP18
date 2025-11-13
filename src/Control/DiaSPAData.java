
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
        
        String query = "INSERT INTO dia_de_spa(fechaDia, preferencias, estado, monto, cliente) VALUES (?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, Date.valueOf(d.getFecha()));
            ps.setString(2, d.getPrefencias());
            ps.setBoolean(3, d.isEstado());
            ps.setInt(4, d.getMonto());
            ps.setInt(5, d.getCliente().getCodCli());
            
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
        
        String query = "DELETE FROM dia_de_spa WHERE dia_de_spa.codPack = ?";

        try {
            
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, eliminar);
            
            if (ps.executeUpdate() > 0) {
                
                JOptionPane.showMessageDialog(null, "El dia de spa ha sido eliminado!");
                
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo eliminarse el dia de spa " + ex.getMessage());
        }
        
    }
    
    //UPDATE
    public void actualizarDiaSpa(DiaSpa d) {
    
        String query = "UPDATE dia_de_spa SET fechaDia= ? ,preferencias= ? ,monto= ? ,cliente= ? WHERE codPack = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(d.getFecha()));
            ps.setString(2, d.getPrefencias());
            ps.setInt(3, d.getMonto());
            ps.setInt(4, d.getCliente().getCodCli());
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
        
        ClientesData clientes = new ClientesData();
        
        DiaSpa diaSpa = new DiaSpa();
        
        String query = "SELECT * FROM dia_de_spa WHERE dia_de_spa.codPack = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, cargar);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                
                diaSpa.setCodPack(rs.getInt("codPack"));
                diaSpa.setFecha(rs.getDate("fechaDia").toLocalDate());
                diaSpa.setPrefencias(rs.getString("preferencias"));
                diaSpa.setEstado(rs.getBoolean("estado"));
                diaSpa.setMonto(rs.getInt("monto"));
                Cliente c = clientes.buscarCliente(rs.getInt("cliente"));
                diaSpa.setCliente(c);
                
            }
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo cargarse el dia de spa " + ex.getMessage());
        }
        return diaSpa;
        
    }
        
    //SELECT TODOS
    public List<DiaSpa> cargarTodosDiaSpa() {
        
        ClientesData clientes = new ClientesData();
        
        List<DiaSpa> cargarTodos = new ArrayList();
        
        String query = "SELECT * FROM dia_de_spa";
        
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                DiaSpa diaSpa = new DiaSpa();

                diaSpa.setCodPack(rs.getInt("codPack"));
                diaSpa.setFecha(rs.getDate("fechaDia").toLocalDate());
                diaSpa.setPrefencias(rs.getString("preferencias"));
                diaSpa.setEstado(rs.getBoolean("estado"));
                diaSpa.setMonto(rs.getInt("monto"));
                
                Cliente c = clientes.buscarCliente(rs.getInt("cliente"));
                diaSpa.setCliente(c);

                cargarTodos.add(diaSpa);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo cargarse todos los dias de spa " + ex.getMessage());
        }
        
        
        return cargarTodos;
        
    }
    
        public List<DiaSpa> cargarDiasSpaActivos() {
        
        ClientesData clientes = new ClientesData();
            
        List<DiaSpa> cargarTodos = new ArrayList();
        
        String query = "SELECT * FROM dia_de_spa WHERE dia_de_spa.estado = 1";
        
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                DiaSpa diaSpa = new DiaSpa();

                diaSpa.setCodPack(rs.getInt("codPack"));
                diaSpa.setFecha(rs.getDate("fechaDia").toLocalDate());
                diaSpa.setPrefencias(rs.getString("preferencias"));
                diaSpa.setEstado(rs.getBoolean("estado"));
                diaSpa.setMonto(rs.getInt("monto"));
                
                Cliente c = clientes.buscarCliente(rs.getInt("cliente"));
                diaSpa.setCliente(c);
                
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

    
    public void actualizarMonto(DiaSpa d){
        
    String sqlUP="UPDATE dia_de_spa SET monto = ? WHERE codPack = ?";
    
    try{
        PreparedStatement ps = con.prepareStatement(sqlUP);
        ps.setInt(1, d.getMonto());
        ps.setInt(2, d.getCodPack());
    
        if(ps.executeUpdate() > 0){
            System.out.println("se ha actualizado el monto!!!");
        }
    }catch(SQLException ex ){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    
    }
}
