
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

public class InstalacionesData {
    private Connection con = null;
    
    public InstalacionesData(){
        this.con = Conexion.getConexion();
    }
    
    public void cargarInstalacion(Instalacion i){
        try{
         String sqlUP="INSERT INTO instalacion(nombre, detalleDeUso, precio30M, estado,usos, apto) VALUES(?,?,?,?,?,?)";
         PreparedStatement ps = con.prepareStatement(sqlUP, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, i.getNombre());
            ps.setString(2, i.getDetallesUso());
            ps.setInt(3, i.getPrecio30M());
            ps.setBoolean(4, i.getEstado());
            ps.setString(5, i.getUsos());
            ps.setString(6, i.getApto());

            if(ps.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Instalacion agregada!!!!");
            }
            
            ResultSet rs= ps.getGeneratedKeys();
            while(rs.next()){
            i.setCodIns(rs.getInt(1));
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    public void borrarInstalacion(int id){
        try{
            String sqlDL="DELETE FROM instalacion WHERE instalacion.codInstal = ?";
            PreparedStatement ps = con.prepareStatement(sqlDL);
            ps.setInt(1, id);
            
            if(ps.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Instalacion eliminada!!!!");
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void modificarInstalacion(Instalacion i){
        try{
            String sqlUP="UPDATE instalacion SET nombre = ?, detalleDeUso = ?, precio30M = ?, estado = ?,usos = ?, apto = ? WHERE instalacion.codInstal = ?";
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setString(1, i.getNombre());
            ps.setString(2, i.getDetallesUso());
            ps.setInt(3, i.getPrecio30M());
            ps.setBoolean(4, i.getEstado());
            ps.setString(5, i.getUsos());
            ps.setString(6, i.getApto());
            ps.setInt(7, i.getCodIns());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Instalacion modificada!!!!");
            }

        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public Instalacion buscarInstalacion(int codInstal){
            Instalacion i = new Instalacion();
            String sqlSL="Select * FROM instalacion WHERE instalacion.codInstal = ?";
            try{
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ps.setInt(1, codInstal);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                
                i.setCodIns(resultado.getInt("codInstal"));
                i.setNombre(resultado.getString("nombre"));
                i.setDetallesUso(resultado.getString("detalleDeUso"));
                i.setPrecio30M(resultado.getInt("precio30M"));
                i.setEstado(true);
                i.setUsos(resultado.getString("usos"));
                i.setApto(resultado.getString("apto"));
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
            return i;
    }
    public List<Instalacion> mostrarInstalaciones(){
        List<Instalacion>instalaciones = new ArrayList();
        
        try{
            String sqlSL="Select * FROM instalacion";
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Instalacion i = new Instalacion();
                i.setCodIns(resultado.getInt("codInstal"));
                i.setNombre(resultado.getString("nombre"));
                i.setDetallesUso(resultado.getString("detalleDeUso"));
                i.setPrecio30M(resultado.getInt("precio30M"));
                i.setEstado(resultado.getBoolean("estado"));
                i.setUsos(resultado.getString("usos"));
                i.setApto(resultado.getString("apto"));
                instalaciones.add(i);
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    return instalaciones;
    }
    public List<Instalacion> mostrarInstalacionesMasSolicitadas(){
        List<Instalacion>instalaciones = new ArrayList();
        
        try{
            String sqlSL="Select i.* FROM instalacion i, sesion s WHERE i.codInstal = s.instalacion AND i.estado = 0";
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Instalacion i = new Instalacion();
                i.setCodIns(resultado.getInt("codInstal"));
                i.setNombre(resultado.getString("nombre"));
                i.setDetallesUso(resultado.getString("detalleDeUso"));
                i.setPrecio30M(resultado.getInt("precio30M"));
                i.setEstado(resultado.getBoolean("estado"));
                i.setUsos(resultado.getString("usos"));
                i.setApto(resultado.getString("apto"));
                instalaciones.add(i);
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    return instalaciones;
    }
    public List<Instalacion> mostrarInstalacionesLibres(){
        List<Instalacion>instalaciones = new ArrayList();
        
        try{
            String sqlSL="Select i.* FROM instalacion i WHERE  i.estado = 1";
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Instalacion i = new Instalacion();
                i.setCodIns(resultado.getInt("codInstal"));
                i.setNombre(resultado.getString("nombre"));
                i.setDetallesUso(resultado.getString("detalleDeUso"));
                i.setPrecio30M(resultado.getInt("precio30M"));
                i.setEstado(resultado.getBoolean("estado"));
                i.setUsos(resultado.getString("usos"));
                i.setApto(resultado.getString("apto"));
                instalaciones.add(i);
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    return instalaciones;
    }
    
    public void darDeAlta(int codInstal){
            String sqlUP="UPDATE instalacion SET estado = 1 WHERE instalacion.codInstal = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, codInstal);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Instalacion dada de alta");
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void darDeBaja(int codInstal){
        String sqlUP="UPDATE instalacion SET estado = 0 WHERE instalacion.codInstal = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, codInstal);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Instalacion dada de baja");
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
        public void libre(int codInstal){
            String sqlUP="UPDATE instalacion SET estado = 1 WHERE instalacion.codInstal = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, codInstal);
            if(ps.executeUpdate() > 0){
                System.out.println("Instalacion libre!!!!");
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void reserva(int codInstal){
        String sqlUP="UPDATE instalacion SET estado = 0 WHERE instalacion.codInstal = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, codInstal);
            if(ps.executeUpdate() > 0){
                System.out.println("la instalacion fue reservada con exito!!!!!");
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
}
