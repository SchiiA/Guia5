/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal_gestion_universidad.entidades;

/**
 *
 * @author Equipo
 */
public class Materia {
    private int idMateria;
    private String nombre;
    private int año;
    private boolean estado;

    public Materia(int idMateria, String nombre, int año, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }

    public Materia() {
    }

    public Materia(String nombre, int año, boolean estado) {
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "idMateria=" + idMateria + ", nombre=" + nombre + ", a\u00f1o=" + año + ", estado=" + estado;
    }

    public int getAnio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setAnio(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
