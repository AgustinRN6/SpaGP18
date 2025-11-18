
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MasajistasData {
    private Connection con = null;
    
    public MasajistasData(){
        this.con = Conexion.getConexion();
    }
    
    public void agregarMasajista(Masajista m){
        
        String sqlUP="INSERT INTO masajista(matricula, nombreApellido, telefono, especialidad,estado) VALUES(?,?,?,?,?)";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, m.getMatricula());
            ps.setString(2, m.getNombreCompleto());
            ps.setInt(3, m.getNumeroT());
            ps.setString(4, m.getEspecialidad());
            ps.setBoolean(5, m.isEstado()); 
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Masajista Agregado!!!!");
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public void borrarMasajista(int matricula){
        
        String sqlDL="DELETE FROM masajista WHERE masajista.matricula = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlDL);
            ps.setInt(1, matricula);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Masajista Eliminado!!!!");
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public void actualizarMasajista(Masajista m){
        
        String sqlUP="UPDATE masajista SET matricula = ? , nombreApellido = ? , telefono = ? , especialidad = ? , estado = ? WHERE masajista.matricula = ?";
       
        try{
            
           PreparedStatement ps = con.prepareStatement(sqlUP);
           ps.setInt(1, m.getMatricula());
           ps.setString(2, m.getNombreCompleto());
           ps.setInt(3, m.getNumeroT());
           ps.setString(4, m.getEspecialidad());
           ps.setBoolean(5, m.isEstado());
           ps.setInt(6, m.getMatricula());
           
           if(ps.executeUpdate() > 0){
               JOptionPane.showMessageDialog(null, "Masajista actualizada");
           }else{
               JOptionPane.showMessageDialog(null, "No se pudo encontrar el masajistas(coloque bien la matricula)");
           }
           
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public Masajista buscarMasajista(int matricula){
        
        Masajista m = new Masajista();
        String sqlSL="SELECT * FROM masajista WHERE masajista.matricula = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreCompleto(rs.getString("nombreApellido"));
                m.setNumeroT(rs.getInt("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
                
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return m;
        
    }
    
        public Masajista buscarMasajistaPorEspecialidad(String especialidad){
            
        Masajista m = new Masajista();
        String sqlSL="SELECT * FROM masajista WHERE masajista.especialidad LIKE '%"+especialidad+"%' ";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreCompleto(rs.getString("nombreApellido"));
                m.setNumeroT(rs.getInt("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));

            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return m;
                
    }
        
    public List<Masajista> mostrarMasajistas(){
        
        List<Masajista> masajistas = new ArrayList();
        String sqlSL="SELECT * FROM masajista";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Masajista m = new Masajista();
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreCompleto(rs.getString("nombreApellido"));
                m.setNumeroT(rs.getInt("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
                masajistas.add(m);
                
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return masajistas;
        
    }
    
    public List<Masajista> mostrarMasajistasDisponibles(){
        
        List<Masajista> masajistas = new ArrayList();
        String sqlSL="SELECT * FROM masajista WHERE masajista.estado = 1";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Masajista m = new Masajista();
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreCompleto(rs.getString("nombreApellido"));
                m.setNumeroT(rs.getInt("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
                masajistas.add(m);
                
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return masajistas;
        
    }

    public List<Masajista> mostrarPorEspecialidad(String especialidad){
        
        List<Masajista> masajistas = new ArrayList();
        String sqlSL="SELECT * FROM masajista WHERE masajista.especialidad LIKE '%"+especialidad+"%' AND masajista.estado = 1";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Masajista m = new Masajista();
                m.setMatricula(rs.getInt("matricula"));
                m.setNombreCompleto(rs.getString("nombreApellido"));
                m.setNumeroT(rs.getInt("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
                masajistas.add(m);
                
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return masajistas;
        
    }
    
    public void darDeAlta(int matricula){
        
        String sqlUP="UPDATE masajista SET estado = 1 WHERE masajista.matricula = ? ";
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sqlUP);
        ps.setInt(1, matricula);
        
        if(ps.executeUpdate() > 0){
            JOptionPane.showMessageDialog(null, "Masajista dado de alta!!!!");
        }
        
        }catch(java.sql.SQLException error){
        JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public void darDeBaja(int matricula){
        
        String sqlUP="UPDATE masajista SET estado = 0 WHERE masajista.matricula = ? ";
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sqlUP);
        ps.setInt(1, matricula);
        
        if(ps.executeUpdate() > 0){
            JOptionPane.showMessageDialog(null, "Masajista dado de baja!!!!");
        }
        
        }catch(java.sql.SQLException error){
        JOptionPane.showMessageDialog(null, error.getMessage());
        }
    
    } 
    
    public boolean buscarMasajistaEnFechaHorario(LocalTime horarioI, LocalTime horarioF, LocalDate fecha, int masajista, int tratamiento) {
        
        boolean hd = false;
        boolean md = false;
        boolean td = false;
        TratamientosData tratamientos = new TratamientosData();
        String query = 
        "SELECT count(*)\n" +
        "FROM sesion s \n" +
        "JOIN tratamiento t ON s.tratamiento = t.codTratam\n" +
        "WHERE t.masajista = ? "+
        "AND date(s.fechaHoraInicio) = date(?) AND\n" +
        "(time(?) < TIME(s.fechaHoraFin) AND time(?) > TIME(s.fechaHoraInicio))\n" +
        ";";
        //time(s.fechaHoraInicio) <= time(?) AND time(s.fechaHoraFin) >= time(?)
        try {
            
            PreparedStatement ps = con.prepareStatement(query);
            //Se utiliza para consultar por fecha brindada por parametro
            ps.setInt(1, masajista);
            ps.setString(2, fecha.toString());
            ps.setString(3, horarioI.toString());
            ps.setString(4, horarioF.toString());
            
            
            ResultSet resultado = ps.executeQuery();
            
                if (resultado.next()) { 
                if (resultado.getInt(1) == 0) {
                    hd = true;
                } else {
                }
                
                if (buscarMasajista(masajista).isEstado()) {
                    md = true;
                } else {
                    md = false;
                }
                
                if (tratamientos.buscarTratamiento(tratamiento).isEstado()) {
                    td = true;
                } else {
                    td = false;
                }
                
            }
            
            
        } catch(java.sql.SQLException error) {
        JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return md && hd && td;
        
        
    }
    
}
