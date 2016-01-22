package model;


import controller.ColaboradorLogic;
import controller.CursoLogic;
import controller.EstudianteLogic;
import controller.UsuarioLogic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deiby
 */
public class Conexion {

    private Connection conexion;

    
        /**
    * Método utilizado para recuperar el valor del atributo conexion
    * @return conexion contiene el estado de la conexión
    *
    */
    public Connection getConexion()
    {
       return conexion;
    }

    /**
    * Método utilizado para establecer la conexión con la base de datos
    * @return estado regresa el estado de la conexión, true si se estableció la conexión,
    * falso en caso contrario
    */
    public boolean crearConexion()
    {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/pamtecdb";
            String usuarioDB="root";
            String passwordDB="201239404";
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
       } catch (SQLException | ClassNotFoundException ex) {
          System.out.println("Failed");
          return false;
       }
        System.out.println("Sucess");
       return true;
    }

    /**
    *
    *Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return estado regresa el estado de la ejecución, true(éxito) o false(error)
    *
    */
    public PreparedStatement ejecutarSQL(String sql)
    {
       crearConexion();
       try {
          PreparedStatement sentencia = conexion.prepareStatement(sql);
    
          return sentencia;
       } catch (SQLException ex) {
          ex.printStackTrace();
       return null;
       }

    }

    /**
    *
    *Método utilizado para realizar la instrucción SELECT
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return resultado regresa los registros generados por la consulta
    *
    */
    public ResultSet ejecutarSQLSelect(String sql)
    {
       crearConexion();
       ResultSet resultado;
       try {
          Statement sentencia = conexion.createStatement();
          resultado = sentencia.executeQuery(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
          return null;
       }
       return resultado;
    }
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        /*EstudianteLogic estud = new EstudianteLogic();
        estud.desmatricularEstudiante("AbrahamAguero50@gmail.com", "CED - 50", "C - 17", 17);*/
        
        /*CursoLogic curso = new CursoLogic();
        curso.InformacionExcelEstudiantes("C - 7", 7);*/
        
        /*ColaboradorLogic colab = new ColaboradorLogic();
        colab.colaboradorDeCurso();*/
        
        UsuarioLogic usuario = new UsuarioLogic();
        usuario.insertarUsuario("deiby-diaz","201239404","Administrador");
    }
    
}