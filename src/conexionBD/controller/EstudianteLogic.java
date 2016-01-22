/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Estudiante;

/**
 *
 * @author Jason
 */
public class EstudianteLogic implements Estudiante{
    
    Conexion connect;
    ResultSet result;
    
    public EstudianteLogic(){
        result = null;
    }
    
    @Override
    public int insertarEstudiante(String nombre_estud, String apellido1_estud,
            String apellido2_estud, String cedula_estud, String email_estud,
            String telefono1_estud, String telefono2_estud) {
        
        connect = new Conexion();
        
        PreparedStatement sentence = connect.ejecutarSQL("CALL InsertarEstudiante(?,?,?,?,?,?,?)");
        try {
            if(!existeColaborador(email_estud))
                return 2;
            sentence.setString(1, nombre_estud);
            sentence.setString(2, apellido1_estud);
            sentence.setString(3, apellido2_estud);
            sentence.setString(4, cedula_estud);
            sentence.setString(5, email_estud);
            sentence.setString(6, telefono1_estud);
            sentence.setString(7, telefono2_estud);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;
      
    }

    @Override
    public int deleteEstudiante(String email_colab, String cedula_estud) {
         connect = new Conexion();
        
      PreparedStatement sentence = connect.ejecutarSQL("CALL EliminarEstudiante(?,?)");
        try {
            if(!existeEstudiante(cedula_estud, email_colab))
                return 2;
            sentence.setString(1, email_colab);
            sentence.setString(2, cedula_estud);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;  
    }

    @Override
    public void findEstudiante(int eventoID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateEstudiante(String correo_viejo, String cedula_vieja,
            String nombre_estud, String apellido1_estud, String apellido2_estud,
            String cedula_nueva, String correo_nuevo, String telefono1_estud,
            String telefono2_estud) {
      connect = new Conexion();
        
      PreparedStatement sentence = connect.ejecutarSQL("CALL ActualizarEstudiante(?,?,?,?,?,?,?,?,?)");
        try {
         
            sentence.setString(1, correo_viejo);
            sentence.setString(2, cedula_vieja);
            sentence.setString(3, nombre_estud);
            sentence.setString(4, apellido1_estud);
            sentence.setString(5, apellido2_estud);
            sentence.setString(6, cedula_nueva);
            sentence.setString(7, correo_nuevo);
            sentence.setString(8, telefono1_estud);
            sentence.setString(9, telefono2_estud);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return true;  
    }

    @Override
    public void selectEstudianteRS(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectEstudianteTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int matricularEstudiante(String email_estud, String cedula_estud, String codigo_curso, int numero_grupo) {
        connect = new Conexion();
        
        PreparedStatement sentence = connect.ejecutarSQL("CALL MatricularEstudiante(?,?,?,?)");
        try {
            if(!existeEstudiante(cedula_estud, email_estud))
                return 2;
            if(!existeCurso(codigo_curso,numero_grupo))
                return 3;
            if(estaMatriculado(email_estud, cedula_estud, codigo_curso, numero_grupo))
                return 4;
            sentence.setString(1, email_estud);
            sentence.setString(2, cedula_estud);
            sentence.setString(3, codigo_curso);
            sentence.setInt(4, numero_grupo);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;  
    }

    private boolean existeEstudiante(String cedula_estud, String email_estud) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL ExisteEstudiante(?,?)");   
        query.setString(1, cedula_estud);
        query.setString(2, email_estud);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            return true;
        }
        System.out.println("El Estudiante " + cedula_estud + " no existe");
        return false;
    }
    

    private boolean existeCurso(String codigo_curso, int numero_grupo) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL ExisteCurso(?,?)");   
        query.setString(1, codigo_curso);
        query.setInt(2, numero_grupo);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            System.out.println("El Curso si existe");
            return true;
        }
        System.out.println("El Curso no existe");
        return false;
}

    private boolean existeColaborador(String email_colab) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL ExisteColaborador(?)");   
        query.setString(1, email_colab);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            System.out.println("El Colaborador si existe");
            return true;
        }
        System.out.println("El Colaborador no existe");
        return false;
    }

    @Override
    public int desmatricularEstudiante(String email_estud, String cedula_estud, String codigo_curso, int numero_grupo) {
        connect = new Conexion();
        PreparedStatement sentence = connect.ejecutarSQL("CALL DesmatricularEstudiante(?,?,?,?)");
        try {
            if(!existeEstudiante(cedula_estud, email_estud))
                return 2; 
            if(!existeCurso(codigo_curso,numero_grupo))
                return 3;
            if(!hayCuposDisponibles(codigo_curso,numero_grupo))
                return 4;
            sentence.setString(1, email_estud);
            sentence.setString(2, cedula_estud);
            sentence.setString(3, codigo_curso);
            sentence.setInt(4, numero_grupo);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;  
    }

    private boolean hayCuposDisponibles(String codigo_curso, int numero_grupo) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL HayCampo(?,?)");   
        query.setString(1, codigo_curso);
        query.setInt(2, numero_grupo);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            System.out.println("Hay campos disponibles");
            return true;
        }
        System.out.println("Ya no hay campos disponibles");
        return false;
    }

    private boolean estaMatriculado(String email_estud, String cedula_estud, String codigo_curso, int numero_grupo) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL EstaEstudianteMatriculado(?,?,?,?)");   
        query.setString(1, email_estud);
        query.setString(2, cedula_estud);
        query.setString(3, codigo_curso);
        query.setInt(4, numero_grupo);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            System.out.println("Estudiante ya estaba matriculado");
            return true;
        }
        System.out.println("Estudiante nuevo");
        return false;
    }

}
