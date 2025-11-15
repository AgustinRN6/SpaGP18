package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TratamientosData {

    private Connection con = null;

    public TratamientosData() {
        this.con = Conexion.getConexion();
    }

    public void cargarTratamiento(Tratamiento t) {
        
        String sqlUP = "INSERT INTO tratamiento(nombre, detalle, duracion, costo, estado,tipo ,masajista)VALUES(?,?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlUP, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDetalle());
            ps.setTime(3, Time.valueOf(t.getDuracion()));
            ps.setInt(4, t.getCosto());
            ps.setBoolean(5, t.isEstado());
            ps.setString(6, t.getTipo());
            ps.setInt(7, t.getMasajista().getMatricula());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento cargado!!!!");
            }
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                t.setCodTrat(rs.getInt(1));
            }

        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }

    public void borrarTratamiento(int codTratam) {
        
        String sqlDL = "DELETE FROM tratamiento WHERE tratamiento.codTratam = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlDL);
            ps.setInt(1, codTratam);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento eliminado");
            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }

    public void actualizarTratamiento(Tratamiento t) {
        
        String sqlUP = "UPDATE tratamiento SET nombre = ?, detalle = ?, duracion = ?, costo = ?, estado = ?, tipo ?,masajista = ? WHERE tratamiento.codTratam = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDetalle());
            ps.setTime(3, Time.valueOf(t.getDuracion()));
            ps.setInt(4, t.getCosto());
            ps.setBoolean(5, t.isEstado());
            ps.setString(6, t.getTipo());
            ps.setInt(7, t.getMasajista().getMatricula());
            ps.setInt(8, t.getCodTrat());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento actualizado");
            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }

    public Tratamiento buscarTratamiento(int codTratam) {
        
        Tratamiento t = new Tratamiento();
        String sqlSL = "SELECT * FROM tratamiento WHERE tratamiento.codTratam = ?";
        MasajistasData masajistas  = new MasajistasData();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ps.setInt(1, codTratam);
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()) {

                t.setCodTrat(resultado.getInt("codTratam"));
                t.setNombre(resultado.getString("nombre"));
                t.setDetalle(resultado.getString("detalle"));
                t.setDuracion((resultado.getTime("duracion").toLocalTime()));
                t.setCosto(resultado.getInt("costo"));
                t.setTipo(resultado.getString("tipo"));
                t.setEstado(resultado.getBoolean("estado"));
                Masajista m = masajistas.buscarMasajista(resultado.getInt("masajista"));
                t.setMasajista(m);

            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        return t;
        
    }

    public List<Tratamiento> mostrarTratamientos() {
        
        List<Tratamiento> tratamientos = new ArrayList();
        String sqlSL = "SELECT * FROM tratamiento";
        MasajistasData masajistas  = new MasajistasData();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()) {
                
                Tratamiento t = new Tratamiento();
                t.setCodTrat(resultado.getInt("codTratam"));
                t.setNombre(resultado.getString("nombre"));
                t.setDetalle(resultado.getString("detalle"));
                t.setDuracion((resultado.getTime("duracion").toLocalTime()));
                t.setCosto(resultado.getInt("costo"));
                t.setEstado(resultado.getBoolean("estado"));
                t.setTipo(resultado.getString("tipo"));
                Masajista m = masajistas.buscarMasajista(resultado.getInt("masajista"));
                t.setMasajista(m);
                tratamientos.add(t);
                
            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        return tratamientos;
        
    }

    public List<Tratamiento> mostrarTratamientosTipos(String tipo) {
        
        List<Tratamiento> tratamientos = new ArrayList();
        String sqlSL = "SELECT * FROM tratamiento WHERE tratamiento.tipo LIKE '%" + tipo + "%'  ";
        MasajistasData masajistas = new MasajistasData();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()) {
                
                Tratamiento t = new Tratamiento();
                t.setCodTrat(resultado.getInt("codTratam"));
                t.setNombre(resultado.getString("nombre"));
                t.setDetalle(resultado.getString("detalle"));
                t.setDuracion((resultado.getTime("duracion").toLocalTime()));
                t.setCosto(resultado.getInt("costo"));
                t.setTipo(resultado.getString("tipo"));
                t.setEstado(resultado.getBoolean("estado"));
                Masajista m = masajistas.buscarMasajista(resultado.getInt("masajista"));
                t.setMasajista(m);
                tratamientos.add(t);
                
            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        return tratamientos;
        
    }

    public void darDeAlta(int codTratam) {
        String sqlUP = "UPDATE tratamiento SET estado = 1 WHERE tratamiento.codTratam = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, codTratam);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento dado de alta");
            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }

    public void darDeBaja(int codTratam) {
        
        String sqlUP = "UPDATE tratamiento SET estado = 0 WHERE tratamiento.codTratam = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sqlUP);
            ps.setInt(1, codTratam);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Tratamiento dado de baja");
            }
            
        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    //Se utilizará para realizar un listado de los tratamientos de un día de spa correspondiente
    public List<diaSpaTratamiento> ListadoTratamientosDelDia(LocalDate fecha, int codTratamiento) {
        
        ArrayList<diaSpaTratamiento> tratamientos = new ArrayList<>();

        //Se realiza un JOIN de masajistas y tratamientos con respecto a la sesion, para corroborar cuales son los tratamientos
        //de la fecha elegida por el usuario
        String query = "SELECT t.codTratam, t.nombre, t.detalle, t.duracion, t.costo," +
        "m.nombreApellido, TIME(s.fechaHoraInicio) 'horario', TIME(s.fechaHoraFin) 'horarioFinal'\n" +
        "FROM tratamiento t\n" +
        "JOIN masajista m ON t.masajista = m.matricula\n" +
        "JOIN sesion s ON t.codTratam = s.tratamiento \n" +
        "AND date(s.fechaHoraInicio) = date(?)"+ 
        "AND t.codTratam = ?;";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query);
            //Se utiliza para consultar por fecha brindada por parametro
            ps.setString(1, fecha.toString());
            ps.setInt(2, codTratamiento);

            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()) {
                
                diaSpaTratamiento t = new diaSpaTratamiento();
                
                t.setCodTrat(resultado.getInt("codTratam"));
                t.setNombre(resultado.getString("nombre"));
                t.setDetalle(resultado.getString("detalle"));
                t.setDuracion(resultado.getTime("duracion").toLocalTime());
                t.setCosto(resultado.getInt("costo"));
                t.setMasajista(resultado.getString("nombreApellido"));
                t.setInicio(resultado.getTime("horario").toLocalTime());
                t.setFin(resultado.getTime("horarioFinal").toLocalTime());
                
                tratamientos.add(t);
                
            }

        } catch (java.sql.SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        
        return tratamientos;
        
        
    }
    
}
