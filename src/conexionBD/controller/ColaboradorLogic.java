/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import model.Colaborador;
import model.Conexion;

/**
 *
 * @author Deiby
 */
public class ColaboradorLogic implements Colaborador{

    Conexion connect;
    ResultSet result;
    public ColaboradorLogic(){
        result = null;
    }
   

    @Override
    public boolean deleteColaborador(String email_colab) {
         connect = new Conexion();
        
        PreparedStatement sentence = connect.ejecutarSQL("CALL EliminarColaborador(?)");
        try {
         
            sentence.setString(1, email_colab);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return true;
    }


    @Override
    public boolean updateColaborador(String correo_viejo, String nombre_colab,
            String apellido1_colab, String apellido2_colab, String correo_nuevo,
            String rol_colab) {
        connect = new Conexion();
        
        PreparedStatement sentence = connect.ejecutarSQL("CALL InsertarColaborador(?,?,?,?,?,?)");
        try {
         
            sentence.setString(1, correo_viejo);
            sentence.setString(2, nombre_colab);
            sentence.setString(3, apellido1_colab);
            sentence.setString(4, apellido2_colab);
            sentence.setString(5, correo_nuevo);
            sentence.setString(6, rol_colab);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return true;
    }
    
    

    @Override
    public void selectColaboradorRS(int cantidad) {
        connect = new Conexion();
        result = connect.ejecutarSQLSelect("select * from colaboradores");
        
        try {
            // iterate through the java resultset
            while (result.next())
            {
                int id = result.getInt("IdColaborador");
                String firstName = result.getString("Nombre");
                String lastName1 = result.getString("Apellido1");
                String lastName2 = result.getString("Apellido2");
                int enabled = result.getInt("Enabled");
                String email = result.getString("email");
                Date dateRegistry = result.getDate("FechaRegistro");
                int idRol = result.getInt("IdRol");
                
                // print the results
                System.out.format("%d %s, %s, %s, %d, %s, %s, %d\n", id, firstName, lastName1, lastName2, enabled, email,dateRegistry.toString(),idRol);
            } } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


    @Override
    public Collection selectCompetidorTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertarColaborador(String nombre_colab, 
            String apellido1_colab, String apellido2_colab, 
            String email_colab, String rol_colab){
        connect = new Conexion();
        
        PreparedStatement sentence = connect.ejecutarSQL("CALL InsertarColaborador(?,?,?,?,?)");
        try {
         
            sentence.setString(1, nombre_colab);
            sentence.setString(2, apellido1_colab);
            sentence.setString(3, apellido2_colab);
            sentence.setString(4, email_colab);
            sentence.setString(5, rol_colab);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
           return 0;
        }
        System.out.println("Sucess");
        return 1;
    }

    @Override
    public boolean insertarRol(String nombre_rol) {
         connect = new Conexion();
        
        PreparedStatement sentence = connect.ejecutarSQL("CALL InsertarRol(?)");
        try {
         
            sentence.setString(1, nombre_rol);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return true;
    }

    @Override
    public ArrayList<ColaboradorTO> colaboradorDeCurso() {
        ArrayList<ColaboradorTO> colaboradores = new ArrayList<ColaboradorTO>();
        
        try {
            connect = new Conexion();
            PreparedStatement query = connect.ejecutarSQL("CALL ColaboradorDeCurso()");
            result = query.executeQuery();
            while (result.next())
            {
                String nombre_curso = result.getString("Nombre");
                String codigo_curso = result.getString("Codigo");
                int numero_grupo = result.getInt("NumeroGrupo");
                String colaborador = result.getString("Colaborador");
                String rol = result.getString("Rol");
                // print the results
                System.out.format("%s, %s, %d, %s, %s\n",nombre_curso,codigo_curso,
                        numero_grupo,colaborador,rol);
                ColaboradorTO colab_temporal = new ColaboradorTO(nombre_curso, codigo_curso, numero_grupo, colaborador, rol);
                colaboradores.add(colab_temporal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colaboradores;
    }
    
}
