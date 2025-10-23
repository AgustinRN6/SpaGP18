
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
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
}
