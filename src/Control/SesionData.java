
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

public class SesionData {
    private Connection  con = null;

    public SesionData(){
        this.con = Conexion.getConexion();
    }
    
    public void crearSesion(Sesion s, Tratamiento t, Masajista m, Instalacion i){
        String sqlUP="INSERT INTO sesion()";
    }
    
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
