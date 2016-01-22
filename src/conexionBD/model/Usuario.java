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
public interface Usuario{
    
    // Basic CRUD operations
    
    // Create new person
    public int insertarUsuario(String nombre_usuario,String password_usuario,
            String rol);
    
    // Remove a person
    public int deleteUsuario(String nombre_usuario);
    
    
    // Update a person
    public boolean updateUsuario();
    
    public int iniciarSesion(String nombre_usuario, String password_usuario);
}
