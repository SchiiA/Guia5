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
public class Inscripcion {
    private int idInscripto;
    private double nota;
    private int idAlumno;
    private int idMateria;

    public Inscripcion(int idInscripto, double nota, int idAlumno, int idMateria) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public Inscripcion() {
    }

    public Inscripcion(double nota, int idAlumno, int idMateria) {
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "idInscripto=" + idInscripto + ", nota=" + nota + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria;
    }
    
    
    
}
