
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
         String sqlUP="INSERT INTO instalacion(nombre, detallesDeUso, precio30M, estado,usos, apto) VALUES(?,?,?,?,?,?,?)";
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
            i.setCodIns(rs.getInt("codInstal"));
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
            String sqlUP="";
            PreparedStatement ps = con.prepareStatement(sqlUP);
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    
    public List<Instalacion> mostrarInstalaciones(){
        SesionData sesion = new SesionData();
        List<Instalacion>instalaciones = new ArrayList();
        
        try{
            String sqlSL="Select * FROM instalacion";
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Instalacion i = new Instalacion();
                i.setCodIns(resultado.getInt("codInstal"));
                i.setNombre(resultado.getString("nombre"));
                i.setDetallesUso("detallesDeUso");
                i.setPrecio30M(resultado.getInt("precio30M"));
                i.setEstado(true);
               //falta sesion
            }
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    return instalaciones;
    }
    
}
