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
public class ColaboradorTO {
    
   private String nombre_curso;
   private String codigo_curso;
   private int numero_grupo;
   private String nombre_colaborador;
   private String rol;
    
    public ColaboradorTO(String nom_curso, String cod_curso,
            int num_curso, String nom_colab, String rol_colab){
        setNombre_curso(nom_curso);
        setCodigo_curso(cod_curso);
        setNumero_grupo(num_curso);
        setNombre_colaborador(nom_colab);
        setRol(rol_colab);
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
     * @return the nombre_colaborador
     */
    public String getNombre_colaborador() {
        return nombre_colaborador;
    }

    /**
     * @param nombre_colaborador the nombre_colaborador to set
     */
    public void setNombre_colaborador(String nombre_colaborador) {
        this.nombre_colaborador = nombre_colaborador;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
