/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal_gestion_universidad.acceso_a_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transversal_gestion_universidad.entidades.Alumno;
import proyecto_transversal_gestion_universidad.entidades.Inscripcion;
import proyecto_transversal_gestion_universidad.entidades.Materia;

/**
 *
 * @author Equipo
 */
public class InscripcionData {
    private Connection con;
    private MateriaData matData=new MateriaData();
    private AlumnoData aluData=new AlumnoData();

    public InscripcionData() {
        con=Conexion.getConection();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        
        String sql="insert into inscripcion (nota, idAlumno,idMateria)values (?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno: "+insc.getAlumno().getNombre()+" fue inscripto a la materia: "+insc.getMateria().getNombre());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public ArrayList<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> lista=new ArrayList<>();
        Inscripcion ins=null;
        String sql="select* from inscripcion in join alumno al on(in.idALumno=al.idAlumno) join materia mat on (in.idMateria=mat.idMateria) where al.estado=true and mat.estado=true";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ins.setIdInscripto(rs.getInt("idInscripcion"));
                ins.setNota(rs.getDouble("nota"));
                int idAlumno=(rs.getInt("idAlumno"));
                Alumno alumno=aluData.buscarAlumnoPorId(idAlumno);
                ins.setAlumno(alumno);
                int idMateria=rs.getInt("idMateria");
                Materia materia=matData.buscarMateria(idMateria);
                ins.setMateria(materia);
                lista.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return lista;
    }
    
    public  ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> lista=new ArrayList<>();
        Inscripcion ins=null;
        String sql="select * from inscripcion in join alumno al on (in.idAlumno=al.idAlumno) where al.estado=true and in.idAlumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Alumno alumno=aluData.buscarAlumnoPorId(idAlumno);
                ins.setAlumno(alumno);
                ins.setIdInscripto(rs.getInt("idInscripcion"));
                int idMateria=rs.getInt("idMateria");
                Materia materia=matData.buscarMateria(idMateria);
                ins.setMateria(materia);
                ins.setNota(rs.getDouble("nota"));
                lista.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
        return lista;
    }
    
    public ArrayList<Materia> obtenerMateriasCursadas(int idAlumno,int idMateria){
        ArrayList<Materia> lista=new ArrayList<>();
        Materia materia=null;
        String sql="select * from materia mat join alumno al on (in.idAlumno=al.idAlumno) join inscripcion in on (mat.idMateria=in.idMateria) where mat.idMateria=? and al.idAlumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                lista.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tablas");
        }
        return lista;
    }
    
    public ArrayList<Materia> obtenerMateriasNoCursadas(int idAlumno,int idMateria){
        ArrayList<Materia> lista=new ArrayList<>();
        Materia materia=null;
        String sql="select * from materia mat, alumno al, inscripcion in where mat.idMateria=? and al.idAlumno=? and in.idAlumno=al.idAlumno and mat.idMateria!=in.idMateria";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                lista.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tablas");
        }
        return lista;
    }
    
    public void borrarInscripcion(int idAlumno, int idMateria){
        String sql="delete from inscripcion where idAlumno=? and idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int rs=ps.executeUpdate();
            if(rs==1){
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql="update inscripcion set nota=? where idAlumno=? and idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int rs=ps.executeUpdate();
            if(rs==1){
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla inscripcion");
        }
    }
    
    public ArrayList<Alumno> obtenerAlumnosXMateria(int idMateria){
        ArrayList<Alumno> alumnos=new ArrayList<>();
        Alumno alumno=null;
        String sql="select * from alumno al join inscripcion in on(in.idAlumno=al.idAlumno) join materia mat on (mat.idMateria=in.idMateria)  where idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFechaNacimiento(LocalDate.parse(String.valueOf(rs.getDate("fechaNacimiento"))));
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a las tablas");
        }
        return alumnos;
    }
}
