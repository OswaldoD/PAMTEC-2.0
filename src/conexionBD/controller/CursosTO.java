/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Deiby
 */
public class CursosTO {
    private String apellidos_estudiante;
    private String nombre_estudiante;
    private String telefono1_estudiante;
    private String telefono2_estudiante;
    
    private String nombre_curso;
    private String codigo_curso;
    private int numero_grupo;
    private int cupo;
   
    
    public CursosTO(String apellidos_estud, String nombre_estud,
            String telefono1_estud, String telefono2_estud){
        setApellidos_estudiante(apellidos_estud);
        setNombre_estudiante(nombre_estud);
        setTelefono1_estudiante(telefono1_estud);
        setTelefono2_estudiante(telefono2_estud);
    }
    
    public CursosTO(String nombre_cur, String codigo_cur, int num_grupo,
            int cupo){
        setNombre_curso(nombre_cur);
        setCodigo_curso(codigo_cur);
        setNumero_grupo(num_grupo);
        setCupo(cupo);
   }

    /**
     * @return the apellidos_estudiante
     */
    public String getApellidos_estudiante() {
        return apellidos_estudiante;
    }

    /**
     * @param apellidos_estudiante the apellidos_estudiante to set
     */
    public void setApellidos_estudiante(String apellidos_estudiante) {
        this.apellidos_estudiante = apellidos_estudiante;
    }

    /**
     * @return the nombre_estudiante
     */
    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    /**
     * @param nombre_estudiante the nombre_estudiante to set
     */
    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    /**
     * @return the telefono1_estudiante
     */
    public String getTelefono1_estudiante() {
        return telefono1_estudiante;
    }

    /**
     * @param telefono1_estudiante the telefono1_estudiante to set
     */
    public void setTelefono1_estudiante(String telefono1_estudiante) {
        this.telefono1_estudiante = telefono1_estudiante;
    }

    /**
     * @return the telefono2_estudiante
     */
    public String getTelefono2_estudiante() {
        return telefono2_estudiante;
    }

    /**
     * @param telefono2_estudiante the telefono2_estudiante to set
     */
    public void setTelefono2_estudiante(String telefono2_estudiante) {
        this.telefono2_estudiante = telefono2_estudiante;
    }

    /**
     * @return the nombre_curso
     */
    public String getNombre_curso() {
        return nombre_curso;
    }

    /**
     * @param nombre_curso the nombre_curso to set
     */
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    /**
     * @return the codigo_curso
     */
    public String getCodigo_curso() {
        return codigo_curso;
    }

    /**
     * @param codigo_curso the codigo_curso to set
     */
    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    /**
     * @return the numero_grupo
     */
    public int getNumero_grupo() {
        return numero_grupo;
    }

    /**
     * @param numero_grupo the numero_grupo to set
     */
    public void setNumero_grupo(int numero_grupo) {
        this.numero_grupo = numero_grupo;
    }

    /**
     * @return the cupo_total
     */
    public int getCupo() {
        return cupo;
    }

    /**
     * @param cupo_total the cupo_total to set
     */
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
   
    
    
}
