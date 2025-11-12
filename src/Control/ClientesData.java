
package Control;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        
        String sqlIN="INSERT INTO cliente(dni, nombreCompleto, telefono, edad, estado)VALUES(?,?,?,?,?)";

        try{
            
            PreparedStatement ps = con.prepareStatement(sqlIN, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreC());
            ps.setInt(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setBoolean(6, c.isEstado());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente Agregado!!!!");
            }
            
            ResultSet rs= ps.getGeneratedKeys();
            
            while(rs.next()){
            c.setCodCli(rs.getInt(1));
            }
            
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void borrarCliente(int id){
       
        String sqlDL="DELETE FROM cliente WHERE cliente.codCli = ?";
       
       try{
           
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
        
        String sqlUP="UPDATE cliente SET dni = ?, nombreCompleto = ?, telefono = ?, edad = ?, estado = ? WHERE cliente.codCli = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlUP);
            
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreC());
            ps.setInt(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setBoolean(6, c.isEstado());
            ps.setInt(7, c.getCodCli());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente Modificado!!!!");
            }
            
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    public Cliente buscarCliente(int id){
        
        Cliente cli = new Cliente();
        
        String sqlSL ="SELECT * FROM cliente WHERE cliente.codCli = ?";
        
        try{
            
        PreparedStatement ps = con.prepareStatement(sqlSL);
        ps.setInt(1, id);
        ResultSet resultado = ps.executeQuery();
        
        while(resultado.next()){
            
            cli.setCodCli(resultado.getInt("codCli"));
            cli.setNombreC(resultado.getString("nombreCompleto"));
            cli.setEdad(resultado.getInt("edad"));
            cli.setDni(resultado.getInt("dni"));
            cli.setTelefono(resultado.getInt("telefono"));
            cli.setEstado(resultado.getBoolean("estado"));
            
        }
        
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return cli;
    
    }
    public List<Cliente> mostrarClientes(){
        
        List<Cliente> clientes = new ArrayList();
        String sqlSL="SELECT * FROM cliente";
        
        try{
            
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                
            Cliente c = new Cliente();
            
            c.setCodCli(resultado.getInt("codCli"));
            c.setNombreC(resultado.getString("nombreCompleto"));
            c.setEdad(resultado.getInt("edad"));
            c.setDni(resultado.getInt("dni"));
            c.setTelefono(resultado.getInt("telefono"));
            c.setEstado(resultado.getBoolean("estado"));
            clientes.add(c);
            
            }
        
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return clientes;
                
    }
        public List<Cliente> mostrarClientesActivos(){
            
        List<Cliente> clientes = new ArrayList();
        String sqlSL="SELECT * FROM cliente WHERE cliente.estado = 1";
        
        try{
            
            
            PreparedStatement ps = con.prepareStatement(sqlSL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
            Cliente c = new Cliente();
            
            c.setCodCli(resultado.getInt("codCli"));
            c.setNombreC(resultado.getString("nombreCompleto"));
            c.setEdad(resultado.getInt("edad"));
            c.setDni(resultado.getInt("dni"));
            c.setTelefono(resultado.getInt("telefono"));
            c.setEstado(resultado.getBoolean("estado"));
            clientes.add(c);
            }
        
        
        }catch(java.sql.SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return clientes;
    }
    
    public void darDeAlta(int id ){
        
        String sqlUP="UPDATE cliente SET estado = 1 WHERE cliente.codCli = ?";
        
        try{
            
            PreparedStatement  ps = con.prepareStatement(sqlUP);
            ps.setInt(1, id);
            
            if(ps.executeUpdate()   > 0){
                JOptionPane.showMessageDialog(null, "Cliente dado de ALTA!!!!!");
            }
            
        }catch(java.sql.SQLException error){
        JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public void darDeBaja(int id){
        
        String sqlUP="UPDATE cliente SET estado = 0 WHERE cliente.codCli = ?";
        
        try{
            
            PreparedStatement  ps = con.prepareStatement(sqlUP);
            ps.setInt(1, id);
            
            if(ps.executeUpdate()   > 0){
                JOptionPane.showMessageDialog(null, "Cliente dado de BAJA!!!!!");
            }
            
        }catch(java.sql.SQLException error){
        JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
}
