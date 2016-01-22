/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deiby
 */

import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author AAC
 */
public interface Estudiante{
    
    // Basic CRUD operations
    
    // Create new person
    public int insertarEstudiante(String nombre_estud, String apellido1_estud,
            String apellido2_estud, String cedula_estud, String email_estud,
            String telefono1_estud, String telefono2_estud);
    
    // Remove a person
    public int deleteEstudiante(String email_colab, String cedula_estud);
    
    // Find an specific person
    public void findEstudiante(int eventoID);
    
    // Update a person
    public boolean updateEstudiante(String correo_viejo, String cedula_vieja,
            String nombre_estud, String apellido1_estud, String apellido2_estud,
            String cedula_nueva, String correo_nuevo, String telefono1_estud,
            String telefono2_estud);
    
    // Select a info row from specific person 
    public void selectEstudianteRS(int cantidad);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectEstudianteTO();
    
    public int matricularEstudiante(String email_estud, String cedula_estud,
            String codigo_curso, int numero_grupo);
    
    public int desmatricularEstudiante(String email_estud, String cedula_estud,
            String codigo_curso, int numero_grupo);
}
