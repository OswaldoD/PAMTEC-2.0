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

import controller.ColaboradorTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author AAC
 */
public interface Colaborador{
    
    // Basic CRUD operations
    
    // Create new person
    public int insertarColaborador(String nombre_colab,String apellido1_colab, 
            String apellido2_colab, String email_colab, String rol_colab);
    
    // Remove a person
    public boolean deleteColaborador(String email_colab);
    

    
    // Update a person
    public boolean updateColaborador(String correo_viejo, String nombre_colab,
            String apellido1_colab, String apellido2_colab, String correo_nuevo,
            String rol_colab);
    
    // Select a info row from specific person 
    public void selectColaboradorRS(int cantidad);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectCompetidorTO();
        
    public boolean insertarRol(String nombre_rol);
    
    public ArrayList<ColaboradorTO> colaboradorDeCurso();
}
