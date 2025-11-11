
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
            
            
            //PONER EN FALSE A TRATAMIENTO, MASAJISTA E INSTALACIONES DEBIDO A QUE ESTAN OCUPADOS....
            InstalacionesData instalaciones = new InstalacionesData();
            MasajistasData masajistas = new MasajistasData();
            TratamientosData tratamientos = new TratamientosData();
            DiaSPAData dia = new DiaSPAData();
            
            
            instalaciones.reserva(s.getInstalacion());
            
            masajistas.reserva(s.getMasajista());
            
            dia.Reserva(s.getDiaS());
            
            tratamientos.reserva(s.getTratamiento());
            
            
            ResultSet rs = ps.getGeneratedKeys();

             while(rs.next()) {

                s.setCodSesion(rs.getInt(1));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo crearse la sesión " + ex.getMessage());
        }
        
        
    }
    
    //DELETE
    public void borrarSesion(int borrar) {
        
        String query = "DELETE FROM sesion WHERE codSesion = ?";
        
            Sesion s = mostrarSesion(borrar);
            
            //se desocupan el masajista, la instalacion, el tratamiento y el dia es eliminado!!! 
            
            InstalacionesData instalaciones = new InstalacionesData();
            
            MasajistasData masajistas = new MasajistasData();
            
            TratamientosData tratamientos = new TratamientosData();
            
            DiaSPAData dia = new DiaSPAData();
            
            //metodos para eliminar dia, y poner los demas objetos en libre o activo
            
            instalaciones.libre(s.getInstalacion());
            
            masajistas.libre(s.getMasajista());
            
            tratamientos.libre(s.getTratamiento());
            
        try {
            

            
            
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, borrar);

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "La sesión ha sido eliminado!");

            }
            
     
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo eliminarse la sesión " + ex.getMessage());
        }

        dia.borrarDiaSpa(s.getDiaS());
    }
    
    //UPDATE
    public void actualizarSesion(Sesion s) {
        
        String query = "UPDATE sesion SET fechaHoraInicio = ? ,fechaHoraFin = ? "
                + ",tratamiento = ? , masajista = ? ,dia_De_Spa =  ? "
                + ",instalacion = ? WHERE codSesion = ?";
        
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setTimestamp(1, Timestamp.valueOf(s.getFechaIn()));
            ps.setTimestamp(2, Timestamp.valueOf(s.getFechaFin()));
            ps.setInt(3, s.getTratamiento());
            ps.setInt(4, s.getMasajista());
            ps.setInt(5, s.getDiaS());
            ps.setInt(6, s.getInstalacion());
            ps.setInt(7, s.getCodSesion());

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha actualizado la sesión con éxito!");

            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo actualizarse la sesión " + ex.getMessage());
        }
        
    }
    
    //SELECT 1
    public Sesion mostrarSesion(int mostrar) {
        
        Sesion sesion = new Sesion();
        
        String query = "SELECT * FROM sesion WHERE codSesion = ?";
        
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, mostrar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                sesion.setCodSesion(rs.getInt("codSesion"));
                sesion.setFechaIn(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                sesion.setFechaFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                sesion.setTratamiento(rs.getInt("tratamiento"));
                sesion.setMasajista(rs.getInt("masajista"));
                sesion.setDiaS(rs.getInt("dia_De_Spa"));
                sesion.setEstado(rs.getBoolean("estado"));
                sesion.setInstalacion(rs.getInt("instalacion"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo mostrarse la sesion " + ex.getMessage());
        }
        
        
        return sesion;
        
        
    }
    
    //SELECT TODOS
    public List<Sesion> mostrarTodasSesiones() {
        
        List<Sesion> todasSesiones = new ArrayList();
        
        String query = "SELECT * FROM sesion ";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Sesion sesion = new Sesion();
                sesion.setCodSesion(rs.getInt("CodSesion"));
                sesion.setFechaIn(rs.getTimestamp("fechaHoraInicio").toLocalDateTime());
                sesion.setFechaFin(rs.getTimestamp("fechaHoraFin").toLocalDateTime());
                sesion.setTratamiento(rs.getInt("tratamiento"));
                sesion.setMasajista(rs.getInt("masajista"));
                sesion.setDiaS(rs.getInt("dia_De_Spa"));;
                sesion.setEstado(rs.getBoolean("estado"));
                sesion.setInstalacion(rs.getInt("instalacion"));
                
                todasSesiones.add(sesion);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo cargarse las sesiones " + ex.getMessage());
        }
        
        return todasSesiones;
        
    }
    
    //UPDATE alta lógica
    public void altaSesion(int alta) {
        
        String query = "UPDATE sesion SET estado = 1 WHERE codSesion = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, alta);

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha dado de alta la sesión con éxito!");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo darse de alta la sesión " + ex.getMessage());
        }
        
    }
    
    //UPDATE baja lógica
    public void bajaSesion(int baja) {

        String query = "UPDATE sesion SET estado = 0 WHERE codSesion = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, baja);

            if (ps.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Se ha dado de baja la sesión con éxito!");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo darse de baja la sesión " + ex.getMessage());
        }

    }
    //Metodo que me retorna el precio de la sesion.    
    public void cargarPrecioTotal(Sesion s){
    
            TratamientosData trat = new TratamientosData();
    
            InstalacionesData ins = new InstalacionesData();
            
            DiaSPAData dia = new DiaSPAData();
            
            //creo los objetos y les saco la informacion y los atributos (monto,hora y costo).
            Instalacion i = ins.buscarInstalacion(s.getInstalacion());
   
            Tratamiento t = trat.buscarTratamiento(s.getTratamiento());
            
            DiaSpa  d = dia.cargarDiaSpa(s.getDiaS());
            
            
            //en caso de que haya una actualizacion en la sesion y se cambie tratamiento e instalacion. se restaura el precio a 0
            d.setMonto(0);
            dia.actualizarMonto(d);
            
            /*metodo que retorna la cantidad de horas que dura el tratamiento en total.
            cada hora consta de 2 media horas entonces si por ejemplo me da 2 horas en total lo multiplico por 2 y me daria la cantidad total */
            int tiempoTotal = t.getDuracion().getHour() * 2;
            int precioTotal = 0;
            
            if(t.getDuracion().getMinute() >= 30){
                //si los minutos del tratamiento dura mas de media hora procede a sumarle el precio por 30m    
                precioTotal += i.getPrecio30M();
            }
            //suma el precio por 30 minutos * lo que dure las horas que dura la sesion + el costo del tratamiento.
            precioTotal = (i.getPrecio30M() * tiempoTotal)+ t.getCosto();
            //en caso de que sea mayor se le suma devuelta
            
            d.setMonto(precioTotal);
            dia.actualizarMonto(d);
            
        }
    
}
    

    
    
