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

import controller.CursosTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author AAC
 */
public interface Curso{
    
    // Basic CRUD operations
    
    // Create new person
    public int insertarCurso(String nombre_curso,String codigo_curso, 
            int numero_grupo, String detalles_curso, int cupo_curso,
            String email_prof, String email_asist1, String email_aasist2);
    
    // Remove a person
    public int deleteCurso(String codigo_curso, int numero_grupo);
    
    
    // Update a person
    public boolean updateCurso(int numero_grupo_viejo, String codigo_viejo,
            String nombre_curso, String codigo_nuevo, int numero_grupo_nuevo,
            String detalles_grupo, int cupo_grupo);
    
    // Select a info row from specific person 
    public ArrayList<CursosTO> infoCursoRS();
    
    // Select a info row from specific person 
    public ArrayList<CursosTO> infoGeneralCursosRS();
    
    public ArrayList<CursosTO> InformacionExcelEstudiantes(String codigo_curso, int numero_grupo);
    
    // Select all info from table without criteria (select * from all)
    public Collection selectCursoTO();
    
    public int cantidadProfesPorCursos(String codigo_curso, int numero_grupo);
    
    public int cantidadAsistentesPorCursos(String codigo_curso, int numero_grupo);
    
    public int asignarProfesor(String email_profesor,String codigo_curso, int numero_grupo);    
    
}