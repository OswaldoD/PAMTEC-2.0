/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Curso;

/**
 *
 * @author Jason
 */
public class CursoLogic implements Curso{
    
    Conexion connect;
    ResultSet result;
    
    public CursoLogic(){
        result = null;
    }
    
    @Override
    public int insertarCurso(String nombre_curso,String codigo_curso, 
            int numero_grupo, String detalles_curso, int cupo_curso,
            String email_prof, String email_asist1, String email_asist2) {
        
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL ExisteCurso(?,?)");       
        PreparedStatement sentence = connect.ejecutarSQL("CALL InsertarCurso(?,?,?,?,?,?,?,?)");
        try {
            if(existeCurso(codigo_curso, numero_grupo))
                return 2;
            if(!existeProfe(email_prof))
                return 3;
            if(!existeAsistente(email_asist1))
                return 4;
            if(!existeAsistente(email_asist2))
                return 5;
            sentence.setString(1, nombre_curso);
            sentence.setString(2, codigo_curso);
            sentence.setInt(3, numero_grupo);
            sentence.setString(4, detalles_curso);
            sentence.setInt(5, cupo_curso);
            sentence.setString(6, email_prof);
            sentence.setString(7, email_asist1);
            sentence.setString(8, email_asist2);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;
      
    }

    @Override
    public int deleteCurso(String codigo_curso, int numero_grupo) {
         connect = new Conexion();
        
      PreparedStatement sentence = connect.ejecutarSQL("CALL EliminarCurso(?,?)");
        try {
            if(!existeCurso(codigo_curso, numero_grupo))
                return 2;
            sentence.setString(1, codigo_curso);
            sentence.setInt(2, numero_grupo);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;  
    }



    @Override
    public boolean updateCurso(int numero_grupo_viejo, String codigo_viejo,
            String nombre_curso, String codigo_nuevo, int numero_grupo_nuevo,
            String detalles_grupo, int cupo_grupo) {
      connect = new Conexion();
        
      PreparedStatement sentence = connect.ejecutarSQL("CALL ActualizarCurso(?,?,?,?,?,?,?)");
        try {
         
            sentence.setInt(1, numero_grupo_viejo);
            sentence.setString(2, codigo_viejo);
            sentence.setString(3, nombre_curso);
            sentence.setString(4, codigo_nuevo);
            sentence.setInt(5, numero_grupo_nuevo);
            sentence.setString(6, detalles_grupo);
            sentence.setInt(7, cupo_grupo);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return true;  
    }

    @Override
    public ArrayList<CursosTO> infoCursoRS() {
        ArrayList<CursosTO> infoCurso = new ArrayList<CursosTO>();
        try {
            connect = new Conexion();
            PreparedStatement query = connect.ejecutarSQL("CALL InformacionCursos()");
            result = query.executeQuery();
            while (result.next())
            {
                String nombre_curso = result.getString("Nombre");
                String codigo_curso = result.getString("Codigo");
                int numero_grupo = result.getInt("NumeroGrupo");
                int cupo_disponible = result.getInt("CupoDisponible");
                // print the results
                System.out.format("%s, %s, %d, %d\n", nombre_curso,codigo_curso,
                        numero_grupo,cupo_disponible);
                
                CursosTO curso_temp = new CursosTO(nombre_curso, codigo_curso, numero_grupo, cupo_disponible);
                infoCurso.add(curso_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
       return infoCurso;
    }

    @Override
    public Collection selectCursoTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadProfesPorCursos(String codigo_curso, int numero_grupo) {
          connect = new Conexion();
          int cantProfes = 0;
        PreparedStatement query = connect.ejecutarSQL("CALL CantProfCurso(?,?)");   
        try {
            query.setString(1, codigo_curso);
            query.setInt(2, numero_grupo);
            result = query.executeQuery();
            while (result.next())
            {
                cantProfes+= result.getInt("count(CpC.IdColaborador)");
            }
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cantidad de profes: " +cantProfes);
        return 1;
    }

    @Override
    public int cantidadAsistentesPorCursos(String codigo_curso, int numero_grupo) {
        connect = new Conexion();
          int cantAsistentes = 0;
        PreparedStatement query = connect.ejecutarSQL("CALL CantAsisCurso(?,?)");   
        try {
            query.setString(1, codigo_curso);
            query.setInt(2, numero_grupo);
            result = query.executeQuery();
            while (result.next())
            {
                cantAsistentes+= result.getInt("Count(CpC.IdColaborador)");
            }
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cantidad de asistentes: " +cantAsistentes);
        return 1;
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
            System.out.println("El Curso ya existe");
            return true;
        }
        System.out.println("El Curso no existe");
        return false;
    }

    private boolean existeProfe(String email_prof) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL isProfe(?)");   
        query.setString(1, email_prof);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            return true;
        }
        System.out.println("El Profe " + email_prof +" no existe");
        return false;
    }

    private boolean existeAsistente(String email_asist) throws SQLException {
        connect = new Conexion();
        PreparedStatement query = connect.ejecutarSQL("CALL isAsistente(?)");   
        query.setString(1, email_asist);
        result = query.executeQuery();
        int bit = 0;
        while (result.next())
        {
            bit+= result.getInt("_Bit");
        }
        if(bit >= 1){
            return true;
        }
        System.out.println("El Asistente " + email_asist + " no existe");
        return false;
    }

    @Override
    public ArrayList<CursosTO> infoGeneralCursosRS() {
         ArrayList<CursosTO> infoCurso = new ArrayList<CursosTO>();
        try {
            connect = new Conexion();
            PreparedStatement query = connect.ejecutarSQL("CALL InformacionGeneralCursos()");
            result = query.executeQuery();
            while (result.next())
            {
                String nombre_curso = result.getString("Nombre");
                String codigo_curso = result.getString("Codigo");
                int numero_grupo = result.getInt("NumeroGrupo");
                int cupo_total = result.getInt("Cupo");
                // print the results
                System.out.format("%s, %s, %d, %d\n", nombre_curso,codigo_curso,
                        numero_grupo,cupo_total);
                CursosTO curso_temp = new CursosTO(nombre_curso, codigo_curso, numero_grupo, cupo_total);
                infoCurso.add(curso_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoCurso;
    }

    @Override
    public ArrayList<CursosTO> InformacionExcelEstudiantes(String codigo_curso, int numero_grupo) {
       ArrayList<CursosTO> infoEstudiante = new ArrayList<CursosTO>();
        try {
            connect = new Conexion();
            PreparedStatement query = connect.ejecutarSQL("CALL InformacionExcelEstudiantes(?,?)");
            query.setString(1, codigo_curso);
            query.setInt(2, numero_grupo);
            result = query.executeQuery();
            while (result.next())
            {
                String apellidos = result.getString("Apellidos");
                String nombre = result.getString("Nombre");
                String telefono1 = result.getString("Telefono1");
                String telefono2 = result.getString("Telefono2");
                // print the results
                System.out.format("%s, %s, %s, %s\n", apellidos,nombre,
                        telefono1,telefono2);
                CursosTO estud_temp = new CursosTO(apellidos, nombre, telefono1, telefono2);
                infoEstudiante.add(estud_temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoEstudiante;
    }

    @Override
    public int asignarProfesor(String email_profesor, String codigo_curso, int numero_grupo) {
        connect = new Conexion();       
        PreparedStatement sentence = connect.ejecutarSQL("CALL AsignarProfesor(?,?,?)");
        try {
            if(existeCurso(codigo_curso, numero_grupo))
                return 2;
             if(!existeProfe(email_profesor))
                 return 3;
             if(existeCurso(codigo_curso,numero_grupo))
                return 4;
            sentence.setString(1, email_profesor);
            sentence.setString(2, codigo_curso);
            sentence.setInt(3, numero_grupo);
            sentence.execute();
            connect.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucess");
        return 1;
    }
    
}
