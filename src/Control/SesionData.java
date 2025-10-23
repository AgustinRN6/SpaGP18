
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

public class SesionData {
    private Connection  con = null;

    public SesionData(){
        this.con = Conexion.getConexion();
    }
    
    //INSERT
    public void crearSesion(Sesion s){
        
        
        String query="INSERT INTO sesion(fechaHoraInicio, fechaHoraFin, tratamiento, masajista, dia_De_Spa, estado, instalacion) VALUES (?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, Timestamp.valueOf(s.getFechaIn()));
            ps.setTimestamp(2, Timestamp.valueOf(s.getFechaFin()));
            ps.setInt(3, s.getTratamiento());
            ps.setInt(4, s.getMasajista());
            ps.setInt(5, s.getDiaS());
            ps.setBoolean(6, s.isEstado());
            ps.setInt(7, s.getInstalacion());

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha creado la sesión con éxito!");

            }

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                s.setCodSesion(rs.getInt(1));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo crearse la sesión " + ex.getMessage());
        }
        
        
    }
    
    //DROP
    
    //UPDATE
    
    //SELECT 1
    
    //SELECT TODOS
    
    //UPDATE alta lógica
    
    //UPDATE baja lógica
    
    
    
    /*public Sesion buscarSesion(int cod){
        MasajistasData mas = new MasajistasData();
        TratamientosData tas = new TratamientosData();
        InstalacionesData ins = new InstalacionesData();
        try{
        String sqlSL="SELECT * FROM sesion WHERE sesion.codSesion = ?";
        PreparedStatement ps = con.prepareStatement(sqlSL);
        ps.setInt(1, cod);
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()){
           Masajista m = mas.buscarMasajista(resultado.getInt("masajista"))  ;
           Tratamiento t= tas.buscarTratamiento(resultado.getInt("tratamiento")); 
        }
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return se;
    }
    */
}
