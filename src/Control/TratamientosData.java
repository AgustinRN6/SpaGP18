
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.time.LocalTime;
public class TratamientosData {
    private Connection con =  null;
    
    public TratamientosData(){
        this.con = Conexion.getConexion();
    }
    
    public void cargarTratamiento(Tratamiento t){
        String sqlUP="INSERT INTO tratamiento(nombre, detalle, duracion, costo, estado, tipo)VALUES(?,?,?,?,?,?)";
        try{
        PreparedStatement  ps = con.prepareStatement(sqlUP,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, t.getNombre());
        ps.setString(2, t.getDetalle());
        ps.setTime(3, Time.valueOf(t.getDuracion()));
        ps.setInt(4, t.getCosto());
        ps.setBoolean(5, t.isEstado());
        ps.setString(6, t.getTipo());
        if(ps.executeUpdate()> 0){
            JOptionPane.showMessageDialog(null, "Tratamiento cargado!!!!");
        }
        ResultSet rs = ps.getGeneratedKeys();
        while(rs.next()){
            t.setCodTrat(rs.getInt(1));
        }
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    public void borrarTratamiento(int codTratam){
        String sqlDL="DELETE FROM tratamiento WHERE tratamiento.codTratam = ?";
        try{
        PreparedStatement ps = con.prepareStatement(sqlDL);
        ps.setInt(1, codTratam);
        if(ps.executeUpdate() > 0){
            JOptionPane.showMessageDialog(null, "Tratamiento eliminado");
        }
        }catch(java.sql.SQLException error){
        JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void actualizarTratamiento(Tratamiento t){
        String sqlUP="UPDATE FROM tratamiento SET nombre = ?, detalle = ?, duracion = ?, costo = ?, estado = ?, tipo = ? WHERE tratamiento.codTratam = ?";
        try{
        PreparedStatement ps = con.prepareStatement(sqlUP);
        ps.setString(1, t.getNombre());
        ps.setString(2, t.getDetalle());
        ps.setTime(3, Time.valueOf(t.getDuracion()));
        ps.setInt(4, t.getCosto());
        ps.setBoolean(5, t.isEstado());
        ps.setString(6, t.getTipo());
        ps.setInt(7, t.getCodTrat());
        if(ps.executeUpdate() > 0){
            JOptionPane.showMessageDialog(null, "Tratamiento actualizado");
        }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public Tratamiento buscarTratamiento(int codTratam){
        Tratamiento t = new Tratamiento();
        String sqlSL="SELECT * FROM tratamiento WHERE tratamiento.codTratam = ?";
        try{
        PreparedStatement ps = con.prepareStatement(sqlSL);
        ps.setInt(1, codTratam);
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()){
            
            t.setCodTrat(resultado.getInt("codTratam"));
            t.setNombre(resultado.getString("nombre"));
            t.setDetalle(resultado.getString("detalle"));
            t.setDuracion( (resultado.getTime("duracion").toLocalTime()));
            t.setCosto(resultado.getInt("costo"));
            t.setEstado(resultado.getBoolean("estado"));
            t.setTipo(resultado.getString("tipo"));
           
        }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return t;
    }
    
    public List<Tratamiento> mostrarTratamientos(){
        List<Tratamiento>tratamientos = new ArrayList();
        String sqlSL="SELECT * FROM tratamiento";
        try{
        PreparedStatement ps = con.prepareStatement(sqlSL);
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()){
            Tratamiento t = new Tratamiento();
            t.setCodTrat(resultado.getInt("codTratam"));
            t.setNombre(resultado.getString("nombre"));
            t.setDetalle(resultado.getString("detalle"));
            t.setDuracion( (resultado.getTime("duracion").toLocalTime()));
            t.setCosto(resultado.getInt("costo"));
            t.setEstado(resultado.getBoolean("estado"));
            t.setTipo(resultado.getString("tipo"));
            tratamientos.add(t);
        }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return tratamientos;
    }
    
    public void darDeAlta(int codTratam){
            String sqlUP="UPDATE FROM tratamiento SET estado = 1 WHERE tratamiento.codTratam = ?";
        try{
        PreparedStatement ps = con.prepareStatement(sqlUP);
        if(ps.executeUpdate()> 0){
            JOptionPane.showMessageDialog(null, "Tratamiento dado de alta");
        }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void darDeBaja(int codTratam){
        String sqlUP="UPDATE FROM tratamiento SET estado = 0 WHERE tratamiento.codTratam = ?";
        try{
        PreparedStatement ps = con.prepareStatement(sqlUP);
        if(ps.executeUpdate()> 0){
            JOptionPane.showMessageDialog(null, "Tratamiento dado de baja");
        }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }    
    }
}
