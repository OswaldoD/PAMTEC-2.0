/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario;

/**
 *
 * @author Jason
 */
public class UsuarioLogic implements Usuario{
    Conexion connect;
    ResultSet result;
    
    public UsuarioLogic(){
        result = null;
    }
    @Override
    public int insertarUsuario(String nombre_usuario, String password_usuario, String rol) {
        connect = new Conexion();
        PreparedStatement sentence = connect.ejecutarSQL("CALL InsertarUsuario(?,?,?)");
        try {
            sentence.setString(1, nombre_usuario);
            sentence.setString(2, password_usuario);
            sentence.setString(3, rol);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        System.out.println("Sucess");
        return 1;
    }

    @Override
    public int deleteUsuario(String nombre_usuario) {
         connect = new Conexion();
        PreparedStatement sentence = connect.ejecutarSQL("CALL EliminarUsuario(?)");
        try {
            if(!existeUsuario(nombre_usuario))
                return 2;
            sentence.setString(1, nombre_usuario);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        System.out.println("Sucess");
        return 1;
    
    }

    @Override
    public boolean updateUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int iniciarSesion(String nombre_usuario, String password_usuario) {
        connect = new Conexion();
        PreparedStatement sentence = connect.ejecutarSQL("CALL IniciarSesion(?,?)");
        try {
            if(!existeUsuario(nombre_usuario))
                return 2;
            sentence.setString(1, nombre_usuario);
            sentence.setString(2, password_usuario);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        System.out.println("Sucess");
        return 1;
    }

    private boolean existeUsuario(String nombre_usuario) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL ExisteUsuario(?)");   
        query.setString(1, nombre_usuario);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            System.out.println("El Usuario ya existe");
            return true;
        }
        System.out.println("El Usuario" +nombre_usuario + " no existe");
        return false;
    }


    
}
