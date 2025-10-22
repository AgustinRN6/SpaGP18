
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

public class ClientesData {
    private Connection con = null;

    public ClientesData(){
        this.con = Conexion.getConexion();
    }
    
    public void subirCliente(Cliente c){
        try{
        String sqlIN="INSERT INTO cliente(dni, nombreCompleto, telefono, edad, afecciones, estado)VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sqlIN, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreC());
            ps.setInt(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getAfecciones());
            ps.setBoolean(6, c.isEstado());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente Agregado!!!!");
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void borrarCliente(int id){
       try{
           String sqlDL="DELETE FROM cliente WHERE cliente.codCli = ?";
           PreparedStatement ps = con.prepareStatement(sqlDL);
           ps.setInt(1, id);
           if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente Eliminado!!!!");
            }
           
       }catch(java.sql.SQLException error){
        JOptionPane.showMessageDialog(null, error.getMessage());
       }
    }
    public void modificarCliente(Cliente c){
        
        try{
        String sqlUP="";
            
            
            
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    public List<Cliente> mostrarClientes(){
        List<Cliente> clientes = new ArrayList();
        try{
            
            String sqlSL="SELECT * FROM cliente";
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
            Cliente c = new Cliente();
            
            c.setCodCli(resultado.getInt("codCli"));
            c.setNombreC(resultado.getString("nombreCompleto"));
            c.setEdad(resultado.getInt("edad"));
            c.setDni(resultado.getInt("dni"));
            c.setTelefono(resultado.getInt("telefono"));
            c.setAfecciones(resultado.getString("afecciones"));
            c.setEstado(resultado.getBoolean("estado"));
            clientes.add(c);
            }
        
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return clientes;
    }
}
